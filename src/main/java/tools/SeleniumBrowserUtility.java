package tools;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


/**SeleniumBrowserUtility class for interacting with browser elements.
 * @author smlungwana
 * */
public class SeleniumBrowserUtility {

    /**navigateToURL method to navigate browser to specified URL.
     * 	@throws	Exception
     */
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


    /**waitFor method to wait for element to be visible. Takes an integer as timeout.
     * 	@throws	Exception
     */
    public static boolean waitFor(WebElement element,int timeout) {
        try {
            WebDriver driver = SeleniumDriver.getInstance().getDriver();
            WebDriverWait exists = new WebDriverWait(driver, timeout);

            exists.until(ExpectedConditions.refreshed(
                    ExpectedConditions.visibilityOf(element)));
            Reporting.logInfo("Successfully located element "+element.toString());
            return true;
        }
        catch(Exception e) {
            Reporting.logError(e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean waitFor(String predicateString, int timeout) {
        try {
            WebDriver driver = SeleniumDriver.getInstance().getDriver();
            WebDriverWait wait = new WebDriverWait(driver, timeout);

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    MobileBy.iOSNsPredicateString(predicateString)));
            Reporting.logInfo("Successfully located element with predicate string "+predicateString);
            return true;
        }
        catch(Exception e) {
            Reporting.logError(e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**waitFor method to wait for element to be visible.
     * 	@throws	Exception
     */
    public static boolean waitFor(WebElement element) {
        try {
            WebDriver driver = SeleniumDriver.getInstance().getDriver();
            WebDriverWait exists = new WebDriverWait(driver, 10);

            exists.until(ExpectedConditions.refreshed(
                    ExpectedConditions.visibilityOf(element)));
            Reporting.logInfo("Successfully located element "+element.toString());
            return true;
        }
        catch(Exception e) {
            Reporting.logError(e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**enterText method to enter text on text input field.
     * 	@throws	Exception
     */
    public static boolean enterText(WebElement element,String text) {
        try {

            element.sendKeys(text);

            Reporting.logInfo("Successfully entered \""+text+"\" on "+element.toString());
            return true;
        }
        catch (Exception e) {
            Reporting.logError(e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**waitForClickable	method to wait for element to be clickable.
     * 	@throws	Exception
     */
    public static boolean waitForClickable(WebElement element, int timeout) {
        try {
            WebDriver driver = SeleniumDriver.getInstance().getDriver();
            WebDriverWait exists = new WebDriverWait(driver, timeout);
            exists.until(ExpectedConditions.refreshed(
                    ExpectedConditions.elementToBeClickable(element)));
            Reporting.logInfo("Element "+element+" is clickable.");
            return true;
        }
        catch(Exception e) {
            Reporting.logError(e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**click method to click an element e.g 'button'.
     * 	@throws	Exception
     */
    public static boolean click(WebElement element) {
        try {
            WebDriver driver = SeleniumDriver.getInstance().getDriver();

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",element);
            Reporting.logInfo("Successfully clicked "+element.toString());

            return true;
        }
        catch(Exception e) {
            Reporting.logError(e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**selectByText method to select value from dropdown.
     * 	@throws	Exception
     */
    public static boolean selectByText(WebElement element, String value) {
        try {
            WebDriver driver = SeleniumDriver.getInstance().getDriver();
            Select selectElement = new Select(element);
            selectElement.selectByVisibleText(value);

            Reporting.logInfo("Successfully selected \""+value+"\" on "+element.toString());

            return true;
        }
        catch(Exception e) {
            Reporting.logError(e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**extractValues method to extracts elements from the DOM structure.
     * 	@throws	Exception
     */
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