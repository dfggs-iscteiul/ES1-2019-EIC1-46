package code;
/** 
 *  Holds the results of the use of the new rule with the Excel data.
 *  Date: Nov 20-2019
 * 
 * @author Daniel Gon�alves
 * @version 1.0
 */
public class CustomDataEntry {
	/**
	 * Represents the attributes of the DefectCalculator class.
	 */
	private int MethodId;
	private String Package;
	private String Class;
	private String Method;
	
	private int LOC;
	private int CYCLO;
	private int ATFD;
	private float LAA;
	private boolean CustomRule;
	/**
	 * Creates the DataEntry with the specific parameters.
	 * @param MethodId is a Integer.
	 * @param Package is the name of the package.
	 * @param Class is the name of the class.
	 * @param Method is the name of the method.
	 * @param LOC is a Integer.
	 * @param CYCLO is a Integer.
	 * @param ATFD is a Integer.
	 * @param LAA is a Float.
	 * @param CustomRule indicates if the CustomRule detects the defect in the method.
	 */
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
