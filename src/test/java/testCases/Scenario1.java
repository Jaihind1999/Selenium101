package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SimpleFormDemoPage;
import testBase.BaseClass;

public class Scenario1 extends BaseClass {
	@Test
	public void formDemo()
	{
		HomePage hp = new HomePage(driver);
		SimpleFormDemoPage sfdp = new SimpleFormDemoPage(driver);
		logger.info("******* starting formDemo Test *******");
		navigateToHomePage();
		hp.clickSimpleFormDemo();
		boolean flag = driver.getCurrentUrl().contains("simple-form-demo");
		Assert.assertEquals(true, flag);
		String str = "Welcome to LambdaTest";
		sfdp.enterText(str);
		sfdp.clickGetCheckedValue();
		Assert.assertTrue(str.equals(sfdp.message()));
		logger.info("******* formDemo Test Completed *******");
	}

}
