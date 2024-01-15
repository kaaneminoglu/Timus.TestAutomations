package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepdefinitions.Hooks;

import java.time.Duration;

public class BasePage {
    private final WebDriver driver = Hooks.getDriver();

    protected void clickWebElement(By locator) {
        try {
            System.out.println("Click web element: " + locator);
            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(3), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void sendText(By locator, String text) {
        try {
            System.out.println("Send text: " + locator);
            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(3), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void clearText(By locator) {
        try {
            System.out.println("Clear text: " + locator);
            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(3), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(locator)).clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected String getText(By locator) {
        System.out.println("Get text: " + locator);
        try {
            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(15), Duration.ofSeconds(0));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
        } catch (Exception e) {
            return "No text";
        }
    }

    protected Boolean webElementIsEnabled(By locator) {
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(3), Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).findElement(locator).isEnabled();
    }

    protected Boolean webElementIsDisplayed(By locator) {
        try {
            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(3), Duration.ofSeconds(5));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void waitBySeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitDisplayingWebElement(By locator) {
        try {
            System.out.println("Wait Displaying Web Element: " + locator);
            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(3), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeToIFrame(int id) {
        System.out.println("Change to iframe: " + id);
        driver.switchTo().frame(id);
    }

    public void switchToDefaultIFrame() {
        System.out.println("Change to default iframe: ");
        driver.switchTo().defaultContent();
    }

    public void scrollToDown() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}