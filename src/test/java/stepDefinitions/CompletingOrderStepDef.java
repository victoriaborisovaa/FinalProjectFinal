package stepDefinitions;

import beforeAfter.BeforeAfter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.LoginPage;


public class CompletingOrderStepDef extends BeforeAfter {
    public WebDriver driver;
    public LoginPage loginPage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    WebElement cartCount = driver.findElement(By.id("shopping_cart_container"));
    By Tshirt = By.id("item_1_title_link");
    By Onesie = By.id("add-to-cart-sauce-labs-onesie");
    By BikeLight = By.id("add-to-cart-sauce-labs-bike-light");


    @Given("the user is on the Product page")
    public void theUserIsOnTheProductPage() {
        driver.navigate().to("https://www.saucedemo.com/inventory.html");
    }

    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String AddToCartButton) {
        cartPage.addTShirt();
        cartPage.addBikeLight();
        cartPage.addBabyOnesie();
        Assert.assertEquals(3, cartPage.getCartItemCount());
    }

    @Then("the user should see a confirmation message that the product has been added to the cart")
    public void theUserShouldSeeAConfirmationMessageThatTheProductHasBeenAddedToTheCart() {
        WebElement confirmationMessage = driver.findElement(By.id("confirmation_message_id"));
        Assert.assertTrue(confirmationMessage.isDisplayed());
    }

    @And("the user should see the updated cart icon with the item count")
    public void theUserShouldSeeTheUpdatedCartIconWithTheItemCount() {
        String itemCount = cartCount.getText();
        Assert.assertTrue("Cart icon item count is not updated", itemCount.contains("3"));
    }

    @When("the user clicks on the cart icon to view the cart")
    public void theUserClicksOnTheCartIconToViewTheCart() {
        cartCount.click();
        driver.navigate().to("https://www.saucedemo.com/cart.html");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        boolean isCorrectUrl = wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/cart.html"));
        Assert.assertTrue(isCorrectUrl);
    }

    @Then("the user should see the added product in the cart with the correct details")
    public void theUserShouldSeeTheAddedProductInTheCartWithTheCorrectDetails() {
        WebElement TshirtElement = driver.findElement(Tshirt);
        WebElement onesieElement = driver.findElement(Onesie);
        WebElement bikeLightElement= driver.findElement(BikeLight);
        Assert.assertTrue("Product is not displayed in the cart", TshirtElement.isDisplayed());
        Assert.assertTrue("Product is not displayed in the cart", onesieElement.isDisplayed());
        Assert.assertTrue("Product is not displayed in the cart", bikeLightElement.isDisplayed());
    }


    @When("the user click on the {string} button")
    public void theUserClickOnTheButton(String CheckoutBtn) {
        WebElement checkoutBtn = driver.findElement(By.id("checkout"));
        checkoutBtn.click();
    }

    @Then("the user should be directed to the checkout page")
    public void theUserShouldBeDirectedToTheCheckoutPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one.html"));
    }


    @When("the user provides valid shipping information")
    public void theUserProvidesValidShippingInformation() {
        checkoutPage.enterFirstName();
        checkoutPage.enterLastName();
        checkoutPage.enterPostalCode();
        Assert.assertEquals("Ivan", driver.findElement(By.id("first-name")).getText());
        Assert.assertEquals("Dimitrov", driver.findElement(By.id("last-name")).getText());
        Assert.assertEquals("1000", driver.findElement(By.id("postal-code")).getText());
    }

    @And("clicks the {string} button")
    public void clicksTheButton(String finishBtn) {
        WebElement finishButtonElement = driver.findElement(By.id("finish"));
        finishButtonElement.click();
    }

    @Then("the user should see an order confirmation message")
    public void theUserShouldSeeAnOrderConfirmationMessage() {
        WebElement confirmationMessage = driver.findElement(By.id("checkout_complete_container"));
        Assert.assertTrue("Order confirmation message is not displayed", confirmationMessage.isDisplayed());
        Assert.assertEquals("Your order has been confirmed", confirmationMessage.getText());
    }
}
