package com.myautomationproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AMTyreSearchResults {
    private WebDriver driver;

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

    public WebElement getRowViewBtn(){
        return rowViewBtn;
    }

    public List<WebElement> getProductCodes(){
        return productCodes;
    }

    public WebElement getPageSizeSlt(){
        return pageSizeSlt;
    }
}
