package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import support.Hooks;
import support.ConfigReader;

import static org.junit.Assert.assertTrue;
import static support.Hooks.driver;

public class LoginSteps {

    @Given("I open page")
    public void i_open_page() {
        // ✅ Just use the driver from Hooks
        driver.get(ConfigReader.get("baseUrl"));
    }

    @Then("the title should contain {string}")
    public void the_title_should_contain(String expected) {
        String title = driver.getTitle();
        assertTrue("Expected title to contain: " + expected + " but was: " + title,
                title.contains(expected));
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {
        // Locate the error message <span>
        String errorText = driver.findElement(By.xpath("//span[contains(text(),'Login was unsuccessful')]")).getText();

        // Assert that correct message is displayed
        Assert.assertEquals(
                "Login was unsuccessful. Please correct the errors and try again.",
                errorText
        );

        // Debug print (optional)
        System.out.println("Displayed error: " + errorText);
    }
}
