package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import code.Main;

class MainTest {
	
	static Main main;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		main = new Main();
	}

	@Test
	void testMain() {
		main.main(new String[] {"", "", ""});
	}

}
