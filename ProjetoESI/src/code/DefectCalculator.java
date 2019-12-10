package code;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * DefectCalculator calculates the number of different types of defects in an list of DataEntry.
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

	private List<DataEntry> dataEntry;
	private CustomRule customRule;
	private int dciIPlasma;
	private int diiIPlasma;
	private int adciIPlasma;
	private int adiiIPlasma;
	private int dciPMD;
	private int diiPMD;
	private int adciPMD;
	private int adiiPMD;
	private int dciCR;
	private int diiCR;
	private int adciCR;
	private int adiiCR;
	private List<DetectedDefect> defects;
	
	/**
	 * Creates the DefectCalculator with the specific parameters.
	 * @param dataEntry is an List of DataEntry.
	 */
	public DefectCalculator(List<DataEntry> dataEntry) {
		this.dataEntry=dataEntry;
		dciIPlasma = 0;
		diiIPlasma = 0;
		adciIPlasma = 0;
		adiiIPlasma = 0;
		dciPMD = 0;
		diiPMD = 0;
		adciPMD = 0;
		adiiPMD = 0;
		dciCR = 0;
		diiCR = 0;
		adciCR = 0;
		adiiCR = 0;
		defects = new ArrayList<DetectedDefect>();
	}
	public DefectCalculator(List<DataEntry> dataEntry,CustomRule customRule) {
		this.dataEntry=dataEntry;
		this.customRule=customRule;
		dciIPlasma = 0;
		diiIPlasma = 0;
		adciIPlasma = 0;
		adiiIPlasma = 0;
		dciPMD = 0;
		diiPMD = 0;
		adciPMD = 0;
		adiiPMD = 0;
		dciCR = 0;
		diiCR = 0;
		adciCR = 0;
		adiiCR = 0;
		defects = new ArrayList<DetectedDefect>();
	}
	
	/**
	 * Calculates defects in the List of DataEntry
	 */
	public void CalculateDefects() {
		for(DataEntry d : dataEntry) {
			boolean defectiplasma = false;
			boolean defectpmd = false;
			if(d.IPlasma()==true && d.Is_Long_Method()==true) {
				dciIPlasma+=1;
				defectiplasma = true;
			}
			if(d.IPlasma()==true && d.Is_Long_Method()==false) {
				diiIPlasma+=1;
				defectiplasma = true;
			}
			if(d.IPlasma()==false && d.Is_Long_Method()==false)
				adciIPlasma+=1;
			if(d.IPlasma()==false && d.Is_Long_Method()==true)
				adiiIPlasma+=1;
			if(d.PMD()==true && d.Is_Long_Method()==true) {
				dciPMD+=1;
				defectpmd = true;
			}
			if(d.PMD()==true && d.Is_Long_Method()==false) {
				diiPMD+=1;
				defectpmd = true;
			}
			if(d.PMD()==false && d.Is_Long_Method()==false)
				adciPMD+=1;
			if(d.PMD()==false && d.Is_Long_Method()==true)
				adiiPMD+=1;
			defects.add(new DetectedDefect(d.getEntryMethodId(), defectiplasma, defectpmd));
		}
	}
	
	//Não tenho a certeza se isto de ir buscar por methodid-1 está certo
	public void CalculateDefectsCustomRule() {
		if(customRule != null && defects !=null) {
			int i = 0;
			for(DataEntry d : dataEntry) {
				if(customRule.getCustomRuleData().get(i).Is_CustomRule()==true && d.Is_Long_Method()==true) {
					dciCR+=1;
					defects.get(d.getEntryMethodId()-1).setIplasma(true);
				}
				if(customRule.getCustomRuleData().get(i).Is_CustomRule()==true && d.Is_Long_Method()==false) {
					diiCR+=1;
					defects.get(d.getEntryMethodId()-1).setIplasma(true);
				}
				if(customRule.getCustomRuleData().get(i).Is_CustomRule()==false && d.Is_Long_Method()==false)
					adciCR+=1;
				if(customRule.getCustomRuleData().get(i).Is_CustomRule()==false && d.Is_Long_Method()==true)
					adiiCR+=1;
			}
		}
	}

	/**
	 * returns the List of DataEntry Objects
	 * 
	 * @return
	 */
	public List<DataEntry> getDataEntry() {
		return dataEntry;
	}
	
	/**
	 * returns the number of dci defects
	 * 
	 * @return
	 */
	public int getDciIPlasma() {
		return dciIPlasma;
	}

	/**
	 * returns the number of dii defects
	 * 
	 * @return
	 */

	public int getDiiIPlasma() {
		return diiIPlasma;
	}

	/**
	 * returns the number of adci defects
	 * 
	 * @return
	 */

	public int getAdciIPlasma() {
		return adciIPlasma;
	}

	/**
	 * returns the number of adii defects
	 * 
	 * @return
	 */

	public int getAdiiIPlasma() {
		return adiiIPlasma;
	}
	public int getDciPMD() {
		return dciPMD;
	}
	public int getDiiPMD() {
		return diiPMD;
	}
	public int getAdciPMD() {
		return adciPMD;
	}
	public int getAdiiPMD() {
		return adiiPMD;
	}
	public int getDciCR() {
		return dciCR;
	}
	public int getDiiCR() {
		return diiCR;
	}
	public int getAdciCR() {
		return adciCR;
	}
	public int getAdiiCR() {
		return adiiCR;
	}
	public List<DetectedDefect> getDefects() {
		return defects;
	}

}
