package steps;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import support.Hooks;

import static org.junit.Assert.assertTrue;

public class SearchSteps {

    @When("I open Bing homepage")
    public void i_open_bing_homepage() {
        Hooks.driver.get("https://www.bing.com");
    }

    @Then("the Bing title should contain {string}")
    public void the_bing_title_should_contain(String expected) {
        String title = Hooks.driver.getTitle();
        assertTrue(title.contains(expected));
    }
}
