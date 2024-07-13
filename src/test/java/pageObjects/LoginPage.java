package pageObjects;

import beforeAfter.BeforeAfter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BeforeAfter {
    WebDriver driver;

    By usernameLog = By.id("user-name");
    By passwordLog = By.id("password");
    By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        WebElement loginInput = driver.findElement(usernameLog);
        loginInput.sendKeys(username);
        Assert.assertEquals(username, loginInput.getAttribute("standard_user"));
    }

    public void enterPassword(String password) {
        WebElement passInput = driver.findElement(passwordLog);
        passInput.sendKeys(password);
        Assert.assertEquals(password, passInput.getAttribute("secret_sauce"));
    }

    public void clickOnButton() {
        WebElement loginButtonElement = driver.findElement(loginButton);
        loginButtonElement.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement contentWrapper = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contents_wrapper")));
        Assert.assertTrue(contentWrapper.isDisplayed());


        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
    }
}

