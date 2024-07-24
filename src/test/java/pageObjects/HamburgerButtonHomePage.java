package pageObjects;

import beforeAfter.BeforeAfter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HamburgerButtonHomePage extends BeforeAfter {
    private WebDriver driver;

    By hamburgerButton = By.id("react-burger-menu-btn");
    By allItemsBtn = By.id("inventory_sidebar_link");
    By aboutBtn = By.id("about_sidebar_link");
    By logoutBtn = By.id("logout_sidebar_link");
    By resetAppStateBtn = By.id("reset_sidebar_link");

    public HamburgerButtonHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnHamburgerButton() {
        WebElement hamburgerBtnElement = driver.findElement(hamburgerButton);
        hamburgerBtnElement.click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bm-menu-wrap")));
        Assert.assertTrue(menu.isDisplayed());
    }

    public void clickOnAllItemsBtn() {
        WebElement allItemsBtnElement = driver.findElement(allItemsBtn);
        allItemsBtnElement.click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        boolean isCorrectUrl = wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
        Assert.assertTrue(isCorrectUrl);
    }

    public void clickOnAboutButton() {
        WebElement aboutBtnElement = driver.findElement(aboutBtn);
        aboutBtnElement.click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement aboutPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]")));
        Assert.assertTrue(aboutPageElement.isDisplayed());
    }

    public void clickOnLogoutBtn() {
        WebElement logoutBtnElement = driver.findElement(logoutBtn);
        logoutBtnElement.click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        boolean isCorrectUrl = wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/"));
        Assert.assertTrue(isCorrectUrl);
    }

    public void clickOnResetAppStateBtn() {
        WebElement resetAppStateBtnElement = driver.findElement(resetAppStateBtn);
        resetAppStateBtnElement.click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement cartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge")));
        Assert.assertTrue(cartBadge.getText().isEmpty());
    }
}
