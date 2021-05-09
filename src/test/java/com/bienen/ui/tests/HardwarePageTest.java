package com.bienen.ui.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bienen.ui.framework.WebdriverTestBase;
import com.bienen.ui.pages.FrontendPage;
import com.bienen.ui.pages.HardwarePage;
import com.bienen.ui.pages.HomePage;

public class HardwarePageTest extends WebdriverTestBase {

	Logger logger = Logger.getLogger(HardwarePageTest.class);
	
	HomePage homePage;
	HardwarePage hardwarePage;

	@Test(description = "TC_33:Verify that user is able to navigate to Hardware page from Navigation bar on HomePage.",
			groups = {"Hardwarepage","smokesuite"})
	public void verifyHardwarePage(){

		logger.info("Test Method started: verifyHardwarePage()");
		hardwarePage = new HardwarePage(driver);
		hardwarePage.navigatetoHardwarePageFromHomePage();
		Assert.assertTrue(hardwarePage.verifyPageTitle(), "User is not able to navigate to Hardware Page");
	}
	
	@Test(description = "TC_34:Verify that user is able to navigate to Frontend page from link given in bottom of page",
			groups = {"Hardwarepage","sanitysuite"})
	public void verifyFrontendPageNavigationFromHardwarePage(){

		logger.info("Test Method started: verifyFrontendPageNavigationFromHardwarePage()");
		hardwarePage = new HardwarePage(driver);
		hardwarePage.navigatetoHardwarePageFromHomePage();
		FrontendPage frontendPage = hardwarePage.navigateToFrontendPageFromHardwarePage();
		Assert.assertTrue(frontendPage.verifyPageTitle(), "User is navigated to Frontend Page for HardwarePage");
	}
	
	@Test(description = "TC_35:Verify that user is able to see Messzarge von unten mit Temperatursensoren Image on rigth of text on Hardware page",
			groups = {"Hardwarepage","sanitysuite"})
	public void verifyMesszargeImageOnHardwarePage(){

		logger.info("Test Method started: verifyMesszargeImageOnHardwarePage()");
		hardwarePage = new HardwarePage(driver);
		hardwarePage.navigatetoHardwarePageFromHomePage();
		Assert.assertTrue(hardwarePage.verifyMesszargeImageBy(), "Messzarge image is not displayed");
	}
	
	@Test(description = "TC_36:Verify that user is able to see Fertige Bienenzarge Image on bottom of Hardware page",
			groups = {"Hardwarepage","sanitytests"})
	public void verifyFertigeImageOnHardwarePage(){

		logger.info("Test Method started: verifyFertigeImageOnHardwarePage()");
		hardwarePage = new HardwarePage(driver);
		hardwarePage.navigatetoHardwarePageFromHomePage();
		Assert.assertTrue(hardwarePage.verifyFertigeImageBy(), "Fertige image is not displayed");
	}
	
}
