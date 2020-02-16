package com.eugene.tests;

import com.eugene.Config;
import com.eugene.DataProviderClass;
import com.eugene.LogResultToFile;
import com.eugene.ScreenMaker;
import org.testng.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.eugene.Config.*;

public class Test1 extends BaseTest {

    @BeforeMethod
    public void setup(){
        app.getDriver().get(START_URL);
    }

    @Test(priority = 1, dataProvider = "query", dataProviderClass = DataProviderClass.class)
    public void positiveTest(String[] query){
        app.getSartPage().search(query[0]);
        app.getSearcResultPage().waitResultPageIsLoaded();
        Assert.assertEquals(app.getSearcResultPage().getPageTitle().substring(0,query[0].length()),query[0]);
    }
    @Test(priority = 2, dataProvider = "query", dataProviderClass = DataProviderClass.class)
    public void negativeTest(String[] query){
        app.getSartPage().search(query[1]);
        app.getSearcResultPage().waitResultPageIsLoaded();
        Assert.assertEquals(app.getSearcResultPage().getPageTitle().substring(0,query[0].length()),query[0]);
    }
    @AfterMethod
    public void handleResult(ITestResult result){
        if(result.getStatus() == result.SUCCESS) {
            LogResultToFile.logResultToFile(OUT_PATH, "Тест пройден" + " " + result.getName());
        }

        if(result.getStatus() == result.FAILURE) {
            LogResultToFile.logResultToFile(Config.ERROR_PATH, "Тест провален" + " " + result.getName());
            ScreenMaker.makeScreenshot(SCREENSHOTS_DIR_PATH, app.getDriver(), result.getName());
        }

    }

}
