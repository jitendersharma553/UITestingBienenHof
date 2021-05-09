package com.bienen.ui.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bienen.ui.framework.WebdriverTestBase;
import com.bienen.ui.pages.ArchitekurPage;
import com.bienen.ui.pages.ProjektPage;

public class ProjektPageTest extends WebdriverTestBase {

	Logger logger = Logger.getLogger(ProjektPageTest.class);

	@Test(description = "TC_8: Verify that user is able to navigate to Projekt page from Navigation bar on HomePage.",
			groups = {"Projektpage","smokesuite"})
	public void verifyProjektPage(){

		logger.info("Test Method started: verifyProjektPage()");
		ProjektPage projektPage = new ProjektPage(driver);
		projektPage.navigateToProjektPage();
		Assert.assertTrue(projektPage.verifyPageTitle(), "User is not navigated to Projekt Page");
	}
	
	@Test(description = "TC_9: Verify that user is able to navigate to Architekur page from link given in bottom of page.",
			groups = {"Projektpage","sanitysuite"})
	public void verifyArchitekurPageLinkOnProjektPage(){

		logger.info("Test Method started: verifyArchitekurPageLinkOnProjektPage()");
		ProjektPage projektPage = new ProjektPage(driver);
		ArchitekurPage architekurPage = projektPage.navigateToArchitekurFromProjektPage();
		Assert.assertTrue(architekurPage.verifyPageTitle(), "User is not navigated to ArchitekurPage from Projekt Page");
		
	}
	@Test(description = "TC_10: Verify that user is able to see Biene Image on right of text on Projekt page.",
			groups = {"Projektpage","sanitysuite"})
	public void verifyBieneImageOnProjektPage(){

		logger.info("Test Method started: verifyBieneImageOnProjektPage()");
		ProjektPage projektPage = new ProjektPage(driver);
		projektPage.navigateToProjektPage();
		Assert.assertTrue(projektPage.verifyBieneImg(), "Biene Image is not displayed on Projekt Page");
		
	}


}
