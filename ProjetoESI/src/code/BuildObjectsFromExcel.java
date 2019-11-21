package code;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Builds DataEntry Objects from the Excel file.
 * 
 *
 */
public class BuildObjectsFromExcel {

	private ArrayList<DataEntry> dataEntry = new ArrayList<DataEntry>();

	/**
	 * Opens Excel file and converts it into DataEntry objects.
	 * @param file Excel file
	 * @throws FileNotFoundException if the specified pathname does not exist or if it is inaccessible. 
	 */
	public void buildObjects(File file) throws FileNotFoundException {

		FileInputStream fis = null;
		String linhaExcel = "";

		try {

			fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();

			// ler primeira linha pois esta nao interessa
			rowIterator.next();

			while (rowIterator.hasNext()) {

				// linha dois
				Row row2 = rowIterator.next();

				Iterator<Cell> cellIterator = row2.iterator();

				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();
					linhaExcel += cell.toString() + ";";

				}

				linhaExcel += '\n';
			}

			
			helper(linhaExcel);

		} catch (FileNotFoundException ex) {
			Logger.getLogger(BuildObjectsFromExcel.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(BuildObjectsFromExcel.class.getName()).log(Level.SEVERE, null, ex);

		}

		finally {

			try {
				fis.close();
			}

			catch (IOException ex) {
				Logger.getLogger(BuildObjectsFromExcel.class.getName()).log(Level.SEVERE, null, ex);

			}
		}

	}

	/**
	 * Splits the excel lines and converts them into DataEntry objects.
	 * @param excelLines All of the excel lines.
	 * @throws IOException if the connection is no longer available.
	 */
	public void helper(String excelLines) throws IOException {

		String[] linhas = excelLines.split("\n");

		for (int i = 0; i < linhas.length; i++) {
			vectorToDataEntry(linhas[i].split(";"));
		}

		//printDataEntries();

	}

	/**
	 * Converts into DataEntry objects.
	 * @param vec Line of excel in array
	 */
	public void vectorToDataEntry(String[] vec) {

		double auxiliar = Double.parseDouble(vec[0]);
		String Package = vec[1];
		String Class = vec[2];
		String method = vec[3];
		double auxiliar1 = Double.parseDouble(vec[4]);
		double auxiliar2 = Double.parseDouble(vec[5]);
		double auxiliar3 = Double.parseDouble(vec[6]);
		float LAA = Float.parseFloat(vec[7]);
		boolean Is_Long_Method = Boolean.parseBoolean(vec[8]);
		boolean IPlasma = Boolean.parseBoolean(vec[9]);
		boolean PMD = Boolean.parseBoolean(vec[10]);
		boolean Is_Feature_Envy = Boolean.parseBoolean(vec[11]);

		int MethodId = (int) auxiliar;
		int LOC = (int) auxiliar1;
		int CYCLO = (int) auxiliar2;
		int ATFD = (int) auxiliar3;

		DataEntry de = new DataEntry(MethodId, Package, Class, method, LOC, CYCLO, ATFD, LAA, Is_Long_Method, IPlasma,
				PMD, Is_Feature_Envy);

		dataEntry.add(de);
	}

	/**
	 * Prints the conversion. Future Objective --Puts the conversion into the GUI.
	 */
	public void printDataEntries() {
		for (DataEntry x : dataEntry) {
			System.out.println(x.toString());
		}
	}
	
	public ArrayList<DataEntry> objects() {
		return dataEntry;
	}

	public static void main(String[] args) {
	}

}
