package com.bienen.ui.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bienen.ui.framework.WebdriverTestBase;
import com.bienen.ui.pages.HomePage;
import com.bienen.ui.pages.MesswertePage;

public class MesswertePageTest extends WebdriverTestBase {

	Logger logger = Logger.getLogger(MesswertePageTest.class);
	
	HomePage homePage;
	MesswertePage messwertePage;

	@Test(description = "TC_37:Verify that user is able to navigate to Messwerte page from Navigation bar on HomePage.",
			groups = {"messwertepage","smokesuite"})
	public void verifyMesswertePage(){

		logger.info("Test Method started: verifyMesswertePage()");
		messwertePage = new MesswertePage(driver);
		messwertePage.navigateToMesswertePage();
		Assert.assertTrue(messwertePage.verifyPageTitle(), "User is not able to navigate to Messwerte Page");
	}
	
	@Test(description = "TC_38:Verify that user is able to navigate to Frontend page from link given in bottom of page",
			groups = {"messwertepage","sanitysuite"})
	public void verifyButtonsOnMesswertePage(){

		logger.info("Test Method started: verifyButtonsOnMesswertePage()");
		messwertePage = new MesswertePage(driver);
		messwertePage.navigateToMesswertePage();
		Assert.assertFalse(messwertePage.verifyBatteryButton(), "Battery button is displayed");
		Assert.assertTrue(messwertePage.verifymagnetButton(), "Magnet button is displayed");
		Assert.assertTrue(messwertePage.verifyTemperatureButton(), "Temperature button is displayed");
	}
	
}
