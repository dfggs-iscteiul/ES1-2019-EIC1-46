package code;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LerDadosExcel {

	public static void main(String[] args) {
		
		File excelFile = new File("Long-Method.xlsx");
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(excelFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFWorkbook workbook=null;
		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		Iterator<Row> rowIt = sheet.iterator();
		
		while(rowIt.hasNext()) {
			Row row = rowIt.next();
			
			Iterator<Cell> cellIterator = row.cellIterator();
			
			while(cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				System.out.println(cell.toString() + ";");
			}
		}
		
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
