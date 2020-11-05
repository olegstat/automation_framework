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
import org.testng.Assert;

import java.io.IOException;

public class LoginStepDefinition extends BaseClass {
    public static Logger log = LogManager.getLogger(LoginStepDefinition.class.getName());
    public WebDriver driver;
    AMHomePage homePage;

    @Given("^Unlogged user is on the home page \\\"([^\\\"]*)\\\"$")
    public void unloggedUserIsOnTheHomePage(String url) throws IOException {
        driver = initWebDriver();
        homePage = new AMHomePage(driver);
        log.info("Driver was initialized");
        driver.get(url);
        Assert.assertTrue(driver.getTitle().contains(getTitle("ru")));
        log.info("Homepage was loaded successfully");
        if(homePage.getPopupWindowStatus()){
            homePage.getDialogPopupCloseButton().click();
            log.info("Popup window was closed");
        }
    }

    @When("^User logs in with (.+) and (.+)$")
    public void userLogsInWithUsernameAndPassword(String username, String password) {
        homePage.getLoginField().sendKeys(username);
        homePage.getPwField().sendKeys(password);
        homePage.getLoginSubmitField().click();
        log.info("Typed login and password and clicked on Login button");
        log.info("Username: " + username);
    }

    @Then("^User is successfully logged in$")
    public void userIsSuccessfullyLoggedIn() throws InterruptedException {
        if(homePage.getPopupWindowStatus()){
            homePage.getDialogPopupCloseButton().click();
            log.info("Popup window was closed");
        }
        Assert.assertTrue(homePage.getButtonExit().isDisplayed());
        log.info("User is successfully logged in");

    }

    @And("^Correct (.+) is displayed on the page$")
    public void correctUserIDIsDisplayedOnThePage(String userid) {
        Assert.assertTrue(homePage.getClientIdField().getText().contains(userid));
        log.info("The UserID of the logged user is correct: " + userid);
    }

    @And("^Close browsers$")
    public void closeBrowsers() {
        driver.quit();
    }
}
