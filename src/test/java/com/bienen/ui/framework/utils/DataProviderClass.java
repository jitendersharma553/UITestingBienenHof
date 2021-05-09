package com.bienen.ui.framework.utils;

import org.testng.annotations.DataProvider;

/**
 * This class contains all the data providers for now and future.
 * 
 * @author Jitender Sharma
 *
 */
public class DataProviderClass {
	
	@DataProvider(name="InselData")
	public Object[][] InselData() throws Exception{
		return new Object[][]{
			new ExcelReader().readFor("dataSheet", "Insel01Volk01"),
			new ExcelReader().readFor("dataSheet", "Insel01Volk02"),
			new ExcelReader().readFor("dataSheet", "Insel02Volk01"),
			new ExcelReader().readFor("dataSheet", "Insel02Volk02"),
			new ExcelReader().readFor("dataSheet", "Insel02Volk03"),
			new ExcelReader().readFor("dataSheet", "Insel03Volk01"),
			new ExcelReader().readFor("dataSheet", "Insel04Volk01"),
			new ExcelReader().readFor("dataSheet", "Insel04Volk02"),
		};	
	} 
	
}
