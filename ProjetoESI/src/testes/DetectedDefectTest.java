package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import code.DetectedDefect;

class DetectedDefectTest {
	
	static DetectedDefect dd1;
	static DetectedDefect dd2;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dd1 = new DetectedDefect(0,true,true,true);
		dd2 = new DetectedDefect(1,true,true);
	}

	@Test
	void testGetId() {
		assertEquals(0, dd1.getId());
		assertEquals(1, dd2.getId());
	}

	@Test
	void testGettersSetters() {
		dd1.setIplasma(false);
		assertTrue(dd2.isIplasma());
		assertFalse(dd1.isIplasma());
		dd1.setPmd(false);
		assertTrue(dd2.isPmd());
		assertFalse(dd1.isPmd());
		dd2.setCustomrule(false);
		assertFalse(dd2.isCustomrule());
		assertTrue(dd1.isCustomrule());
	}

}
