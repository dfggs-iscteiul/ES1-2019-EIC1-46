package code;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
/**
 * Builds DataEntry Objects from the Excel file.
 * 
 *
 */
public class BuildObjectsFromExcel {

	/**
	 * Database of the conversion.
	 */
	private ArrayList<DataEntry> dataEntry = new ArrayList<DataEntry>();

/**
 * Default path. Opens Excel file and converts it into DataEntry objects.
 */
	public BuildObjectsFromExcel() { 
		try {
			 //Fetches the directory or path of the workspace for the current project.
			String pathWorkspace = System.getProperty("user.dir");

			String finalPath = pathWorkspace + "/src/DataEs1.csv";
			BufferedReader br = new BufferedReader(new FileReader(finalPath));

			 //First line of Excel
			String ExcelLine = br.readLine();

			 //Second line of Excel, from here creating objects matters.
			ExcelLine = br.readLine();

			 //Converts all Excel lines to DataEntry.
			while (ExcelLine != null) {
				String[] line = ExcelLine.split(",");
				vectorToDataEntry(line);
				ExcelLine = br.readLine();
			}
			br.close();


		} catch (Exception e) {
			e.printStackTrace();
		}

		finally{
			printDataEntries();
		}

	}
/**
 * Choose File path. Opens Excel file and converts it into DataEntry objects.
 * @param ficheiroExcel File to read.
 */
	public BuildObjectsFromExcel(File ficheiroExcel) { 
		try {
			 //File opened by GUI, doesn't open really well.
			BufferedReader br = new BufferedReader(new FileReader(ficheiroExcel));
			
			 //First line of Excel
			String excelLine = br.readLine();

			 //Second line of Excel, from here creating objects matters.	
			excelLine = br.readLine();
			
			// Converts all Excel lines to DataEntry.
			while (excelLine != null) {
				String[] line = excelLine.split(",");
				vectorToDataEntry(line);
				excelLine = br.readLine();
			}
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally{
			printDataEntries();
		}

	}
	
	/**
	 * Converts each column to the correspondent data and then converts the line into DataEntry.
	 * @param ExcelLine Line from Excel
	 */
	public void vectorToDataEntry(String[] ExcelLine) {
		
		//System.out.println(linhaExcel[1]);
		int MethodId = Integer.parseInt(ExcelLine[0]);
		String Package = ExcelLine[1];
		String Class = ExcelLine[2];
		String method = ExcelLine[3];
		int LOC = Integer.parseInt(ExcelLine[4]);
		int CYCLO = Integer.parseInt(ExcelLine[5]);
		int ATFD = Integer.parseInt(ExcelLine[6]);
		float LAA = Float.parseFloat(ExcelLine[7]);
		boolean Is_Long_Method = Boolean.parseBoolean(ExcelLine[8]);
		boolean IPlasma = Boolean.parseBoolean(ExcelLine[9]);
		boolean PMD = Boolean.parseBoolean(ExcelLine[10]);
		boolean Is_Feature_Envy = Boolean.parseBoolean(ExcelLine[11]);

		DataEntry de = new DataEntry(
				MethodId, Package, Class, method,
				LOC, CYCLO, ATFD, LAA, Is_Long_Method, IPlasma,
				PMD, Is_Feature_Envy);

		dataEntry.add(de);
	}

	/**
	 * Prints the conversion.
	 * Future Objective --Puts the conversion into the GUI.
	 */
	public void printDataEntries() {
		for (DataEntry x : dataEntry) {
			System.out.println(x.toString());
		}
	}

	 /** 
     * This is the main method  
     * which is very important for  
     * execution for a java program.
     * @param args None.
     */
	public static void main(String[] args) {
		BuildObjectsFromExcel bofe = new BuildObjectsFromExcel();
	}

}


