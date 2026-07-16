package utils;

import org.openqa.selenium.*;
import java.io.File;
import org.apache.commons.io.FileUtils;


/**
 * Utility Class: CommonUtils
 * Description: Contains reusable methods like pause and screenshot
 */

public class CommonUtils {

    public static void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {}
    }

    public static void screenshot(WebDriver driver, String name) {
        try {
            File folder = new File("./screenshots");
            if (!folder.exists()) {
                folder.mkdir();   // create folder if not exists
            }

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File("./screenshots/" + name + ".png");
            
            FileUtils.copyFile(src, dest);

            System.out.println("Screenshot saved: " + dest.getAbsolutePath());

        } catch (Exception e) {
            System.out.println("Screenshot error: " + e.getMessage());
        }
    }
    }
