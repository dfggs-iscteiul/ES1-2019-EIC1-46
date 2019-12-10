package code;

public class DetectedDefect {

	private int id;
	private boolean iplasma;
	private boolean pmd;
	private boolean customrule = false;
	
	public DetectedDefect(int id,boolean iplasma,boolean pmd,boolean customrule) {
		this.id=id;
		this.iplasma=iplasma;
		this.pmd=pmd;
		this.customrule=customrule;
	}
	public DetectedDefect(int id,boolean iplasma,boolean pmd) {
		this.id=id;
		this.iplasma=iplasma;
		this.pmd=pmd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isIplasma() {
		return iplasma;
	}

	public void setIplasma(boolean iplasma) {
		this.iplasma = iplasma;
	}

	public boolean isPmd() {
		return pmd;
	}

	public void setPmd(boolean pmd) {
		this.pmd = pmd;
	}

	public boolean isCustomrule() {
		return customrule;
	}

	public void setCustomrule(boolean customrule) {
		this.customrule = customrule;
	}
	
	
}
