package core;

import tools.SeleniumBrowserUtility;

/**
 @author smlungwana
 Utility class Global variables
 */
public class Global_VARS {

    public static SeleniumBrowserUtility seleniumBrowser;
    public static final String DEMO_STORE_URL = "http://demo-store.seleniumacademy.com/";
    public static final String DEMO_STORE_USERNAME = "";
    public static final String DEMO_STORE_PASSWORD = "";
    public static final String URL = "http://www.way2automation.com/angularjs-protractor/webtables/";
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static final String SAFARI = "safari";
    public static final String EDGE = "edge";
    public static final String OPERA_MINI = "opera_mini";

    //Global variables for Report
    public static String reportDirectory = System.getProperty("user.dir") + "/Reports/";
    public static int screenshotCounter;
    public static String executionTime = "";
    public static boolean isJSON_Test;

}
