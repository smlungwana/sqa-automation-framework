package testing.pages;

import core.Global_VARS;
import org.openqa.selenium.By;

public class DemoStorePageObjects extends Global_VARS {

    public static By welcomeHeader()  {return  By.className("welcome-msg");}
    public static By accountLink()  {return  By.xpath("//span[@class='label'][text()='Account']");}
    public static By loginLink()  {return  By.linkText("Log In");}
    public static By logoutLink()  {return  By.linkText("Log Out");}
    public static By loggedOutMessage()  {return  By.xpath("//h1[text()='You are now logged out']");}
    public static By emailField()  {return  By.id("email");}
    public static By passwordField()  {return  By.id("pass");}
    public static By loginButton()  {return  By.id("send2");}
    public static By dashboardHeader()  {return  By.xpath("//h1[text()='My Dashboard']");}
    public static By searchField()  {return  By.id("search");}
    public static By searchButton()  {return  By.xpath("//button[@class='button search-button']");}
    public static By viewDetailsButton()  {return  By.xpath("//a[@title='View Details']");}
    public static By bookTitle(String text)  {return By.xpath("(//a[contains(text(),'"+text+"')])[1]");}
    public static By addToCartButton()  {return  By.xpath("(//button[@class='button btn-cart'])[2]");}
    public static By continueButton()  {return  By.xpath("(//span[text()='Continue'])[1]");}
    public static By continueButton2()  {return  By.xpath("(//span[text()='Continue'])[2]");}
    public static By cashOnDeliveryLabel()  {return  By.xpath("//label[contains(text(),'Cash On Delivery')]");}
    public static By billingInformationHeader()  {return  By.xpath("//h2[text()='Billing Information']");}
    public static By checkBoxValidation()  { return  By.id("links_21"); }
    public static By shoppingCartItemValidation()  {
        return  By.xpath("//span[contains(text(),'was added to your shopping cart')]");
    }
    public static By proceedToCheckout()  {return  By.xpath("(//span[contains(text(),'Proceed to Checkout')])[1]");}
    public static By placeOrderButton()  {return  By.xpath("//button[@title='Place Order']");}
    public static By thankYouHeader()  {return  By.xpath("//h2[text()='Thank you for your purchase!']");}



}
