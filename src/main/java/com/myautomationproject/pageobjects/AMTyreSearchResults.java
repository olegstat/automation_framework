package com.myautomationproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AMTyreSearchResults {
    public WebDriver driver;

    public  AMTyreSearchResults(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "span[title='список']")
    private WebElement rowViewBtn;
    @FindBy(css = "td.number > a")
    private List<WebElement> productCodes;
    @FindBy(css = "select#PageSize")
    private WebElement pageSizeSlt;
    @FindBy(css= "select[id='1586'] + button > span:nth-child(2)")
    private  WebElement seasonField;
    @FindBy(css= "select[id='3589'] + button > span:nth-child(2)")
    private  WebElement widthField;
    @FindBy(css= "select[id='126'] + button > span:nth-child(2)")
    private  WebElement heightField;
    @FindBy(css= "select[id='653'] + button > span:nth-child(2)")
    private  WebElement diameterField;
    @FindBy(tagName = "h2")
    private WebElement pageH2;

    public WebElement getRowViewBtn(){
        return rowViewBtn;
    }

    public List<WebElement> getProductCodes(){
        return productCodes;
    }

    public WebElement getPageSizeSlt(){
        return pageSizeSlt;
    }

    public WebElement getSeasonField(){
        return seasonField;
    }

    public WebElement getWidthField(){
        return widthField;
    }

    public WebElement getHeightField(){
        return heightField;
    }

    public WebElement getDiameterField(){
        return diameterField;
    }

    public WebElement getPageH2() {
        return pageH2;
    }
}
