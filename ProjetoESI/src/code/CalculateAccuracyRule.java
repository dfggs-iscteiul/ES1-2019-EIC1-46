package code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CalculateAccuracyRule {

	private File fileChoosen;
	private double accuracyNewRule;

	public CalculateAccuracyRule(File fileChoosen) {
		this.fileChoosen = fileChoosen;
		calcAccuracy();
	}

	public void calcAccuracy() {
		File excelFile = new File("Long-Method.xlsx");
		BuildObjectsFromExcel helper = new BuildObjectsFromExcel();
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
							System.out.println(String.valueOf(y.Is_Long_Method()));
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
			this.accuracyNewRule = (equalLines / objs.size()) * 100;
			System.out.printf("Accuracy = %.2f %n", accuracyNewRule);


		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		String folderPath = System.getProperty("user.dir");
		String filePath = folderPath + "/rule1_04715_21102019.txt";
		File f = new File(filePath);
		CalculateAccuracyRule car = new CalculateAccuracyRule(f);
	}

}
