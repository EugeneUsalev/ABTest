package com.eugene.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearcResultPage extends Page {

    private By searchFielg = By.cssSelector(".input__control.mini-suggest__input");

    public SearcResultPage(WebDriver driver) {
        super(driver);
    }

    public void waitResultPageIsLoaded(){
        waitVisible(searchFielg);
    }
}
