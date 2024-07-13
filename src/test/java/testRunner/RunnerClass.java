package testRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(value = Cucumber.class)
@CucumberOptions(strict = true,
        features = {"classpath:features/"},
        glue = {"classpath:Steps"},
        tags = "@Smoke",
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html"},
        monochrome = true
)
public class RunnerClass { }


