package com.vtiger.genericUtils;

import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelFileUtility implements AutoConstant{
	/**
	 *  its used read the data from excel based on below arguments 
	 * @paramsheetName
	 * @paramrowNum
	 * @paramcelNum
	 * @return Data
	 * @throwsThrowable
	 */
	public String getDataFromExcel(String sheetName , int rowNum, int celNum) throws Throwable {
		FileInputStream fis  =new FileInputStream(xcelFilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(celNum).getStringCellValue();
		wb.close();
		return data;
	}
	
	public int getintExcel(String sheetName , int rowNum, int celNum) throws Throwable {
		FileInputStream fis  =new FileInputStream(xcelFilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		 int data = (int) row.getCell(celNum).getNumericCellValue();
		wb.close();
		return data;
}
	public Object[][] getDataFromExcel(String sheetName ) throws Throwable {
		FileInputStream fis  =new FileInputStream(xcelFilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		 int lastrow = sh.getLastRowNum();
		 int lastcell = sh.getRow(0).getLastCellNum();
		 Object[][] data = new Object[lastrow][lastcell];
		for(int i=0;i<lastrow;i++)
		{
			for(int j=0;j<lastcell;j++) {
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
}
