package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utilities.DriverFactory;

public class Hooks {
    public static WebDriver driver;
    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get("https://manage-st01-us-01.timusnetworks.com");
    }
    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
    public static WebDriver getDriver() {
        return driver;
    }
}
