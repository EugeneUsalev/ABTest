package com.eugene.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    protected WebElement waitVisible(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 10, 100);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }


}
