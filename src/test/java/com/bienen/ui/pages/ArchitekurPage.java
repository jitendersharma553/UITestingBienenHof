package com.bienen.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.bienen.ui.framework.Elements;

public class ArchitekurPage extends Elements {
	
	private final String pageTitle = "Architekur - bienen.hof-university.de";
	private By backendLinkBy = By.partialLinkText("Backend");
	private By projektLinkBy = By.partialLinkText("Projekt");
	private By gesamtarchitekturImgBy = By.cssSelector("img[alt='Gesamtarchitektur des Systems']");
	private By messarchitekturBy = By.cssSelector("img[alt='Messarchitektur']");
	
	
	
	private HomePage homePage;

	public ArchitekurPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Method to verify Architekur Page Title.
	 * @return
	 */
	public boolean verifyPageTitle() {
		return getPageTitle().equals(pageTitle);
	}
	
	/**
	 * Method to navigate to Architekur page.
	 * @return ArchitekurPage
	 */
	public ArchitekurPage navigateToArchitekurPage() {
		homePage = new HomePage(driver);
		homePage.navigateToHomePage();
		homePage.navigateToPageFromNavigationBar("Architekur");
		return this;
	}
	
	/**
	 * Method to verify if user is navigated to Backend Page from Architekur Page.
	 * @return
	 */
	public BackendPage navigateToBackendFromArchitekurPage(){
		 navigateToArchitekurPage();
		 waitForPresent(backendLinkBy);
		 click(backendLinkBy);
		 return new BackendPage(driver);	 
	}
	
	/**
	 * Method to verify if user is navigated to Projekt Page from Architekur Page.
	 * @return
	 */
	public ProjektPage navigateToProjektFromArchitekurPage(){
		 navigateToArchitekurPage();
		 waitForPresent(projektLinkBy);
		 click(projektLinkBy);
		 return new ProjektPage(driver);	 
	}
	
	/**
	 * Method to verify Gesamtarchitektur Image is displayed.
	 * @return
	 */
	public boolean verifyGesamtarchitekturImg() {
		return isElementPresent(gesamtarchitekturImgBy);
	}
	
	/**
	 * Method to verify Messarchitektur Image is displayed.
	 * @return
	 */
	public boolean verifyMessarchitektuImg() {
		return isElementPresent(messarchitekturBy);
	}

	
	
	


}
