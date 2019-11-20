package code;
/** 
 *  Represents the Data from the Excel file.
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
	 * Getter of the ID of the method of Java Project.
	 * @return Identification of the method of Java Project.
	 */
	public int getEntryMethodId() {
		return MethodId;
	}

	/**
	 * Getter of the  ID of the method of Java Project.
	 * @return Identification of the package where the method is.
	 */
	public String getEntryPackage() {
		return Package;
	}

	/**
	 * Getter of the ID of the class where the method is.
	 * @return Identification of the class where the method is.
	 */
	public String getEntryClass() {
		return Class;
	}

	/**
	 * Getter of the name of the method.
	 * @return The name of the method.
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
	 * Checks CustomRule.
	 * @return Checks if a certain CustomRule is present.
	 */
	public boolean Is_CustomRule() {
		return CustomRule;
	}

	/**
	 * Converts the object DataEntry to String.
	 */
	@Override
	public String toString() {
		return "DataEntry [MethodId=" + MethodId + ", Package=" + Package + ", Class=" + Class + ", Method=" + Method
				+ ", LOC=" + LOC + ", CYCLO=" + CYCLO + ", ATFD=" + ATFD + ", LAA=" + LAA + ", Is_CustomRule=" + CustomRule+ "]";
	}

	
	
}
