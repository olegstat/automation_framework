package com.myautomationproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AMTyreSearch {
    private WebDriver driver;

    public AMTyreSearch(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "select[id='126'] + span > input:first-of-type")
    private WebElement heightInput;
    @FindBy(css = "select[id='3589'] + span > input:first-of-type")
    private WebElement widthInput;
    @FindBy(css = "select[id='3589']")
    private WebElement firstSelect;
    @FindBy(css = "select[id='653'] + span > input:first-of-type")
    private WebElement diameterInput;
    @FindBy(css = "select[id='1586'] + span > input:first-of-type")
    private WebElement seasonInput;
    @FindBy(css = "button[class='button-submit']")
    private WebElement submitBtn;

    public WebElement getHeightInput(){
        return heightInput;
    }
    public WebElement getWidthInput(){
        return widthInput;
    }
    public WebElement getSeasonInput(){
        return seasonInput;
    }
    public WebElement getDiameterInput(){
        return diameterInput;
    }

    public AMTyreSearchResults getTyreSearchResultsObject(){
        submitBtn.click();
        return new AMTyreSearchResults(driver);
    }

    public WebElement getFirstSelect(){
        return firstSelect;
    }
}
