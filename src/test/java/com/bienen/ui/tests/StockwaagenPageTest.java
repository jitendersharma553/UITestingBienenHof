package com.bienen.ui.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bienen.ui.framework.WebdriverTestBase;
import com.bienen.ui.framework.utils.DataProviderClass;
import com.bienen.ui.pages.HomePage;
import com.bienen.ui.pages.StockwaagenPage;

public class StockwaagenPageTest extends WebdriverTestBase {

	Logger logger = Logger.getLogger(StockwaagenPageTest.class);

	HomePage homePage;
	StockwaagenPage stockwaagenPage;



	@Test(description = "TC_39:Verify that user is able to navigate to Stockwaagen page from Navigation bar on HomePage.",
			groups = {"stockwaagenpage","smokesuite"})
	public void verifyStockwaagenPage(){

		logger.info("Test Method started: verifyMesswertePage()");
		stockwaagenPage = new StockwaagenPage(driver);
		stockwaagenPage.navigateToStockwaagenPage();
		Assert.assertTrue(stockwaagenPage.verifyPageTitle(), "User is not able to navigate to Stockwaagen Page");
	}


	//TC: 40 Verify that user is able to see container with header "Insel-01-Volk-01" with Gesten and Heute data and "Header Link" on the Stockwaagen page.
	//TC: 41 Verify that user is able to see container with header "Insel-01-Volk-02" with Gesten and Heute data and "Header Link" on the Stockwaagen page.
	//TC: 42 Verify that user is able to see container with header "Insel-02-Volk-01" with Gesten and Heute data and "Header Link" on the Stockwaagen page.
	//TC: 43 Verify that user is able to see container with header "Insel-02-Volk-02" with Gesten and Heute data and "Header Link" on the Stockwaagen page.
	//TC: 44 Verify that user is able to see container with header "Insel-02-Volk-03" with Gesten and Heute data and "Header Link" on the Stockwaagen page.
	//TC: 45 Verify that user is able to see container with header "Insel-03-Volk-01" with Gesten and Heute data and "Header Link" on the Stockwaagen page.
	//TC: 46 Verify that user is able to see container with header "Insel-04-Volk-01" with Gesten and Heute data and "Header Link" on the Stockwaagen page.
	//TC: 47 Verify that user is able to see container with header "Insel-04-Volk-01" with Gesten and Heute data and "Header Link" on the Stockwaagen page.

	@Test(description = "Test to verify Insel Gestern, Heute data from Stockwaagen Page and Wolf Waagen Source",
			groups = {"stockwaagenpage"},
			dataProviderClass=DataProviderClass.class,
			dataProvider = "InselData")
	public void verifyInselSectionOnStockwaagenPage(String key, String env, String InselName, String IFrameID){

		logger.info("Test Method started: verifyInselSectionOnStockwaagenPage()");
		stockwaagenPage = new StockwaagenPage(driver);
		stockwaagenPage.navigateToStockwaagenPage();
		String gesternDataOnstockwaagenPage = stockwaagenPage.getGesternDataOnStockWaagenPage(InselName,Integer.parseInt(IFrameID));
		stockwaagenPage.clickOnGesternDataOnStockWaagenPage(InselName);
		String gesternDataOnWolfWaagenPage= stockwaagenPage.getYeildDataOnWolfWaagenPage();

		Assert.assertTrue(gesternDataOnstockwaagenPage.contains(gesternDataOnWolfWaagenPage), "Gestern Data on both Pages doesnt match for: "+InselName);

		String heuteDataOnstockwaagenPage= stockwaagenPage.getHeuteDataOnStockWaagenPage(InselName,Integer.parseInt(IFrameID));
		stockwaagenPage.clickOnHeuteDataOnStockWaagenPage(InselName);
		String heuteDataOnWolfWaagenPage= stockwaagenPage.getYeildDataOnWolfWaagenPage();

		Assert.assertTrue(heuteDataOnstockwaagenPage.contains(heuteDataOnWolfWaagenPage), "Gestern Data on both Pages doesnt match for: "+InselName);
		stockwaagenPage.verifyInselLinkOnStockwaagenPage(InselName,Integer.parseInt(IFrameID));

	}


}
