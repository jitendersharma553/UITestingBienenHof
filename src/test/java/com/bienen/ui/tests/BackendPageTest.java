package com.bienen.ui.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bienen.ui.framework.WebdriverTestBase;
import com.bienen.ui.pages.ArchitekurPage;
import com.bienen.ui.pages.BackendPage;
import com.bienen.ui.pages.DatenbankPage;

public class BackendPageTest extends WebdriverTestBase {

	Logger logger = Logger.getLogger(BackendPageTest.class);

	BackendPage backendPage; 

	@Test(description = "TC_16: Verify that user is able to navigate to Backend page from Navigation bar on HomePage.",
			groups = {"Backendpage","smokesuite"})
	public void verifyBackEndPage(){

		logger.info("Test Method started: verifyBackendPage()");
		backendPage = new BackendPage(driver);
		backendPage.navigateToBackendPage();
		Assert.assertTrue(backendPage.verifyPageTitle(), "User is not able to navigate to Backend Page");
	}

	@Test(description = "TC_17: Verify that user is able to navigate to Architekur page from link given in bottom of page",
			groups = {"Backendpage","sanitysuite"})
	public void verifyArchitekurPageLinkOnBackendPage(){

		logger.info("Test Method started: verifyArchitekurPageLinkOnBackendPage()");
		backendPage = new BackendPage(driver);
		backendPage.navigateToBackendPage();
		ArchitekurPage architekurPage = backendPage.navigateToArchitekturFromBackendPage();
		Assert.assertTrue(architekurPage.verifyPageTitle(), "User is not navigated to architekurPage from Backend Page");

	}
	@Test(description = "TC_18: Verify that user is able to navigate to Datenbank page from link given in bottom of page",
			groups = {"Backendpage","sanitysuite"})
	public void verifyDatenbankPageLinkOnBackendPage(){

		logger.info("Test Method started: verifyDatenbankPageLinkOnBackendPage()");
		backendPage = new BackendPage(driver);
		backendPage.navigateToBackendPage();
		DatenbankPage datenbankPage = backendPage.navigateToDatenBankFromBackendPage();
		Assert.assertTrue(datenbankPage.verifyPageTitle(), "User is not navigated to Datenbank from Backend Page");

	}
	@Test(description = "TC_20: Verify that user is able to see Backend Architektur final Image is displayed on Backend page",
			groups = {"Backendpage"})
	public void verifyBackendArchitekturfinalImage(){

		logger.info("Test Method started: verifyBackendArchitekturfinalImage()");
		backendPage = new BackendPage(driver);
		backendPage.navigateToBackendPage();
		Assert.assertTrue(backendPage.verifyBackendArchitekturfinalImg(), "Backend Architektur final Image is not displayed on Backend Page");

	}
	@Test(description = "TC_19: Verify that user is able to see Backend Architektur final Image on right of text on Backend page",
			groups = {"Backendpage"})
	public void verifyBackendErsteImage(){

		logger.info("Test Method started: verifyBackendErsteImage()");
		backendPage = new BackendPage(driver);
		backendPage.navigateToBackendPage();
		Assert.assertTrue(backendPage.verifyBackendErsteImg(), "Backend Erste Image is not displayed on Backend Page");	
	}



}
