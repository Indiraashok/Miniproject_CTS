package testcases;

import java.io.FileInputStream;
import java.time.Duration;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


import pages.AlertConfirmPage;
import pages.AlertOKPage;
import pages.AlertPromptPage;
import utils.CommonUtils;


/**
 * Project Name: Selenium Alert Handling
 * Description: This class executes alert handling scenarios
 * Author: Indira
 */


public class AlertTest {

    public static void main(String[] args) {

        WebDriver driver = null;
        //Exception Handling
        try {

            //  Load data
            Properties prop = new Properties();
            FileInputStream fis = new FileInputStream("./config.properties");
            prop.load(fis);
            //Read data from config.properties file.
            String name = prop.getProperty("name");
            String browser = prop.getProperty("browser");

            //  Multi-browser setup
            
            //launch browser based on input
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver-win64/chromedriver.exe");
                driver = new ChromeDriver();
            } 

            else {
                
                driver = new EdgeDriver();
            }
            //maximize browser
            driver.manage().window().maximize();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            //Launch application
            driver.get("http://demo.automationtesting.in/Alerts.html");

            System.out.println("Website opened");

         // Create Actions object
         Actions actions = new Actions(driver);

         // Hover on "SwitchTo"
         WebElement switchTo = wait.until(
             ExpectedConditions.visibilityOfElementLocated(By.linkText("SwitchTo"))
         );
         actions.moveToElement(switchTo).perform();

         // Press ENTER (keyboard action)
         actions.sendKeys(Keys.ENTER).perform();

         // Click on "Alerts"
         WebElement alerts = wait.until(
             ExpectedConditions.elementToBeClickable(By.linkText("Alerts"))
         );
         actions.moveToElement(alerts).click().perform();


         //  Screenshot of homepage
            CommonUtils.pause(2);
            CommonUtils.screenshot(driver, "homepage");

            // ================= ALERT OK =================
            AlertOKPage ok = new AlertOKPage(driver);
            ok.handleAlertOK();

            CommonUtils.pause(3);
            CommonUtils.screenshot(driver, "alert_ok");

         // ================= CONFIRM ALERT =================
            AlertConfirmPage confirm = new AlertConfirmPage(driver);
            confirm.handleConfirm();

            CommonUtils.pause(3);
            CommonUtils.screenshot(driver, "confirm");

         // ================= PROMPT ALERT =================
            AlertPromptPage prompt = new AlertPromptPage(driver);
            prompt.handlePrompt(name);

            CommonUtils.pause(3);
            CommonUtils.screenshot(driver, "prompt");

        } 
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } 
        finally {
        	//close browser safely
            driver.quit();
            System.out.println("Browser closed");
        }
    }
}