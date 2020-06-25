package core;

import tools.SeleniumBrowserUtility;

/**
 @author smlungwana
 Utility class Global variables
 */
public class Global_VARS {

    public static SeleniumBrowserUtility seleniumBrowser;
    public static final String URL = "http://www.way2automation.com/angularjs-protractor/webtables/";
    public static final int CHROME = 0;
    public static final int FIREFOX = 1;

    //Global variables for Report
    public static String reportDirectory = System.getProperty("user.dir") + "\\Reports\\";
    public static int screenshotCounter;
    public static String executionTime = "";
    public static boolean isJSON_Test;

}
