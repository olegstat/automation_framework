package com.automationproject;

import com.myautomationproject.BaseClass;
import com.myautomationproject.pageobjects.AMHomePage;
import com.myautomationproject.pageobjects.AMTyreSearch;
import com.myautomationproject.pageobjects.AMTyreSearchResults;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import stepDefinitions.LoginStepDefinition;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import static org.testng.TestRunner.PriorityWeight.dependsOnMethods;

public class TyreSearchTest extends BaseClass {
    public static Logger log = LogManager.getLogger(LoginStepDefinition.class.getName());
    public WebDriver driver;
    AMHomePage homePage;
    AMTyreSearch tyreSearch;
    AMTyreSearchResults tyreSearchResults;
    String width;
    String height;
    String diameter;
    String season;

    @BeforeClass
    public void amHomePageSetup() throws IOException {
        driver = initWebDriver();
        log.info("Driver is initialized.");
        homePage = new AMHomePage(driver);
        homePageUrl = getHomePageUrl();
        driver.get(homePageUrl);
        if(homePage.closePopupWindow()){
            log.info("Popup window was closed");
        }
        Assert.assertTrue(driver.getTitle().contains(getTitle("ru")));
        log.info("Homepage was loaded successfully");
    }

    @Test
    public void tyreSearchParametersTest() throws IOException, InterruptedException {
        width = getProperty("width");
        height = getProperty("height");
        diameter = getProperty("diameter");
        season = getProperty("season");

        tyreSearch = homePage.getTyreSearchObject();
        log.info("Navigated to Tyre Search Page");
        tyreSearch.getWidthInput().clear();
        tyreSearch.getWidthInput().sendKeys(width);
        tyreSearch.getWidthInput().sendKeys(Keys.TAB);
        log.info("Typed width: " + width);
        tyreSearch.getHeightInput().clear();
        tyreSearch.getHeightInput().sendKeys(height);
        tyreSearch.getHeightInput().sendKeys(Keys.TAB);
        log.info("Typed height: " + height);
        tyreSearch.getDiameterInput().clear();
        tyreSearch.getDiameterInput().sendKeys(diameter);
        tyreSearch.getDiameterInput().sendKeys(Keys.TAB);
        log.info("Typed diameter: " + diameter);
        tyreSearch.getSeasonInput().clear();
        tyreSearch.getSeasonInput().sendKeys(season);
        tyreSearch.getSeasonInput().sendKeys(Keys.TAB);
        log.info("Selected tyre season: " + season);
        tyreSearchResults = tyreSearch.getTyreSearchResultsObject();
        log.info("Clicked on show results button.");
        Assert.assertEquals(tyreSearchResults.getPageH2().getText(),"Шины");
        log.info("Results page successfully loaded");
    }

    @Test(dependsOnMethods = {"tyreSearchParametersTest"})
    public void saveProductsToExcelTest() throws IOException {
        tyreSearchResults.getRowViewBtn().click();
        Select slt = new Select(tyreSearchResults.getPageSizeSlt());
        slt.selectByVisibleText("100");
        List<WebElement> tyreCodes = tyreSearchResults.getProductCodes();
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Search Results");
        int rowNum = 0;
        Date date = new Date();
        for(WebElement tyreCode: tyreCodes){
            Row row = sheet.createRow(rowNum);
            rowNum++;
            row.createCell(0).setCellValue(tyreCode.getText());
        }
        FileOutputStream fileOut = new FileOutputStream("SearchResults_" + date.getTime() + ".xlsx");
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
        log.info("Generated and saved Excel file with product codes");
    }

    @Test(dependsOnMethods = {"tyreSearchParametersTest"})
    public void correspondenceOfSelectedParametersTest(){
        Assert.assertEquals(tyreSearchResults.getSeasonField().getText(), season);
        log.info("Season check passed: " + season);
        Assert.assertEquals(tyreSearchResults.getWidthField().getText(), width);
        log.info("Width check passed: " + width);
        Assert.assertEquals(tyreSearchResults.getHeightField().getText(), height);
        log.info("Height check passed: " + height);
        Assert.assertTrue(tyreSearchResults.getDiameterField().getText().contains(diameter));
        log.info("Diameter check passed: " + diameter);
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
        log.info("Driver is closed.");
    }
}
