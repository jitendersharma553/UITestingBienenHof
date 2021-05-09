package com.bienen.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bienen.ui.framework.Elements;

public class StockwaagenPage extends Elements {


	private static final String pageTitle = "Stockwaagen - bienen.hof-university.de";
	private By stockwaagenPageNavigationBarBy = By.cssSelector("#mainnavigation a[title=\"Stockwaagen\"]");
	private By inselHeadingOnWolfWaagenPageBy = By.cssSelector("#scale-selection-col h5");
	private By heuteDataOnStockwaagenPageBy = By.cssSelector(".row.yield-row div:nth-child(2) div:nth-child(1)");
	private By yeildDataOnWolfWaagenPageBy = By.cssSelector("#stock-container span.value.text-yield");
	private String firstGestern = "((//a[contains(text(),'";
	private String lastGestern = "')]//following::div[@class='row yield-row']//following::div[contains(@class, 'value')]))[1]";
	private String firstHeute = "((//a[contains(text(),'";
	private String lastHeute = "')]//following::div[@class='row yield-row']//following::div[contains(@class, 'value')]))[2]";
	private HomePage homePage;
	
	
	public StockwaagenPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Method to return Page Title 
	 * @return PageTitle
	 */
	public boolean verifyPageTitle() {
		return getPageTitle().equals(pageTitle);
	}
	
	/**
	 * Method to navigate to Stockwaagen Page.
	 * @return StockwaagenPage
	 */
	public StockwaagenPage navigateToStockwaagenPage() {
		homePage = new HomePage(driver);
		homePage.navigateToHomePage();
		click(stockwaagenPageNavigationBarBy);
		return this;
	}
	
	/**
	 * Method to Open to Insel on Stockwaagen Page.
	 */
	public void openInselLink(String inselName, int iFrameIndex) {
		navigateToStockwaagenPage();
		switchToIframeByIndex(iFrameIndex);
		WebElement link = driver.findElement(By.partialLinkText(inselName));
		hoverOver(link);
		driver.findElement(By.partialLinkText(inselName)).click();
		
	}
	
	/**
	 * Method to get Insel Heading from Insel Section
	 * @param inselName
	 * @param iFrameIndex
	 * @return
	 */
	public String getInselHeadingOnWolfwaagenPage(String inselName, int iFrameIndex) {
		openInselLink(inselName, iFrameIndex);
		switchToNewWindow();
		waitForPresent(inselHeadingOnWolfWaagenPageBy);
		return getText(inselHeadingOnWolfWaagenPageBy);
	}
	
	/**
	 * Method to verify Insel link on Stockwaagen Page.
	 * @param inselName
	 * @param iFrameIndex
	 * @return
	 */
	public boolean verifyInselLinkOnStockwaagenPage(String inselName, int iFrameIndex) {
		switchBackToBaseWindow();
		return getInselHeadingOnWolfwaagenPage(inselName, iFrameIndex).contains(inselName);
	}
	
	/**
	 * Method to get Gestern data form Insel section on Stockwaagen Page 
	 * @param inselName
	 * @param iFrameIndex
	 * @return
	 */
	public String getGesternDataOnStockWaagenPage(String inselName, int iFrameIndex) {
		switchToIframeByIndex(iFrameIndex);
		WebElement gestenDataWebElement = driver.findElement(By.xpath(firstGestern+inselName+lastGestern));
		String gesternData = gestenDataWebElement.getText();
		return gesternData;
	}
	
	/**
	 * Method to get Heute data from Insel Section on Stockwaagen Page
	 * @param inselName
	 * @param iFrameIndex
	 * @return
	 */
	public String getHeuteDataOnStockWaagenPage(String inselName, int iFrameIndex) {
		switchBackToBaseWindow();
		switchToIframeByIndex(iFrameIndex);
		String HeuteData = getText(heuteDataOnStockwaagenPageBy);
		return HeuteData;
	}
	
	/**
	 * Method to get Yeild data from WolfWaagen source
	 * @return
	 */
	public String getYeildDataOnWolfWaagenPage(){
		switchToNewWindow();
		String dataOnWolfWaagenPage = getText(yeildDataOnWolfWaagenPageBy);
		return dataOnWolfWaagenPage;
	}
	
	/**
	 * Method to click on Gestern Data on Stockwaagen Page.
	 * @param inselName
	 */
	public void clickOnGesternDataOnStockWaagenPage(String inselName) {
		WebElement gestenDataWebElement = driver.findElement(By.xpath(firstGestern+inselName+lastGestern));
		jsClick(gestenDataWebElement);
	}
	
	/**
	 * Method to click on Heute data on Stockwaagen Page.
	 * @param inselName
	 */
	public void clickOnHeuteDataOnStockWaagenPage(String inselName) {
		WebElement heuteDataWebElement = driver.findElement(By.xpath(firstHeute+inselName+lastHeute));
		jsClick(heuteDataWebElement);
	}


	
	


}
