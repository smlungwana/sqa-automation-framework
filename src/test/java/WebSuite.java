import core.Global_VARS;
import org.junit.jupiter.api.*;
import testing.pages.WebTest;
import tools.Reporting;
import tools.SeleniumDriver;

import static org.junit.jupiter.api.Assertions.assertNull;

/**WebSuite class
 * @author smlungwana
 * */
public class WebSuite {


    @BeforeAll
    public static void init() {
        Reporting.reportName = "QA Assessment";
        Reporting.init();
    }

    @BeforeEach
    public void setup() {
        SeleniumDriver driver = SeleniumDriver.getInstance();
        driver.setBrowser(Global_VARS.CHROME);
    }

    @AfterEach
    public void shutdown() {
        SeleniumDriver driver = SeleniumDriver.getInstance();
        driver.closeDriver();
    }

    @Test
    public void automationAssessment_JSON_Test() {
        Global_VARS.isJSON_Test = true;
        Reporting.createTest("QA Automation Assessment -  JSON Test");
        assertNull(WebTest.validateTest(),"JSON Test validation Failed!");
    }

    @Test
    public void automationAssessment_CSV_Test() {
        Global_VARS.isJSON_Test = false;
        Reporting.createTest("QA Automation Assessment -  CSV Test");
        assertNull(WebTest.validateTest(),"CSV Test validation Failed!");
    }
}
