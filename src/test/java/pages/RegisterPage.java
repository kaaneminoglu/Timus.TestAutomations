package pages;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;

public class RegisterPage extends BasePage {
    private final By txt_first_name = By.xpath("//input[@data-testid='register-firstname-input']");
    private final By txt_last_name = By.xpath("//input[@data-testid='register-lastname-input']");
    private final By txt_email_address = By.xpath("//input[@autocomplete='new-password']");
    private final By cmb_country = By.xpath("//input[@placeholder='Select']");
    private final By chb_privacy_policy = By.xpath("//label[@id='privacy_box']//span[@class='el-checkbox__inner']");
    private final By chb_terms_and_service = By.xpath("//label[@id='term_of_use_box']//span[@class='el-checkbox__inner']");
    private final By btn_continue = By.xpath("//button[@class='el-button el-button--danger']");
    private final By btn_read_and_accept = By.xpath("//button[contains(.,'I have read and accept')]");
    private final By lbl_dialog_title = By.xpath("//span[@class='el-dialog__title']");
    private final By lbl_first_name = By.xpath("//div[contains(text(),'Please fill First Name field.')]");
    private final By lbl_last_name = By.xpath("//div[contains(text(),'Please fill Last Name field.')]");
    private final By lbl_email_address = By.xpath("//div[contains(text(),'Please fill Email Address field.')]");
    private final By lbl_country = By.xpath("//div[contains(text(),'Please select a country.')]");
    private final By lbl_verify_email_address = By.xpath("//h1[normalize-space()='Please verify your email address.']");
    static Faker fake = new Faker();
    public void setText(String textName, String value) {
        System.out.println("setText started");
        switch (textName) {
            case "name":
                clearText(txt_first_name);
                sendText(txt_first_name, value);
                break;
            case "surname":
                clearText(txt_last_name);
                sendText(txt_last_name, value);
                break;
            case "email":
                clearText(txt_email_address);
                sendText(txt_email_address, value);
                break;
        }
        System.out.println("setText finished");
    }

    public void clickButton(String buttonName) {
        System.out.println("clickButton started");
        if (buttonName.equals("continue")) {
            clickWebElement(btn_continue);
        }
        System.out.println("clickButton finished");
    }

    public void selectCountry(String countryName) {
        System.out.println("selectCountry started");
        clickWebElement(cmb_country);
        sendText(cmb_country, countryName);
        String selectedCountry = "//span[normalize-space()='" + countryName + "']";
        clickWebElement(By.xpath(selectedCountry));
        System.out.println("selectCountry finished");
    }

    public void registerIndex(String registerName) {
        System.out.println("registerIndex started");
        switch (registerName) {
            case "Privacy Policy":
                clickWebElement(chb_privacy_policy);
                break;
            case "Terms of Service":
                clickWebElement(chb_terms_and_service);
                break;
        }
        Assert.assertEquals(getText(lbl_dialog_title), registerName);
        Assert.assertFalse(webElementIsEnabled(btn_read_and_accept));
        waitBySeconds(2);
        changeToIFrame(0);
        scrollToDown();
        switchToDefaultIFrame();
        Assert.assertTrue(webElementIsEnabled(btn_read_and_accept));
        clickWebElement(btn_read_and_accept);
        System.out.println("registerIndex finished");
    }

    public void checkErrorMessage(String textName, String validationCheck) {
        System.out.println("checkErrorMessage started");
        switch (textName) {
            case "firstname":
                Assert.assertEquals(webElementIsDisplayed(lbl_first_name),Boolean.parseBoolean(validationCheck));
                break;
            case "lastname":
                Assert.assertEquals(webElementIsDisplayed(lbl_last_name),Boolean.parseBoolean(validationCheck));
                break;
            case "email":
                Assert.assertEquals(webElementIsDisplayed(lbl_email_address),Boolean.parseBoolean(validationCheck));
                break;
            case "country":
                Assert.assertEquals(webElementIsDisplayed(lbl_country),Boolean.parseBoolean(validationCheck));
                break;
        }
        System.out.println("checkErrorMessage finished");
    }

    public void addFakeMandatoryFields() {
        System.out.println("clickButton started");
        setText("name",fake.name().firstName());
        setText("surname",fake.name().lastName());
        setText("email",fake.internet().emailAddress());
        selectCountry(fake.country().name());
        System.out.println("clickButton finished");
    }

    public void checkCreateAccountMessage() {
        System.out.println("checkCreateAccountMessage started");
        webElementIsDisplayed(lbl_verify_email_address);
        System.out.println("checkCreateAccountMessage finished");
    }
}