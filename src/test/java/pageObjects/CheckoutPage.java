package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {

    private WebDriver driver;
    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueButton = By.id("continue");
    By totalSum = By.id("checkout_summary_container");
    By finishButton = By.id("finish");
    By completeOrder = By.id("checkout_complete_container");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName() {
        WebElement firstNameElement = driver.findElement(firstName);
        firstNameElement.sendKeys("Ivan");
        Assert.assertEquals("Ivan", firstNameElement.getAttribute("value"));
    }

    public void enterLastName() {
        WebElement lastNameElement = driver.findElement(lastName);
        lastNameElement.sendKeys("Dimitrov");
        Assert.assertEquals("Dimitrov", lastNameElement.getAttribute("value"));
    }

    public void enterPostalCode() {
        WebElement postalCodeElement = driver.findElement(postalCode);
        postalCodeElement.sendKeys("1000");
        Assert.assertEquals("1000", postalCodeElement.getAttribute("value"));
    }

    public void pressContinueButton() {
        WebElement continueButtonElement = driver.findElement(continueButton);
        continueButtonElement.click();
        WebElement totalSumElement = driver.findElement(totalSum);
        Assert.assertTrue(totalSumElement.isDisplayed());
    }

    public void finishButtonClick() {
        WebElement finishBtnElement = driver.findElement(finishButton);
        finishBtnElement.click();
        WebElement completeOrderElement = driver.findElement(completeOrder);
        Assert.assertTrue(completeOrderElement.isDisplayed());
    }

    public void completeOrderText() {
        WebElement completeOrderElement = driver.findElement(completeOrder);
        Assert.assertTrue(completeOrderElement.isDisplayed());
    }

    public String getTotalSum() {
        WebElement totalSumElement = driver.findElement(totalSum);
        String totalText = totalSumElement.getText();
        Assert.assertFalse(totalText.isEmpty());
        return totalText;
    }

    public String completeOrderFinal() {
        WebElement completeOrderElement = driver.findElement(completeOrder);
        String completeText = completeOrderElement.getText();
        Assert.assertFalse(completeText.isEmpty());
        return completeText;
    }
}
