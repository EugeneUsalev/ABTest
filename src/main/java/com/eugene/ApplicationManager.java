package com.eugene;

import com.eugene.pages.SearcResultPage;
import com.eugene.pages.StartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private WebDriver driver;
    private StartPage startPage;
    private SearcResultPage searcResultPage;


    public ApplicationManager() {

        this.driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        startPage = new StartPage(driver);
        searcResultPage = new SearcResultPage(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }

    public StartPage getSartPage(){
        return startPage;
    }
    public SearcResultPage getSearcResultPage(){ return searcResultPage; }
}
