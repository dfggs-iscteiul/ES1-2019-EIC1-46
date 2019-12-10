package code;
/**
 * 
 * Shows if the defect is detected for a methodID in the IPlasma, PMD and CustomRule
 * 
 * 
 * Date: Dec 05-2019
 * 
 * @author Filipe Cruz
 * @version 1.0
 * 
 * 
 *
 */
public class DetectedDefect {

	/**
	 * Represents the attributes of the DetectedDefect class.
	 */
	
	private int id;
	private boolean iplasma;
	private boolean pmd;
	private boolean customrule = false;
	/**
	 * Creates the DetectedDefect with the specific parameters.
	 * @param id is the methodID.
	 * @param iplasma checks if IPlasma detects the defect.
	 * @param pmd checks if PMD detects the defect.
	 * @param customrule checks if CustomRule detects the defect.
	 */
	public DetectedDefect(int id,boolean iplasma,boolean pmd,boolean customrule) {
		this.id=id;
		this.iplasma=iplasma;
		this.pmd=pmd;
		this.customrule=customrule;
	}
	/**
	 * Creates the DetectedDefect with the specific parameters.
	 * @param id is the methodID.
	 * @param iplasma checks if IPlasma detects the defect.
	 * @param pmd checks if PMD detects the defect.
	 */
	public DetectedDefect(int id,boolean iplasma,boolean pmd) {
		this.id=id;
		this.iplasma=iplasma;
		this.pmd=pmd;
	}
	/**
	 * returns the method id
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * Getter for IPlasma.
	 * @return iplasma.
	 */
	public boolean isIplasma() {
		return iplasma;
	}
	/**
	 * Setter for IPlasma.
	 */
	public void setIplasma(boolean iplasma) {
		this.iplasma = iplasma;
	}
	/**
	 * Getter for PMD.
	 * @return pmd.
	 */
	public boolean isPmd() {
		return pmd;
	}
	/**
	 * Setter for PMD.
	 */
	public void setPmd(boolean pmd) {
		this.pmd = pmd;
	}
	/**
	 * Getter for CustomRule.
	 * @return customrule.
	 */
	public boolean isCustomrule() {
		return customrule;
	}
	/**
	 * Setter for CustomRule.
	 */
	public void setCustomrule(boolean customrule) {
		this.customrule = customrule;
	}
	
	
}
