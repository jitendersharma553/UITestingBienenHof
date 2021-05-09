package com.bienen.ui.framework;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
public class WebdriverManager {


	public static WebDriver getDriver() throws MalformedURLException{

		WebDriver driver = null;

		/**
		 * Creates an authentication instance using the supplied user name/access key.
		 */

		String browser = PropertyManager.getProperty("browser");


		if(browser.equalsIgnoreCase("firefox")){
			String path = null;
			try {
				path = new File(PropertyManager.getProperty("geckoDriver")).getCanonicalPath();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.setProperty("webdriver.gecko.driver", path);
			driver = new FirefoxDriver();


			driver = new FirefoxDriver();

		} else if(browser.equalsIgnoreCase("chrome")){

			String path = null;

			try {
				path = new File(PropertyManager.getProperty("chromeDriver")).getCanonicalPath();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.setProperty("webdriver.chrome.driver", path);
			driver = new ChromeDriver();


		} else{

			/**
			 * Represents the browser type, version, and operating system to be used as part * of the test run.
			 */
			String SAUCE_USERNAME = "jitenderhof";
			String SAUCE_ACCESS_KEY= "3d849b56-7c86-4948-9dff-0d5fe8c29126";
			String SAUCE_DC = "@ondemand.eu-central-1.saucelabs.com:443";
			String URL = "https://" + SAUCE_USERNAME + ":" + SAUCE_ACCESS_KEY + SAUCE_DC;

			System.out.println("browser name is : " + browser);

			MutableCapabilities sauceOpts = new MutableCapabilities();
			sauceOpts.setCapability("build", "Java-W3C-Examples");
			sauceOpts.setCapability("seleniumVersion", "3.141.59");
			sauceOpts.setCapability("username", SAUCE_USERNAME);
			sauceOpts.setCapability("accessKey", SAUCE_ACCESS_KEY);
			sauceOpts.setCapability("tags", "w3c-chrome-tests");

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("sauce:options", sauceOpts);
			cap.setCapability("browserName", "chrome");
			cap.setCapability("browserVersion", "latest");
			cap.setCapability("platformName", "Windows 10");

			try {
				driver = new RemoteWebDriver(new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub"), cap);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		return driver;
	}
}



