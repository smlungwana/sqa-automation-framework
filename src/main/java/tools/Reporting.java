package tools;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import core.Global;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**Reporting class
 * @author smlungwana
 * */
public class Reporting extends Global {

    private static ExtentReports report = null;
    private static ExtentTest currentTest;
    public static String reportName;
    public static String latestScreenshotAbs;
    private static String logFile;

    public static void init() {
        report = new ExtentReports();
        reportDirectory =  reportDirectory +"\\"+reportName+"\\"+ "_" +getCurrentTime()+"\\";
        new File(reportDirectory).mkdirs();
        logFile = reportDirectory + "log.txt";
        ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(reportDirectory + "ExtentReport.html");
        report.attachReporter(htmlReport);
        report.setAnalysisStrategy(AnalysisStrategy.TEST);
    }

    public static void createTest(String testName) {
        if(report == null) {
            init();
        }
        if (currentTest == null || !currentTest.getModel().getName().equals(testName)) {
            currentTest = report.createTest(testName);
        }
    }

    public static String stepPassedWithScreenshot(String message) {
        try {
            SeleniumDriver driverInstance = SeleniumDriver.getInstance();

            currentTest.pass(message, MediaEntityBuilder.createScreenCaptureFromPath(driverInstance.takeScreenshot(true)).build());

        }
        catch (IOException e) {
            currentTest.pass(message);
        }
        report.flush();
        return message;
    }

    public static String testFailed(String message) {
        try {
            SeleniumDriver driverInstance = SeleniumDriver.getInstance();
            currentTest.fail(message, MediaEntityBuilder.createScreenCaptureFromPath(driverInstance.takeScreenshot(true)).build());
            report.flush();
            logFailure(message);
        }
        catch(IOException e) {
            currentTest.fail(message);
        }

        return message;
    }

    public static void logPass(String pass) {
        try {
            writeToLogFile("- [PASS] " + pass);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void logDebug(String debug) {
        try {
            writeToLogFile("- [DEBUG] " + debug);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void logFailure(String failure) {
        try {
            writeToLogFile("- [FAIL] " + failure);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    /**Private helper methods*/
    private static String getCurrentTime() {
        Date date = new Date();
        SimpleDateFormat ft;
        ft = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
        executionTime = ft.format(date);
        return ft.format(date);
    }

    private static void writeToLogFile(String logMessage) throws IOException
    {
        File file = new File(logFile);
        String formatStr = "%n%-24s %-20s %-60s %-25s";
        if (!file.exists()) {
            file.createNewFile();
            PrintWriter writer = new PrintWriter(new FileWriter(file, true));
            writer.println(String.format(formatStr, "", "--QA ASSESSMENT LOG FILE --", "", ""));
            writer.close();
        }
        // Writes info to the text file
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
            PrintWriter writer = new PrintWriter(new FileWriter(file, true));
            writer.println(String.format(formatStr, dateFormat.format(new Date()), logMessage, "", ""));
            writer.close();
        } catch (IOException e) {
            System.out.printf(e.getMessage());
        }
    }

}
