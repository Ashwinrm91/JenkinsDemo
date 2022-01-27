package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static String TESTDATA_SHEET_PATH = "C:\\Users\\asrm\\Documents\\Demo Framework\\src\\main\\java\\com\\crm\\qa\\testdata\\Sample data.xlsx";

	static JavascriptExecutor js;

	public static String Readingexcelfile(String sheetName) throws IOException {
	    File f  = new File(TESTDATA_SHEET_PATH);;
		
		FileInputStream file = null;
		try {
			file = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//sheet = book.getSheet(sheetName);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
	    XSSFSheet sheetname = workbook.getSheet(sheetName);        
		 String Value = sheetname.getRow(0).getCell(0).getStringCellValue();
		 System.out.println(Value);
		 return Value;
//		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//		// System.out.println(sheet.getLastRowNum() + "--------" +
//		// sheet.getRow(0).getLastCellNum());
//		for (int i = 0; i < sheet.getLastRowNum(); i++) {
//			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
//				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
//				// System.out.println(data[i][k]);
//			}
	//	}
		//return data;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	
	
	public static void main (String args[]) throws Exception {
		
		TestUtil.Readingexcelfile("Demo");
	}

}
