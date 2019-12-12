package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import code.BuildObjectsFromExcel;
import code.CustomRule;
import gui.CustomDataEntryTableModel;

class CustomDataEntryTableModelTest {

	static CustomDataEntryTableModel table;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		BuildObjectsFromExcel helper = new BuildObjectsFromExcel();
		helper.buildObjects(new File("Long-Method.xlsx"));
		CustomRule cr = new CustomRule("teste","10","0","20","0", "10","0","30","0");
		cr.applyCustomRule(helper.objects());
		table = new CustomDataEntryTableModel(cr.getCustomRuleData());
	}

	@Test
	void testDataEntryTableModel() {
		assertNotNull(table);
	}

	@Test
	void testGetColumnCount() {
		assertEquals(9, table.getColumnCount());
	}

	@Test
	void testGetRowCount() {
		assertEquals(420, table.getRowCount());
	}

	@Test
	void testGetValueAt() {
		assertEquals(420, table.getValueAt(419, 0));
		assertEquals("net.wastl.webmail.logger", table.getValueAt(419, 1));
		assertEquals("ServletLogger", table.getValueAt(419, 2));
		assertEquals("ServletLogger(WebMailServer,Storage)", table.getValueAt(419, 3));
		assertEquals(13, table.getValueAt(419, 4));
		assertEquals(2, table.getValueAt(419, 5));
		assertEquals(1, table.getValueAt(419, 6));
		assertEquals(0.666667f, table.getValueAt(419, 7));
		assertEquals(false, table.getValueAt(419, 8));
		assertNull(table.getValueAt(419, 9));
	}

	@Test
	void testGetColumnNameInt() {
		assertEquals("ID", table.getColumnName(0));
	}

}
