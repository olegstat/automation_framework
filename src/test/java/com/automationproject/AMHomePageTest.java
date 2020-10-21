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

import java.io.IOException;

public class AMHomePageTest extends BaseClass {
    public static Logger log = LogManager.getLogger(BaseClass.class.getName());
    public WebDriver driver;
    AMHomePage homePage;

    @BeforeClass
    public void amHomePageSetup() throws IOException {
        driver = initWebDriver();
        log.info("Driver is initialized.");
        homePage = new AMHomePage(driver);
        homePageUrl = getHomePageUrl();
        driver.get(homePageUrl);
        log.info("Homepage is loaded.");
        if (homePage.getDialogPopupCLoseButton().isDisplayed()) {
            homePage.getDialogPopupCLoseButton().click();
            log.info("Popup window is closed.");
        }
    }

    @Test
    public void amHomePageLanguageChangeTest() throws IOException {
        String titleTextRo = getTitle("ro");
        homePage.getLanguageBar().click();
        homePage.getSelectLanguageMenu("ro").click();
        log.info("Language is changed to RO.");
        Assert.assertTrue(driver.getTitle().toLowerCase().contains(titleTextRo));
        log.info("Validated the language change.");
        homePage.getLanguageBar().click();
        homePage.getSelectLanguageMenu("ru").click();
        log.info("Changed the language back to RU.");
    }

    @Test
    public void amHomePageTitleTest() throws IOException {
        String titleText = null;
        if (homePage.getSelectLanguageMenuDefault().getText().equalsIgnoreCase("ru")) {
            titleText = getTitle("ru");
            log.info("The default language is RU.");
        } else if (homePage.getSelectLanguageMenuDefault().getText().equalsIgnoreCase("ro")) {
            titleText = getTitle("ro");
            log.info("The default language is RO.");
        }
        Assert.assertTrue(driver.getTitle().toLowerCase().contains(titleText));
        log.info("Validated the title according to default language.");
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
        log.info("Driver is closed.");
    }
}
