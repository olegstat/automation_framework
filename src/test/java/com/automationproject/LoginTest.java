package com.automationproject;

import com.myautomationproject.BaseClass;
import com.myautomationproject.pageobjects.AMHomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import stepDefinitions.LoginStepDefinition;

import java.io.IOException;

public class LoginTest extends BaseClass {
    public static Logger log = LogManager.getLogger(LoginStepDefinition.class.getName());
    public WebDriver driver;
    AMHomePage homePage;

    @BeforeClass
    public void amHomePageSetup() throws IOException {
        driver = initWebDriver();
        log.info("Driver is initialized.");
        homePage = new AMHomePage(driver);
        homePageUrl = getHomePageUrl();
        driver.get(homePageUrl);
        if (homePage.getDialogPopupCloseButton().isDisplayed()) {
            homePage.getDialogPopupCloseButton().click();
            log.info("Popup window is closed.");
        }
        Assert.assertTrue(driver.getTitle().contains(getTitle("ru")));
        log.info("Homepage was loaded successfully");
    }

    @Test
    public void loginTest() throws IOException {
        String login = getProperty("login");
        String password = getProperty("password");
        String userId = getProperty("userId");
        homePage.getLoginField().sendKeys(login);
        homePage.getPwField().sendKeys(password);
        homePage.getLoginSubmitField().click();
        if (homePage.getDialogPopupCloseButton().isDisplayed()) {
            homePage.getDialogPopupCloseButton().click();
            log.info("Popup window is closed.");
        }
        log.info("Typed login and password and clicked on Login button");
        log.info("Username: " + login);
        Assert.assertTrue(homePage.getButtonExit().isDisplayed());
        Assert.assertTrue(homePage.getClientIdField().getText().contains(userId));
        log.info("The UserID of the logged user is correct: " + userId);
    }

    @Test
    public void logoutTest(){
        homePage.getButtonExit().click();
        Assert.assertTrue(homePage.getLoginSubmitField().isDisplayed());
        log.info("User was successfully logged out");
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
        log.info("Driver is closed.");
    }
}
