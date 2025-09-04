package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import support.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.UUID;

import static support.Hooks.driver;

public class LinkSteps {

    @When("I click the link with text {string}")
    public void i_click_the_link_with_text(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }
    // Reusable step to type into input fields by their "name" attribute
    @When("I enter {string} into the {string} field")
    public void iEnterIntoTheField(String text, String fieldName) {
        WebElement inputField = driver.findElement(By.name(fieldName));
        inputField.clear();
        inputField.sendKeys(text);
        System.out.println("✅ Entered '" + text + "' into field: " + fieldName);
    }
    @When("I enter a random email into the Email field")
    public void iEnterRandomEmail() {
        String randomEmail = "user_" + UUID.randomUUID().toString().substring(0,8) + "@test.com";

        WebElement emailField = driver.findElement(By.name("Email"));
        emailField.clear();
        emailField.sendKeys(randomEmail);

        System.out.println("✅ Entered random email: " + randomEmail);
    }
    @When("I click on the {string} button")
    public void iClickOnTheButton(String buttonText) {
        // Find button by its visible text
        WebElement button = driver.findElement(By.xpath("//input[@type='submit' and @value='" + buttonText + "']"));
        button.click();
        System.out.println("✅ Clicked on button: " + buttonText);
    }
    @Then("I should see the registration success message")
    public void iShouldSeeTheRegistrationSuccessMessage() {
        WebElement successMessage = driver.findElement(By.cssSelector("div.result"));

        String actualText = successMessage.getText();
        String expectedText = "Your registration completed";

        Assert.assertEquals("❌ Registration message does not match!", expectedText, actualText);
        System.out.println("✅ Registration verified: " + actualText);
    }

}
