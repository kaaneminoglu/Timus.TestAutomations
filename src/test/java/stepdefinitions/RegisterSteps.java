package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegisterPage;

public class RegisterSteps extends RegisterPage {
    @When("Name {string}, surname {string}, email address {string} fields are filled in and country {string} is selected.")
    public void nameSurnameEmailAddressFieldsAreFilledInAndCountryIsSelected(String name, String surname, String email, String country) {
        setText("name", name);
        setText("surname", surname);
        setText("email", email);
        selectCountry(country);
    }

    @When("Accept {string}.")
    public void accept(String readAcceptName) {
        registerIndex(readAcceptName);
    }

    @When("Click continue button")
    public void clickContinueButton() {
        clickButton("continue");
        waitBySeconds(1);
    }

    @Then("Register page {string} validation check for {string} field.")
    public void validationCheckForField(String validationCheck, String fieldName) {
        checkErrorMessage(fieldName, validationCheck);
    }

    @When("Mandatory fields are filled.")
    public void mandatoryFieldsAreFilled() {
        addFakeMandatoryFields();
    }

    @Then("Check create account")
    public void checkCreateAccount() {
        checkCreateAccountMessage();
    }
}
