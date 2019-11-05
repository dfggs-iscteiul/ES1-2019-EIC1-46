package code;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class BuildObjetsFromExcel {


	private ArrayList<DataEntry> dataEntry = new ArrayList<DataEntry>();


	public BuildObjetsFromExcel() { //Caminho default
		try {
			//fetches the directory or path of the workspace for the current project
			String pathWorkspace = System.getProperty("user.dir");

			String finalPath = pathWorkspace + "/src/DataEs1.csv";
			BufferedReader br = new BufferedReader(new FileReader(finalPath));

			//Primeira Linha do Excel
			String linhaExcel = br.readLine();

			//Segunda Linha do excel é a partir daqui que nos interessa criar os objetos			
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

		finally{				
			for (DataEntry x : dataEntry) {
				System.out.println(x.toString());
			}
		}

	}

	public BuildObjetsFromExcel(File ficheiroExcel) { // recebe o ficheiro para ler
		try {
			BufferedReader br = new BufferedReader(new FileReader(ficheiroExcel)); //TODO Ficheiro enviado pela GUI não abre bem aqui.

			//Primeira Linha do Excel
			String linhaExcel = br.readLine();

			//Segunda Linha do excel é a partir daqui que nos interessa criar os objetos			
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

		finally{
			printDataEntries();
		}

	}

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

	public void printDataEntries() {
		for (DataEntry x : dataEntry) {
			System.out.println(x.toString());
		}
	}

	public static void main(String[] args) {
		BuildObjetsFromExcel bofe = new BuildObjetsFromExcel();
	}

}


