package tools;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static core.Global_VARS.*;
import core.Global_VARS;

/**Singleton design pattern
 * Selenium  Singleton class to ensure that there's only one WebDriver instance on runtime.
 * @author smlungwana
 * */
public class SeleniumDriver {
    private static SeleniumDriver instance;
    private	static final int IMPLICIT_TIMEOUT =	0;

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static ThreadLocal<AppiumDriver<MobileElement>> mobileDriver = new ThreadLocal<>();
    private ThreadLocal<AppiumDriver> appiumDriver = new ThreadLocal<AppiumDriver>();
    private String browser;

    //Singleton private Constructor
    private SeleniumDriver(){}

    /***getInstance	method to get active driver instance
     @return SeleniumDriver*/
    public static SeleniumDriver getInstance() {
        if (instance ==  null ) {
            instance = new SeleniumDriver();
            mobileDriver.set(startMobileDriver());
        }
        return instance;
    }

    /**setBrowser method to switch between browsers. CHROME, FIREFOX etc.
     * 	@throws	Exception
     */
    public void setBrowser(String browser) {
        this.browser = browser;
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
                this.browser = CHROME;
                System.out.println("Invalid parameter \""+browser+"\" - Setting up Chrome as default.");
                WebDriverManager.chromedriver().setup();
                webDriver.set(new ChromeDriver());
                webDriver.get().manage().window().maximize();
                break;

        }
    }

    /***getBrowser method to get current browser
     @return browser*/
    public String getBrowser() {
        return browser;
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

    /***getMobileDriver method to	get the active Selenium mobile driver
     @return mobileDriver*/
    public AppiumDriver<MobileElement> getMobileDriver() {
        if (mobileDriver.get() == null) {
            mobileDriver.set(startMobileDriver());
        }
        return mobileDriver.get();
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
            imagePathBuilder.append(reportDirectory+"/");
            relativePathBuilder.append("Screenshots/");

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

            return imagePathBuilder.toString();
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

    public void tearDown() {
        if (webDriver.get() != null) {
            webDriver.get().quit();
            webDriver.remove();
        }
        if (mobileDriver.get() != null) {
            mobileDriver.get().quit();
            mobileDriver.remove();
        }
    }

    private static AppiumDriver<MobileElement> startMobileDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", Global_VARS.TARGET_PLATFORM);
        capabilities.setCapability("deviceName", Global_VARS.DEVICE_NAME);
        capabilities.setCapability("platformVersion", Global_VARS.PLATFORM_VERSION);
        capabilities.setCapability("app", Global_VARS.APP);
        capabilities.setCapability("automationName", Global_VARS.AUTOMATION_NAME);

        try {
            mobileDriver.set(new IOSDriver<>(new URL(Global_VARS.GRID_URL), capabilities));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return mobileDriver.get();
    }

}
