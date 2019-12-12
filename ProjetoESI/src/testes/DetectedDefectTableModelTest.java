package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import code.BuildObjectsFromExcel;
import code.CustomRule;
import code.DefectCalculator;
import gui.DetectedDefectTableModel;

class DetectedDefectTableModelTest {
	
	static DetectedDefectTableModel table;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		BuildObjectsFromExcel helper = new BuildObjectsFromExcel();
		helper.buildObjects(new File("Long-Method.xlsx"));
		CustomRule cr = new CustomRule("teste","10","0","20","0", "10","0","30","0");
		cr.applyCustomRule(helper.objects());
		DefectCalculator calculator = new DefectCalculator(helper.objects(),cr);
		calculator.CalculateDefects();
		calculator.CalculateDefectsCustomRule();
		table = new DetectedDefectTableModel(calculator.getDefects());
	}

	@Test
	void testDetectedDefectTableModel() {
		assertNotNull(table);
	}

	@Test
	void testGetColumnCount() {
		assertEquals(4, table.getColumnCount());
	}

	@Test
	void testGetRowCount() {
		assertEquals(420, table.getRowCount());
	}

	@Test
	void testGetValueAt() {
		assertEquals(420, table.getValueAt(419, 0));
		assertEquals(false, table.getValueAt(419, 1));
		assertEquals(false, table.getValueAt(419, 2));
		assertEquals(false, table.getValueAt(419, 3));
		assertNull(table.getValueAt(419, 12));
	}

	@Test
	void testGetColumnNameInt() {
		assertEquals("MethodID", table.getColumnName(0));
	}

	@Test
	void testSetDefectAt() {
		table.setDefectAt(true, 0, 1);
		assertEquals(true, table.getValueAt(0, 1));
		table.setDefectAt(true, 0, 2);
		assertEquals(true, table.getValueAt(0, 1));
		table.setDefectAt(true, 0, 3);
		assertEquals(true, table.getValueAt(0, 1));
		table.setDefectAt(true, 0, 4);
		assertNull(table.getValueAt(0, 4));
	}

}
