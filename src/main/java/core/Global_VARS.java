package core;

import tools.SeleniumBrowserUtility;

/**
 @author smlungwana
 Utility class Global variables
 */
public class Global_VARS {

    public static String operatingSystem = System.getProperty("os.name");

    public static SeleniumBrowserUtility seleniumBrowser;

    public static final String MADISON_ISLAND_STORE_URL = "http://demo-store.seleniumacademy.com/";
    public static final String DEMO_STORE_EMAIL = "smlungwana@test.com";
    public static final String DEMO_STORE_PASSWORD = "sm12345";

    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static final String SAFARI = "safari";
    public static final String EDGE = "edge";
    public static final String OPERA = "opera";
    public static final String DEFAULT_BROWSER = CHROME;

    //Global variables for Report
    public static String reportDirectory = System.getProperty("user.dir") + "/Reports/";
    public static int screenshotCounter;
    public static String executionTime = "";

    //TestNG Reporting
    public static String testNGLogFile = "";

    public static final String SUCCESS = "success";

}
