package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import code.BuildObjectsFromExcel;
import code.CustomDataEntry;
import code.ExcelAccuracy;

class CustomDataEntryTest {

	private static CustomDataEntry cde; 
	private static CustomDataEntry cde1; 
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cde = new CustomDataEntry(1,"teste-p","teste-c","teste-m",1,2,3,(float) 4,true);
		cde1 = new CustomDataEntry(1,"teste-p","teste-c","teste-m",1,2,3,(float) 4,false);
	}
	
	@Test
	protected void CustomDataEntry_GettersTests() {
		assertEquals(cde.getEntryATFD(),3);
		assertEquals(cde.getEntryClass(),"teste-c");
		assertEquals(cde.getEntryCYCLO(),2);
		assertEquals(cde.getEntryLAA(),(float)4);
		assertEquals(cde.getEntryLOC(),1);
		assertEquals(cde.getEntryMethod(),"teste-m");
		assertEquals(cde.getEntryMethodId(),1);
		assertEquals(cde.getEntryPackage(),"teste-p");
		assertEquals(cde.Is_CustomRule(),true);
		assertEquals(cde1.Is_CustomRule(),false);
	}
	
	@Test
	protected void ToString_Test() {
		assertEquals(cde.toString(),"DataEntry [MethodId=1, Package=teste-p, Class=teste-c, Method=teste-m, LOC=1,"
				+ " CYCLO=2, ATFD=3, LAA=4.0, Is_CustomRule=true]");
	}

}
