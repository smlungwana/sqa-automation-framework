package testing.pages;

import core.Global;
import tools.TestDataReader;
import tools.Reporting;

import java.util.Map;

public class WebPageTest extends Global {

    public static String webAssessmentTest() {
        Map<String,String> testData;
        String a =  "debug";

        if(isJSON_Test) {
           testData = TestDataReader.getJSON_Data();
        }
        else { //CSV Test
           testData = TestDataReader.getCSV_Data();
        }

        String firstName = testData.get("FirstName");
        String lastName = testData.get("LastName");
        String username =  testData.get("Username");
        String password =  testData.get("Password");
        String customer =  testData.get("Customer");
        String role =  testData.get("Role");
        String email =  testData.get("Email");
        String cell =  testData.get("Cell");

        if(!seleniumBrowser.navigateToURL(WebPageObjects.URL)) {
            return Reporting.testFailed("Failed to navigate to URL.");
        }

        if(!seleniumBrowser.waitFor(WebPageObjects.addUserButton()))  {
            return Reporting.testFailed("Failed to wait for 'Add User' button.");
        }

        Reporting.stepPassedWithScreenshot("Successfully navigated to 'User List Table'.");

        if(!seleniumBrowser.click(WebPageObjects.addUserButton()))  {
            return Reporting.testFailed("Failed to click 'Add User' button.");
        }

        if(!seleniumBrowser.waitFor(WebPageObjects.closeButton()))  {
            return Reporting.testFailed("Failed to wait for 'Close' button.");
        }

        if(!seleniumBrowser.enterText(firstName,WebPageObjects.firstNameInput())) {
            return Reporting.testFailed("Failed to enter text on 'First Name' field.");
        }

        if(!seleniumBrowser.enterText(lastName,WebPageObjects.lastNameInput())) {
            return Reporting.testFailed("Failed to enter text on 'Last Name' field.");
        }

        if(!seleniumBrowser.enterText(username,WebPageObjects.userNameInput())) {
            return Reporting.testFailed("Failed to enter text on 'User Name' field.");
        }

        if(!seleniumBrowser.enterText(password,WebPageObjects.passwordInput())) {
            return Reporting.testFailed("Failed to enter text on 'Password' field.");
        }


        if(customer.contains("AAA")) {
            if (!seleniumBrowser.click(WebPageObjects.companyAAARadioButton())) {
                return Reporting.testFailed("Failed to click 'Company AAA' button.");
            }
        }
        if(customer.contains("BBB")) {
            if (!seleniumBrowser.click(WebPageObjects.companyBBBRadioButton())) {
                return Reporting.testFailed("Failed to click 'Company BBB' button.");
            }
        }

//        if(!seleniumBrowser.selectByValue(WebPageObjects.selectRoleDropdown(),"Customer"))  {
//            return Reporting.testFailed("Failed to wait for 'Role' option to be clickable.");
//        }TODO

        if(!seleniumBrowser.enterText(email,WebPageObjects.emailInput())) {
            return Reporting.testFailed("Failed to enter text on 'Last Name' field.");
        }

        if(!seleniumBrowser.enterText(cell,WebPageObjects.mobileInput())) {
            return Reporting.testFailed("Failed to enter text on 'Mobile' field.");
        }

        return null;
    }
}
