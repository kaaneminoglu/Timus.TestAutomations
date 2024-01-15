package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps extends LoginPage {
    @When("{string} and {string} are entered.")
    public void setMailAndPassword(String email, String password) {
        setText("email", email);
        setText("password", password);
        clickButton("continue");
    }

    @Then("Verify the alert is {string}")
    public void verifyTheAlertIs(String messageText) {
        verifyMessage(messageText);
    }

    @Then("Validation check for {string} field.")
    public void validationCheckForField(String fieldName) {
        checkErrorMessage(fieldName);
    }

    @Given("Click create account button.")
    public void clickCreateAccountButton() {
        clickButton("create account");
    }
}
