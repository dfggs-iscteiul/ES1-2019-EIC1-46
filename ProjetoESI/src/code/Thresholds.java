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
	 * @return the name of the treshold.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Setter for the name of the treshold
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return if rule1(LOC) is active
	 */
	public boolean isRule1() {
		return rule1;
	}
	/**
	 * Setter for rule1(LOC)
	 */
	public void setRule1(boolean rule1) {
		this.rule1 = rule1;
	}
	/**
	 * @return if rule2(CYCLO) is active
	 */
	public boolean isRule2() {
		return rule2;
	}
	/**
	 * Setter for rule2(CYCLO)
	 */
	public void setRule2(boolean rule2) {
		this.rule2 = rule2;
	}
	/**
	 * @return if rule3(AFTD) is active
	 */
	public boolean isRule3() {
		return rule3;
	}
	/**
	 * Setter for rule3(AFTD)
	 */
	public void setRule3(boolean rule3) {
		this.rule3 = rule3;
	}
	/**
	 * @return if rule4(LAA) is active
	 */
	public boolean isRule4() {
		return rule4;
	}
	/**
	 * Setter for rule4(LAA)
	 */
	public void setRule4(boolean rule4) {
		this.rule4 = rule4;
	}
	/**
	 * @return logicalOperator1 AND(true) or OR(false) for is_long_method
	 */
	public boolean isLogicalOperator1() {
		return logicalOperator1;
	}
	/**
	 * Setter for setLogicalOperator1
	 */
	public void setLogicalOperator1(boolean logicalOperator1) {
		this.logicalOperator1 = logicalOperator1;
	}
	/**
	 * @return logicalOperator2 AND or OR for is_feature_envy.
	 */
	public boolean isLogicalOperator2() {
		return logicalOperator2;
	}
	/**
	 * Setter for setLogicalOperator2
	 */
	public void setLogicalOperator2(boolean logicalOperator2) {
		this.logicalOperator2 = logicalOperator2;
	}
	/**
	 * @return LOC
	 */
	public int getLOCVal() {
		return LOCVal;
	}
	/**
	 * Setter for LOC
	 */
	public void setLOCVal(int lOCVal) {
		LOCVal = lOCVal;
	}
	/**
	 * @return CYCLO
	 */
	public int getCYCLOVal() {
		return CYCLOVal;
	}
	/**
	 * Setter for CYCLO
	 */
	public void setCYCLOVal(int cYCLOVal) {
		CYCLOVal = cYCLOVal;
	}
	/**
	 * @return AFTD
	 */
	public int getAFTDVal() {
		return AFTDVal;
	}
	/**
	 * Setter for AFTD
	 */
	public void setAFTDVal(int aFTDVal) {
		AFTDVal = aFTDVal;
	}
	/**
	 * @return LAA
	 */
	public float getLAAVal() {
		return LAAVal;
	}
	/**
	 * Setter for LAA
	 */
	public void setLAAVal(float lAAVal) {
		LAAVal = lAAVal;
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
