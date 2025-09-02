package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[contains(text(),'Simple Form Demo')]")
	WebElement simpleFormDemo;
	@FindBy(xpath = "//a[contains(text(),'Drag & Drop Sliders')]")
	WebElement dragAndDropSlider;
	@FindBy(xpath = "//a[contains(text(),'Input Form Submit')]")
	WebElement inputFormSubmit;

	public void clickSimpleFormDemo()
	{
		simpleFormDemo.click();
	}
	
	public void clickDragAndDropSlider()
	{
		dragAndDropSlider.click();
	}
	
	public void clickInputFormSubmit()
	{
		inputFormSubmit.click();
	}
	
	
	
}
