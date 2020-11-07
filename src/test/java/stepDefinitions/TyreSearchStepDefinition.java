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

    @Given("^User is on the home page \\\"([^\\\"]*)\\\"$")
    public void userIsOnTheHomePage() {
    }

    @When("^User clicks on the tyre search link$")
    public void userClicksOnTheTyreSearchLink() {
    }

    @And("^User selects tyre (.+)$")
    public void userSelectsTyreWidth() {
    }

    @And("^User selects tyre (.+)$")
    public void userSelectsTyreHeight() {
    }

    @And("^User selects tyre (.+)$")
    public void userSelectsTyreDiameter() {

    }

    @And("^User selects tyre (.+)$")
    public void userSelectsTyreSeason() {
    }

    @And("^User clicks on the show results button$")
    public void userClicksOnTheShowResultsButton() {
    }

    @And("^User clicks on the row view button$")
    public void userClicksOnTheRowViewButton() {
    }

    @Then("^Results are present on the page$")
    public void resultsArePresentOnThePage() {
    }

    @And("^All the product codes with quantity more that zero are printed in the console$")
    public void allTheProductCodesWithQuantityMoreThatZeroArePrintedInTheConsole() {
    }

    @And("^Close browsers$")
    public void closeBrowsers() {
        driver.quit();
    }

}
