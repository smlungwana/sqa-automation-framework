package testing.pages;

import core.Global_VARS;
import org.openqa.selenium.By;

public class DemoStorePageObjects extends Global_VARS {

    public static By welcomeHeader()  {return  By.className("welcome-msg");}
    public static By accountLink()  {return  By.xpath("//span[@class='label'][text()='Account']");}
    public static By loginLink()  {return  By.linkText("Log In");}
    public static By emailField()  {return  By.id("email");}
    public static By passwordField()  {return  By.id("pass");}
    public static By loginButton()  {return  By.id("send2");}
    public static By dashboardHeader()  {return  By.xpath("//h1[text()='My Dashboard']");}



}
