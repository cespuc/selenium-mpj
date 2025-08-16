package steps;

import io.cucumber.java.en.When;
import support.Hooks;
import org.openqa.selenium.By;

public class ButtonSteps {

    @When("I click the button with id {string}")
    public void i_click_the_button_with_id(String buttonId) {
        Hooks.driver.findElement(By.id(buttonId)).click();
    }
}