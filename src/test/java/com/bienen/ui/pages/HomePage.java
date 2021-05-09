package com.bienen.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bienen.ui.framework.Elements;
import com.bienen.ui.framework.PropertyManager;

public class HomePage extends Elements {


	private By headerTextBy = By.cssSelector("#c211 header.frame-header h2");
	private By navigationBarBy = By.cssSelector("nav#mainnavigation");
	private By messwerteSectionHeaderBy = By.cssSelector("div#c318 h2 span");
	private By messwerteSectionLinkBy = By.cssSelector("div#c318 h2 a"); 
	private By messwerteSectionImgBy = By.cssSelector("div#c318 img");
	private By projektSectionHeaderBy = By.cssSelector("div#c319 h2 span");
	private By projektSectionLinkBy = By.cssSelector("div#c319 h2 a"); 
	private By projektSectionImgBy = By.cssSelector("div#c319 img");
	private By stockwaagenSectionHeaderBy = By.cssSelector("div#c320 h2 span");
	private By stockwaagenSectionLinkBy = By.cssSelector("div#c320 h2 a"); 
	private By stockwaagenSectionImgBy = By.cssSelector("div#c320 img");
	private By languageOptionsSelectedBy = By.cssSelector("#language_menu  li.active span");
	private By languageOptionsNotSelectedBy = By.cssSelector("#language_menu  li.text-muted  span");
	private By copyrightSectionBy = By.cssSelector("div .footer-copyright p");
	private By projectDropdownBy = By.id("nav-item-101");


	public HomePage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Method to navigate to HomePage of Application
	 * @return Object HomePage
	 */
	public HomePage navigateToHomePage() {
		driver.navigate().to(PropertyManager.getProperty("homePageURL"));
		return this;
	}

	/**
	 * Method to get header of the HomePage
	 * @return String 
	 */
	public String getHeaderText(){
		return getText(headerTextBy);
	}

	/**
	 * Method to check if Navigation Bar is Present 
	 * @return boolean
	 */
	public boolean isNavigationBarPresent(){
		return isElementPresent(navigationBarBy);
	}

	/**
	 * Method to get Messwerte Header Section
	 * @return
	 */
	public String getMesswerteHeader(){
		return getText(messwerteSectionHeaderBy);
	}

	/**
	 * Method to get Messwerte Image Source
	 * @return
	 */
	public String getMesswerteImg(){
		return getAttribute(messwerteSectionImgBy,"src");
	}

	/**
	 * Method to return click on Messwerte Section header on Home Page
	 * @param driver
	 * @return MesswertePage
	 */
	public MesswertePage clickOnMesswerteSectionLink(WebDriver driver) {
		click(messwerteSectionLinkBy);
		MesswertePage messwertePage = new MesswertePage(driver);
		return messwertePage;	
	}
	
	/**
	 * Method to get Projekt Header Section
	 * @return
	 */
	public String getProjektHeader(){
		return getText(projektSectionHeaderBy);
	}

	/**
	 * Method to get Projekt Image Source
	 * @return
	 */
	public String getProjekImg(){
		return getAttribute(projektSectionImgBy,"src");
	}
	

	/**
	 * Method to return click on Project Section header on Home Page
	 * @param driver
	 * @return ProjektPage
	 */
	public ProjektPage clickOnProjektSectionLink(WebDriver driver) {
		click(projektSectionLinkBy);
		ProjektPage projectPage = new ProjektPage(driver);
		return projectPage;	
	}

	/**
	 * Method to get Stockwaagen Header Section
	 * @return
	 */
	public String getStockwaagenHeader(){
		return getText(stockwaagenSectionHeaderBy);
	}

	/**
	 * Method to get Stockwaagen Image Source
	 * @return
	 */
	public String getStockwaagenImg(){
		return getAttribute(stockwaagenSectionImgBy,"src");
	}
	
	/**
	 * Method to click on Stockwaagen Header Link on Home Page
	 * @param driver
	 * @return StockwaagenPage
	 */
	public StockwaagenPage clickOnStockwaagenSectionLink(WebDriver driver) {
		click(stockwaagenSectionLinkBy);
		StockwaagenPage stockwaagenPage = new StockwaagenPage(driver);
		return stockwaagenPage;	
	}
	
	/**
	 * Method to get Selected Language Option on HomePage
	 * @return String
	 */
	public String getSelectedLanguageOption() {
			return getText(languageOptionsSelectedBy);		
	}
	/**
	 * Method to get Not Selected Language Option on HomePage
	 * @return String
	 */
	public String getNotSelectedLanguageOption() {
		return getText(languageOptionsNotSelectedBy);		
	}
	
	/**
	 * Method to verify both language options
	 * @return Boolean
	 */
	public boolean verifyLanguageOptions() {
		boolean result = false;
		if ( getSelectedLanguageOption().contains("Deutsch") && getNotSelectedLanguageOption().contains("English")) {
			result = true;
		} else result = false;
		return result;	
	}


	/**
	 * Method to get copyright section on HomePage
	 * @return String
	 */
	public String getCopyRightSectionOnHomePage() {
		return getText(copyrightSectionBy);
	}
	
	/**
	 * Method to navigate to Specific page from Navigation bar on Homepage
	 */
	public void navigateToPageFromNavigationBar(String pageName) {
		 WebElement projektWebElement = driver.findElement(projectDropdownBy);
		 hoverOver(projektWebElement);
		 click(driver.findElement(By.cssSelector("a[title='"+pageName+"']")));
		
	}




}
