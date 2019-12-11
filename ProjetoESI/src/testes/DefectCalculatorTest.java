package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import code.BuildObjectsFromExcel;
import code.CustomRule;
import code.DefectCalculator;
import code.Thresholds;

class DefectCalculatorTest {
	
	//Cobertura pode melhorar com adição de Tresholds e Regras
	
	static DefectCalculator dc1;
	static DefectCalculator dc2;
	static DefectCalculator dc3;
	static DefectCalculator dc4;
	static Thresholds t1;
	static Thresholds t2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		BuildObjectsFromExcel helper = new BuildObjectsFromExcel();
		helper.buildObjects(new File("Long-Method.xlsx"));
		CustomRule cr = new CustomRule("teste","10","0","20","0", "10","0","30","0");
		cr.applyCustomRule(helper.objects());
		dc1 = new DefectCalculator(helper.objects());
		dc2 = new DefectCalculator(helper.objects(), cr);
		BuildObjectsFromExcel helper1 = new BuildObjectsFromExcel();
		helper1.buildObjects(new File("Long-Method.xlsx"));
		Thresholds t1 = new Thresholds(helper1,true,true,true,true,true,true,0,0,0,0);
		Thresholds t2 = new Thresholds(helper1,true,true,true,true,true,true,150,150,150,150);
		t1.calcThresholds();
		t2.calcThresholds();
		dc3 = new DefectCalculator(t1.getInputs(),cr);
		dc4 = new DefectCalculator(t2.getInputs(),cr);
		dc3.CalculateDefects();
		dc4.CalculateDefects();
		dc3.CalculateDefectsCustomRule();
		dc4.CalculateDefectsCustomRule();
	}

	@Test
	void testCalculateDefects() {
		dc1.CalculateDefects();
		assertEquals(140, dc1.getDciIPlasma());
		assertEquals(0, dc1.getDiiIPlasma());
		assertEquals(280, dc1.getAdciIPlasma());
		assertEquals(0, dc1.getAdiiIPlasma());
		assertEquals(140, dc1.getDciPMD());
		assertEquals(18, dc1.getDiiPMD());
		assertEquals(262, dc1.getAdciPMD());
		assertEquals(0, dc1.getAdiiPMD());
		
	}

	@Test
	void testCalculateDefectsCustomRule() {
		dc2.CalculateDefects();
		dc2.CalculateDefectsCustomRule();
		assertEquals(0, dc2.getDciCR());
		assertEquals(163, dc2.getDiiCR());
		assertEquals(117, dc2.getAdciCR());
		assertEquals(140, dc2.getAdiiCR());
	}

	@Test
	void testGetDataEntry() {
		assertEquals(420, dc1.getDataEntry().size());
		assertEquals(420, dc2.getDataEntry().size());
	}

	@Test
	void testGetDefects() {
		dc1.CalculateDefects();
		dc2.CalculateDefects();
		dc2.CalculateDefectsCustomRule();
		assertNotEquals(0, dc1.getDefects().size());
		assertNotEquals(0, dc1.getDefects().size());
	}

}
