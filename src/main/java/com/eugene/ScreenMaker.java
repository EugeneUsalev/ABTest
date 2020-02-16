package com.eugene;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ScreenMaker {
    public static void makeScreenshot(String screenDirPath, WebDriver driver, String testName){
        Date dateNow = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_DD_HH_mm");
        String screenName=(dateFormat.format(dateNow) + testName + ".png");
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File targetFile = new File(screenDirPath+screenName);


        try (InputStream is = new FileInputStream(scrFile); OutputStream os = new FileOutputStream(targetFile)){

            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
