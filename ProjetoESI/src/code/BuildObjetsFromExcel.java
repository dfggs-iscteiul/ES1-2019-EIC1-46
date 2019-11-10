package code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BuildObjetsFromExcel {

	private ArrayList<DataEntry> dataEntry = new ArrayList<DataEntry>();

	public BuildObjetsFromExcel() { // Caminho default
		try {
			// fetches the directory or path of the workspace for the current project
			String pathWorkspace = System.getProperty("user.dir");

			String finalPath = pathWorkspace + "/src/DataEs1.csv";
			BufferedReader br = new BufferedReader(new FileReader(finalPath));

			// Primeira Linha do Excel
			String linhaExcel = br.readLine();

			// Segunda Linha do excel é a partir daqui que nos interessa criar os objetos
			linhaExcel = br.readLine();

			while (linhaExcel != null) {
				String[] linha = linhaExcel.split(",");
				vectorToDataEntry(linha);
				linhaExcel = br.readLine();
			}
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			for (DataEntry x : dataEntry) {
				System.out.println(x.toString());
			}
		}

	}


	/*
	public void buildObjects(File file) throws FileNotFoundException {

		FileInputStream fis = null;
		String [] linhaExcel = new String[12];
		int i = 0;

		try {

			fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();

			//ler primeira linha pois esta nao interessa
			Row row = rowIterator.next();
			while (rowIterator.hasNext()) {

				Row row2 = rowIterator.next();
				
				Iterator<Cell> cellIterator = row2.iterator();

				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();
					System.out.println(cell);
					linhaExcel[i] = cell.toString();
					/*
					switch(cell.getCellType()) {
					case STRING:
						linhaExcel[i] = cell.getStringCellValue().toString();
						break;
						
					case NUMERIC:
						linhaExcel[i] = (String.valueOf(cell.getNumericCellValue()));
						break;
				
					case BOOLEAN:
						linhaExcel[i] = (String.valueOf(cell.getBooleanCellValue()));
						break;
						
					default:
						break;
					}*/
		
					/*i++;
				}
				
				vectorToDataEntry(linhaExcel);
				i = 0;
				linhaExcel = null;
			}

		} catch (FileNotFoundException ex) {
			Logger.getLogger(BuildObjetsFromExcel.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(BuildObjetsFromExcel.class.getName()).log(Level.SEVERE, null, ex);

		}

		finally {

			try {
				fis.close();
			}

			catch (IOException ex) {
				Logger.getLogger(BuildObjetsFromExcel.class.getName()).log(Level.SEVERE, null, ex);

			}
		}

	}*/

	public void vectorToDataEntry(String[] linhaExcel) {

		// System.out.println(linhaExcel[1]);
		int MethodId = Integer.parseInt(linhaExcel[0]);
		String Package = linhaExcel[1];
		String Class = linhaExcel[2];
		String method = linhaExcel[3];
		int LOC = Integer.parseInt(linhaExcel[4]);
		int CYCLO = Integer.parseInt(linhaExcel[5]);
		int ATFD = Integer.parseInt(linhaExcel[6]);
		float LAA = Float.parseFloat(linhaExcel[7]);
		boolean Is_Long_Method = Boolean.parseBoolean(linhaExcel[8]);
		boolean IPlasma = Boolean.parseBoolean(linhaExcel[9]);
		boolean PMD = Boolean.parseBoolean(linhaExcel[10]);
		boolean Is_Feature_Envy = Boolean.parseBoolean(linhaExcel[11]);

		DataEntry de = new DataEntry(MethodId, Package, Class, method, LOC, CYCLO, ATFD, LAA, Is_Long_Method, IPlasma,
				PMD, Is_Feature_Envy);

		dataEntry.add(de);
	}

	public void printDataEntries() {
		for (DataEntry x : dataEntry) {
			System.out.println(x.toString());
		}
	}

	public static void main(String[] args) {
		BuildObjetsFromExcel bofe = new BuildObjetsFromExcel();
	}

}
