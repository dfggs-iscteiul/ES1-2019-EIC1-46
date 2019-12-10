package code;
/** 
 *  Represents a new rule created by a merge of different criteria and thresholds. Holds the results of the use of the new rule with de Excel data.
 */
public class CustomDataEntry {

	private int MethodId;
	private String Package;
	private String Class;
	private String Method;
	
	private int LOC;
	private int CYCLO;
	private int ATFD;
	private float LAA;
	private boolean CustomRule;
	
	public CustomDataEntry(int MethodId, String Package, String Class, String Method,
						int LOC, int CYCLO, int ATFD, float LAA, boolean CustomRule ) {
		this.MethodId=MethodId;
		this.Package=Package;
		this.Class=Class;
		this.Method=Method;
		this.LOC=LOC;
		this.CYCLO=CYCLO;
		this.ATFD=ATFD;
		this.LAA=LAA;
		this.CustomRule=CustomRule;
		
	}
	/**
	 * Getter of the ID of the method that is being analyzed.
	 * @return Identification of the method that is being analyzed.
	 */
	public int getEntryMethodId() {
		return MethodId;
	}

	/**
	 * Getter of the package that contains the method that is being analyzed.
	 * @return Name of the package that contains the method that is being analyzed.
	 */
	public String getEntryPackage() {
		return Package;
	}

	/**
	 * Getter of the class that contains the method that is being analyzed.
	 * @return Name of the class that contains the method that is being analyzed.
	 */
	public String getEntryClass() {
		return Class;
	}

	/**
	 * Getter of the method that contains the method that is being analyzed.
	 * @return Name of the method that contains the method that is being analyzed.
	 */
	public String getEntryMethod() {
		return Method;
	}

	/**
	 * Getter of the number of coding lines of the method.
	 * @return The number of coding lines of the method.
	 */
	public int getEntryLOC() {
		return LOC;
	}

	/**
	 * Getter of the cyclomatic complexity of the method.
	 * @return The cyclomatic complexity of the method.
	 */
	public int getEntryCYCLO() {
		return CYCLO;
	}

	/**
	 * Getter of the number of accesses that the method do to methods of other classes.
	 * @return The accesses that the method do to methods of other classes.
	 */
	public int getEntryATFD() {
		return ATFD;
	}

	/**
	 * Getter of the number of accesses that the method do to attributes of the own class.
	 * @return The accesses that the method do to attributes of the own class.
	 */
	public float getEntryLAA() {
		return LAA;
	}

	/**
	 * Getter for the result of the new rule application to that specific method of the Excel data.
	 * @return Result of the application of the new rule.
	 */
	public boolean Is_CustomRule() {
		return CustomRule;
	}

	/**
	 * Represents the CustomDataEntry as a String able to be printed on the console.
	 */
	@Override
	public String toString() {
		return "DataEntry [MethodId=" + MethodId + ", Package=" + Package + ", Class=" + Class + ", Method=" + Method
				+ ", LOC=" + LOC + ", CYCLO=" + CYCLO + ", ATFD=" + ATFD + ", LAA=" + LAA + ", Is_CustomRule=" + CustomRule+ "]";
	}

	
	
}
