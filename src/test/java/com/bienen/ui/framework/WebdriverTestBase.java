package com.bienen.ui.framework;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * 
 * Base test class which starts and ends the webdriver instance.
 * Note: Each test script class must extend this class.
 * 
 * @author Jitender Sharma
 */
public abstract class WebdriverTestBase {

	Logger logger = Logger.getLogger(WebdriverTestBase.class);

	protected WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void launchBrowser(Method method) throws MalformedURLException {
		driver = WebdriverManager.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		logger.info("Started test method: " + method.getName());
	}

	@AfterMethod( alwaysRun = true)
	public void quitBrowser() {
		if (driver != null)
			driver.quit();

	}

	/**
	 * Take screenshot only when any test method is failed
	 * @param result
	 * @throws IOException
	 */
	@AfterMethod
	public void takeScreenshot(ITestResult result) throws IOException {
		String testMethodName = result.getName();
		String testClass = result.getInstanceName();
		logger.info("***** End of test :" + testClass + testMethodName);

		if (!result.isSuccess()) {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);

			try{
				//FileHandler.copy(source, new File(".//Screenshots//"+result.getName()+".png"));
				System.out.println("Screenshot taken");
			}
			catch (Exception e)
			{
				System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
		}

	}

	// ------------Assertions----------------

	public void verify(Object actual, Object expected) {
		Assert.assertEquals(actual, expected, "Objects not matched");
	}

	public void verifyTrue(boolean condition) {
		Assert.assertTrue(condition, "Condition is not true");
	}

}
