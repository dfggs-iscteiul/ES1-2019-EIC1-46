package code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * RuleAccuracy represents an object that calculates the accuracy using the
 * fields of a file and an excel file.
 * 
 * Date: Dec 03-2019
 * @author Guilherme Ferreira
 * @version 1.0
 *
 */

public class RuleAccuracy {

	/**
	 * Represents the attributes of the RuleAccuracy class.
	 */

	private File fileChoosen;
	private BuildObjectsFromExcel helper;
	private double accuracyNewRule;

	/**
	 * 
	 * Constructs and Initializes a RuleAccuracy
	 * 
	 * @param fileChoosen file that is picked by the user and will be used as a
	 *                    comparison term for precision calculation
	 * @param helper      is an object of type BuildObjetsFromExcel that helps
	 *                    reading excel, or looks for excel fields, and is used to
	 *                    calculate accuracy when compared to fileChoosen fields
	 */

	public RuleAccuracy(File fileChoosen, BuildObjectsFromExcel helper) {
		this.fileChoosen = fileChoosen;
		this.helper = helper;

	}

	/**
	 * It is the method that finally calculates accuracy after instantiating a
	 * RuleAccuracy object. Compare the fields in a column of a file with their
	 * fields in the Excel column It then gives us the result of accuracy (number of
	 * times IsLongMethod is equal in both files (excel file , file chosen by the
	 * user as argument in the RuleAccuracy constructor). The result of accuracy is
	 * stored in the accuracyNewRule variable, an attribute of the Rule Accuracy
	 * class.
	 * 
	 */

	public void calcAccuracy() {
		// Builds a excel File
		File excelFile = new File("Long-Method.xlsx");
		try {
			/*
			 * Reads a excel file and builds objects and store them in an ArrayList of
			 * DataEntry objects
			 */
			helper.buildObjects(excelFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Give us the excel objects in a DataEntry array
		ArrayList<DataEntry> objs = helper.objects();
		double equalLines = 0;
		BufferedReader br = null;

		try {
			// creates a BufferedReader for the file picked by the user
			br = new BufferedReader(new FileReader(fileChoosen));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * compare the file's IsLongMethod column with the excel file's IsLongMethod
		 * column if the result is equal it will be stored in the equalLines variable
		 */
		for (DataEntry y : objs) {
			String linha;
			try {
				while ((linha = br.readLine()) != null) {
					String[] vec = linha.split(";");
					System.out.println(vec[vec.length - 1]);
					if (vec[vec.length - 1].equals(String.valueOf(y.Is_Long_Method()))) {
						equalLines++;

					}
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//accuracy calculation
		this.accuracyNewRule = ((equalLines * 100) / objs.size());
		//prints accuracy calculation
		System.out.printf("Accuracy = %.2f %n", accuracyNewRule);

		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Main of the program used to create instances of the RuleAccuracy class
	 * and test methods of it.
	 * 
	 * @param args String[] args
	 */

	public static void main(String[] args) {
		/*
		 * Creates a BuildObjectsFromExcel instance that will help reading excel
		 */
		BuildObjectsFromExcel bofe = new BuildObjectsFromExcel();

		/*
		 * filePath in String that you will use to build the file
		 */
		String folderPath = System.getProperty("user.dir");
		String filePath = folderPath + "/1_215916_21102019.txt";

		/*
		 * Creates the file with its path
		 */
		File f = new File(filePath);

		/*
		 * creates an instance of RuleAccuracy passing as arguments for objects (File)
		 * and bofe (BuildObjectsFromExcel).
		 */
		RuleAccuracy car = new RuleAccuracy(f, bofe);

		/*
		 * finally using the calcAccuracy () method we calculate the accuracy
		 */
		car.calcAccuracy();

	}

}
