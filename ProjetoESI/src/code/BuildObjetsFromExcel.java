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
public class BuildObjetsFromExcel {

	/**
	 * Database of the conversion.
	 */
	private ArrayList<DataEntry> dataEntry = new ArrayList<DataEntry>();

/**
 * Default path. Opens Excel file and converts it into DataEntry objects.
 */
	public BuildObjetsFromExcel() { 
		try {
			 //Fetches the directory or path of the workspace for the current project.
			String pathWorkspace = System.getProperty("user.dir");

			String finalPath = pathWorkspace + "/src/DataEs1.csv";
			BufferedReader br = new BufferedReader(new FileReader(finalPath));

			 //First line of Excel
			String linhaExcel = br.readLine();

			 //Second line of Excel, from here creating objects matters.
			linhaExcel = br.readLine();

			 //Converts all Excel lines to DataEntry.
			while (linhaExcel != null) {
				String[] linha = linhaExcel.split(",");
				vectorToDataEntry(linha);
				linhaExcel = br.readLine();
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
	public BuildObjetsFromExcel(File ficheiroExcel) { 
		try {
			 //File opened by GUI, doesn't open really well.
			BufferedReader br = new BufferedReader(new FileReader(ficheiroExcel));
			
			 //First line of Excel
			String linhaExcel = br.readLine();

			 //Second line of Excel, from here creating objects matters.	
			linhaExcel = br.readLine();
			
			// Converts all Excel lines to DataEntry.
			while (linhaExcel != null) {
				String[] linha = linhaExcel.split(",");
				vectorToDataEntry(linha);
				linhaExcel = br.readLine();
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
	 * @param linhaExcel Line from Excel
	 */
	public void vectorToDataEntry(String[] linhaExcel) {
		
		//System.out.println(linhaExcel[1]);
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
		BuildObjetsFromExcel bofe = new BuildObjetsFromExcel();
	}

}


