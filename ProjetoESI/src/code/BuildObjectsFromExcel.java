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
 * 
 * BuildObjectsFromExcel represents an object that builds DataEntry Objects from
 * the Excel file.
 * 
 * 
 * Date: Dec 03-2019
 * 
 * @author Guilherme Ferreira and Joao Macedo
 * @version 1.0
 * 
 * 
 *
 */
public class BuildObjectsFromExcel {

	/**
	 * Represent the attribute of the RuleAccuracy class. In this case, the excel
	 * file converted to DataEntry objects in an ArrayList
	 */

	private ArrayList<DataEntry> dataEntry = new ArrayList<DataEntry>();

	/**
	 * Opens excel file reads it and converts all information to DataEntry objects.
	 * 
	 * @param file File choosen by the user in this case Excel file
	 * @throws FileNotFoundException if the specified pathname does not exist or if
	 *                               it is inaccessible.
	 */
	public void buildObjects(File file) throws FileNotFoundException {

		// Initializes FileInputStream to null
		FileInputStream fis = null;

		// all excel lines will be stored in a string
		String linhaExcel = "";

		try {

			// Creates a FileInputStream for the excel file.
			fis = new FileInputStream(file);

			// Creates a workbook with the file Excel
			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			// first spreadsheet because in this case let's just read an excel
			XSSFSheet sheet = workbook.getSheetAt(0);

			// iterator that will read the excel lines
			Iterator<Row> rowIterator = sheet.iterator();

			// we read the first line because it has unnecessary information for building
			// our DataEntry objects
			rowIterator.next();

			// loop that reads line by line the excel file
			while (rowIterator.hasNext()) {

				// read line of excel
				Row row2 = rowIterator.next();

				// iterator that will read the excel cells
				Iterator<Cell> cellIterator = row2.iterator();

				// loop that reads cell by cell the excel file line
				while (cellIterator.hasNext()) {

					// cell of the excel
					Cell cell = cellIterator.next();

					/*
					 * converts the information contained in the cell to string and adds its
					 * contents, to excelLine variable
					 */
					linhaExcel += cell.toString() + ";";

				}

				// add \n to jump to next line
				linhaExcel += '\n';
			}

			// prints the excel lines
			System.out.println(linhaExcel);

			// pass excel in string to helper method
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
		
		printDataEntries();

	}

	/**
	 * Splits the excel lines and converts them into DataEntry objects.
	 * 
	 * @param excelLines All of the excel lines
	 * @throws IOException if the connection is no longer available.
	 */
	public void helper(String excelLines) throws IOException {

		// Divide all lines into a string array
		String[] linhas = excelLines.split("\n");

		/*
		 * For each line, let's divide it by the marker ";" And pass this information to
		 * the vectorToDataEntry method
		 */

		for (int i = 0; i < linhas.length; i++) {
			vectorToDataEntry(linhas[i].split(";"));
		}

	}

	/**
	 * Receives the line divided into pieces. Converts each line information to its
	 * type object and finally creates the DataEntry object that represents an Excel
	 * line.
	 * 
	 * @param vec Line of excel in array
	 */
	public void vectorToDataEntry(String[] vec) {

		// converts the line splited to objects of type int,float,boolean,String

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

		// creates object DataEntry
		DataEntry de = new DataEntry(MethodId, Package, Class, method, LOC, CYCLO, ATFD, LAA, Is_Long_Method, IPlasma,
				PMD, Is_Feature_Envy);

		// adds object DataEntry to an ArrayList
		dataEntry.add(de);
	}

	/**
	 * print all DataEntry objects or all Excel rows already converted
	 * 
	 */
	public void printDataEntries() {
		for (DataEntry x : dataEntry) {
			System.out.println(x.toString());
		}
	}

	/**
	 * returns the ArrayList of DataEntry Objects
	 * 
	 * @return
	 */

	public ArrayList<DataEntry> objects() {
		return dataEntry;
	}

	/**
	 * 
	 * Main of the program used to create instances of the BuildObjectsFromExcel
	 * class and test methods of it.
	 * 
	 * 
	 * @param args String[] args
	 */

//	public static void main(String[] args) {
//		
//		//Creates a BuildObjectsFromExcel instance t
//		BuildObjectsFromExcel bofe = new BuildObjectsFromExcel();
//		
//		//Creates the file excel
//		File excel = new File("Long-Method.xlsx");
//		
//		//try to read and convert your information to DataEntry objects
//		try {
//			bofe.buildObjects(excel);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

}
