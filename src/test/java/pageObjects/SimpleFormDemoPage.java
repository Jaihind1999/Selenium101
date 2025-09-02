package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SimpleFormDemoPage extends BasePage {
	public SimpleFormDemoPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//input[@id='user-message']")
	WebElement textBox;
	@FindBy(xpath = "//button[contains(text(),'Get Checked Value')]")
	WebElement getCheckedValue;
	@FindBy(xpath = "//p[@id='message']")
	WebElement message;
	
	
	public void enterText(String text)
	{
		textBox.sendKeys(text);
	}

	public void clickGetCheckedValue()
	{
		getCheckedValue.click();
	}
	 public String message()
	 {
		 return message.getText();
	 }
}
