package tools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.File;

import static core.Global_VARS.*;

/**Singleton design pattern
 * Selenium  Singleton class to ensure that there's only one WebDriver instance on runtime.
 * @author smlungwana
 * */
public class SeleniumDriver {
    private static SeleniumDriver instance;
    private	static final int IMPLICIT_TIMEOUT =	0;
    private	ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
    private ThreadLocal<AppiumDriver> appiumDriver = new ThreadLocal<AppiumDriver>();

    //Singleton private Constructor
    private SeleniumDriver(){}

    /***getInstance	method to get active driver instance
     @return SeleniumDriver*/
    public static SeleniumDriver getInstance() {
        if (instance ==  null ) {
            instance = new SeleniumDriver();
        }
        return instance;
    }

    /**setBrowser method to switch between browsers. CHROME, FIREFOX.
     * 	@throws	Exception
     */
    public void setBrowser(String browser) {
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

            case OPERA:
                 WebDriverManager.operadriver().setup();
                 webDriver.set(new OperaDriver());
                 webDriver.get().manage().window().maximize();
                 break;

            case EDGE:
                WebDriverManager.edgedriver().setup();
                webDriver.set(new EdgeDriver());
                webDriver.get().manage().window().maximize();
                break;

            default:
                System.out.println("Invalid 'browser' parameter - Setting up Chrome as default.");
                WebDriverManager.chromedriver().setup();
                webDriver.set(new ChromeDriver());
                webDriver.get().manage().window().maximize();
                break;

        }
    }


    /***getDriver method to	get Selenium driver
     @return SeleniumDriver*/
    public WebDriver getDriver() {
        return webDriver.get();
    }

    /***getDriver method to	get Selenium driver
     @return appiumDriver*/
    public AppiumDriver getAppiumDriver() {
        return appiumDriver.get();
    }

    /***getCurrentDriver method to	get the active Selenium driver
     @return SeleniumDriver*/
    public  WebDriver getCurrentDriver() {
        return getInstance().getDriver();
    }

    /**takeScreenshot method to take a screenshot and append the .png file to Report results.
     * 	@throws	Exception
     */
    public String takeScreenshot(boolean status) {
        screenshotCounter++;
        StringBuilder imagePathBuilder = new StringBuilder();
        StringBuilder relativePathBuilder = new StringBuilder();

        try
        {
            if(operatingSystem.toLowerCase().contains("win")) { //Windows Machine
                imagePathBuilder.append(reportDirectory+"\\");
                relativePathBuilder.append("Screenshots\\");
            }
            else if(operatingSystem.toLowerCase().contains("mac") ||
                    operatingSystem.toLowerCase().contains("linux")) { //Unix Machine
                imagePathBuilder.append(reportDirectory+"/");
                relativePathBuilder.append("Screenshots/");
            }

            new File(imagePathBuilder.toString() + (relativePathBuilder).toString()).mkdirs();
            relativePathBuilder.append(screenshotCounter + "_");
            if (status) {
                relativePathBuilder.append("PASSED");
            } else {
                relativePathBuilder.append("FAILED");
            }
            relativePathBuilder.append(".png");
            File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(imagePathBuilder.append(relativePathBuilder).toString()));
            Reporting.latestScreenshotAbs = screenshot.toString();
            return "./" + relativePathBuilder.toString();
        }
        catch (Exception e) {
            return null;
        }
    }

    /**closeDriver method quits the current driver
     * @throws	Exception*/
    public void closeDriver() {
        try {
            getCurrentDriver().close();
            getCurrentDriver().quit();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void closeAppiumDriver() {
        try {
            getAppiumDriver().close();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
