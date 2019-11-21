package code;

import java.util.ArrayList;

public class CalculateAccuracyRule {

	private CustomRule cr;
	private BuildObjectsFromExcel bofe;
	private ArrayList<DataEntry> listExcel;
	private ArrayList<CustomDataEntry> listNewRule;
	private double accuracyNewRule;

	public CalculateAccuracyRule(BuildObjectsFromExcel bofe, CustomRule cr) {
		this.cr = cr;
		this.bofe = bofe;
		this.listExcel = bofe.objects();
		this.listNewRule = cr.getCustomRuleData();
	}

	public void calcAccuracy() {

		double equalLines = 0;
		double lengthFile = listExcel.size();
		
		if (listExcel.size() == listNewRule.size()) {
				for(CustomDataEntry y : listNewRule) {
					for(DataEntry x : listExcel) {
					if(y.getEntryMethodId()==x.getEntryMethodId() 
					&& y.Is_CustomRule() == x.Is_Long_Method()) {
								equalLines++;
					}
					break;
				}
			}

		this.accuracyNewRule = (equalLines/lengthFile)*100;
		System.out.printf("Accuracy = %.2f %n",accuracyNewRule);
				
		}
		
		else {
			System.out.println("Os ficheiros têm tamanhos diferentes");
		}

	}

	public CustomRule getCr() {
		return cr;
	}

	public void setCr(CustomRule cr) {
		this.cr = cr;
	}

	public BuildObjectsFromExcel getBofe() {
		return bofe;
	}

	public void setBofe(BuildObjectsFromExcel bofe) {
		this.bofe = bofe;
	}

	public ArrayList<DataEntry> getListExcel() {
		return listExcel;
	}

	public void setListExcel(ArrayList<DataEntry> listExcel) {
		this.listExcel = listExcel;
	}

	public ArrayList<CustomDataEntry> getListNewRule() {
		return listNewRule;
	}

	public void setListNewRule(ArrayList<CustomDataEntry> listNewRule) {
		this.listNewRule = listNewRule;
	}

	public double getAccuracyNewRule() {
		return accuracyNewRule;
	}

	public void setAccuracyNewRule(double accuracyNewRule) {
		this.accuracyNewRule = accuracyNewRule;
	}

}
