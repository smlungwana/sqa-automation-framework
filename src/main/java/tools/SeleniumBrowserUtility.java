package tools;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**SeleniumBrowserUtility class
 * @author smlungwana
 * */
public class SeleniumBrowserUtility {

    public static boolean navigateToURL(String url) {
        try {
            WebDriver driver = SeleniumDriver.getInstance().getDriver();
            driver.navigate().to(url);
            return true;
        }
        catch(Exception e) {
            //TODO Report exception
            return false;
        }
    }
    public static boolean waitFor(By selector,int timeout) {
        try {
            WebDriver driver = SeleniumDriver.getInstance().getDriver();
            WebDriverWait exists = new WebDriverWait(driver, timeout);

            exists.until(ExpectedConditions.refreshed(
                    ExpectedConditions.visibilityOfElementLocated(selector)));
            return true;
        }
        catch(Exception e) {
            //TODO Log Error
            return false;
        }
    }
    public static boolean waitFor(By selector) {
        try {
            WebDriver driver = SeleniumDriver.getInstance().getDriver();
            WebDriverWait exists = new WebDriverWait(driver, 5);

            exists.until(ExpectedConditions.refreshed(
                    ExpectedConditions.visibilityOfElementLocated(selector)));
            return true;
        }
        catch(Exception e) {
            //TODO Log Error
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
            return false;
        }
    }

    public static boolean enterText(String text, By selector) {
        try {
            WebDriver driver = SeleniumDriver.getInstance().getDriver();
            WebElement element = driver.findElement(selector);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value='"	+	text	+	"';",	element);
            return true;
        }
        catch (Exception e) {
            //TODO
            return false;
        }
    }


    public static boolean click(By selector) {
        try {
            WebDriver driver = SeleniumDriver.getInstance().getDriver();
            WebElement element = driver.findElement(selector);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",element);

            return true;

        }
        catch(Exception e) {
            //TODO Log Error
            return false;
        }
    }
}
