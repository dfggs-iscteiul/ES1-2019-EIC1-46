package testes;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import code.BuildObjectsFromExcel;
import code.Thresholds;

class ThresholdsTest {

	Thresholds th1, th2, th3, th4, th5, th6;

	protected void setUp() {
		BuildObjectsFromExcel bofe = new BuildObjectsFromExcel();

		th1 = new Thresholds(bofe,"a",false,false,false,false,false,false,10,5,4,0.3f);
		th2 = new Thresholds(bofe,"b",true,true,true,true,true,true,10,5,4,0.3f);
		th3 = new Thresholds(bofe,"c",true,true,false,false,true,false,10,5,4,0.3f);
		th4 = new Thresholds(bofe,"d",true,true,false,false,true,false,10,5,4,0.3f);
		th5 = new Thresholds(bofe,"e",true,true,true,false,false,true,10,5,4,0.3f);
		th6 = new Thresholds(bofe,"f",false,true,false,true,true,true,10,5,4,0.3f);

	}

	@Test
	void testcalcAccuracy() {
		setUp();
		th1.calcThresholds();
		th2.calcThresholds();
		th3.calcThresholds();
		th4.calcThresholds();
		th5.calcThresholds();
		th6.calcThresholds();

	}
	
	@Test
	void testGettersSetters() {
		setUp();
		th1.calcThresholds();
		th1.setName("Teste");
		assertEquals("Teste", th1.getName());
		th1.setRule1(true);
		assertTrue(th1.isRule1());
		th1.setRule2(true);
		assertTrue(th1.isRule2());
		th1.setRule3(true);
		assertTrue(th1.isRule3());
		th1.setRule4(true);
		assertTrue(th1.isRule4());
		th1.setLogicalOperator1(true);
		assertTrue(th1.isLogicalOperator1());
		th1.setLogicalOperator2(true);
		assertTrue(th1.isLogicalOperator2());
		th1.setLOCVal(0);
		th1.setCYCLOVal(0);
		th1.setLAAVal(0);
		th1.setAFTDVal(0);
		assertEquals(0,th1.getAFTDVal());
		assertEquals(0,th1.getLAAVal());
		assertEquals(0,th1.getCYCLOVal());
		assertEquals(0,th1.getLOCVal());
	}

}
