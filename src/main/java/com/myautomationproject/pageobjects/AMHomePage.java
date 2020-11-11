package com.myautomationproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AMHomePage {
    private WebDriver driver;

    @FindBy(css = "button.button-submit")
    private WebElement dialogPopupCloseButton;
    @FindBy(css = "input[type='email']")
    private WebElement loginField;
    @FindBy(css = "input[type='password']")
    private WebElement pwField;
    @FindBy(css = "input[type='submit']")
    private WebElement loginSubmitField;
    @FindBy(id = "button-exit")
    private WebElement buttonExit;
    @FindBy(css = "a[id='client'] span")
    private WebElement clientIdField;
    @FindBy(css = "a[class*=bus")
    private WebElement tyreSearchLink;

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

    public AMTyreSearch getTyreSearchObject(){
        tyreSearchLink.click();
        return new AMTyreSearch(driver);
    }

    public Boolean closePopupWindow(){
        Boolean status = Boolean.FALSE;
        if(getPopupWindowStatus()){
            getDialogPopupCloseButton().click();
            status = Boolean.TRUE;
        }
        return status;
    }
}
