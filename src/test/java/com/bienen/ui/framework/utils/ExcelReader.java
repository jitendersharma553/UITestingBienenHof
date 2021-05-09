package com.bienen.ui.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {


	public Object[] readFor(String sheetName, String key) throws IOException{

		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testData.xlsx");

		String fileName = file.getName();
		String extension = fileName.substring(fileName.indexOf("."));
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = null;
		if(extension.equals(".xlsx")){
			workbook = new XSSFWorkbook(fileInputStream);
		} else if (extension.equals(".xls")) {
			workbook = new HSSFWorkbook(fileInputStream);
		}
		Sheet sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		Object[] array = null;
		for (int i = 0; i <= rowCount; i++) {
			Row row = sheet.getRow(i);
			if(row.getCell(0).getRichStringCellValue().toString().contains(key) && row.getCell(1).getRichStringCellValue().toString().contains(JavaUtils.getEnvironment())){
				array = new Object[row.getLastCellNum()];
				for(int j = 0; j < row.getLastCellNum(); j++ ){
					array[j] = getCellData(row.getCell(j));
				}
				break;
			}
		}
		return array;
	}

	public Object getCellData(Cell cell){
		if(cell.getCellType().equals(CellType.STRING)) {return cell.getRichStringCellValue().getString();}
		else if(cell.getCellType().equals(CellType.NUMERIC)){
			cell.setCellType(CellType.STRING);
			return cell.getRichStringCellValue().getString();}
		else return null;
	}
}
