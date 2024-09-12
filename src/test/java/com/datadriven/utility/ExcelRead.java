package com.datadriven.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.datadriven.test.BaseClass;

public class ExcelRead extends BaseClass{

	public static void excelread() throws IOException {
	
		File f = new File("C:\\neworkspace\\DataDriven_Aug\\resources\\Testdata.xlsx");
		
		FileInputStream fis = new FileInputStream(f);
		
		XSSFWorkbook work = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = work.getSheet("Sheet1");
		
		int rowcount =	sheet.getLastRowNum()+1;
		
		System.out.println(rowcount);
		
		int colcount = sheet.getRow(0).getLastCellNum();
		
		System.out.println(colcount);
		
		for(int i=0;i<colcount;i++)
		{
			map.put(data.formatCellValue(sheet.getRow(0).getCell(i)), data.formatCellValue(sheet.getRow(1).getCell(i)));

		}
		

	}
	
	public String getData(String key) throws IOException
	{
		excelread();
		return map.get(key);
	}

}
