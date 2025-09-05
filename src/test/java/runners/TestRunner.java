package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = {"steps", "support"},   // 👈 include both packages
        plugin = {"pretty", "html:target/cucumber-report.html"},
        tags = "@smoke"
)
public class TestRunner {}
