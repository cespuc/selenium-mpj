package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.time.Duration;


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
    @Then("I should see the message {string}")
    public void iShouldSeeTheMessage(String expectedMessage) {
        WebElement messageElement = driver.findElement(By.cssSelector("div.result, div.validation-summary-errors, span.field-validation-error"));

        String actualMessage = messageElement.getText().trim();

        Assert.assertTrue(
                "❌ Expected message not found. Actual: " + actualMessage,
                actualMessage.contains(expectedMessage)
        );

        System.out.println("✅ Verified message: " + actualMessage);
    }
    @When("I navigate to the home page")
    public void iNavigateToTheHomePage() {
        driver.get("https://demowebshop.tricentis.com/");
        System.out.println("✅ Navigated to homepage");
    }

    @When("I click the Continue button")
    public void iClickTheContinueButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement continueButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("input.register-continue-button"))
        );

        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueButton);

        // Click using JS to avoid overlay issues
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueButton);

        System.out.println("✅ Continue button clicked");
    }

}
