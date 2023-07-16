package core;

import tools.SeleniumBrowserUtility;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 @author smlungwana
 Utility class Global variables
 */
public class Global_VARS {

    public static String operatingSystem = System.getProperty("os.name");

    public static SeleniumBrowserUtility seleniumBrowser;

    public static final String MADISON_ISLAND_STORE_URL = "http://demo-store.seleniumacademy.com/";
    public static final String DEMO_STORE_EMAIL = "smlu@test.com";
    public static final String DEMO_STORE_PASSWORD = "123456";

    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static final String SAFARI = "safari";
    public static final String EDGE = "edge";
    public static final String OPERA = "opera";
    public static final String DEFAULT_BROWSER = CHROME;

    //Global variables for Report
    public static String userDir = System.getProperty("user.dir");
    public static String reportDirectory =  Paths.get(userDir,"test-output").toString();
    public static String reportConfigFile = Paths.get(userDir,"extent-config.xml").toString();
    public static int screenshotCounter;
    public static String executionTime = "";

    //TestNG Reporting
    public static String testNGLogFile = "";

    public static final String SUCCESS = "success";

    //Global variables for Mobile Testing
    public static String TARGET_PLATFORM = "";
    public static String DEVICE_NAME = "";
    public static String PLATFORM_VERSION = "";
    public static String APP = "";

    public static String AUTOMATION_NAME = "";

    public static String GRID_URL = "";


}
