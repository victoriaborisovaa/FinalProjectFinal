package pageObjects;

import beforeAfter.BeforeAfter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderAndFooterHomePage extends BeforeAfter {
    WebDriver driver;

    By logo = By.id("header_container");
    By hamburgerButton = By.id("react-burger-menu-btn");
    By cartButton = By.id("shopping_cart_container");
    By xButton = By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[1]/a");
    By facebookBtn = By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[2]/a");
    By linkedInBtn = By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[3]/a");

    public HeaderAndFooterHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void visibleLogo() {
        WebElement logoElement = driver.findElement(logo);
        Assert.assertTrue(logoElement.isDisplayed());
    }

    public void clickHamburgerBtn() {
        WebElement hamburgerBtnElement = driver.findElement(hamburgerButton);
        hamburgerBtnElement.click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bm-menu-wrap")));
        Assert.assertTrue(menu.isDisplayed());
    }

    public void clickCartBtn() {
        WebElement cartBtnElement = driver.findElement(cartButton);
        cartBtnElement.click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        boolean isCorrectUrl = wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/cart.html"));
        Assert.assertTrue(isCorrectUrl);
    }

    public void clickXBtn() {
        WebElement xBtnElement = driver.findElement(xButton);
        xBtnElement.click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        boolean isCorrectUrl = wait.until(ExpectedConditions.urlToBe("https://twitter.com/saucelabs"));
        Assert.assertTrue(isCorrectUrl);
    }

    public void clickFacebookBtn() {
        WebElement facebookBtnElement = driver.findElement(facebookBtn);
        facebookBtnElement.click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        boolean isCorrectUrl = wait.until(ExpectedConditions.urlToBe("https://www.facebook.com/saucelabs"));
        Assert.assertTrue(isCorrectUrl);
    }

    public void clickLinkedInBtn() {
        WebElement linkedInBtnElement = driver.findElement(linkedInBtn);
        linkedInBtnElement.click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        boolean isCorrectUrl = wait.until(ExpectedConditions.urlToBe("https://www.linkedin.com/company/sauce-labs/"));
        Assert.assertTrue(isCorrectUrl);
    }
}
