package com.bienen.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.bienen.ui.framework.Elements;
import com.bienen.ui.framework.PropertyManager;

public class DatenschutzPage extends Elements {


	private By headerTextBy = By.cssSelector("#c211 header.frame-header h2");
	private By navigationBarBy = By.cssSelector("nav#mainnavigation");
	private By messwerteHeaderBy = By.cssSelector("div#c318 h2 span");
	private By messwerteLinkBy = By.cssSelector("div#c318 h2 a"); 
	private By messwerteImgBy = By.cssSelector("div#c318 img");
	

	public DatenschutzPage(WebDriver driver) {
		super(driver);
	}

	public DatenschutzPage navigateToHomePage() {
		driver.navigate().to(PropertyManager.getProperty("homePageURL"));
		return this;
	}

	public String getHeaderText(){
		return getText(headerTextBy);
	}


	public boolean isNavigationBarPresent(){
		return isElementPresent(navigationBarBy);
	}
	

	public String getMesswerteHeader(){
		 return getText(messwerteHeaderBy);
	}
	
	public String getMesswerteImg(){
		 return getText(messwerteImgBy);
	}
	
	
	


}
