package steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;
import support.Hooks;

public class ButtonSteps {

    @Then("I should see First name error message")
    public void iShouldSeeFirstNameErrorMessage() {
        WebDriver driver = Hooks.driver;
        if (driver == null) {
            throw new IllegalStateException("❌ WebDriver is NULL. Did you initialize Hooks.driver?");
        }

        // Click Register to trigger validation
        WebElement registerBtn = driver.findElement(By.id("register-button"));
        registerBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By firstNameErrorLocator = By.cssSelector("span[for='FirstName']");

        WebElement errorElement;
        try {
            errorElement = wait.until(ExpectedConditions.presenceOfElementLocated(firstNameErrorLocator));
        } catch (Exception e) {
            throw new AssertionError("❌ First Name error message element not found on the page. " +
                    "Check if the Register button was clicked or locator is correct.");
        }

        if (!errorElement.isDisplayed()) {
            throw new AssertionError("❌ First Name error message is present but not visible.");
        }

        String actualMessage = errorElement.getText().trim();
        System.out.println("✅ First Name error message displayed: " + actualMessage);

        Assert.assertEquals("First name is required.", actualMessage);
    }

    @Then("I should see error message for {string}")
    public void iShouldSeeErrorMessageForField(String fieldName) {
        WebDriver driver = Hooks.driver;
        if (driver == null) {
            throw new IllegalStateException("❌ WebDriver is NULL. Did you initialize Hooks.driver?");
        }

        // Click Register button to trigger validation
        WebElement registerBtn = driver.findElement(By.id("register-button"));
        registerBtn.click();

        // Map field name to its 'for' attribute in the span
        String forAttribute = "";
        switch (fieldName.toLowerCase().trim()) {
            case "first name":
                forAttribute = "FirstName";
                break;
            case "last name":
                forAttribute = "LastName";
                break;
            case "email":
                forAttribute = "Email";
                break;
            case "password":
                forAttribute = "Password";
                break;
            case "confirm password":
                forAttribute = "ConfirmPassword";
                break;
            default:
                throw new IllegalArgumentException("❌ Unknown field: " + fieldName);
        }

        By errorLocator = By.cssSelector("span[for='" + forAttribute + "']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement;
        try {
            errorElement = wait.until(ExpectedConditions.presenceOfElementLocated(errorLocator));
        } catch (Exception e) {
            throw new AssertionError("❌ Error message for '" + fieldName + "' not found on the page.");
        }

        if (!errorElement.isDisplayed()) {
            throw new AssertionError("❌ Error message for '" + fieldName + "' is present but not visible.");
        }

        String actualMessage = errorElement.getText().trim();
        System.out.println("✅ Error message for '" + fieldName + "': " + actualMessage);

        // Optional: verify exact message text
        Assert.assertEquals(fieldName + " is required.", actualMessage);
    }

    @Then("I should see error message for {string} with text {string}")
    public void iShouldSeeErrorMessageForFieldWithText(String fieldName, String expectedMessage) {
        WebDriver driver = Hooks.driver;
        if (driver == null) {
            throw new IllegalStateException("❌ WebDriver is NULL. Did you initialize Hooks.driver?");
        }

        // Click Register button to trigger validation
        WebElement registerBtn = driver.findElement(By.id("register-button"));
        registerBtn.click();

        // Map field name to its 'for' attribute in the span
        String forAttribute;
        switch (fieldName.toLowerCase().trim()) {
            case "first name":
                forAttribute = "FirstName";
                break;
            case "last name":
                forAttribute = "LastName";
                break;
            case "email":
                forAttribute = "Email";
                break;
            case "password":
                forAttribute = "Password";
                break;
            case "confirm password":
                forAttribute = "ConfirmPassword";
                break;
            default:
                throw new IllegalArgumentException("❌ Unknown field: " + fieldName);
        }

        By errorLocator = By.cssSelector("span[for='" + forAttribute + "']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement errorElement;
        try {
            errorElement = wait.until(ExpectedConditions.presenceOfElementLocated(errorLocator));
        } catch (Exception e) {
            throw new AssertionError("❌ Error message for '" + fieldName + "' not found on the page.");
        }

        if (!errorElement.isDisplayed()) {
            throw new AssertionError("❌ Error message for '" + fieldName + "' is present but not visible.");
        }

        String actualMessage = errorElement.getText().trim();
        System.out.println("✅ Error message for '" + fieldName + "': " + actualMessage);

        // Assert actual vs expected message
        Assert.assertEquals("Validation message mismatch for " + fieldName, expectedMessage, actualMessage);
    }

} // <-- make sure this is the last closing brace of the class
