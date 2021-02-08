package testing.pages;

import core.Global_VARS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import tools.Reporting;
import tools.SeleniumDriver;

/**
 * @author smlungwana
 * */
public class MadisonIslandWebTest extends Global_VARS {

    private static WebDriver driver = SeleniumDriver.getInstance().getDriver();
    private static MadisonIslandPageObject pageObject =
            PageFactory.initElements(driver,
                    MadisonIslandPageObject.class);

    public static String login(String email,String password) {


        if(!seleniumBrowser.navigateToURL(MADISON_ISLAND_STORE_URL)) {
            return Reporting.testFailed("Failed to navigate to Demo Store URL.");
        }

        if(!seleniumBrowser.waitFor(pageObject.welcomeMessage))  {
            return Reporting.testFailed("Failed to wait for 'Welcome' header.");
        }

        Reporting.stepPassedWithScreenshot("Successfully navigated to Demo Store");

        if(!seleniumBrowser.click(pageObject.accountLink))  {
            return Reporting.testFailed("Failed to click for Account link.");
        }

        if(!seleniumBrowser.waitFor(pageObject.loginLink))  {
            return Reporting.testFailed("Failed to wait for 'Log in' link.");
        }

        if(!seleniumBrowser.click(pageObject.loginLink))  {
            return Reporting.testFailed("Failed to click 'Log in' link.");
        }

        if(!seleniumBrowser.waitFor(pageObject.emailField))  {
            return Reporting.testFailed("Failed to wait for 'email' field.");
        }

        Reporting.stepPassedWithScreenshot("Successfully navigated to Login Page.");

        if(!seleniumBrowser.enterText(pageObject.emailField,email))  {
            return Reporting.testFailed("Failed to enter text on 'email' field.");
        }

        if(!seleniumBrowser.enterText(pageObject.passwordField,password))  {
            return Reporting.testFailed("Failed to enter text on 'password' field.");
        }

        if(!seleniumBrowser.click(pageObject.loginButton)) {
            return Reporting.testFailed("Failed to click 'Log in' button.");
        }

        return SUCCESS;
    }

    public static String placeOrder(String order) {

        if(!seleniumBrowser.waitFor(pageObject.dashboardHeader)) {
            return Reporting.testFailed("Failed to wait for 'My Dashboard' header.");
        }

        Reporting.stepPassedWithScreenshot("Successfully navigated to 'My Dashboard' page.");

        if(!seleniumBrowser.enterText(pageObject.searchField,order)) {
            return Reporting.testFailed("Failed to enter "+order+" on 'Search' field.");
        }

        if(!seleniumBrowser.click(pageObject.searchButton)) {
            return Reporting.testFailed("Failed to click Search button.");
        }

        if(!seleniumBrowser.waitFor(pageObject.viewDetailsButton)) {
            return Reporting.testFailed("Failed to wait for 'View Details' button.");
        }

        Reporting.stepPassedWithScreenshot("Successfully searched for "+order+".");

        if(!seleniumBrowser.click(pageObject.viewDetailsButton)) {
            return Reporting.testFailed("Failed to click 'View Details' button.");
        }

        if(!seleniumBrowser.waitFor(pageObject.addToCartButton)) {
            return Reporting.testFailed("Failed to wait for 'Add to Cart' button .");
        }

        Reporting.stepPassedWithScreenshot("Successfully navigated to order preview.");

        if(!seleniumBrowser.click(pageObject.checkBoxValidation)) {
            return Reporting.testFailed("Failed to click check box validation.");
        }

        if(!seleniumBrowser.click(pageObject.addToCartButton)) {
            return Reporting.testFailed("Failed to click 'Add to Cart' button.");
        }

        if(!seleniumBrowser.waitFor(pageObject.shoppingCartItemValidation)) {
            return Reporting.testFailed("Failed to wait for shopping cart item validation.");
        }

        Reporting.stepPassedWithScreenshot("Successfully added item to shopping cart.");

        if(!seleniumBrowser.click(pageObject.proceedToCheckout)) {
            return Reporting.testFailed("Failed to click 'Proceed to Checkout' button.");
        }

        if(!seleniumBrowser.waitFor(pageObject.billingInformationHeader)) {
            return Reporting.testFailed("Failed to wait for 'Billing Information' header.");
        }

        Reporting.stepPassedWithScreenshot("Successfully navigated to 'Checkout' page.");

        if(!seleniumBrowser.click(pageObject.continueButton)) {
            return Reporting.testFailed("Failed to click 'Continue' button.");
        }

        if(!seleniumBrowser.waitFor(pageObject.cashOnDeliveryLabel)) {
            return Reporting.testFailed("Failed to wait for 'Cash on Delivery' label.");
        }

        if(!seleniumBrowser.click(pageObject.continueButton2)) {
            return Reporting.testFailed("Failed to click 'Continue' button.");
        }

        if(!seleniumBrowser.waitFor(pageObject.placeOrderButton)) {
            return Reporting.testFailed("Failed to wait for 'Place Order' button.");
        }

        if(!seleniumBrowser.click(pageObject.placeOrderButton)) {
            return Reporting.testFailed("Failed to click 'Place Order' button.");
        }

        if(!seleniumBrowser.waitFor(pageObject.thankYouHeader)) {
            return Reporting.testFailed("Failed to wait for Order confirmation header.");
        }

        Reporting.stepPassedWithScreenshot("Successfully placed Order number #."); //TODO extract order number

        return SUCCESS;
    }

    public static String logout() {

        if(!seleniumBrowser.click(pageObject.accountLink))  {
            return Reporting.testFailed("Failed to click for Account link.");
        }

        if(!seleniumBrowser.waitFor(pageObject.logoutLink)) {
            return Reporting.testFailed("Failed to wait for 'Log out' link.");
        }

        if(!seleniumBrowser.click(pageObject.logoutLink)) {
            return Reporting.testFailed("Failed to click 'Log out' link.");
        }

//        if(!seleniumBrowser.waitFor(pageObject.loggedOutMessage)) {
//            return Reporting.testFailed("Failed to wait for 'Log out' message.");
//        }

        Reporting.stepPassedWithScreenshot("Successfully logged out.");

        return SUCCESS;
    }
}
