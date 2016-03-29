package utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import testCases.LoginTest;

public class ExcelRead {

	// method to load values from excel cells to data array
	@SuppressWarnings("resource")
	public static String[][] read(String path, String sheet) throws Exception {

		// path(excel file) >> worksheet variable ws
		File excel = new File(path);
		FileInputStream fis = new FileInputStream(excel);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet(sheet);

		// setting maximum limit for rows and cols
		int row = ws.getLastRowNum() + 1;
		int col = ws.getRow(0).getLastCellNum();

		// intializing data 2D array
		String[][] data = new String[row][col];

		// transferring cell value into data array
		for (int i = 0; i < row; i++) {
			XSSFRow vrow = ws.getRow(i);
			for (int j = 0; j < col; j++) {
				try {
					XSSFCell cell;
					cell = vrow.getCell(j);
					cell.setCellType(1);
					data[i][j] = cell.getStringCellValue();
					;
				} catch (NullPointerException e) {
					System.out.println();

				}

			}
		}
		return data;
	}

	
	//Method to Find username corresponding to testcase name
	
	public static String username(String testCaseName) throws Exception {
		String valueOf = null;

		if (testCaseName.equalsIgnoreCase(ExcelUpdate.getData(LoginTest.h, 0))) 
			System.out.println();
			valueOf = ExcelUpdate.getData(LoginTest.h, 1);
			LoginTest.flag--;
		
		
		return valueOf;
		
		

		
	}
	
	//method to find password corresponding to testcase name

	public static String password(String testCaseName) throws Exception {
		String valueOf = null;

		if (testCaseName.equalsIgnoreCase(ExcelUpdate.getData(LoginTest.h, 0))) 
			System.out.println();
		valueOf = ExcelUpdate.getData(LoginTest.h, 2);
			LoginTest.flag--;
		

		return valueOf;
	}
}
