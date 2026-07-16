package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import utils.CommonUtils;

import java.time.Duration;


/**
 * Page Name: AlertConfirmPage
 * Description: This class handles Confirm Alert (OK & Cancel)
 */

public class AlertConfirmPage {

    WebDriver driver;
    WebDriverWait wait;
    

/**
     * Constructor to initialize driver and wait
     */


    public AlertConfirmPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

 // Locator for Confirm tab
    By tab = By.xpath("//a[contains(text(),'Alert with OK & Cancel ')]");
    By button = By.xpath("(//button[contains(text(),'click the button')])[2]");
    By result = By.id("demo");

    

    /**
        * This method handles Confirm Alert scenario
        */

    public void handleConfirm() {
        driver.findElement(tab).click();

        wait.until(ExpectedConditions.elementToBeClickable(button)).click();

        Alert alert = driver.switchTo().alert();
        System.out.println("Confirm Text: " + alert.getText());
        
        CommonUtils.pause(5);
     // Click Cancel
        alert.dismiss();

     // Capture result message
        String msg = driver.findElement(result).getText();
        System.out.println("Message: " + msg);
    }
}