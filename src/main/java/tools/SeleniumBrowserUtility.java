package tools;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import testing.pages.WebPageObjects;

import java.util.ArrayList;
import java.util.List;


/**SeleniumBrowserUtility class
 * @author smlungwana
 * */
public class SeleniumBrowserUtility {

    public static boolean navigateToURL(String url) {
        try {
            WebDriver driver = SeleniumDriver.getInstance().getDriver();
            driver.navigate().to(url);
            Reporting.logPass("Navigated to "+url);
            return true;
        }
        catch(Exception e) {
            Reporting.logError(e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
    }
    public static boolean waitFor(By selector,int timeout) {
        try {
            WebDriver driver = SeleniumDriver.getInstance().getDriver();
            WebDriverWait exists = new WebDriverWait(driver, timeout);

            exists.until(ExpectedConditions.refreshed(
                    ExpectedConditions.visibilityOfElementLocated(selector)));
            Reporting.logInfo("Successfully located element "+selector.toString());
            return true;
        }
        catch(Exception e) {
            Reporting.logError(e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
    }
    public static boolean waitFor(By selector) {
        try {
            WebDriver driver = SeleniumDriver.getInstance().getDriver();
            WebDriverWait exists = new WebDriverWait(driver, 5);

            exists.until(ExpectedConditions.refreshed(
                    ExpectedConditions.visibilityOfElementLocated(selector)));
            Reporting.logInfo("Successfully located element "+selector.toString());
            return true;
        }
        catch(Exception e) {
            Reporting.logError(e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean enterText(String text, By selector) {
        try {
            WebDriver driver = SeleniumDriver.getInstance().getDriver();
            WebElement element = driver.findElement(selector);

            element.sendKeys(text);

            Reporting.logInfo("Successfully entered \""+text+"\" on "+selector.toString());
            return true;
        }
        catch (Exception e) {
            Reporting.logError(e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean waitForClickable(By selector, int timeout) {
        try {
            WebDriver driver = SeleniumDriver.getInstance().getDriver();
            WebDriverWait exists = new WebDriverWait(driver, timeout);
            exists.until(ExpectedConditions.refreshed(
                    ExpectedConditions.elementToBeClickable(selector)));
            Reporting.logInfo("Element "+selector+" is clickable.");
            return true;
        }
        catch(Exception e) {
            Reporting.logError(e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean click(By selector) {
        try {
            WebDriver driver = SeleniumDriver.getInstance().getDriver();
            WebElement element = driver.findElement(selector);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",element);
            Reporting.logInfo("Successfully clicked "+selector.toString());

            return true;
        }
        catch(Exception e) {
            Reporting.logError(e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean selectByText(By selector, String value) {
        try {
            WebDriver driver = SeleniumDriver.getInstance().getDriver();
            Select selectElement = new Select(driver.findElement(selector));
            selectElement.selectByVisibleText(value);

            Reporting.logInfo("Successfully selected \""+value+"\" on "+selector.toString());

            return true;
        }
        catch(Exception e) {
            Reporting.logError(e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static List<String> extractValues(By selector) {
        List<String> valueList = new ArrayList<>();
        try {
            WebDriver driver = SeleniumDriver.getInstance().getDriver();

            List<WebElement> elementList = driver.findElements(selector);
            for (WebElement element : elementList) {
                valueList.add(element.getText());
            }
            Reporting.logInfo("Successfully extracted Items - " + selector);
            return valueList;
        }
        catch (Exception e) {
            Reporting.logError("Failed to extract Items - " + e);
        }
        return null;
    }
}