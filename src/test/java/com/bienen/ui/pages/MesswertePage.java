package com.bienen.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.bienen.ui.framework.Elements;

public class MesswertePage extends Elements {


	private static final String pageTitle = "Messwerte - bienen.hof-university.de";
	private By messwerteNavigationBarBy = By.cssSelector("#mainnavigation a[title=\"Messwerte\"]");
	private By batteryButtonBy = By.cssSelector("img.btnbattery");
	private By temperatureButtonBy = By.cssSelector("img.btntemp");
	private By magnetButtonBy = By.cssSelector("img.btnmagnet");
	
	private HomePage homePage;
	
	public MesswertePage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Method to verify Messwerte Page Title.
	 * @return boolean
	 */
	public boolean verifyPageTitle() {
		return getPageTitle().equals(pageTitle);
	}
	
	/**
	 * Method to navigate to Messwerte Page.
	 * @return MesswertePage
	 */
	public MesswertePage navigateToMesswertePage() {
		homePage = new HomePage(driver);
		homePage.navigateToHomePage();
		click(messwerteNavigationBarBy);
		return this;
	}
	
	/**
	 * Method to verify Battery button is displayed on Messwerte Page.
	 * @return Boolean
	 */
	public boolean verifyBatteryButton() {
		return isElementPresent(batteryButtonBy);
	}
	
	/**
	 * Method to verify Temperature button is displayed on Messwerte Page.
	 * @return Boolean
	 */
	public boolean verifyTemperatureButton() {
		return isElementPresent(temperatureButtonBy);
	}
	
	/**
	 * Method to verify Magnet button is displayed on Messwerte Page.
	 * @return Boolean
	 */
	public boolean verifymagnetButton() {
		return isElementPresent(magnetButtonBy);
	}

	
	
	


}
