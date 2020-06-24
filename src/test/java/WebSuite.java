import core.Global;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import testing.pages.WebPageTest;
import tools.Reporting;
import tools.SeleniumDriver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

/**WebSuite class
 * @author smlungwana
 * */
public class WebSuite {


    @BeforeAll
    public static void init() {
        Reporting.reportName = "Web Assessment";
        Reporting.init();
    }

    @BeforeEach
    public void setup() {
        SeleniumDriver driver = SeleniumDriver.getInstance();
        driver.setBrowser(Global.CHROME);
    }

    @AfterAll
    public static void shutdown() {
        SeleniumDriver driver = SeleniumDriver.getInstance();
        driver.closeDriver();
    }

    @Test
    public void webAssessmentTestCase() {
        Global.isJSON_Test = true;
        Reporting.createTest("JSON Data - webTest case");
        assertNull(WebPageTest.webAssessmentTest(),"Test Failed!");
    }

    @Test
    public void webAssessmentTestCase2() {
        Global.isJSON_Test = false;
        Reporting.createTest("CSV Data - webTest case 2");
        assertNull(WebPageTest.webAssessmentTest(),"Test Failed!");
    }
}
