package com.actTime.genericLibNew;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtils 
{
	public Properties getPropertyFileObject() throws Throwable
	{
		FileInputStream fis = new FileInputStream("./CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		return pObj;	
	}

	public String getExcelData(String sheetName, int rowName, int colName) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./testScriptData.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet(sheetName);
        Row row = sh.getRow(rowName);
        String data = row.getCell(colName).getStringCellValue();
        wb.close();
		return data;
	}
	
	public void setExcelData(String sheetName, int rowName, int colName, String data)throws Throwable
	{
		FileInputStream fis = new FileInputStream("./testScriptData.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet(sheetName);
        Row row = sh.getRow(rowName);
        Cell cel = row.createCell(rowName);
        cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./testScriptData.xlsx");
		wb.write(fos);
		wb.close();
	}
}
