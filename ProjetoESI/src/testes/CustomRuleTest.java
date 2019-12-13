package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import code.BuildObjectsFromExcel;
import code.CustomDataEntry;
import code.CustomRule;
import code.DataEntry;

class CustomRuleTest {

	private static CustomRule cr; 
	private static CustomRule cr2; 
	private static CustomRule cr3; 
	private static CustomRule cr4; 
	private static CustomRule cr5; 
	private static CustomRule cr6; 
	private static CustomRule cr7; 
	private static CustomRule cr8; 
	private static CustomRule cr9; 
	private static CustomRule cr10; 


	private static ArrayList<CustomDataEntry> results;
	private static ArrayList<DataEntry> data;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		results =  new ArrayList<CustomDataEntry>();
		cr10 = new CustomRule("teste10","4","2","2","0", "-1","2","0","2");
		cr = new CustomRule("teste","2","1","2","1", "2","1","2","1");

		File f = new File("Long-Method.xlsx");
		BuildObjectsFromExcel bofe = new BuildObjectsFromExcel();
		try {
			bofe.buildObjects(f);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		data = bofe.objects();
	}
	
	@Test
	protected void applyCustomRuleTest() {
		try {
			cr.applyCustomRule(data);
			cr10.applyCustomRule(data);


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	protected void getCustomRuleDataTest() {
		cr.getCustomRuleData();
		cr10.getCustomRuleData();
	}
	@Test
	void getNameTest() {
		cr.getName();
	}
}
