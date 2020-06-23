package testing.pages;

import core.Global;

public class WebPageTest extends Global {

    public static String testWebPage() {
        if(!seleniumBrowser.navigateToURL(WebPageObject.URL)) {
            return "Failed";
        }

        return null;
    }
}
