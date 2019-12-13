package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import code.BuildObjectsFromExcel;
import code.CustomRule;
import code.ExcelAccuracy;

class ExcelAccuracyTest {
	
	static ExcelAccuracy ea;
	static ExcelAccuracy ea1;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		BuildObjectsFromExcel helper = new BuildObjectsFromExcel();
		helper.buildObjects(new File("Long-Method.xlsx"));
		ea = new ExcelAccuracy(helper.objects());
		CustomRule cr = new CustomRule("teste","10","0","20","0", "10","0","30","0");
		cr.applyCustomRule(helper.objects());
		ea1 = new ExcelAccuracy(helper.objects(), cr.getCustomRuleData());
	}

	@Test
	void testExcelAccuracy() {
		assertEquals(97.5, ea.getAverageAccuracy());
	}

	@Test
	void testGetAverageAccuracy() {
		assertEquals(95, ea.getEntryAccuracy());
	}
	@Test
	void testGetCustomAccuracy() {
		assertEquals(27.0, ea1.getCustomAccuracy());
	}
}
