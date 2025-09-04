package support;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.ConfigReader;

public class Hooks {

    public static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        // Get browser from system property or config
        String browser = System.getProperty("browser", ConfigReader.get("browser"));
        System.out.println("Launching browser: " + browser);

        // Initialize driver via DriverFactory
        driver = DriverFactory.getDriver(browser);

        // Navigate to base URL
        String baseUrl = ConfigReader.get("baseUrl");
        driver.get(baseUrl);

        System.out.println("✅ Browser started and navigated to: " + baseUrl);
    }

    @AfterAll
    public static void tearDown() {
        // Quit driver once after all tests
        DriverFactory.quitDriver();
        System.out.println("✅ Browser closed after all tests");
    }
}
