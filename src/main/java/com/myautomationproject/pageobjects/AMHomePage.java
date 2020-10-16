package com.myautomationproject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class AMHomePage {
    public WebDriver driver;

    By registerButton = By.cssSelector("a[href*='LogOn']");
    By dialogPopupCloseButton = By.cssSelector("span.ui-button-text");
    By languageMenuRo = By.xpath("//a[text()='RO']");
    By languageMenuRu = By.xpath("//a[text()='RU']");
    By languageBar = By.cssSelector(".select");

    public AMHomePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getRegisterButton(){
        return driver.findElement(registerButton);
    }

    public By getDialogPopupCloseButtonBy(){
        return dialogPopupCloseButton;
    }

    public  WebElement getDialogPopupCLoseButton(){
        return driver.findElement(dialogPopupCloseButton);
    }

    public  WebElement getLanguageBar(){
        return driver.findElement(languageBar);
    }

    public WebElement getSelectLanguageMenu(String language){
        WebElement languageMenu = null;
        if (language.equalsIgnoreCase("RO")){
            languageMenu = driver.findElement(languageMenuRo);
        }else if (language.equalsIgnoreCase("RU")){
            languageMenu =  driver.findElement(languageMenuRu);
        }
        return languageMenu;
    }

}