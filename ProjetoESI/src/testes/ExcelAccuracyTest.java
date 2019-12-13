package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import code.BuildObjectsFromExcel;
import code.ExcelAccuracy;

class ExcelAccuracyTest {
	
	static ExcelAccuracy ea;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		BuildObjectsFromExcel helper = new BuildObjectsFromExcel();
		helper.buildObjects(new File("Long-Method.xlsx"));
		ea = new ExcelAccuracy(helper.objects());
	}

	@Test
	void testExcelAccuracy() {
		assertEquals(97.5, ea.getAverageAccuracy());
	}

	@Test
	void testGetAverageAccuracy() {
		assertEquals(95, ea.getEntryAccuracy());
	}
}
