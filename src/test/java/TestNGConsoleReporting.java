import core.Global_VARS;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import tools.Reporting;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestNGConsoleReporting extends TestListenerAdapter {

    private static String logFile = null;

    @Override
    public void onStart(ITestContext testContext) {
        super.onStart(testContext);
    }

    public void onTestStart(ITestResult tr) {
//        if ( logFile == null ) {
//            logFile = Global_VARS.testNGLogFile;
//
//        }
//        Reporting.logTestNG("\n---------------------------------- Test '"
//                + tr.getName()
//                + getTestDescription(tr)
//                + "' ----------------------------------\n");
//        Reporting.logTestNG("START-> " + tr.getName() + "\n");
//        Reporting.logTestNG(" ***Test Parameters = " + getTestParams(tr) + "\n");

        super.onTestStart(tr);
    }

    /**
     * onTestSuccess method
     *
     * @param tr
     */
    @Override
    public void onTestSuccess(ITestResult tr) {
//        Reporting.logTestNG(" ***Result = PASSED\n");
//        Reporting.logTestNG("END -> " + tr.getName());
//        Reporting.logTestNG("\n---\n");
        super.onTestSuccess(tr);
    }

    /**
     * onFinish method
     *
     * @param testContext
     */
    @Override
    public void onFinish(ITestContext testContext) {
//        Reporting.logTestNG("\nTotal Passed = " + getPassedTests().size()
//                        + ", Total Failed = " + getFailedTests().size()
//                        + ", Total Skipped = " + getSkippedTests().size() + "\n");

        super.onFinish(testContext);
    }






    private String getTestParams(ITestResult tr) {
        int iLength = tr.getParameters().length;
        String message = "";
        try {
            if ( tr.getParameters().length > 0 ) {
                message = tr.getParameters()[0].toString();
                for ( int iCount = 0; iCount < iLength; iCount++ ) {
                    if ( iCount == 0 ) {
                        message = tr.getParameters()[0].toString();
                    }
                    else {
                        message = message
                                + ", "
                                + tr.getParameters()
                                [iCount].toString();
                    }
                }
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return message;
    }

    private String getTestDescription(ITestResult tr) {
        String message = "";
        try {
            if ( tr.getParameters().length > 0 ) {
                message = ": "
                        + tr.getParameters()[1].toString();
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return message;
    }

















}
