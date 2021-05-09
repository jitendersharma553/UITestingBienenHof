package com.bienen.ui.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bienen.ui.framework.WebdriverTestBase;
import com.bienen.ui.pages.ArchitekurPage;
import com.bienen.ui.pages.BackendPage;
import com.bienen.ui.pages.ProjektPage;

public class ArchitekurPageTest extends WebdriverTestBase {

	Logger logger = Logger.getLogger(ArchitekurPageTest.class);
	
	ArchitekurPage architekurPage; 

	@Test(description = "TC_11: Verify that user is able to navigate to Architekur page from Navigation bar on HomePage.",
			groups = {"Architekurpage","smokesuite"})
	public void verifyArchitekurPage(){

		logger.info("Test Method started: verifyArchitekurPage()");
		architekurPage = new ArchitekurPage(driver);
		architekurPage.navigateToArchitekurPage();
		Assert.assertTrue(architekurPage.verifyPageTitle(), "User is not ArchitekurPage to Projekt Page");
	}
	
	@Test(description = "TC_12: Verify that user is able to navigate to Backend page from link given in bottom of page",
			groups = {"Architekurpage","sanitysuite"})
	public void verifyBakendPageLink(){

		logger.info("Test Method started: verifyBakendPageLink()");
		architekurPage = new ArchitekurPage(driver);
		architekurPage.navigateToArchitekurPage();
		BackendPage backendPage = architekurPage.navigateToBackendFromArchitekurPage();
		Assert.assertTrue(backendPage.verifyPageTitle(), "User is not navigated to backendPage from Architekur Page");
		
	}
	@Test(description = "TC_13: Verify that user is able to navigate to Projekt page from link given in bottom of page",
			groups = {"Architekurpage","sanitysuite"})
	public void verifyProjektPageLink(){

		logger.info("Test Method started: verifyProjektPageLink()");
		architekurPage = new ArchitekurPage(driver);
		architekurPage.navigateToArchitekurPage();
		ProjektPage projektPage = architekurPage.navigateToProjektFromArchitekurPage();
		Assert.assertTrue(projektPage.verifyPageTitle(), "User is not navigated to Projekt Page from Architekur Page");
		
	}
	@Test(description = "TC_14: Verify that user is able to see Gesamtarchitektur des Systems Image on right of text on Architekur page",
			groups = {"Architekurpage"})
	public void verifyGesamtArchitekturImageOnArchPage(){

		logger.info("Test Method started: verifyGesamtArchitekturImageOnArchPage()");
		architekurPage = new ArchitekurPage(driver);
		architekurPage.navigateToArchitekurPage();
		Assert.assertTrue(architekurPage.verifyGesamtarchitekturImg(), "Gesamtarchitektur Image is not displayed on Architekur Page");
		
	}
	@Test(description = "TC_15: Verify that user is able to see Messarchitektur Image on right of text on Architekur page",
			groups = {"Architekurpage"})
	public void verifyMessarchitekturImageOnArchPage(){

		logger.info("Test Method started: verifyMessarchitekturImageOnArchPage()");
		architekurPage = new ArchitekurPage(driver);
		architekurPage.navigateToArchitekurPage();
		Assert.assertTrue(architekurPage.verifyMessarchitektuImg(), "Messarchitektu Image is not displayed on Architekur Page");
		
	}


}
