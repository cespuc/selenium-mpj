package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import support.Hooks;
import support.ConfigReader;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    @Given("I open page")
    public void i_open_page() {
        // ✅ Just use the driver from Hooks
        Hooks.driver.get(ConfigReader.get("baseUrl"));
    }

    @Then("the title should contain {string}")
    public void the_title_should_contain(String expected) {
        String title = Hooks.driver.getTitle();
        assertTrue("Expected title to contain: " + expected + " but was: " + title,
                title.contains(expected));
    }
}
