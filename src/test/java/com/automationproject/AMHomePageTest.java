package com.automationproject;

import com.myautomationproject.BaseClass;
import com.myautomationproject.pageobjects.AMHomePage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class AMHomePageTest extends BaseClass {
    AMHomePage homePage;

    @BeforeClass
    public void amHomePageSetup() throws IOException{
        driver = initWebDriver();
        homePage = new AMHomePage(driver);
        homePageUrl = getHomePageUrl();
        driver.get(homePageUrl);
        if (homePage.getDialogPopupCLoseButton().isDisplayed()){
            homePage.getDialogPopupCLoseButton().click();
        }
    }

    @Test
    public void amHomePageLanguageChangeTest(){
        homePage.getLanguageBar().click();
        homePage.getSelectLanguageMenu("ro").click();
        Assert.assertTrue(driver.getTitle().contains("Pagina"));
        homePage.getLanguageBar().click();
        homePage.getSelectLanguageMenu("ru").click();
    }

    @AfterClass
    public void closeDriver(){
        driver.quit();
    }
}
