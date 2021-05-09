package com.bienen.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.bienen.ui.framework.Elements;

public class BackendPage extends Elements {


	private final String pageTitle = "Backend - bienen.hof-university.de";
	private By architekturLinkBy = By.partialLinkText("Architektur");
	private By datenbankLinkBy = By.partialLinkText("Datenbank");
	private By backendErsteImgBy = By.cssSelector("img[alt='Backend erste Variante']");
	private By backendArchitekturfinaBy = By.cssSelector("img[alt='Backend Architektur final']");
	
	
	
	private HomePage homePage;

	public BackendPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Method to verify Backend Page Title.
	 * @return
	 */
	public boolean verifyPageTitle() {
		return getPageTitle().equals(pageTitle);
	}
	
	/**
	 * Method to navigate to Backend page.
	 * @return BackendPage
	 */
	public BackendPage navigateToBackendPage() {
		homePage = new HomePage(driver);
		homePage.navigateToHomePage();
		homePage.navigateToPageFromNavigationBar("Backend");
		return this;
	}
	
	/**
	 * Method to verify if user is navigated to Architekur Page from Backend Page.
	 * @return
	 */
	public ArchitekurPage navigateToArchitekturFromBackendPage(){
		 homePage = new HomePage(driver);
		 navigateToBackendPage();
		 waitForPresent(architekturLinkBy);
		 click(architekturLinkBy);
		 return new ArchitekurPage(driver);	 
	}
	
	/**
	 * Method to verify if user is navigated to DatenBank Page from Backend Page.
	 * @return
	 */
	public DatenbankPage navigateToDatenBankFromBackendPage(){
		 homePage = new HomePage(driver);
		 navigateToBackendPage();
		 waitForPresent(datenbankLinkBy);
		 click(datenbankLinkBy);
		 return new DatenbankPage(driver);	 
	}
	
	/**
	 * Method to verify backend Erste Img Image is displayed.
	 * @return
	 */
	public boolean verifyBackendErsteImg() {
		return isElementPresent(backendErsteImgBy);
	}
	
	/**
	 * Method to verify backend Architektur final  Image is displayed.
	 * @return
	 */
	public boolean verifyBackendArchitekturfinalImg() {
		return isElementPresent(backendArchitekturfinaBy);
	}

	
	
	
	
	


}
