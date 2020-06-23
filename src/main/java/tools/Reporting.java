package tools;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**Reporting class
 * @author smlungwana
 * */
public class Reporting {
    public static boolean takeScreenShot() {
        try {
            DateFormat stamp = new SimpleDateFormat("MM.dd.yy.HH.mm.ss");
            Date date = new Date();

            captureScreen(stamp.format(date)+".png");
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    private static void captureScreen(String fileName) throws Exception{
        WebDriver driver = SeleniumDriver.getInstance().getDriver();
        String path = "";
        File screenShot = null;

        screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot,new File(path + fileName));
    }
}
