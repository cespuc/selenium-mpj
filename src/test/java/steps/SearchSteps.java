package steps;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import support.Hooks;

import static org.junit.Assert.assertTrue;
import static support.Hooks.driver;

public class SearchSteps {


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

    @Then("I accept the browser popup")
    public void i_accept_the_browser_popup() {
        try {
            // Switch focus to alert
            Alert alert = driver.switchTo().alert();

            // Print the text (optional, for debugging)
            System.out.println("Popup text: " + alert.getText());

            // Click OK (accept)
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert popup appeared.");
        }
    }
}
