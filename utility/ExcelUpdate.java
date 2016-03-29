package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUpdate {
	
	private static XSSFWorkbook wb;
	
	
	//Set Value for a particulat column row (cell).Write in excel

	@SuppressWarnings("resource")
	public static void update(int row,int col, String newValue) throws Exception {
			FileInputStream file = new FileInputStream(Constants.path);
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet ws = wb.getSheetAt(0);
			
			Cell cell = null;
			
			
			cell = ws.getRow(row).createCell(col);
			cell.setCellValue(newValue);
			
			
			
			file.close();
			FileOutputStream fileOut = new FileOutputStream(new File(Constants.path));
			wb.write(fileOut);
			System.out.println("cell ("+row+","+col+") is updated to value of : "+newValue );
			
		}
	
	
	//Get Data from excel for particular row col. xlsx
	
	public static String getData(int row , int col) throws Exception{
		FileInputStream file = new FileInputStream(Constants.path);
		wb = new XSSFWorkbook(file);
		XSSFSheet ws = wb.getSheetAt(0);
		
		Cell cell = null;
		
		
		cell = ws.getRow(row).getCell(col);
		
		cell.setCellType(1);
		String value = cell.getStringCellValue();
		
		return value;
		
		
	}

}
