package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {

	public XSSFWorkbook wb;
	public XSSFSheet ws;
	public XSSFCell cell;

	public String[][] readFromExcel(String fileName, String sheetName) {
		try {
			wb = new XSSFWorkbook("./src/main/resources/utils/" + fileName + ".xlsx");
		} catch (IOException e) {

			e.getMessage();
		}

		ws = wb.getSheet(sheetName);
		int lastRowNum = ws.getLastRowNum();
		short lastColNum = ws.getRow(0).getLastCellNum();

		String[][] value = new String[lastRowNum][lastColNum];

		for (int i = 1; i <= lastRowNum; i++) {
			for (int j = 0; j < lastColNum; j++) {
				cell = ws.getRow(i).getCell(j);
				value[i - 1][j] = cell.getStringCellValue();

			}
		}

		try {

			wb.close();
		} catch (IOException e) {
			e.getMessage();
		}

		return value;
	}

}
