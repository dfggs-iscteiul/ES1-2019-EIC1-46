package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import code.BuildObjectsFromExcel;
import gui.DataEntryTableModel;

class DataEntryTableModelTest {
	
	static DataEntryTableModel table;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		BuildObjectsFromExcel helper = new BuildObjectsFromExcel();
		helper.buildObjects(new File("Long-Method.xlsx"));
		table = new DataEntryTableModel(helper.objects());
	}

	@Test
	void testDataEntryTableModel() {
		assertNotNull(table);
	}

	@Test
	void testGetColumnCount() {
		assertEquals(12, table.getColumnCount());
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
		assertEquals(false, table.getValueAt(419, 9));
		assertEquals(false, table.getValueAt(419, 10));
		assertEquals(false, table.getValueAt(419, 11));
		assertNull(table.getValueAt(419, 12));
	}

	@Test
	void testGetColumnNameInt() {
		assertEquals("ID", table.getColumnName(0));
	}

}
