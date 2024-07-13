package beforeAfter;
import browserFactory.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BeforeAfter {
    public WebDriver driver ;

    @Before

    public void setUp() {

            // Use WebDriverManager to manage the WebDriver binary
            WebDriverManager.chromedriver().setup();

            // Initialize the WebDriver
            driver = new ChromeDriver();

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver(options);
//        driver = BrowserFactory.getBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
//        driver.get("https://www.saucedemo.com/");

    }

    @After

    public void teardown() {

        if (driver != null) {

            driver.quit();
        }
    }
}


