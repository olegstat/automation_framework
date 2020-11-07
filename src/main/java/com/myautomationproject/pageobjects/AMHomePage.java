package com.myautomationproject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.awt.print.Pageable;


public class AMHomePage {
    private WebDriver driver;

    @FindBy(css = "button.button-submit")
    WebElement dialogPopupCloseButton;
    @FindBy(css = "input[type='email']")
    WebElement loginField;
    @FindBy(css = "input[type='password']")
    WebElement pwField;
    @FindBy(css = "input[type='submit']")
    WebElement loginSubmitField;
    @FindBy(id = "button-exit")
    WebElement buttonExit;
    @FindBy(css = "a[id='client'] span")
    WebElement clientIdField;

    public AMHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean getPopupWindowStatus() {
        Boolean status = null;
        if (dialogPopupCloseButton.isDisplayed()){
            status = true;
        }else{
            status = false;
        }
        return status;
    }

    public WebElement getDialogPopupCloseButton(){
        return dialogPopupCloseButton;
    }

    public WebElement getLoginField(){
        return loginField;
    }

    public WebElement getPwField(){
        return pwField;
    }

    public WebElement getLoginSubmitField(){
        return loginSubmitField;
    }

    public WebElement getButtonExit(){
        return buttonExit;
    }

    public WebElement getClientIdField() {
        return clientIdField;
    }
}
