package code;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LerDadosExcel {

	public static void main(String[] args) {
		FileInputStream fis = null;

		try {

			File file = new File("C:\\Users\\35196\\Documents\\Long-Method.xlsx");
			fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);

		} catch (FileNotFoundException ex) {

			Logger.getLogger(LerDadosExcel.class.getName()).log(Level.SEVERE, null, ex);

		} catch (IOException ex) {
			// TODO Auto-generated catch block
			Logger.getLogger(LerDadosExcel.class.getName()).log(Level.SEVERE, null, ex);
			
		} finally {
			try {
				fis.close();
			} catch (IOException ex) {
				Logger.getLogger(LerDadosExcel.class.getName()).log(Level.SEVERE, null, ex);

			}
		}
	}
}
