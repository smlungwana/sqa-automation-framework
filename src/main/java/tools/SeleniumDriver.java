package tools;

import core.Global.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

import static core.Global.*;

/**Selenium  Singleton class
 * @author smlungwana
 * */
public class SeleniumDriver {
    private static SeleniumDriver instance;
    private	static final int IMPLICIT_TIMEOUT =	0;
    private	ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    //Singleton private Constructor
    private SeleniumDriver(){}

    /***getInstance	method	to	retrieve active	driver instance
     @return SeleniumDriver*/
    public static SeleniumDriver getInstance() {
        if (instance ==  null ) {
            instance = new SeleniumDriver();
        }
        return instance;
    }

    public void setBrowser(int browser) {
        switch(browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                webDriver.set(new ChromeDriver());
                webDriver.get().manage().window().maximize();
                break;

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                webDriver.set(new FirefoxDriver());
                webDriver.get().manage().window().maximize();
                break;
        }
    }
    public void setDriver(WebDriver driver) {
        webDriver.set(driver);
    }

    public WebDriver getDriver() {
        return webDriver.get();
    }

    public  WebDriver getCurrentDriver() {
        return getInstance().getDriver();
    }

    public String takeScreenshot(boolean status)
    {
        screenshotCounter++;
        StringBuilder imagePathBuilder = new StringBuilder();
        StringBuilder relativePathBuilder = new StringBuilder();
        try
        {
            imagePathBuilder.append(reportDirectory);
            relativePathBuilder.append("Screenshots\\");
            new File(imagePathBuilder.toString() + (relativePathBuilder).toString()).mkdirs();
            relativePathBuilder.append(screenshotCounter + "_");
            if (status)
            {
                relativePathBuilder.append("PASSED");
            } else
            {
                relativePathBuilder.append("FAILED");
            }
            relativePathBuilder.append(".png");
            File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(imagePathBuilder.append(relativePathBuilder).toString()));
            Reporting.latestScreenshotAbs = screenshot.toString();
            return "./" + relativePathBuilder.toString();
        } catch (Exception e)
        {
            return null;
        }
    }

    /**closeDriver method quits the current driver*/
    public void closeDriver() {
        try {
            getCurrentDriver().quit();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
