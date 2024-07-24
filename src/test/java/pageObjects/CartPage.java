package pageObjects;

import beforeAfter.BeforeAfter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BeforeAfter {
    private WebDriver driver;
    By Tshirt = By.id("item_1_title_link");
    By BikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    By Onesie = By.id("add-to-cart-sauce-labs-onesie");
    By ShoppingCartButton = By.id("shopping_cart_container");
    By ShoppingCount = By.id("shopping_cart_container");
    By CheckoutButton = By.id("checkout");
    By ProductAssert = By.id("header_container");
    By CartCount = By.id("shopping_cart_container");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addTShirt() {
        WebElement TshirtElement = driver.findElement(Tshirt);
        TshirtElement.click();
    }

    public void addBabyOnesie() {
        WebElement OnesieElement = driver.findElement(Onesie);
        OnesieElement.click();
    }

    public void addBikeLight() {
        WebElement BikeLightElement = driver.findElement(BikeLight);
        BikeLightElement.click();
    }

    public int getCartItemCount() {
        WebElement cartBadge = driver.findElement(CartCount);
        if (cartBadge.isDisplayed()) {
            return Integer.parseInt(cartBadge.getText());
        } else {
            return 0;
        }
    }

    public void checkCart(int expectedCount) {
        WebElement countElement = driver.findElement(ShoppingCount);
        String countText = countElement.getText();
        Assert.assertEquals(String.valueOf(expectedCount), countText);
    }

    public void cartBtn() {
        WebElement cartButtonElement = driver.findElement(ShoppingCartButton);
        cartButtonElement.click();
    }

    public void productAssert() {
        WebElement productAssertElement = driver.findElement(ProductAssert);
        Assert.assertTrue(productAssertElement.isDisplayed());
    }

    public void checkout() {
        WebElement checkoutBtnElement = driver.findElement(CheckoutButton);
        checkoutBtnElement.click();
    }
}
