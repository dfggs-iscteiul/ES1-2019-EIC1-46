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
	private boolean logicalOperator1;//AND ou OR para is_long_method, AND = TRUE
	private boolean logicalOperator2;//"" para is_feature_envy
	private int LOCVal;
	private int CYCLOVal;
	private int AFTDVal;
	private float LAAVal;

	public Thresholds(BuildObjectsFromExcel bofe, boolean rule1, boolean rule2, boolean rule3,
			boolean rule4, boolean logicalOperator1, boolean logicalOperator2, int LOCVal, int CYCLOVal,
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
		String folderPath = System.getProperty("user.dir");
		String filePath = folderPath + "/thresholds.txt";
		File abc = new File(filePath);
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(abc);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(DataEntry input:inputs) {
			if(rule1 && rule2) {
				if(logicalOperator1) {
					if(input.getEntryLOC() > LOCVal && input.getEntryCYCLO() > CYCLOVal)
						input.setIs_Long_Method(true);
					else
						input.setIs_Long_Method(false);
				}
				else{
					if(input.getEntryLOC() > LOCVal || input.getEntryCYCLO() > CYCLOVal)
						input.setIs_Long_Method(true);
					else
						input.setIs_Long_Method(false);
				}
			}
			if(rule1 && !rule2) {
				if(input.getEntryLOC()> LOCVal)
					input.setIs_Long_Method(true);
				else
					input.setIs_Long_Method(false);
			}
			if(!rule1 && rule2) {
				if(input.getEntryCYCLO() > CYCLOVal)
					input.setIs_Long_Method(true);
				else
					input.setIs_Long_Method(false);
			}
			if(rule3 && rule4) {
				if(logicalOperator1) {
					if(input.getEntryATFD() > AFTDVal && input.getEntryLAA() < LAAVal)
						input.setIs_Feature_Envy(true);
					else
						input.setIs_Feature_Envy(false);
				}
				else {
					if(input.getEntryATFD() > AFTDVal || input.getEntryLAA() < LAAVal)
						input.setIs_Feature_Envy(true);
					else
						input.setIs_Feature_Envy(false);
				}
			}
			if(rule3 && !rule4) {
				if(input.getEntryATFD()> AFTDVal)
					input.setIs_Feature_Envy(true);
				else
					input.setIs_Feature_Envy(false);
			}
			if(!rule3 && rule4) {
				if(input.getEntryLAA() < LAAVal)
					input.setIs_Feature_Envy(true);
				else
					input.setIs_Feature_Envy(false);
			}
			System.out.println(input.Is_Long_Method());
			printWriter.println(input.toString());
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
		Thresholds ct= null;
		ct= new Thresholds(bofe, true,true,false,false,true,false,4,2,0,0);
	}
}
