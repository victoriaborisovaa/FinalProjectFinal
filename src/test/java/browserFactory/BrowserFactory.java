package browserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class BrowserFactory {
    public static WebDriver driver;

    public static WebDriver getBrowser(String browserName) {

        switch (browserName) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver",
                        "\"C:\\Users\\vikiv\\OneDrive\\Работен плот\\chromedriver-win64\\chromedriver.exe\"");
                return driver = new ChromeDriver();
            case "Edge":
                System.setProperty("webdriver.edge.driver", "\"C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe\"");
                return driver = new EdgeDriver();
            default:
                throw new IllegalArgumentException("Undefined or Unsupported browser type" + browserName);
        }
    }
}



