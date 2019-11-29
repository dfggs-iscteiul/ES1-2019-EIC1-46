package code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RuleAccuracy {

	private File fileChoosen;
	private BuildObjectsFromExcel helper;
	private double accuracyNewRule;

	public RuleAccuracy(File fileChoosen, BuildObjectsFromExcel helper ) {
		this.fileChoosen = fileChoosen;
		this.helper = helper;
		calcAccuracy();
	}

	public void calcAccuracy() {
		File excelFile = new File("Long-Method.xlsx");
		try {
			helper.buildObjects(excelFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		ArrayList<DataEntry> objs = helper.objects();
		double equalLines = 0;
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(fileChoosen));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
			this.accuracyNewRule = ((equalLines * 100)/objs.size());
			System.out.printf("Accuracy = %.2f %n", accuracyNewRule);


		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		BuildObjectsFromExcel bofe = new BuildObjectsFromExcel();
		String folderPath = System.getProperty("user.dir");
		String filePath = folderPath + "/1_215916_21102019.txt";
		File f = new File(filePath);
		RuleAccuracy car = new RuleAccuracy(f,bofe);
	}

}
