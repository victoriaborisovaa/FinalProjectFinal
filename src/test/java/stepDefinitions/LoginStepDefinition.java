package stepDefinitions;

import beforeAfter.BeforeAfter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.LoginPage;

import static beforeAfter.BeforeAfter.*;


public class LoginStepDefinition {
   LoginPage loginPage = new LoginPage(BeforeAfter.driver);


    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        BeforeAfter.driver.get("https://www.saucedemo.com/");
    }

    @When("the user enters valid data {string} and {string}")
    public void theUserEntersValidDataAnd(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickOnButton();
    }

    @Then("the login will be successful with title {string}")
    public void theLoginWillBeSuccessfulWithTitle(String ExpectedTitle) {
        driver.navigate().to("https://www.saucedemo.com/inventory.html");
        String actualTitle = driver.getTitle();
        Assert.assertEquals(ExpectedTitle, actualTitle);
    }}
