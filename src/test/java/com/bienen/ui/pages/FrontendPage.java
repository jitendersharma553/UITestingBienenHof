package com.bienen.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.bienen.ui.framework.Elements;

public class FrontendPage extends Elements {


	private final String pageTitle = "Frontend - bienen.hof-university.de";
	private By datenbankLinkBy = By.partialLinkText("Datenbank");
	private By hardwareLinkBy = By.partialLinkText("Hardware");
	private By logoImgBy = By.cssSelector("img[alt='Logo']");
	private By farbschemaImgBy = By.cssSelector("img[alt='Farbschema']");
	private By verworfenesLogoImgBy = By.cssSelector("img[alt='verworfenes Logo']");
	private By bienenstockNachtImgBy = By.cssSelector("img[alt='Bienenstock Nacht']");
	private By bienenstockTagImgBy = By.cssSelector("img[alt='Bienenstock Tag']");
	
	
	private HomePage homePage;

	public FrontendPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Method to verify Frontend Page Title.
	 * @return boolean
	 */
	public boolean verifyPageTitle() {
		return getPageTitle().equals(pageTitle);
	}
	
	/**
	 * Method to navigate to Frontend page
	 * @return FrontendPage
	 */
	public FrontendPage navigatetoFrontEndPage() {
		homePage = new HomePage(driver);
		homePage.navigateToHomePage();
		homePage.navigateToPageFromNavigationBar("Frontend");
		return this;
	}
	
	/**
	 * Method to verify if user is navigated to Datenbank Page from Frontend Page.
	 * @return DatenbankPage
	 */
	public DatenbankPage navigateToDatenbankPageFromFrontendPage(){
		 homePage = new HomePage(driver);
		 navigatetoFrontEndPage();
		 waitForPresent(datenbankLinkBy);
		 click(datenbankLinkBy);
		 return new DatenbankPage(driver);	 
	}
	
	/**
	 * Method to verify if user is navigated to Hardware Page from Frontend Page.
	 * @return HardwarePage
	 */
	public HardwarePage navigateToHardwarePageFromFrontendPage(){
		 homePage = new HomePage(driver);
		 navigatetoFrontEndPage();
		 waitForPresent(hardwareLinkBy);
		 click(hardwareLinkBy);
		 return new HardwarePage(driver);	 
	}
	
	/**
	 * Method to verify Logo Image is displayed on Frontend Page
	 * @return Boolean
	 */
	public boolean verifyLogoImage() {
		return isElementPresent(logoImgBy);
	}
	
	/**
	 * Method to verify Farbschema Image is displayed on Frontend Page
	 * @return Boolean
	 */
	public boolean verifyFarbschemaImage() { 
		return isElementPresent(farbschemaImgBy);
	}
	/**
	 * Method to verify Verworfenes Logo Image is displayed on Frontend Page
	 * @return Boolean
	 */
	public boolean verifyVerworfenesLogoImageBy() { 
		return isElementPresent(verworfenesLogoImgBy);
	}
	/**
	 * Method to verify Bienenstock Nacht Image is displayed on Frontend Page
	 * @return Boolean
	 */
	public boolean verifyBienenstockNachtImage() { 
		return isElementPresent(bienenstockNachtImgBy);
	}
	/**
	 * Method to verify Bienen stock Image is displayed on Frontend Page
	 * @return Boolean
	 */
	public boolean verifyBienenstockImage() {
		return isElementPresent(bienenstockTagImgBy);
	}

}
