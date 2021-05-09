package com.bienen.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.bienen.ui.framework.Elements;

public class HardwarePage extends Elements {


	private final String pageTitle = "Hardware - bienen.hof-university.de";
	private By frontendLinkBy = By.partialLinkText("Frontend");
	private By messzargeImgBy = By.cssSelector("img[alt='Messzarge von unten mit Temperatursensoren']");
	private By fertigeImgBy = By.cssSelector("img[alt='Fertige Bienenzarge']");
	
	
	private HomePage homePage;

	public HardwarePage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Method to verify Hardware Page Title.
	 * @return boolean
	 */
	public boolean verifyPageTitle() {
		return getPageTitle().equals(pageTitle);
	}
	
	/**
	 * Method to navigate to Hardware page
	 * @return HardwarePage
	 */
	public HardwarePage navigatetoHardwarePageFromHomePage() {
		homePage = new HomePage(driver);
		homePage.navigateToHomePage();
		homePage.navigateToPageFromNavigationBar("Hardware");
		return this;
	}
	
	/**
	 * Method to verify if user is navigated to Frontend Page from Hardware Page.
	 * @return FrontendPage
	 */
	public FrontendPage navigateToFrontendPageFromHardwarePage(){
		 homePage = new HomePage(driver);
		 navigatetoHardwarePageFromHomePage();
		 waitForPresent(frontendLinkBy);
		 click(frontendLinkBy);
		 return new FrontendPage(driver);	 
	}
	
	
	/**
	 * Method to verify Messzarge Image is displayed on Hardware Page
	 * @return Boolean
	 */
	public boolean verifyMesszargeImageBy() { 
		return isElementPresent(messzargeImgBy);
	}
	/**
	 * Method to verify Verworfenes Logo Image is displayed on Frontend Page
	 * @return Boolean
	 */
	public boolean verifyFertigeImageBy() { 
		return isElementPresent(fertigeImgBy);
	}

	
	
	


}
