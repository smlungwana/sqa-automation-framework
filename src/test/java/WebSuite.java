import core.Global;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import testing.pages.WebPageTest;
import tools.SeleniumDriver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

/**WebSuite class
 * @author smlungwana
 * */
public class WebSuite extends Global{

    @BeforeAll
    public static void init() {
        SeleniumDriver driver = SeleniumDriver.getInstance();
        driver.setBrowser(CHROME);
    }

    @AfterAll
    public static void shutdown() {
        SeleniumDriver driver = SeleniumDriver.getInstance();
        driver.closeDriver();
    }
    @Test
    public void webAssessmentTestCase() {
        assertNull(WebPageTest.testWebPage(),"Test Failed!");
    }
}
