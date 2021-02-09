import core.Global_VARS;
import org.testng.annotations.*;
import org.testng.Assert;
import testing.pages.MadisonIslandWebTest;
import tools.Reporting;
import tools.SeleniumDriver;

/**
 * @author smlungwana
 * */

@Listeners(TestNGConsoleReporting.class)
public class MadisonIslandWebSuite {

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
        Assert.assertEquals(MadisonIslandWebTest.login(email,pass),Global_VARS.SUCCESS,"Failed to login to Madison Island");
        Assert.assertEquals(MadisonIslandWebTest.placeOrder(book),Global_VARS.SUCCESS,"Failed to place an order.");
        Assert.assertEquals(MadisonIslandWebTest.logout(),Global_VARS.SUCCESS,"Failed to logout.");

    }

}
