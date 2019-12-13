package code;

import java.util.ArrayList;

/**
 * Sets new Thresholds for the Excel file.
 * @author Joao Macedo
 *
 */
public class Thresholds {

	private ArrayList<DataEntry> inputs;
	private String name;
	private boolean rule1;
	private boolean rule2;
	private boolean rule3;
	private boolean rule4;
	private boolean logicalOperator1;
	private boolean logicalOperator2;
	private int LOCVal;
	private int CYCLOVal;
	private int AFTDVal;
	private float LAAVal;
/**
 * Creates the Threshold with the specific parameters.
 * @param bofe Is an object of type BuildObjetsFromExcel that helps reading the excel file
 * @param name Is the name of the Threshold.
 * @param rule1 Active(true) or inactive(false) for LOC.
 * @param rule2 Active or inactive for CYCLO.
 * @param rule3 Active or inactive for AFTD.
 * @param rule4 Active or inactive for LAA.
 * @param logicalOperator1 AND(true) or OR(false) for is_long_method.
 * @param logicalOperator2 AND or OR for is_feature_envy.
 * @param LOCVal value of LOC threshold.
 * @param CYCLOVal value of CYCLO threshold.
 * @param AFTDVal value of AFTD threshold.
 * @param LAAVal value of LAA threshold.
 */
	public Thresholds(BuildObjectsFromExcel bofe,String name, boolean rule1, boolean rule2, boolean rule3,
			boolean rule4, boolean logicalOperator1, boolean logicalOperator2, int LOCVal, int CYCLOVal,
			int AFTDVal, float LAAVal) {
		inputs = bofe.objects();
		this.name=name;
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
	}
	/**
	 * Getter for the List of DataEntries.
	 * @return the list of DataEntries.
	 */
public ArrayList<DataEntry> getInputs() {
	return inputs;
}
/**
 * Cross-checks the new Thresholds with the Excel file and changes the is_long_method and is_feature_envy if needed.
 */
	public void calcThresholds() {
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
				if(logicalOperator2) {
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
		}
	}
}
