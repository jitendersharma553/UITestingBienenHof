package com.bienen.ui.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.bienen.ui.framework.Elements;

public class ProjektPage extends Elements {

	private static final String pageTitle = "Projekt - bienen.hof-university.de";
	private By projektNavigationBarBy = By.cssSelector("#mainnavigation a[title=\"Projekt\"]");
	private By architekturLinkBy = By.partialLinkText("Architektur");
	private By bieneImgBy = By.cssSelector("img[title=\"Biene\"]");
	
	private HomePage homePage;
	
	public ProjektPage(WebDriver driver) {
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
	 * Method to navigate to Projekt page.
	 * @return
	 */
	public ProjektPage navigateToProjektPage() {
		homePage = new HomePage(driver);
		homePage.navigateToHomePage();
		click(projektNavigationBarBy);
		return this;
	}

	/**
	 * Method to verify if user is navigated to ArchitekurPage from Projekt Page.
	 * @return
	 */
	public ArchitekurPage navigateToArchitekurFromProjektPage(){
		 homePage = new HomePage(driver);
		 navigateToProjektPage();
		 waitForPresent(architekturLinkBy);
		 click(architekturLinkBy);
		 return new ArchitekurPage(driver);	 
	}
	
	/**
	 * Method to verify Biene Image is displayed.
	 * @return
	 */
	public boolean verifyBieneImg() {
		return isElementPresent(bieneImgBy);
	}

}
