package browserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;


public class BrowserFactory {
    public static WebDriver driver;

    public static WebDriver getBrowser(String browserName) {

        switch (browserName) {
            case "Chrome":
                if (driver == null) {
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\vikiv\\IdeaProjects\\NewFinalProject\\src\\test\\resources\\drivers\\chromedriver.exe");
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(options);
                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                }
                return driver = new ChromeDriver();
            case "Edge":
                System.setProperty("webdriver.edge.driver", "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
                return driver = new EdgeDriver();
            default:
                throw new IllegalArgumentException("Undefined or Unsupported browser type" + browserName);
        }

    }
}



