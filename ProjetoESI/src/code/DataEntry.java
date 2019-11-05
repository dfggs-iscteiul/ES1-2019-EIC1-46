package code;

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
		this.Is_Long_Method=Is_Long_Method();
		this.IPlasma=IPlasma;
		this.PMD=PMD;
		this.Is_Feature_Envy=Is_Feature_Envy;
		System.out.println("Data Entry with the Method ID: "+this.MethodId+""
				+ " was successfully created!");
	}
	
	public int getEntryMethodId() {
		return MethodId;
	}

	public String getEntryPackage() {
		return Package;
	}

	public String getEntryClass() {
		return Class;
	}

	public String getEntryMethod() {
		return Method;
	}

	public int getEntryLOC() {
		return LOC;
	}

	public int getEntryCYCLO() {
		return CYCLO;
	}

	public int getEntryATFD() {
		return ATFD;
	}

	public float getEntryLAA() {
		return LAA;
	}

	public boolean Is_Long_Method() {
		return Is_Long_Method;
	}

	public boolean IPlasma() {
		return IPlasma;
	}

	public boolean PMD() {
		return PMD;
	}

	public boolean Is_Feature_Envy() {
		return Is_Feature_Envy;
	}

	@Override
	public String toString() {
		return "DataEntry [MethodId=" + MethodId + ", Package=" + Package + ", Class=" + Class + ", Method=" + Method
				+ ", LOC=" + LOC + ", CYCLO=" + CYCLO + ", ATFD=" + ATFD + ", LAA=" + LAA + ", Is_Long_Method="
				+ Is_Long_Method + ", IPlasma=" + IPlasma + ", PMD=" + PMD + ", Is_Feature_Envy=" + Is_Feature_Envy
				+ "]";
	}

	
	
}
