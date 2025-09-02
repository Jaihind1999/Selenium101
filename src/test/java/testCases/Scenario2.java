package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SliderPage;
import testBase.BaseClass;

public class Scenario2 extends BaseClass{
	@Test
	public void dragAndDropTest(){
		HomePage hp = new HomePage(driver);
		SliderPage sl = new SliderPage(driver);
		logger.info("******* starting dragAndDrop Test *******");
		navigateToHomePage();
		hp.clickDragAndDropSlider();
		String currentValue=sl.dragDrop();
		Assert.assertTrue(currentValue.equals("95"));
	}
}
