package com.bienen.ui.framework.utils;

import com.bienen.ui.framework.PropertyManager;

/**
 * This class will be used to contain common java util functions which will be used throughout the application.
 * 
 * @author Jitender Sharma
 *
 */
public class JavaUtils {
	
	
	/**
	 * This method will return the environment where we will run out testcases ex. Prod or beta
	 * @return String Environment
	 */
	public static String getEnvironment(){
		return PropertyManager.getProperty("env");
	}	

}
