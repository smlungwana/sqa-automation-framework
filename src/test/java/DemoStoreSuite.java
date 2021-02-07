import core.Global_VARS;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import testing.pages.DemoStoreWeb;
import tools.Reporting;
import tools.SeleniumDriver;

public class DemoStoreSuite {

    /**Initialize Report*/
    @BeforeSuite(groups = "test-group")
    public static void init() {
        Reporting.reportName = "Demo Store";
        Reporting.init();
    }
    /**Setup driver and start up browser*/
    @BeforeTest(groups = "test-group")
    public void setup() {
        SeleniumDriver driver = SeleniumDriver.getInstance();
        driver.setBrowser(Global_VARS.CHROME);
    }
    /**Kills the browser driver after each test*/
    @AfterTest(groups = "test-group")
    public void shutdown() {
        SeleniumDriver driver = SeleniumDriver.getInstance();
        driver.closeDriver();
    }

    /**Test case method for testing JSON test data*/
    @Test(groups = "test-group")
    public void placeOrderTest() {
        String book = "Alice";
        String email = Global_VARS.DEMO_STORE_EMAIL;
        String pass = Global_VARS.DEMO_STORE_PASSWORD;

        Reporting.createTest("Madison Island - Place Order");
        Assert.assertNull(DemoStoreWeb.login(email,pass),"Failed to login to Demo Store");
        Assert.assertNull(DemoStoreWeb.placeOrder(book),"Failed to place an order.");
        Assert.assertNull(DemoStoreWeb.logout(),"Failed to logout.");
    }

}
