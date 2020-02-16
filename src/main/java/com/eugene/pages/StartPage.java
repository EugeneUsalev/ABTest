package com.eugene.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPage extends Page {

    private By searchField = By.cssSelector(".input__control.input__input");
    private By sendButton = By.cssSelector(".search2__button");

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public void search(String query){
        driver.findElement(searchField).sendKeys(query);
        driver.findElement(sendButton).click();
    }


}
