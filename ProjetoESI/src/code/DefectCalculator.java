package code;

import java.util.ArrayList;

public class DefectCalculator {

	private ArrayList<DataEntry> dataEntry;
	private int dci;
	private int dii;
	private int adci;
	private int adii;
	
	public DefectCalculator(ArrayList<DataEntry> dataEntry) {
		this.dataEntry=dataEntry;
		dci = 0;
		dii = 0;
		adci = 0;
		adii = 0;
	}
	
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

	public ArrayList<DataEntry> getDataEntry() {
		return dataEntry;
	}

	public void setDataEntry(ArrayList<DataEntry> dataEntry) {
		this.dataEntry = dataEntry;
	}

	public int getDci() {
		return dci;
	}

	public void setDci(int dci) {
		this.dci = dci;
	}

	public int getDii() {
		return dii;
	}

	public void setDii(int dii) {
		this.dii = dii;
	}

	public int getAdci() {
		return adci;
	}

	public void setAdci(int adci) {
		this.adci = adci;
	}

	public int getAdii() {
		return adii;
	}

	public void setAdii(int adii) {
		this.adii = adii;
	}

}
