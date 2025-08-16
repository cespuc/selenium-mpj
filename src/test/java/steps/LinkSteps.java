package steps;

import io.cucumber.java.en.When;
import support.Hooks;
import org.openqa.selenium.By;

public class LinkSteps {

    @When("I click the link with text {string}")
    public void i_click_the_link_with_text(String linkText) {
        Hooks.driver.findElement(By.linkText(linkText)).click();
    }
}
