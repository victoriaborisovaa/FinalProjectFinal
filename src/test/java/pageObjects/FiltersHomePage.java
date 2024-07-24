package pageObjects;

import beforeAfter.BeforeAfter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FiltersHomePage extends BeforeAfter {

    private WebDriver driver;
    By filterBtn = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select");
    By AtoZOption = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[1]");
    By ZtoAOption = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[2]");
    By lowToHighOption = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]");
    By highToLowOption = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[4]");

    public FiltersHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectAtoZFilter() {
        WebElement AtoZFilterElement = driver.findElement(AtoZOption);
        AtoZFilterElement.click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeSelected(AtoZFilterElement));
        WebElement selectedOption = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[@selected='selected']"));
        Assert.assertEquals("Name (A to Z)", selectedOption.getText());
    }

    public void selectZtoAFilter() {
        WebElement ZtoAFilterElement = driver.findElement(ZtoAOption);
        ZtoAFilterElement.click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeSelected(ZtoAFilterElement));
        WebElement selectedOption = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[@selected='selected']"));
        Assert.assertEquals("Name (Z to A)", selectedOption.getText());
    }

    public void selectLowToHighFilter() {
        WebElement lowToHighElement = driver.findElement(lowToHighOption);
        lowToHighElement.click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeSelected(lowToHighElement));
        WebElement selectedOption = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[@selected='selected']"));
        Assert.assertEquals("Price (low to high)", selectedOption.getText());
    }

    public void selectHighToLowFilter() {
        WebElement highToLowElement = driver.findElement(highToLowOption);
        highToLowElement.click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.elementToBeSelected(highToLowElement));
        WebElement selectedOption = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[@selected='selected']"));
        Assert.assertEquals("Price (high to low)", selectedOption.getText());
    }
}

