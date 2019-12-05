package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * 
 * Calculates the long method checking tools accuracy.
 * 
 *
 */
public class ExcelAccuracy {

	private ArrayList<DataEntry> entradas;
	private double iPlasmaAccuracy;
	private double PMDAccuracy;
	private double entryAccuracy;

	public ExcelAccuracy(BuildObjectsFromExcel bofe) {

		entradas = bofe.objects();
		int iPlasmaCerto = 0;
		int pmdCerto = 0;
		int entradaCerta = 0;
		for(DataEntry entrada: entradas) {
			if(entrada.Is_Long_Method() == entrada.IPlasma())
				iPlasmaCerto++;
			if (entrada.Is_Long_Method() == entrada.PMD())
				pmdCerto++;
			if (entrada.Is_Long_Method() == entrada.IPlasma() && entrada.Is_Long_Method() == entrada.PMD())
				entradaCerta++;
		}


		iPlasmaAccuracy = (iPlasmaCerto * 100 / entradas.size());
		//System.out.printf("iPlasmaAccuracy = %.2f%%%n", iPlasmaAccuracy);

		PMDAccuracy = (pmdCerto * 100 / entradas.size());
		//System.out.printf("PMD Accuracy = %.2f%%%n", PMDAccuracy);

		this.entryAccuracy = (entradaCerta * 100 / entradas.size());
	}

	
	/**
	 * 
	 * @return average percentage of the iPlasma and PMD accuracy.
	 */
	public double getAverageAccuracy() {
		return (iPlasmaAccuracy + PMDAccuracy) / 2;
	}

	/**
	 *  
	 * @return percentage of the lines 100% correct. Which means that the PMD and the iPlasma values are the same that the isLongMethod.
	 */
	public double getEntryAccuracy() {
		return entryAccuracy;
	}

	public static void main(String[] args) throws FileNotFoundException {
		File excelFile = new File("Long-Method.xlsx");
		BuildObjectsFromExcel helper = new BuildObjectsFromExcel();
		helper.buildObjects(excelFile);
		ExcelAccuracy teste = new ExcelAccuracy(helper);
		System.out.println("Media: " + teste.getAverageAccuracy() + "%");
		System.out.println("Linhas 100% certas: " + teste.getEntryAccuracy() + "%");
	}


}
