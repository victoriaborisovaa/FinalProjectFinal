package beforeAfter;
import browserFactory.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.concurrent.TimeUnit;

import static browserFactory.BrowserFactory.driver;

public class BeforeAfter extends BrowserFactory {

@Before
    public void startBrowser() {
        driver = BrowserFactory.getBrowser("Chrome");
        driver.manage().window().maximize();
    }

    @After

    public void teardown() {

        if (driver != null) {

            driver.quit();
        }
    }
}


