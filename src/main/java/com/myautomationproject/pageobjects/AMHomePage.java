package com.myautomationproject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.print.Pageable;


public class AMHomePage {
    private WebDriver driver;

    @FindBy(css = "span.ui-button-text")
    WebElement dialogPopupCloseButton;
    @FindBy(xpath = "//a[text()='RO']")
    WebElement languageMenuRo;
    @FindBy(xpath = "//a[text()='RU']")
    WebElement languageMenuRu;
    @FindBy(css = ".slct")
    WebElement languageMenuDefault;
    @FindBy(css = ".select")
    WebElement languageBar;

    public AMHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getDialogPopupCLoseButton() {
        return dialogPopupCloseButton;
    }

    public WebElement getLanguageBar() {
        return languageBar;
    }

    public WebElement getSelectLanguageMenu(String language) {
        WebElement languageMenu = null;
        if (language.equalsIgnoreCase("RO")) {
            languageMenu = languageMenuRo;
        } else if (language.equalsIgnoreCase("RU")) {
            languageMenu = languageMenuRu;
        }
        return languageMenu;
    }

    public WebElement getSelectLanguageMenuDefault() {
        return languageMenuDefault;
    }

}
