package com.bienen.ui.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bienen.ui.framework.WebdriverTestBase;
import com.bienen.ui.pages.BackendPage;
import com.bienen.ui.pages.DatenbankPage;
import com.bienen.ui.pages.FrontendPage;
import com.bienen.ui.pages.MesswertePage;

public class DatenbankPageTest extends WebdriverTestBase {

	Logger logger = Logger.getLogger(DatenbankPageTest.class);

	DatenbankPage datenbankPage; 

	@Test(description = "TC_21: Verify that user is able to navigate to Datenbank page from Navigation bar on HomePage.",
			groups = {"Datenbankpage", "smokesuite"})
	public void verifyDatenbankPage(){

		logger.info("Test Method started: verifyDatenbankPage()");
		DatenbankPage datenbankPage = new DatenbankPage(driver);
		datenbankPage.navigateToDatenbankPage();
		Assert.assertTrue(datenbankPage.verifyPageTitle(), "User is not able to navigate to Datenbank Page");
	}

	@Test(description = "TC_22: Verify that user is able to navigate to Backend page from link given in bottom of page",
			groups = {"Datenbankpage","sanitysuite"})
	public void verifyBackendPageLinkOnDatenBankPage(){

		logger.info("Test Method started: verifyBackendPageLinkOnDatenBankPage()");
		DatenbankPage datenbankPage = new DatenbankPage(driver);
		datenbankPage.navigateToDatenbankPage();
		BackendPage backendPage = datenbankPage.navigateToBackendPageFromDatenbankPage();
		Assert.assertTrue(backendPage.verifyPageTitle(), "User is not navigated to Backend Page from Datenbank Page");

	}
	@Test(description = "TC_23: Verify that user is able to navigate to Frontend page from link given in bottom of page",
			groups = {"Datenbankpage","sanitysuite"})
	public void verifyFrontEndPageLinkOnDatenBankPage(){

		logger.info("Test Method started: verifyFrontEndPageLinkOnDatenBankPage()");
		DatenbankPage datenbankPage = new DatenbankPage(driver);
		datenbankPage.navigateToDatenbankPage();
		FrontendPage frontendPage = datenbankPage.navigateToFrontendPageFromDatenbankPage();
		Assert.assertTrue(frontendPage.verifyPageTitle(), "User is not navigated to Front End Page from Datenbank Page");

	}
	@Test(description = "TC_24: Verify that user is able to see Datenbankentwurf Image on left of text on Datenbank page",
			groups = {"Datenbankpage"})
	public void verifyDatenbankentwurfImage(){

		logger.info("Test Method started: verifyBackendArchitekturfinalImage()");
		DatenbankPage datenbankPage = new DatenbankPage(driver);
		datenbankPage.navigateToDatenbankPage();
		Assert.assertTrue(datenbankPage.verifyDatenbankentwurfImg(), "Datenbankentwurf Image is not displayed on Datenbank Page");

	}
	@Test(description = "TC_25: Verify that messwerte and grafana links navigate to appropriate page from Datenbank page",
			groups = {"Datenbankpage"})
	public void verifyLinksOnBottomOfDatenbankPage(){

		logger.info("Test Method started: verifyLinksOnBottomOfDatenbankPage()");
		DatenbankPage datenbankPage = new DatenbankPage(driver);
		datenbankPage.navigateToDatenbankPage();
		datenbankPage.clickOnMesswerteLinkOnDatenbankPage();
		MesswertePage messwertePage = new MesswertePage(driver);
		Assert.assertTrue(messwertePage.verifyPageTitle());
		datenbankPage.navigateToDatenbankPage();
		datenbankPage.clickOnGrafanaLinkOnDatenbankPage();
		// TODO: Add Page Verification when Link works again. For now it is failing as Link is not working
		Assert.assertTrue(false);	

	}



}
