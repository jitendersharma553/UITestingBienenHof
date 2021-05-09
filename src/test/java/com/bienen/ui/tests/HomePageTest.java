package com.bienen.ui.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bienen.ui.framework.WebdriverTestBase;
import com.bienen.ui.pages.HomePage;
import com.bienen.ui.pages.MesswertePage;
import com.bienen.ui.pages.ProjektPage;
import com.bienen.ui.pages.StockwaagenPage;

public class HomePageTest extends WebdriverTestBase {
	
	private final String MesswerteImgSrc = "/fileadmin/_processed_/8/1/csm_chart_icon_bg_ef64324029.png";
	private final String ProjektImgSrc = "/fileadmin/_processed_/0/7/csm_project_icon_bg_458e6767fc.png";
	private final String StockwaagenImgSrc = "/fileadmin/_processed_/a/e/csm_beehive_icon_bg_7ae2b85dbb.png";

	Logger logger = Logger.getLogger(HomePageTest.class);	

	@Test(description = "TC_1: Verify that user is navigated to home page",
			groups = {"homepage","smokesuite"})
	public void verifyHomePage(){

		logger.info("Test Method started: verifyHomePage()");

		HomePage homePage = new HomePage(driver);
		homePage.navigateToHomePage();
		Assert.assertEquals(driver.getTitle(), "Startseite - bienen.hof-university.de");
	}
	
	@Test(description = "TC_2: Verify Navigation bar should be displayed on HomePage.",
			groups = {"homepage","smokesuite"})
	public void verifyNavigationBarHomePage(){

		logger.info("Test Method started: verifyNavigationBarHomePage()");

		HomePage homePage = new HomePage(driver);
		homePage.navigateToHomePage();
		Assert.assertTrue(homePage.isNavigationBarPresent());
	}
	
	@Test(description = "TC_3: Verify that Messwerte section with Picture and link is displayed on homepage",
			groups = {"homepage","sanitysuite"})
	public void verifyMesswerteSectionHomePage(){

		logger.info("Test Method started: verifyMesswerteSectionHomePage()");

		HomePage homePage = new HomePage(driver);
		homePage.navigateToHomePage();
		
		logger.info("Verifying Messwerte Header");
		Assert.assertEquals(homePage.getMesswerteHeader(), "MESSWERTE");
		
		logger.info("Verifying Messwerte Image source");
		Assert.assertTrue(homePage.getMesswerteImg().contains(MesswerteImgSrc), "Image source is not correct");
		
		logger.info("Verifying Messwerte Section Link");
		MesswertePage messwertePage = homePage.clickOnMesswerteSectionLink(driver);
		Assert.assertTrue(messwertePage.verifyPageTitle(), "User is not navigated to Messwerte Page");	
	}
	
	@Test(description = "TC_4: Verify that Projekt section with Picture and link is displayed on homepage",
			groups = {"homepage","sanitysuite"})
	public void verifyProjektSectionHomePage(){

		logger.info("Test Method started: verifyProjektSectionHomePage()");

		HomePage homePage = new HomePage(driver);
		homePage.navigateToHomePage();
		
		logger.info("Verifying Projekt Header");
		Assert.assertEquals(homePage.getProjektHeader(), "PROJEKT");
		
		logger.info("Verifying Projekt Image source");
		Assert.assertTrue(homePage.getProjekImg().contains(ProjektImgSrc), "Image source is not Correct");
		
		logger.info("Verifying Projekt Section Link");
		ProjektPage projektPage = homePage.clickOnProjektSectionLink(driver);
		Assert.assertTrue(projektPage.verifyPageTitle(), "User is not navigated to Projekt Page");
	}
	
	@Test(description = "TC_5: Verify that Stockwaagen section with Picture and link is displayed on homepage",
			groups = {"homepage"})
	public void verifyStockwaagenSectionHomePage(){

		logger.info("Test Method started: verifyStockwaagenSectionHomePage()");

		HomePage homePage = new HomePage(driver);
		homePage.navigateToHomePage();
		
		logger.info("Verifying Stockwaagen Header");
		Assert.assertEquals(homePage.getStockwaagenHeader(), "STOCKWAAGEN");
		
		logger.info("Verifying Stockwaagen Image source");
		Assert.assertTrue(homePage.getStockwaagenImg().contains(StockwaagenImgSrc), "Image source is not correct");
		
		logger.info("Verifying Stockwaagen Section Link");
		StockwaagenPage stockwaagenPage = homePage.clickOnStockwaagenSectionLink(driver);
		Assert.assertTrue(stockwaagenPage.verifyPageTitle(), "User is not navigated to Stockwaagen Page");
	}	
	
	@Test(description = "TC_6: Verify that Langauage section with two options Deutsch and English is displayed on homepage footer",
			groups = {"homepage"})
	public void verifyLanguageOptionsOnHomePage(){

		logger.info("Test Method started: verifyLanguageOptionsOnHomePage()");

		HomePage homePage = new HomePage(driver);
		homePage.navigateToHomePage();
		Assert.assertTrue(homePage.verifyLanguageOptions(), "Language options are not correct");
	}
	
	@Test(description = "TC_7: Verify that copyright section is displayed on homepage footer",
			groups = {"homepage"})
	public void verifyCopyRightSectionOnHomePage(){

		logger.info("Test Method started: verifyCopyRightSectionOnHomePage()");

		HomePage homePage = new HomePage(driver);
		homePage.navigateToHomePage();
		Assert.assertEquals(homePage.getCopyRightSectionOnHomePage(), "© 2020 Hochschule Hof");
	}	
}
