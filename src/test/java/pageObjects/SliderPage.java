package pageObjects;

import org.apache.logging.log4j.core.tools.picocli.CommandLine.MaxValuesforFieldExceededException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class SliderPage extends BasePage {
	public SliderPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h4[contains(text(),'Default value 15')]/parent::div//input")
	WebElement slider;
	@FindBy(xpath = "//h4[contains(text(),'Default value 15')]/parent::div//output")
	WebElement outputValue;

	public String dragDrop() {
		int min = Integer.parseInt(slider.getAttribute("min"));   // 1
		int max = Integer.parseInt(slider.getAttribute("max"));   // 100
		int current = Integer.parseInt(slider.getAttribute("value")); // 15
		int target = 95;
		int sliderWidth = slider.getSize().width;
		int xOffset = (target - current) * sliderWidth / (max - min);
		System.err.println(xOffset);
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider,xOffset/2+14, 0).perform();
		return outputValue.getText();
	}
}
