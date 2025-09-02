package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

import pageObjects.InputFormPage;
import testBase.BaseClass;

public class Scenario3 extends BaseClass {
    
    @Test
    public void testInputForm() throws InterruptedException {
        logger.info("Starting Input Form Test");
        
        // Navigate directly to the Input Form Demo page
        driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");
        logger.info("Navigated to Input Form Demo page");
        
        // Wait for page load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("name")));
        
        // Initialize the page object
        InputFormPage inputForm = new InputFormPage(driver);
        
        // Find the submit button and scroll it into view
        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(500); // Small pause for scroll to complete
        
        // Click submit without filling the form
        inputForm.clickSubmit();
        logger.info("Clicked submit button without filling form");
        
        // Assert the validation message
        String validationMessage = inputForm.getNameFieldValidationMessage();
        Assert.assertEquals(validationMessage, "Please fill out this field.");
        logger.info("Validated error message: " + validationMessage);
        
        // Fill in the form fields
        inputForm.fillForm("John Doe", "john.doe@example.com");
        logger.info("Filled in form fields");
        
        // Select United States from country dropdown
        inputForm.selectCountry("United States");
        logger.info("Selected United States from country dropdown");
    }
}
