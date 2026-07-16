package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import utils.CommonUtils;

import java.time.Duration;


/**
 * Page Name: AlertOKPage
 * Description: This class handles "Alert with OK" functionality
 */

public class AlertOKPage {

    WebDriver driver;
    WebDriverWait wait;
    

/**
     * Constructor to initialize driver and wait
     */

    public AlertOKPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

 // Locator for Alert with OK tab
    By tab = By.xpath("//a[contains(text(),'Alert with OK ')]");
    
 // Locator for alert button
    By button = By.xpath("//button[contains(text(),'click the button')]");

    

/**
     * This method handles Alert with OK scenario
     */

    public void handleAlertOK() {
        driver.findElement(tab).click();

        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
        
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert Text: " + alert.getText());
        CommonUtils.pause(3);


        alert.accept();

    }
}