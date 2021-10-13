package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	/*
	 * @Monika
	 */
		/**
		 * This method is used to read data from excel by specifying sheetname, row number and cell number
		 * @param sheetName
		 * @param rownum
		 * @param cellnum
		 * @return
		 * @throws Throwable
		 */
		public String getExcelData(String sheetName,int rownum,int cellnum) throws Throwable {
			FileInputStream file = new FileInputStream(IPathConstant.EXCEL_FILEPATH);
			Workbook workbook = WorkbookFactory.create(file);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rownum);
			Cell cell = row.getCell(cellnum);
			return cell.getStringCellValue();
			
		}
		
	//  public Object[][] getExcelData(String sheetName){
//		  FileInputStream file = new FileInputStream(IPathConstant.EXCEL_FILEPATH);
//		  
//		  
//		 // return data;
	//  }
		
		/**
		 * This method used to write data inside the excel sheet
		 * @param sheetname
		 * @param rownum
		 * @param column
		 * @param value
		 * @throws Throwable
		 */
		public void writeExcelData(String sheetname,int rownum,int column,String value ) throws Throwable {
			FileInputStream file = new FileInputStream(IPathConstant.EXCEL_FILEPATH);
			Workbook workbook = WorkbookFactory.create(file);
			workbook.createSheet(sheetname).createRow(rownum).createCell(column).setCellValue(value);
			FileOutputStream writeFile = new FileOutputStream(IPathConstant.EXCEL_FILEPATH);
			workbook.write(writeFile);
		}
}
