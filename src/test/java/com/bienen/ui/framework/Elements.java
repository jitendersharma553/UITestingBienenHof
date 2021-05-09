package com.bienen.ui.framework;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is used for all common methods that will be reused in Page classes.
 * 
 * @author Jitender Sharma
 *
 */
public abstract class Elements {

	public WebDriver driver;
	private String baseWindow; 
	public Elements(WebDriver driver){
		this.driver = driver;
	}
	
	/**
	 * Method to switch between different windows of browser
	 */
	public void switchToNewWindow(){
		baseWindow = driver.getWindowHandle();
		
		Set<String> handles = driver.getWindowHandles();
		
		for (String handle : handles) {
			if(!handle.equals(baseWindow)){
 				driver.switchTo().window(handle);
			}
		}
	}
	
	/**
	 * Method to switch between different iFrames of browser
	 */
	public void switchToIframeByIndex(int index){
		driver.switchTo().frame(index);
		
	}
	
	
	/**
	 * Method to switch to Parent iFrame of browser
	 */
	public void switchToParentIframe(){
		driver.switchTo().parentFrame();
		
	}
	
	/**
	 * Method to switch back to Main window from new window
	 */
	public void switchBackToBaseWindow(){
		driver.close();
		driver.switchTo().window(baseWindow);
	}
	
	// -------------Waits--------------
	
	/**
	 * Method to wait for presence of element on page.
	 * @param by
	 * @return
	 */
	public WebElement waitForPresent(By by){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	
	/**
	 * Method to wait for element to be disappeared from page
	 * @param by
	 */
	public void waitForDissappear(By by){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
	
	/**
	 * Method to wait for text to be present on Page.
	 * @param by
	 * @param text
	 */
	public void waitForTextToPresent(By by, String text){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
	}
	
	
	// ------------Conditions------------
	
	
	/**
	 * Method to check if element is present on Page.
	 * @param by
	 * @return
	 */
	public boolean isElementPresent(By by){
		
		if(getElements(by).size() > 0)
			return true;
		else return false;
	}

	// -------------Actions--------------
	/**
	 * Method to get WebElement Object.
	 * @param by
	 * @return
	 */
	public WebElement getElement(By by){
		return driver.findElement(by);
	}
	
	/**
	 * Method to get list of WebElement Objects.
	 * @param by
	 * @return
	 */
	public List<WebElement> getElements(By by){
		return driver.findElements(by);
	}
	
	/**
	 * Method to click on Element on Page using by parameter
	 * @param by
	 */
	public void click(By by){
		getElement(by).click();
	}
	
	/**
	 * Method to use Javascript click.
	 */
	public void jsClick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		
	}
	
	/**
	 * Method to click on Element on Page using WebElement parameter.
	 * @param webElement
	 */
	public void click(WebElement webElement){
		webElement.click();
	}
	
	/**
	 * Method to enter value in Element on Page.
	 * @param by
	 * @param value
	 */
	public void enter(By by, String value){
		getElement(by).sendKeys(value);
	}
	
	/**
	 * Method to Hover mouse over web element on Page.
	 * @param element
	 */
	public void hoverOver(WebElement element){
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	
	/**
	 * This method is used to get text from element
	 * @param by
	 * @return
	 */
	public String getText(By by){
		return getElement(by).getText();
	}
	
	/**
	 * This method is used to get attibute of Element
	 * @param by
	 * @return
	 */
	public String getAttribute(By by, String attribute){
		return getElement(by).getAttribute(attribute);
	}
	
	/**
	 * This method is used to get Title of Page
	 * @param by
	 * @return
	 */
	public String getPageTitle(){
		return driver.getTitle();
	}
	
	// -------------Drop-Down-------------------
	
	
	/**
	 * Method to select Element from Dropdown using Visible Text.
	 * @param element
	 * @param option
	 */
	public void selectDropdownOption(WebElement element, String option){
		Select select = new Select(element);
		select.selectByVisibleText(option);
	}
	
	/**
	 * Method to select Option from Dropdown using Option Value
	 * @param listItems
	 * @param option
	 */
	public void clickOption(By listItems, String option){
	
		List<WebElement>  li = getElements(listItems);
		
		for (WebElement item : li) {
			if(item.getText().contains(option)){
				item.click();
				break;
			}
		}
		
	}
	
	
	
}
