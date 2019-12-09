package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class CustomRule {
	
	private String name;
	private String LOC_Max;
	private String LOC_Min;
	private String CYCLO_Max;
	private String CYCLO_Min;
	private String ATFD_Min;
	private String ATFD_Max;
	private String LAA_Min;
	private String LAA_Max;
	private ArrayList<CustomDataEntry> customRuleData;
	
	public CustomRule(String name, String LOC_Max, String LOC_Min, String CYCLO_Max, 
		String CYCLO_Min, String ATFD_Min, String ATFD_Max, String LAA_Min, String LAA_Max) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat(" HH:mm:ss dd-MM-yyyy");
		this.name=name+"_"+calendar.get(calendar.HOUR_OF_DAY)+calendar.get(calendar.MINUTE)
		+calendar.get(calendar.SECOND)+"_"+
		calendar.get(calendar.DAY_OF_MONTH)+calendar.get(calendar.MONTH)+calendar.get(calendar.YEAR);
		this.LOC_Max=LOC_Max;
		this.LOC_Min=LOC_Min;
		this.CYCLO_Max=CYCLO_Max;
		this.CYCLO_Min=CYCLO_Min;
		this.ATFD_Max=ATFD_Max;
		this.ATFD_Min=ATFD_Min;
		this.LAA_Min=LAA_Min;
		this.LAA_Max=LAA_Max;
		System.out.println("New custom rule '" + this.name + "'  was succefully created!");
	}
	/**
	 * Method that applies the new rule created, generating a set of CustomDataEntry and printing them to a File.
	 * @param ExcelData - List with all the DataEntries that are build from the Excel file.
	 * @throws FileNotFoundException if the CustomRuleDataFile is not found. 
	 * */
	
	public void applyCustomRule(ArrayList<DataEntry> ExcelData ) throws FileNotFoundException{
		customRuleData = new ArrayList<CustomDataEntry>();
		File CustomRuleDataFile = new File(this.name + ".txt");
		PrintWriter printWriter = new PrintWriter(CustomRuleDataFile);
		String[] checklist = new String[16];
			for(DataEntry d: ExcelData) {
				int i=0;
				if(this.LOC_Max!=null) {
					if(d.getEntryLOC()<Integer.parseInt(this.LOC_Max)) {
						checklist[i]="true";
					}
					else {
						checklist[i]="false";
					}
					i++;
				}		
				if(this.LOC_Min!=null) {
					if(d.getEntryLOC()>Integer.parseInt(this.LOC_Min)) {
						checklist[i]="true";
					}
					else {
						checklist[i]="false";
					}
					i++;
				}		
				if(this.CYCLO_Max!=null) {
					if(d.getEntryCYCLO()<Integer.parseInt(this.CYCLO_Max)) {
						checklist[i]="true";
					}
					else {
						checklist[i]="false";
					}
					i++;
				}		
				if(this.CYCLO_Min!=null) {
					if(d.getEntryCYCLO()>Integer.parseInt(this.CYCLO_Min)) {
						checklist[i]="true";
					}
					else {
						checklist[i]="false";
					}
					i++;
				}		
				if(this.ATFD_Max!=null) {
					if(d.getEntryATFD()<Integer.parseInt(this.ATFD_Max)) {
						checklist[i]="true";
					}
					else {
						checklist[i]="false";
					}
					i++;
				}		
				if(this.ATFD_Min!=null) {
					if(d.getEntryATFD()>Integer.parseInt(this.ATFD_Min)) {
						checklist[i]="true";
					}
					else {
						checklist[i]="false";
					}
					i++;
				}		
				if(this.LAA_Max!=null) {
					if(d.getEntryLAA()<Integer.parseInt(this.LAA_Max)) {
						checklist[i]="true";
					}
					else {
						checklist[i]="false";
					}
					i++;
				}		
				if(this.LAA_Min!=null) {
					if(d.getEntryLAA()>Integer.parseInt(this.LAA_Min)) {
						checklist[i]="true";
					}
					else {
						checklist[i]="false";
					}
					i++;
				}
			boolean check = true;
			for (int a = 0; a < checklist.length; a++) {
				if(checklist[a]=="false") {
					check = false;
				}
			}
			if(check==true) {
				CustomDataEntry c = new CustomDataEntry(d.getEntryMethodId(),d.getEntryPackage(), 
						d.getEntryClass(), d.getEntryMethod(), d.getEntryLOC(), 
						d.getEntryCYCLO(), d.getEntryATFD(), d.getEntryLAA(),true);
				customRuleData.add(c);
				printWriter.println(c.getEntryMethodId()+";"+d.getEntryPackage()+";"
						+c.getEntryClass()+";"+c.getEntryMethod()+";"+c.getEntryLOC()
						+";"+c.getEntryCYCLO()+";"+c.getEntryATFD()+";"+c.getEntryLAA()
						+";"+"true");
			}
			else {
				CustomDataEntry c = new CustomDataEntry(d.getEntryMethodId(),d.getEntryPackage(), 
						d.getEntryClass(), d.getEntryMethod(), d.getEntryLOC(), 
						d.getEntryCYCLO(), d.getEntryATFD(), d.getEntryLAA(),false);
				customRuleData.add(c);
				printWriter.println(c.getEntryMethodId()+";"+d.getEntryPackage()+";"
						+c.getEntryClass()+";"+c.getEntryMethod()+";"+c.getEntryLOC()
						+";"+c.getEntryCYCLO()+";"+c.getEntryATFD()+";"+c.getEntryLAA()
						+";"+"false");
			}
		}
		printWriter.close();
		System.out.println("New custom rule '"+this.name+"' was sucessfully evaluated and its data was exported!");
	}
	
	/**
	 * Getter of list that stores the data that comes from the application of the new rule.
	 * @return ArrayList with all of the newly created CustomDataEntry associated with this new rule.
	 */
	public ArrayList<CustomDataEntry> getCustomRuleData() {
		return customRuleData;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("Long-Method.xlsx");
		BuildObjectsFromExcel bofe = new BuildObjectsFromExcel();
		try {
			bofe.buildObjects(f);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ArrayList<DataEntry> l = bofe.objects();
		CustomRule cr = null;
		try {
		cr = new CustomRule("1", "5", "2", "2", "0", "-1", "1", "0", "2");
		cr.applyCustomRule(l);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
