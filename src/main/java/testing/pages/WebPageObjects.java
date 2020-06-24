package testing.pages;

import core.Global;
import org.openqa.selenium.By;

/**WebPageObject class
 * @author smlungwana
 * */
public class WebPageObjects extends Global {

    public static String link() {
        return URL;
    }

    public static By addUserButton() {
        return By.xpath("//button[contains(text(),'Add User')]");
    }

    public static By saveButton() {
        return By.xpath("//button[contains(text(),'Save')]");
    }

    public static By closeButton() {
        return By.xpath("//button[contains(text(),'Close')]");
    }

    public static By firstNameInput() {
        return By.xpath("//input[@name='FirstName']");
    }

    public static By lastNameInput() {
        return By.xpath("//input[@name='LastName']");
    }

    public static By userNameInput() {
        return By.xpath("//input[@name='UserName']");
    }

    public static By passwordInput() {
        return By.xpath("//input[@name='Password']");
    }

    public static By emailInput() {
        return By.xpath("//input[@name='Email']");
    }

    public static By mobileInput() {
        return By.xpath("//input[@name='Mobilephone']");
    }

    public static By companyAAARadioButton() {
        return By.xpath("//input[@name='optionsRadios'][@value='15']");
    }

    public static By companyBBBRadioButton() {
        return By.xpath("//input[@name='optionsRadios'][@value='16']");
    }

    public static By selectRoleDropdown() {
        return By.xpath("//select[@name='RoleId']");
    }


}
