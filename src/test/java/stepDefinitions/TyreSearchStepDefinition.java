package stepDefinitions;

import com.myautomationproject.BaseClass;
import com.myautomationproject.pageobjects.AMHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
public class TyreSearchStepDefinition extends BaseClass {
    public static Logger log = LogManager.getLogger(LoginStepDefinition.class.getName());
    public WebDriver driver;
    AMHomePage homePage;

    @Given("^User is on the home page \"([^\"]*)\"$")
    public void userIsOnTheHomePage(String strArg1){
        System.out.println("test");
    }

    @When("^User clicks on the tyre search link$")
    public void userClicksOnTheTyreSearchLink(){
        System.out.println("test");
    }

    @Then("^User selects tyre width (.+)$")
    public void userSelectsTyreWidth(String width){
        System.out.println("test");
    }

    @And("^User selects tyre height (.+)$")
    public void userSelectsTyreHeight(String height){
        System.out.println("test");
    }

    @And("^User selects tyre diameter (.+)$")
    public void userSelectsTyreDiameter(String diameter){
        System.out.println("test");
    }

    @And("^User selects tyre season (.+)$")
    public void userSelectsTyreSeason(String season){
        System.out.println("test");
    }

    @And("^User clicks on the show results button$")
    public void userClicksOnTheShowResultsButton(){
        System.out.println("test");
    }

    @And("^User clicks on the row view button$")
    public void userClicksOnTheRowViewButton(){
        System.out.println("test");
    }

    @And("^Results are present on the page$")
    public void resultsArePresentOnThePage(){
        System.out.println("test");
    }

    @And("^All the product codes with quantity more than zero are printed in the console$")
    public void allTheProductCodesWithQuantityMoreThanZeroArePrintedInTheConsole(){
        System.out.println("test");
    }

    @And("^Close browsers TyreSearch$")
    public void closeBrowsersTyresearch(){
        System.out.println("test");

    }
    }
