package testing.pages;

import core.Global_VARS;
import tools.Reporting;

public class DemoStoreWeb extends Global_VARS {

    public static String login(String email,String password) {

        if(!seleniumBrowser.navigateToURL(DEMO_STORE_URL)) {
            return Reporting.testFailed("Failed to navigate to Demo Store URL.");
        }

        if(!seleniumBrowser.waitFor(DemoStorePageObjects.welcomeHeader()))  {
            return Reporting.testFailed("Failed to wait for Welcome header.");
        }

        Reporting.stepPassedWithScreenshot("Successfully navigated to Demo Store");

        return null;
    }
}
