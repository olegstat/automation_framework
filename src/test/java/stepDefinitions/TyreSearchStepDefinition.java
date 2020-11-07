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
    public static Logger log = LogManager.getLogger(TyreSearchStepDefinition.class.getName());
    public WebDriver driver;
    AMHomePage homePage;

    @Given("^User is on the home page \\\"([^\\\"]*)\\\"$")
    public void userIsOnTheHomePage() {
        System.out.println("pass");
    }

    @When("^User clicks on the tyre search link$")
    public void userClicksOnTheTyreSearchLink() {
        System.out.println("pass");
    }

    @Then("^User selects tyre width (.+)$")
    public void userSelectsTyreWidth() {
        System.out.println("pass");
    }

    @And("^User selects tyre height (.+)$")
    public void userSelectsTyreHeight() {
        System.out.println("pass");
    }

    @And("^User selects tyre diameter (.+)$")
    public void userSelectsTyreDiameter() {
        System.out.println("pass");
    }

    @And("^User selects tyre season (.+)$")
    public void userSelectsTyreSeason() {
        System.out.println("pass");
    }

    @And("^User clicks on the show results button$")
    public void userClicksOnTheShowResultsButton() {
        System.out.println("pass");
    }

    @And("^User clicks on the row view button$")
    public void userClicksOnTheRowViewButton() {
        System.out.println("pass");
    }

    @And("^Results are present on the page$")
    public void resultsArePresentOnThePage() {
        System.out.println("pass");
    }

    @And("^All the product codes with quantity more that zero are printed in the console$")
    public void allTheProductCodesWithQuantityMoreThatZeroArePrintedInTheConsole() {
        System.out.println("pass");
    }

    @And("^Close browsers TyreSearch$")
    public void closeBrowsersTyreSearch() {
        System.out.println("pass");
        //driver.quit();
    }

}