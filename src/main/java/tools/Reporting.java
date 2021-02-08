package tools;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import core.Global_VARS;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

/**Reporting class for building the HTML Report
 * @author smlungwana
 * */
public class Reporting extends Global_VARS {

    private static ExtentReports report = null;
    private static ExtentTest currentTest;
    public static String reportName;
    public static String latestScreenshotAbs;
    private static String logFile;

    /**Initialise reports and create sub folders*/
    public static void init() {
        report = new ExtentReports();

        //Path reportDirectoryPath = Paths.get( reportDirectory,reportName,"_"+getCurrentTime());

        if(operatingSystem.toLowerCase().contains("win")) { //Windows Machine
            reportDirectory = reportDirectory +"\\"+reportName+"\\"+"_"+getCurrentTime();
        }
        else if(operatingSystem.toLowerCase().contains("mac") ||
                operatingSystem.toLowerCase().contains("linux")) { //Unix Machine
            reportDirectory = reportDirectory +"/"+reportName+"/"+"_"+getCurrentTime();

        }

        //reportDirectoryPath.toString();

        new File(reportDirectory).mkdirs();

        Path logPath = Paths.get(reportDirectory,"log.txt");

        logFile = logPath.toString();

        Path path = Paths.get(reportDirectory,"ExtentReport.html");
        ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(path.toString());
        report.attachReporter(htmlReport);
        report.setAnalysisStrategy(AnalysisStrategy.TEST);
    }

    /**Creates a new tab in report summary*/
    public static void createTest(String testName) {
        if(report == null) {
            init();
        }
        if (currentTest == null || !currentTest.getModel().getName().equals(testName)) {
            currentTest = report.createTest(testName);
        }
    }
    /**stepPassedWithScreenshot method takes a screenshot and pass with message.
     * @throws	Exception*/
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
    /**testFailed method captures screenshots of failed tests.
     * @throws	Exception*/
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
    /** /**logPass method logs all step passes to 'log.txt' file.
     * @throws	Exception*/
    public static void logPass(String pass) {
        try {
            writeToLogFile("- [PASS] " + pass);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /** /**logPass method logs all step passes to 'log.txt' file.
     * @throws	Exception*/
    public static void logInfo(String info) {
        try {
            writeToLogFile("- [INFO] " + info);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** /**logError method logs all step errors to 'log.txt' file.
     * @throws	Exception*/
    public static void logError(String error) {
        try {
            writeToLogFile("- [EROR] " + error);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /** /**logFailure method logs all step fails to 'log.txt' file.
     * @throws	Exception*/
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
    //writes to log file
    private static void writeToLogFile(String logMessage) throws IOException
    {
        File file = new File(logFile);
        String formatStr = "%n%-24s %-20s %-60s %-25s";
        if (!file.exists()) {
            file.createNewFile();
            PrintWriter writer = new PrintWriter(new FileWriter(file, true));
            writer.println(String.format(formatStr, "", "--SQA AUTOMATION LOG FILE --", "", ""));
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
