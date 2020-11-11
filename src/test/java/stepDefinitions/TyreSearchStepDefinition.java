package stepDefinitions;

import com.myautomationproject.BaseClass;
import com.myautomationproject.pageobjects.AMHomePage;
import com.myautomationproject.pageobjects.AMTyreSearch;
import com.myautomationproject.pageobjects.AMTyreSearchResults;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TyreSearchStepDefinition extends BaseClass {
    public static Logger log = LogManager.getLogger(LoginStepDefinition.class.getName());
    public WebDriver driver;
    AMHomePage homePage;
    AMTyreSearch tyreSearch;
    AMTyreSearchResults tyreSearchResults;

    @Given("^User is on the home page \"([^\"]*)\"$")
    public void userIsOnTheHomePage(String url) throws IOException {
        driver = initWebDriver();
        homePage = new AMHomePage(driver);
        driver.get(url);
        if(homePage.closePopupWindow()){
            log.info("Popup window was closed");
        }
        Assert.assertTrue(driver.getTitle().contains(getTitle("ru")));
        log.info("Homepage was loaded successfully");
    }

    @When("^User clicks on the tyre search link$")
    public void userClicksOnTheTyreSearchLink(){
        tyreSearch = homePage.getTyreSearchObject();
        log.info("Navigated to Tyre Search Page");
    }

    @Then("^User selects tyre width (.+)$")
    public void userSelectsTyreWidth(String width) throws InterruptedException {
        tyreSearch.getWidthInput().clear();
        tyreSearch.getWidthInput().sendKeys(width);
        Thread.sleep(200);
        log.info("Typed width: " + width);
    }

    @And("^User selects tyre height (.+)$")
    public void userSelectsTyreHeight(String height) throws InterruptedException {
        tyreSearch.getHeightInput().clear();
        tyreSearch.getHeightInput().sendKeys(height);
        Thread.sleep(200);
        log.info("Typed height: " + height);
    }

    @And("^User selects tyre diameter (.+)$")
    public void userSelectsTyreDiameter(String diameter) throws InterruptedException {
        tyreSearch.getDiameterInput().clear();
        tyreSearch.getDiameterInput().sendKeys(diameter);
        Thread.sleep(200);
        log.info("Typed diameter: " + diameter);
    }

    @And("^User selects tyre season (.+)$")
    public void userSelectsTyreSeason(String season) throws InterruptedException {
        tyreSearch.getSeasonInput().clear();
        tyreSearch.getSeasonInput().sendKeys(season);
        Thread.sleep(200);
        log.info("Selected tyre season: " + season);
    }

    @And("^User clicks on the show results button$")
    public void userClicksOnTheShowResultsButton(){
        tyreSearchResults = tyreSearch.getTyreSearchResultsObject();
        log.info("Clicked on show results button.");
        Assert.assertEquals(tyreSearchResults.getPageH2().getText(),"Шины");
        log.info("Results page successfully loaded");
    }

    @And("^User clicks on the row view button$")
    public void userClicksOnTheRowViewButton(){
        tyreSearchResults.getRowViewBtn().click();
    }

    @And("^User selects hundred values per page view$")
    public void userSelectsHundredValuesPerPageView() {
        Select slt = new Select(tyreSearchResults.getPageSizeSlt());
        slt.selectByVisibleText("100");
    }

    @And("^All the product codes are saved in excel$")
    public void allTheProductCodesAreSavedInExcel() throws IOException {
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
    }

    @And("^Tyre season (.+) corresponds$")
    public void tyreSeasonCorresponds(String season){
        Assert.assertEquals(tyreSearchResults.getSeasonField().getText(), season);
        log.info("Season check passed: " + season);
    }

    @And("^Tyre width (.+) corresponds$")
    public void tyreWidthCorresponds(String width){
        Assert.assertEquals(tyreSearchResults.getWidthField().getText(), width);
        log.info("Width check passed: " + width);
    }

    @And("^Tyre height (.+) corresponds$")
    public void tyreHeightCorresponds(String height){
        Assert.assertEquals(tyreSearchResults.getHeightField().getText(), height);
        log.info("Height check passed: " + height);
    }

    @And("^Tyre diameter (.+) corresponds$")
    public void tyreDiameterCorresponds(String diameter){
        Assert.assertTrue(tyreSearchResults.getDiameterField().getText().contains(diameter));
        log.info("Diameter check passed: " + diameter);
    }

    @And("^Close browsers TyreSearch$")
    public void closeBrowsersTyresearch(){
        driver.close();
        log.info("Browser closed.");
    }

}
