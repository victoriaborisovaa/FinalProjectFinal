package stepDefinitions;

import beforeAfter.BeforeAfter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class ProductFilteringStepDefinition  {
    public WebDriver driver;
    public LoginPage loginPage;
    public BeforeAfter beforeAfter = new BeforeAfter();


    By price = By.id("inventory_container");


    @Given("the user is on the product listing page")
    public void theUserIsOnTheProductListingPage() {
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized");
        }
        driver.get("https://www.saucedemo.com/inventory.html");
    }

    @When("the user selects a specific filter from the filter options")
    public void theUserSelectsASpecificFilterFromTheFilterOptions() {
        WebElement filterDropdown = driver.findElement(By.className("product_sort_container"));
        filterDropdown.click();
        WebElement filterAtoZ = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[1]"));
        filterAtoZ.click();
    }

    @Then("the user should see the filtered products")
    public void theUserShouldSeeTheFilteredProducts() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement filteredProduct = driver.findElement(By.xpath("//*[@id=\"item_4_img_link\"]/img"));
        wait.until(ExpectedConditions.visibilityOf(filteredProduct));

        String firstProductName = driver.findElement(By.className("inventory_item_name")).getText();
        Assert.assertTrue("The products are not sorted correctly", firstProductName.startsWith("A"));
    }}

