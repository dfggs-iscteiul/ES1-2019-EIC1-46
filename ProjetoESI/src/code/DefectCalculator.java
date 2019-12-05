package code;

import java.util.ArrayList;
/**
 * 
 * DefectCalculator calculates the number of different types of defects in an arraylist of DataEntry.
 * 
 * 
 * Date: Dec 05-2019
 * 
 * @author Filipe Cruz
 * @version 1.0
 * 
 * 
 *
 */
public class DefectCalculator {
	
	/**
	 * Represents the attributes of the DefectCalculator class.
	 */

	private ArrayList<DataEntry> dataEntry;
	private int dci;
	private int dii;
	private int adci;
	private int adii;
	
	/**
	 * Creates the DefectCalculator with the specific parameters.
	 * @param dataEntry is an ArrayList of DataEntry.
	 */
	public DefectCalculator(ArrayList<DataEntry> dataEntry) {
		this.dataEntry=dataEntry;
		dci = 0;
		dii = 0;
		adci = 0;
		adii = 0;
	}
	
	/**
	 * Calculates defects in the ArrayList of DataEntry
	 */
	public void CalculateDefects() {
		for(DataEntry d : dataEntry) {
			if((d.IPlasma()==true || d.PMD()==true) && d.Is_Long_Method()==true)
				dci+=1;
			if((d.IPlasma()==true || d.PMD()==true) && d.Is_Long_Method()==false)
				dii+=1;
			if((d.IPlasma()==false || d.PMD()==false) && d.Is_Long_Method()==false)
				adci+=1;
			if((d.IPlasma()==false || d.PMD()==false) && d.Is_Long_Method()==true)
				adii+=1;
		}
	}

	/**
	 * returns the ArrayList of DataEntry Objects
	 * 
	 * @return
	 */
	public ArrayList<DataEntry> getDataEntry() {
		return dataEntry;
	}
	
	/**
	 * returns the number of dci defects
	 * 
	 * @return
	 */
	public int getDci() {
		return dci;
	}

	/**
	 * returns the number of dii defects
	 * 
	 * @return
	 */

	public int getDii() {
		return dii;
	}

	/**
	 * returns the number of adci defects
	 * 
	 * @return
	 */

	public int getAdci() {
		return adci;
	}

	/**
	 * returns the number of adii defects
	 * 
	 * @return
	 */

	public int getAdii() {
		return adii;
	}

}
