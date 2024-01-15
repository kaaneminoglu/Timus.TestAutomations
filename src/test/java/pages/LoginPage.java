package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final By txt_email = By.xpath("//input[@type='text']");
    private final By txt_password = By.xpath("//input[@type='password']");
    private final By btn_continue = By.xpath("//button[@type='submit']");
    private final By lbl_alert = By.xpath("//div[@role='alert']");
    private final By lbl_email_error = By.xpath("//div[contains(text(),'Please enter a valid Email Address.')]");
    private final By lbl_password_error = By.xpath("//div[contains(text(),'Please enter a valid Password Address.')]");
    private final By btn_create_account = By.xpath("//button[@class='el-button el-button--primary']");

    public void setText(String textName, String value) {
        System.out.println("setText started");
        switch (textName) {
            case "email":
                clearText(txt_email);
                sendText(txt_email, value);
                break;
            case "password":
                clearText(txt_password);
                sendText(txt_password, value);
                break;
        }
        System.out.println("setText finished");
    }

    public void clickButton(String buttonName) {
        System.out.println("clickButton started");
        switch (buttonName) {
            case "continue":
                clickWebElement(btn_continue);
                break;
            case "create account":
                clickWebElement(btn_create_account);
                break;
        }
        System.out.println("clickButton finished");
    }

    public void verifyMessage(String message) {
        System.out.println("clickButton started");
        Assert.assertEquals(getText(lbl_alert), message);
        System.out.println("clickButton finished");
    }

    public void checkErrorMessage(String textName) {
        System.out.println("checkErrorMessage started");
        switch (textName) {
            case "email":
                waitDisplayingWebElement(lbl_email_error);
                break;
            case "password":
                waitDisplayingWebElement(lbl_password_error);
                break;
        }
        System.out.println("checkErrorMessage finished");
    }
}