package steps;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import support.Hooks;

import static org.junit.Assert.assertTrue;
import static support.Hooks.driver;

public class SearchSteps {

    @When("I open Bing homepage")
    public void i_open_bing_homepage() {
        driver.get("https://www.bing.com");
    }

    @Then("the Bing title should contain {string}")
    public void the_bing_title_should_contain(String expected) {
        String title = driver.getTitle();
        assertTrue(title.contains(expected));
    }

    @When("user navigates to My account page")
    public void user_navigates_to_my_account_page() {
        driver.findElement(By.className("account")).click(); // Click My Account link
    }

    @Then("customer info should display first name {string} last name {string} and email {string}")
    public void customer_info_should_display_first_name_last_name_and_email(String expectedFirst, String expectedLast, String expectedEmail) {
        // Locate input fields
        String actualFirst = driver.findElement(By.id("FirstName")).getAttribute("value");
        String actualLast  = driver.findElement(By.id("LastName")).getAttribute("value");
        String actualEmail = driver.findElement(By.id("Email")).getAttribute("value");

        // Verify values
        Assert.assertEquals("First name does not match", expectedFirst, actualFirst);
        Assert.assertEquals("Last name does not match", expectedLast, actualLast);
        Assert.assertEquals("Email does not match", expectedEmail, actualEmail);

        // Debug print
        System.out.println("Verified Customer Info: " + actualFirst + " " + actualLast + " / " + actualEmail);
    }
}
