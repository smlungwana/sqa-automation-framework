package testing.pages;

import core.Global_VARS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import tools.SeleniumDriver;
import tools.TestDataReader;
import tools.Reporting;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**@author smlungwana
 **/
public class WebTest extends Global_VARS {

    /***/
    public static String validateTest() {
        Map<String,String> testData;

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

        //Retrieve all data from table and check for unique username
        List<String> tableData = seleniumBrowser.extractValues(WebPageObjects.tableDataCells());

        for(int i = 2;i < tableData.size();i = i+10) { //
            String user = tableData.get(i);
            if(user.equals(username)) { //Username is already on list
                return Reporting.testFailed("\""+username+"\" is not unique. Please update test data with a different username.");
            }
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

        if(!seleniumBrowser.selectByText(WebPageObjects.selectRoleDropdown(),role)) {
            return Reporting.testFailed("Failed to select "+role+".");
        }

        if(!seleniumBrowser.enterText(email,WebPageObjects.emailInput())) {
            return Reporting.testFailed("Failed to enter text on 'Last Name' field.");
        }

        if(!seleniumBrowser.enterText(cell,WebPageObjects.mobileInput())) {
            return Reporting.testFailed("Failed to enter text on 'Mobile' field.");
        }

        //Validate if all data is entered by waiting for Save button to be clickable
        if(!seleniumBrowser.waitForClickable(WebPageObjects.saveButton(),5)) {
            return Reporting.testFailed("Failed to wait for 'Save' button to be clickable.");
        }

        Reporting.stepPassedWithScreenshot("Successfully entered user details.");

        if(!seleniumBrowser.click(WebPageObjects.saveButton()))  {
            return Reporting.testFailed("Failed to click 'Save' button.");
        }

        //Retrieve all data from table and check if user is added to table
        List<String> tableResults = seleniumBrowser.extractValues(WebPageObjects.tableDataCells());
        List<String> usersOnListTable = new ArrayList<String>();

        for(int i = 2;i < tableResults.size();i = i+10) { //
            String user = tableResults.get(i);
            usersOnListTable.add(user);
        }

        if(usersOnListTable.contains(username)) {
            Reporting.stepPassedWithScreenshot("Successfully added \"" + username + "\" to 'User List Table'.");
        }
        else {
            return Reporting.testFailed("Failed to add \""+username+"\" to 'User List Table.'");
        }

        return null;
    }
}
