package testing.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * @author smlungwana
 * */
public class MadisonIslandPageObject {

    @FindBy(className = "welcome-msg")
    WebElement welcomeMessage;

    @FindBy(xpath = "//span[@class='label'][text()='Account']")
    WebElement accountLink;

    @FindBy(id = "pass")
    WebElement passwordField;

    @FindBy(linkText = "Log In")
    WebElement loginLink;

    @FindBy(id = "send2")
    WebElement loginButton;
    
    @FindBy(linkText = "Log Out")
    WebElement logoutLink;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(xpath = "//h1[text()='My Dashboard']")
    WebElement dashboardHeader;

    @FindBy(id = "search")
    WebElement searchField;

    @FindBy(xpath = "//button[@class='button search-button']")
    WebElement searchButton;

    @FindBy(xpath = "//a[@title='View Details']")
    WebElement viewDetailsButton;

    @FindBy(xpath = "(//button[@class='button btn-cart'])[2]")
    WebElement addToCartButton;

    @FindBy(xpath = "(//span[text()='Continue'])[1]")
    WebElement continueButton;

    @FindBy(xpath = "(//span[text()='Continue'])[2]")
    WebElement continueButton2;

    @FindBy(xpath = "//label[contains(text(),'Cash On Delivery')]")
    WebElement cashOnDeliveryLabel;

    @FindBy(xpath = "//h2[text()='Billing Information']")
    WebElement billingInformationHeader;

    @FindBy(id = "links_21")
    WebElement checkBoxValidation;

    @FindBy(xpath = "//span[contains(text(),'was added to your shopping cart')]")
    WebElement shoppingCartItemValidation;

    @FindBy(xpath = "(//span[contains(text(),'Proceed to Checkout')])[1]")
    WebElement proceedToCheckout;

    @FindBy(xpath = "//button[@title='Place Order']")
    WebElement placeOrderButton;

    @FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
    WebElement thankYouHeader;
    
}
