package code;
/** 
 *  Represents the Data from the Excel file.
 */
public class DataEntry {

	private int MethodId;
	private String Package;
	private String Class;
	private String Method;
	
	private int LOC;
	private int CYCLO;
	private int ATFD;
	private float LAA;
	private boolean Is_Long_Method;
	private boolean IPlasma;
	private boolean PMD;
	private boolean Is_Feature_Envy;
	
	public DataEntry(int MethodId, String Package, String Class, String Method,
						int LOC, int CYCLO, int ATFD, float LAA, boolean Is_Long_Method,
						boolean IPlasma, boolean PMD, boolean Is_Feature_Envy ) {
		this.MethodId=MethodId;
		this.Package=Package;
		this.Class=Class;
		this.Method=Method;
		this.LOC=LOC;
		this.CYCLO=CYCLO;
		this.ATFD=ATFD;
		this.LAA=LAA;
		this.Is_Long_Method=Is_Long_Method;
		this.IPlasma=IPlasma;
		this.PMD=PMD;
		this.Is_Feature_Envy=Is_Feature_Envy;
		
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
	 * Checks is_long_method.
	 * @return Checks if is_long_method is present.
	 */
	public boolean Is_Long_Method() {
		return Is_Long_Method;
	}

	/**
	 * Checks IPlasma.
	 * @return Checks if IPlasma is present on long_method.
	 */
	public boolean IPlasma() {
		return IPlasma;
	}

	/**
	 * Checks PMD.
	 * @return Checks if PMD is present on long_method.
	 */
	public boolean PMD() {
		return PMD;
	}

	/**
	 * Checks is_feature_envy.
	 * @return Checks if is_feature_envy is present.
	 */
	public boolean Is_Feature_Envy() {
		return Is_Feature_Envy;
	}
	/**
	 * Setter for is_long_method
	 * @param is_Long_Method
	 */
	public void setIs_Long_Method(boolean is_Long_Method) {
		Is_Long_Method = is_Long_Method;
	}
	/**
	 * Setter for is_feature_envy
	 * @param is_Feature_Envy
	 */
	public void setIs_Feature_Envy(boolean is_Feature_Envy) {
		Is_Feature_Envy = is_Feature_Envy;
	}
	/**
	 * Converts the object DataEntry to String.
	 */
	@Override
	public String toString() {
		return "DataEntry [MethodId=" + MethodId + ", Package=" + Package + ", Class=" + Class + ", Method=" + Method
				+ ", LOC=" + LOC + ", CYCLO=" + CYCLO + ", ATFD=" + ATFD + ", LAA=" + LAA + ", Is_Long_Method="
				+ Is_Long_Method + ", IPlasma=" + IPlasma + ", PMD=" + PMD + ", Is_Feature_Envy=" + Is_Feature_Envy
				+ "]";
	}

	
	
}
