package ddt_extra;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ddt_USING_EXCEL {
	public static void main(String[] args) throws IOException {


		FileInputStream fis = new FileInputStream("./src/test/resources/New Microsoft Excel Worksheet.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Sheet1");
		
		Row row = sh.getRow(5);
		
		Cell cell = row.getCell(1);
		
		String value = cell.getStringCellValue();
		
		System.out.println(value);
		
		wb.close();
	}






	}


