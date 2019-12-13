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
		cr2 = new CustomRule("teste2",null,"1","2","1", "2","1","2","1");
		cr3 = new CustomRule("teste3",null,null,"2","1", "2","1","2","1");
		cr4 = new CustomRule("teste4",null,null,null,"1", "2","1","2","1");
		cr5 = new CustomRule("teste5",null,null,null,null, "2","1","2","1");
		cr6 = new CustomRule("teste6",null,null,null,null,null,"1","2","1");
		cr7 = new CustomRule("teste7",null,null,null,null, null,null,"2","1");
		cr8 = new CustomRule("teste8",null,null,null,null,null,null,null,"1");
		cr9 = new CustomRule("teste9",null,null,null,null,null,null,"2",null);
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
			cr2.applyCustomRule(data);
			cr3.applyCustomRule(data);
			cr4.applyCustomRule(data);
			cr5.applyCustomRule(data);
			cr6.applyCustomRule(data);
			cr7.applyCustomRule(data);
			cr8.applyCustomRule(data);
			cr9.applyCustomRule(data);
			cr10.applyCustomRule(data);


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	protected void getCustomRuleDataTest() {
		cr.getCustomRuleData();
		cr2.getCustomRuleData();
		cr3.getCustomRuleData();
		cr4.getCustomRuleData();
		cr5.getCustomRuleData();
		cr6.getCustomRuleData();
		cr7.getCustomRuleData();
		cr8.getCustomRuleData();
		cr9.getCustomRuleData();
		cr10.getCustomRuleData();
	}
	
	@Test
	void testGetName() {
		assertEquals("teste", cr.getName());
	}
	

}
