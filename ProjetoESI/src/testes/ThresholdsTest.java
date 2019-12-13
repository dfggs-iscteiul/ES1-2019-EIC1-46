package testes;

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

}
