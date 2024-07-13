package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    By Tshirt = By.id("item_1_title_link");
    By BikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    By Onesie = By.id("add-to-cart-sauce-labs-onesie");
    By BackPack = By.id("item_4_img_link");
    By FleeceJacket = By.id("item_5_title_link");
    By RedTshirt = By.id("item_3_title_link");
    By addBackpackBtn = By.id("add-to-cart-sauce-labs-backpack");
    By addRedTshirtBtn = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    By addJacketBtn = By.id("add-to-cart-sauce-labs-fleece-jacket");
    By removeJacketBtn = By.id("remove-sauce-labs-fleece-jacket");
    By removeRedTshirtBtn = By.id("remove-test.allthethings()-t-shirt-(red)");
    By removeBackPackBtn = By.id("remove-sauce-labs-backpack");
    By cartCount = By.id("shopping_cart_container");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCartItems() {
        WebElement backPackBtnElement = driver.findElement(addBackpackBtn);
        WebElement fleeceJacketBtnElement = driver.findElement(addJacketBtn);
        WebElement redTshirtBtnElement = driver.findElement(addRedTshirtBtn);

        backPackBtnElement.click();
        fleeceJacketBtnElement.click();
        redTshirtBtnElement.click();
    }

    public void checkCartCount() {
        WebElement countElement = driver.findElement(cartCount);
        String countText = countElement.getText();
        Assert.assertEquals("3", countText);
    }

    public void removeItems() {
        WebElement removeJacketElement = driver.findElement(removeJacketBtn);
        WebElement removeRedTshirtElement = driver.findElement(removeRedTshirtBtn);
        WebElement removeBackPackElement = driver.findElement(removeBackPackBtn);

        removeJacketElement.click();
        removeBackPackElement.click();
        removeRedTshirtElement.click();
    }

    public void clickToPreviewItem() {
        WebElement backPackElement = driver.findElement(BackPack);
        backPackElement.click();

        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory-item.html?id=4"));

        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/inventory-item.html?id=4", actualUrl);
    }
}
