package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import base.BaseClassPOM;

public class ReadExcelData extends BaseClassPOM{
	
	public static String[][] readData(String fileName, String sheetName) throws IOException {

		XSSFWorkbook wb = new XSSFWorkbook("./data/" + fileName + ".xlsx");
		XSSFSheet ws = wb.getSheet(sheetName);
		int rowCount = ws.getLastRowNum();
		int columnCount = ws.getRow(0).getLastCellNum();
		String[][] data = new String[rowCount][columnCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				XSSFRow row = ws.getRow(i);
				XSSFCell cell = row.getCell(j);
				data[i - 1][j] = cell.getStringCellValue();

			}

		}
		wb.close();
		return data;
	}

}
