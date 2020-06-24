package tools;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


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
            Reporting.logFailure(e.getMessage());
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
            Reporting.logDebug("Successfully located element "+selector.toString());
            return true;
        }
        catch(Exception e) {
            Reporting.logFailure(e.getMessage());
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
            Reporting.logDebug("Successfully located element "+selector.toString());
            return true;
        }
        catch(Exception e) {
            Reporting.logFailure(e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
    }
    public static boolean waitForClickable(By selector) {
        try {
            WebDriver driver = SeleniumDriver.getInstance().getDriver();
            WebDriverWait exists = new WebDriverWait(driver, 5);

            exists.until(ExpectedConditions.refreshed(
                    ExpectedConditions.elementToBeClickable(selector)));
            return true;
        }
        catch(Exception e) {
            Reporting.logFailure(e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean enterText(String text, By selector) {
        try {
            WebDriver driver = SeleniumDriver.getInstance().getDriver();
            WebElement element = driver.findElement(selector);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value='"	+	text	+	"';",	element);
            Reporting.logDebug("Successfully entered \""+text+"\" on "+selector.toString());
            return true;
        }
        catch (Exception e) {
            Reporting.logFailure(e.getMessage());
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
            Reporting.logDebug("Successfully clicked "+selector.toString());

            return true;
        }
        catch(Exception e) {
            Reporting.logFailure(e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
    }

    public  boolean selectByValue(By selector, String value) {
        try {
            WebDriver driver = SeleniumDriver.getInstance().getDriver();
            WebElement element = driver.findElement(selector);
            Select selectElement = new Select(element);
            selectElement.selectByValue(value);

            Reporting.logDebug("Successfully selected \""+value+"\" on "+selector.toString());

            return true;
        }
        catch(Exception e) {
            Reporting.logFailure(e.getMessage());
            System.out.println(e.getMessage());
            return false;
        }
    }
}
