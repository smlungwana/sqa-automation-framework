package testing.pages;

import core.Global_VARS;
import tools.Reporting;

public class DemoStoreWeb extends Global_VARS {

    public static String login(String email,String password) {

        if(!seleniumBrowser.navigateToURL(MADISON_ISLAND_STORE_URL)) {
            return Reporting.testFailed("Failed to navigate to Demo Store URL.");
        }

        if(!seleniumBrowser.waitFor(DemoStorePageObjects.welcomeHeader()))  {
            return Reporting.testFailed("Failed to wait for 'Welcome' header.");
        }

        Reporting.stepPassedWithScreenshot("Successfully navigated to Demo Store");

        if(!seleniumBrowser.click(DemoStorePageObjects.accountLink()))  {
            return Reporting.testFailed("Failed to click for Account link.");
        }

        if(!seleniumBrowser.waitFor(DemoStorePageObjects.loginLink()))  {
            return Reporting.testFailed("Failed to wait for 'Log in' link.");
        }

        if(!seleniumBrowser.click(DemoStorePageObjects.loginLink()))  {
            return Reporting.testFailed("Failed to click 'Log in' link.");
        }

        if(!seleniumBrowser.waitFor(DemoStorePageObjects.emailField()))  {
            return Reporting.testFailed("Failed to wait for 'email' field.");
        }

        Reporting.stepPassedWithScreenshot("Successfully navigated to Login Page.");

        if(!seleniumBrowser.enterText(email,DemoStorePageObjects.emailField()))  {
            return Reporting.testFailed("Failed to enter text on 'email' field.");
        }

        if(!seleniumBrowser.enterText(password,DemoStorePageObjects.passwordField()))  {
            return Reporting.testFailed("Failed to enter text on 'password' field.");
        }

        if(!seleniumBrowser.click(DemoStorePageObjects.loginButton()))  {
            return Reporting.testFailed("Failed to click 'Log in' button.");
        }

        return null;
    }

    public static String placeOrder(String order) {

        if(!seleniumBrowser.waitFor(DemoStorePageObjects.dashboardHeader()))  {
            return Reporting.testFailed("Failed to wait for 'My Dashboard' header.");
        }

        Reporting.stepPassedWithScreenshot("Successfully navigated to 'My Dashboard' page.");

        if(!seleniumBrowser.enterText(order,DemoStorePageObjects.searchField()))  {
            return Reporting.testFailed("Failed to enter "+order+" on 'Search' field.");
        }

        if(!seleniumBrowser.click(DemoStorePageObjects.searchButton()))  {
            return Reporting.testFailed("Failed to click Search button.");
        }

        if(!seleniumBrowser.waitFor(DemoStorePageObjects.viewDetailsButton()))  {
            return Reporting.testFailed("Failed to wait for 'View Details' button.");
        }

        Reporting.stepPassedWithScreenshot("Successfully searched for "+order+".");

        if(!seleniumBrowser.click(DemoStorePageObjects.viewDetailsButton()))  {
            return Reporting.testFailed("Failed to click 'View Details' button.");
        }

        if(!seleniumBrowser.waitFor(DemoStorePageObjects.addToCartButton()))  {
            return Reporting.testFailed("Failed to wait for 'Add to Cart' button .");
        }

        Reporting.stepPassedWithScreenshot("Successfully navigated to order preview.");

        if(!seleniumBrowser.click(DemoStorePageObjects.checkBoxValidation())) {
            return Reporting.testFailed("Failed to click check box validation.");
        }

        if(!seleniumBrowser.click(DemoStorePageObjects.addToCartButton())) {
            return Reporting.testFailed("Failed to click 'Add to Cart' button.");
        }

        if(!seleniumBrowser.waitFor(DemoStorePageObjects.shoppingCartItemValidation()))  {
            return Reporting.testFailed("Failed to wait for shopping cart item validation.");
        }

        Reporting.stepPassedWithScreenshot("Successfully added item to shopping cart.");

        if(!seleniumBrowser.click(DemoStorePageObjects.proceedToCheckout())) {
            return Reporting.testFailed("Failed to click 'Proceed to Checkout' button.");
        }

        if(!seleniumBrowser.waitFor(DemoStorePageObjects.billingInformationHeader()))  {
            return Reporting.testFailed("Failed to wait for 'Billing Information' header.");
        }

        Reporting.stepPassedWithScreenshot("Successfully navigated to 'Checkout' page.");

        if(!seleniumBrowser.click(DemoStorePageObjects.continueButton())) {
            return Reporting.testFailed("Failed to click 'Continue' button.");
        }

        if(!seleniumBrowser.waitFor(DemoStorePageObjects.cashOnDeliveryLabel()))  {
            return Reporting.testFailed("Failed to wait for 'Cash on Delivery' label.");
        }

        if(!seleniumBrowser.click(DemoStorePageObjects.continueButton2())) {
            return Reporting.testFailed("Failed to click 'Continue' button.");
        }

        if(!seleniumBrowser.waitFor(DemoStorePageObjects.placeOrderButton()))  {
            return Reporting.testFailed("Failed to wait for 'Place Order' button.");
        }

        if(!seleniumBrowser.click(DemoStorePageObjects.placeOrderButton())) {
            return Reporting.testFailed("Failed to click 'Place Order' button.");
        }

        if(!seleniumBrowser.waitFor(DemoStorePageObjects.thankYouHeader()))  {
            return Reporting.testFailed("Failed to wait for Order confirmation header.");
        }

        Reporting.stepPassedWithScreenshot("Successfully placed Order number #."); //TODO extract order number

        return null;
    }

    public static String logout() {

        if(!seleniumBrowser.click(DemoStorePageObjects.accountLink()))  {
            return Reporting.testFailed("Failed to click for Account link.");
        }

        if(!seleniumBrowser.waitFor(DemoStorePageObjects.logoutLink()))  {
            return Reporting.testFailed("Failed to wait for 'Log out' link.");
        }

        if(!seleniumBrowser.click(DemoStorePageObjects.logoutLink()))  {
            return Reporting.testFailed("Failed to click 'Log out' link.");
        }

//        if(!seleniumBrowser.waitFor(DemoStorePageObjects.loggedOutMessage()))  {
//            return Reporting.testFailed("Failed to wait for 'Log out' message.");
//        }

        Reporting.stepPassedWithScreenshot("Successfully logged out.");

        return null;
    }
}
