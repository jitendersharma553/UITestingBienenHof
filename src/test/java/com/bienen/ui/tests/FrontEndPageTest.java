package com.bienen.ui.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bienen.ui.framework.WebdriverTestBase;
import com.bienen.ui.pages.DatenbankPage;
import com.bienen.ui.pages.FrontendPage;
import com.bienen.ui.pages.HardwarePage;

public class FrontEndPageTest extends WebdriverTestBase {

	Logger logger = Logger.getLogger(FrontEndPageTest.class);
	
	FrontendPage frontendPage; 

	@Test(description = "TC_26:Verify that user is able to navigate to Frontend page from Navigation bar on HomePage.",
			groups = {"Frontendpage","smokesuite"})
	public void verifyFrontEndPage(){

		logger.info("Test Method started: verifyFrontEndPage()");
		frontendPage = new FrontendPage(driver);
		frontendPage.navigatetoFrontEndPage();
		Assert.assertTrue(frontendPage.verifyPageTitle(), "User is not able to navigate to Frontend Page");
	}
	
	@Test(description = "TC_27: Verify that user is able to navigate to Datenbank page from link given in bottom of page",
			groups = {"Frontendpage","sanitysuite"})
	public void verifyDatenBankLinkOnFrontendPage(){

		logger.info("Test Method started: verifyDatenBankLinkOnFrontendPage()");
		frontendPage = new FrontendPage(driver);
		frontendPage.navigatetoFrontEndPage();
		DatenbankPage datenbankPage = frontendPage.navigateToDatenbankPageFromFrontendPage();
		Assert.assertTrue(datenbankPage.verifyPageTitle(), "User is not navigated to Datenbank from Frontend Page");
		
	}
	@Test(description = "TC_28: Verify that user is able to navigate to Hardware page from link given in bottom of page",
			groups = {"Frontendpage","sanitysuite"})
	public void verifyHardwarePageLinkOnFrontendPage(){

		logger.info("Test Method started: verifyHardwarePageLinkOnFrontendPage()");
		frontendPage = new FrontendPage(driver);
		frontendPage.navigatetoFrontEndPage();
		HardwarePage hardwarePage = frontendPage.navigateToHardwarePageFromFrontendPage();
		Assert.assertTrue(hardwarePage.verifyPageTitle(), "User is not navigated to Hardware from Frontend Page");
		
	}
	@Test(description = "TC_29: Verify that user is able to see Logo Image on rigth of text on Frontend page",
			groups = {"Frontendpage"})
	public void verifyLogoImage(){

		logger.info("Test Method started: verifyLogoImage()");
		frontendPage = new FrontendPage(driver);
		frontendPage.navigatetoFrontEndPage();
		Assert.assertTrue(frontendPage.verifyLogoImage(), "Logo Image is not displayed on Frontend Page");
		
	}
	
	@Test(description = "TC_30: Verify that user is able to see Farbschema Image on right of text on Frontend page",
			groups = {"Frontendpage"})
	public void verifyFarbschemaImage(){

		logger.info("Test Method started: verifyFarbschemaImage()");
		frontendPage = new FrontendPage(driver);
		frontendPage.navigatetoFrontEndPage();
		Assert.assertTrue(frontendPage.verifyFarbschemaImage(), "Farbschema Image is not displayed on Frontend Page");	
	}
	
	@Test(description = "TC_31: Verify that user is able to see verworfenes Logo Image on left of text on Frontend page",
			groups = {"Frontendpage"})
	public void verifyVerworfenesLogoImage(){

		logger.info("Test Method started: verifyVerworfenesLogoImage()");
		frontendPage = new FrontendPage(driver);
		frontendPage.navigatetoFrontEndPage();
		Assert.assertTrue(frontendPage.verifyVerworfenesLogoImageBy(), "Verworfenes Logo Image is not displayed on Frontend Page");	
	}
	
	@Test(description = "TC_32: Verify that user is able to see Bienenstock Nacht Image on bottom of Frontend page",
			groups = {"Frontendpage"})
	public void verifyBienenstockNachtImage(){

		logger.info("Test Method started: verifyBienenstockNachtImage()");
		frontendPage = new FrontendPage(driver);
		frontendPage.navigatetoFrontEndPage();
		Assert.assertTrue(frontendPage.verifyBienenstockNachtImage(), "Bienenstock Nacht Image is not displayed on Frontend Page");	
	}
	
	@Test(description = "TC_33: Verify that user is able to see Bienenstock Tag Image on bottom of Frontend page",
			groups = {"Frontendpage"})
	public void verifyBienenstockTagImage(){

		logger.info("Test Method started: verifyBienenstockTagImage()");
		frontendPage = new FrontendPage(driver);
		frontendPage.navigatetoFrontEndPage();
		Assert.assertTrue(frontendPage.verifyBienenstockImage(), "Bienenstock Tag is not displayed on Frontend Page");	
	}
}
