package com.bienen.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.bienen.ui.framework.Elements;

public class DatenbankPage extends Elements {


	private final String pageTitle = "Datenbank - bienen.hof-university.de";
	private By backendLinkBy = By.partialLinkText("Backend");
	private By frontendLinkBy = By.partialLinkText("Frontend");
	private By datenbankentwurfImgBy = By.cssSelector("img[alt='Datenbankentwurf']");
	private By messwerteLinkBy = By.partialLinkText("messwerte");
	private By grafanaLinkBy = By.partialLinkText("grafana");
	
	
	private HomePage homePage;

	public DatenbankPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Method to verify Datenbank Page Title.
	 * @return
	 */
	public boolean verifyPageTitle() {
		return getPageTitle().equals(pageTitle);
	}
	
	/**
	 * Method to navigate to Datenbank page.
	 * @return Datenbank
	 */
	public DatenbankPage navigateToDatenbankPage() {
		homePage = new HomePage(driver);
		homePage.navigateToHomePage();
		homePage.navigateToPageFromNavigationBar("Datenbank");
		return this;
	}
	
	/**
	 * Method to verify if user is navigated to Backend Page from Datenbank Page.
	 * @return BackendPage
	 */
	public BackendPage navigateToBackendPageFromDatenbankPage(){
		 navigateToDatenbankPage();
		 waitForPresent(backendLinkBy);
		 click(backendLinkBy);
		 return new BackendPage(driver);	 
	}
	
	/**
	 * Method to verify if user is navigated to Frontend Page from Datenbank Page.
	 * @return FrontendPage
	 */
	public FrontendPage navigateToFrontendPageFromDatenbankPage(){
		 homePage = new HomePage(driver);
		 navigateToDatenbankPage();
		 waitForPresent(frontendLinkBy);
		 click(frontendLinkBy);
		 return new FrontendPage(driver);	 
	}
	
	/**
	 * Method to verify Datenbankentwurf Image is displayed.
	 * @return Boolean
	 */
	public boolean verifyDatenbankentwurfImg() {
		return isElementPresent(datenbankentwurfImgBy);
	}
	
	/**
	 * Method to click on Messwerte Link on DataenBank Page
	 */
	public void clickOnMesswerteLinkOnDatenbankPage() {
		click(messwerteLinkBy);
	}
	/**
	 * Method to click on Grafana Link on DataenBank Page
	 */
	public void clickOnGrafanaLinkOnDatenbankPage() {
		click(grafanaLinkBy);
	}

}
