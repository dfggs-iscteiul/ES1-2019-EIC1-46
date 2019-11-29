package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Thresholds {

	private ArrayList<DataEntry> inputs;
	private boolean rule1; // active or inactive , 1- LOC
	private boolean rule2;// 2- CYCLO
	private boolean rule3;// 3- ATFD
	private boolean rule4;// 4- LAA
	private String logicalOperator1;//AND ou OR para is_long_method
	private String logicalOperator2;//"" para is_feature_envy
	private int LOCVal;
	private int CYCLOVal;
	private int AFTDVal;
	private float LAAVal;

	public Thresholds(BuildObjectsFromExcel bofe, boolean rule1, boolean rule2, boolean rule3,
			boolean rule4, String logicalOperator1, String logicalOperator2, int LOCVal, int CYCLOVal,
			int AFTDVal, float LAAVal) {
		inputs = bofe.objects();
		this.rule1=rule1;
		this.rule2=rule2;
		this.rule3=rule3;
		this.rule4=rule4;
		this.logicalOperator1=logicalOperator1;
		this.logicalOperator2=logicalOperator2;
		this.LOCVal=LOCVal;
		this.CYCLOVal=CYCLOVal;
		this.AFTDVal=AFTDVal;
		this.LAAVal=LAAVal;
		calcThresholds();
	}
	
	private void calcThresholds() {
		for(DataEntry input:inputs) {
			if(rule1 && rule2) {
				if(logicalOperator1 == "AND") {
					if(input.getEntryLOC() > LOCVal && input.getEntryCYCLO() > CYCLOVal)
						input.setIs_Long_Method(true);
					input.setIs_Long_Method(false);
				}
				if(logicalOperator1 == "OR") {
					if(input.getEntryLOC() > LOCVal || input.getEntryCYCLO() > CYCLOVal)
						input.setIs_Long_Method(true);
					input.setIs_Long_Method(false);
				}
			}
			if(rule1 && !rule2) {
				if(input.getEntryLOC()> LOCVal)
					input.setIs_Long_Method(true);
				input.setIs_Long_Method(false);
			}
			if(!rule1 && rule2) {
				if(input.getEntryCYCLO() > CYCLOVal)
					input.setIs_Long_Method(true);
				input.setIs_Long_Method(false);
			}
			if(rule3 && rule4) {
				if(logicalOperator1 == "AND") {
					if(input.getEntryATFD() > AFTDVal && input.getEntryLAA() < LAAVal)
						input.setIs_Feature_Envy(true);
					input.setIs_Feature_Envy(false);
				}
				if(logicalOperator1 == "OR") {
					if(input.getEntryATFD() > AFTDVal || input.getEntryLAA() < LAAVal)
						input.setIs_Feature_Envy(true);
					input.setIs_Feature_Envy(false);
				}
			}
			if(rule3 && !rule4) {
				if(input.getEntryATFD()> AFTDVal)
					input.setIs_Feature_Envy(true);
				input.setIs_Feature_Envy(false);
			}
			if(!rule3 && rule4) {
				if(input.getEntryLAA() < LAAVal)
					input.setIs_Feature_Envy(true);
				input.setIs_Feature_Envy(false);
			}
			System.out.println(input.toString());
		}

	}
	
	public static void main(String[] args) {
		File f = new File("Long-Method.xlsx");
		BuildObjectsFromExcel bofe = new BuildObjectsFromExcel();
		try {
			bofe.buildObjects(f);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String ananas;
		Thresholds ct= null;
		ct= new Thresholds(bofe, true,true,false,false,"AND", "AND", 80,10,0,0);
	}
}
