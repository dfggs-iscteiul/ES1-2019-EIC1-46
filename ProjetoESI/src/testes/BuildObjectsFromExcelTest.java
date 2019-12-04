package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import code.BuildObjectsFromExcel;

class BuildObjectsFromExcelTest {

	BuildObjectsFromExcel b1, b2, b3, b4, b5, b6;

	protected void setUp() {
		b1 = new BuildObjectsFromExcel();
		b2 = new BuildObjectsFromExcel();
		b3 = new BuildObjectsFromExcel();
		b4 = new BuildObjectsFromExcel();
		b5 = new BuildObjectsFromExcel();
		b6 = new BuildObjectsFromExcel();

	}

	@Test
	void testBuildObjects() {
		setUp();

	}

}
