package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class InputFormPage extends BasePage {
    private WebDriverWait wait;
    
    public InputFormPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    @FindBy(xpath = "//button[text()='Submit']")
    private WebElement submitButton;
    
    @FindBy(id = "name")
    private WebElement nameField;
    
    @FindBy(id = "inputEmail4")
    private WebElement emailField;
    
    @FindBy(id = "inputPassword4")
    private WebElement passwordField;
    
    @FindBy(id = "company")
    private WebElement companyField;
    
    @FindBy(id = "websitename")
    private WebElement websiteField;
    
    @FindBy(name = "country")
    private WebElement countryDropdown;
    
    @FindBy(id = "inputCity")
    private WebElement cityField;
    
    @FindBy(id = "inputAddress1")
    private WebElement addressField;
    
    @FindBy(id = "inputAddress2")
    private WebElement address2Field;
    
    @FindBy(id = "inputState")
    private WebElement stateField;
    
    @FindBy(id = "inputZip")
    private WebElement zipField;
    
    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        try {
            Thread.sleep(500); // wait for page to settle after scroll
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
    }
    
    public String getNameFieldValidationMessage() {
        wait.until(ExpectedConditions.visibilityOf(nameField));
        return nameField.getAttribute("validationMessage");
    }
    
    public void fillForm(String name, String email) {
        wait.until(ExpectedConditions.visibilityOf(nameField)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys("password123");
        wait.until(ExpectedConditions.visibilityOf(companyField)).sendKeys("Test Company");
        wait.until(ExpectedConditions.visibilityOf(websiteField)).sendKeys("www.example.com");
        wait.until(ExpectedConditions.visibilityOf(addressField)).sendKeys("123 Test St");
        wait.until(ExpectedConditions.visibilityOf(address2Field)).sendKeys("Apt 456");
        wait.until(ExpectedConditions.visibilityOf(stateField)).sendKeys("Test State");
        wait.until(ExpectedConditions.visibilityOf(cityField)).sendKeys("Test City");
        wait.until(ExpectedConditions.visibilityOf(zipField)).sendKeys("12345");
    }
    
    public void selectCountry(String country) {
        wait.until(ExpectedConditions.visibilityOf(countryDropdown));
        Select select = new Select(countryDropdown);
        select.selectByVisibleText(country);
    }
}
