package stepDefinitions;

import beforeAfter.BeforeAfter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;

public class LoginStepDefinition extends BeforeAfter {
    public WebDriver driver;
    public LoginPage loginPage;


    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        driver.navigate().to("https://www.saucedemo.com/");
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
    }
}
