package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import utils.CommonUtils;

import java.time.Duration;


/**
 * Page Name: AlertPromptPage
 * Description: This class handles Prompt Alert (Textbox input)
 */

public class AlertPromptPage {

    WebDriver driver;
    WebDriverWait wait;


/**
     * Constructor to initialize driver and wait
     */

    public AlertPromptPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

 // Locator for Prompt tab
    By tab = By.xpath("//a[contains(text(),'Alert with Textbox ')]");
 // Locator for prompt button
    By button = By.xpath("(//button[contains(text(),'click the button')])[3]");
    By result = By.id("demo1");

    

    /* This method handles Prompt Alert
        * @param name - value to be entered in alert textbox
        */

    public void handlePrompt(String name) {
        driver.findElement(tab).click();

        wait.until(ExpectedConditions.elementToBeClickable(button)).click();

        Alert alert = driver.switchTo().alert();
        CommonUtils.pause(3);
     // Enter name in alert
        alert.sendKeys(name);
        
        
     // Accept alert
        alert.accept();

     // Capture result message
        String msg = driver.findElement(result).getText();
        System.out.println("Message: " + msg);
    }
}