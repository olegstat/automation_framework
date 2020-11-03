package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {

    @Given("^Unlogged user is on the home page$")
    public void unloggedUserIsOnTheHomePage() {
        System.out.println("test");
    }

    @When("^User logs in with (.+) and (.+)$")
    public void userLogsInWithUsernameAndPassword(String username, String password) {
        System.out.println("test");
    }

    @Then("^User is successfully logged in$")
    public void userIsSuccessfullyLoggedIn() {
        System.out.println("test");
    }

    @And("^Correct UserID is displayed on the page$")
    public void correctUserIDIsDisplayedOnThePage() {
        System.out.println("test");
    }

    @And("^Close browsers$")
    public void closeBrowsers() {
        System.out.println("test");
    }
}
