import core.Global_VARS;
import org.testng.annotations.*;
import testing.pages.WebTest;
import tools.Reporting;
import tools.SeleniumDriver;

import static org.junit.jupiter.api.Assertions.assertNull;

/**WebSuite class for executing JSON and CSV test cases
 * @author smlungwana
 * */
public class WebSuite {

    /**Initialize Report*/
    @BeforeSuite(groups = "test-group")
    public static void init() {
        Reporting.reportName = "QA Assessment";
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
    public void automationAssessment_JSON_Test() {
        Global_VARS.isJSON_Test = true;
        Reporting.createTest("QA Automation Assessment -  JSON Test");
        assertNull(WebTest.validateTest(),"JSON Test validation Failed!");
    }

    /**Test case method for testing CSV test data*/
    @Test(groups = "csv-test")
    public void automationAssessment_CSV_Test() {
        Global_VARS.isJSON_Test = false;
        Reporting.createTest("QA Automation Assessment -  CSV Test");
        assertNull(WebTest.validateTest(),"CSV Test validation Failed!");
    }
}
