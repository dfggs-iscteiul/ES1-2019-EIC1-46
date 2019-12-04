package testes;

import java.io.File;

import org.junit.jupiter.api.Test;

import code.BuildObjectsFromExcel;
import code.RuleAccuracy;

class RuleAccuracyTest {

	RuleAccuracy ra1, ra2, ra3, ra4, ra5, ra6;

	protected void setUp() {
		String folderPath = System.getProperty("user.dir");
		String filePath = folderPath + "/1_215916_21102019.txt";

		File f = new File(filePath);

		BuildObjectsFromExcel bofe = new BuildObjectsFromExcel();

		ra1 = new RuleAccuracy(f, bofe);
		ra2 = new RuleAccuracy(f, bofe);
		ra3 = new RuleAccuracy(f, bofe);
		ra4 = new RuleAccuracy(f, bofe);
		ra5 = new RuleAccuracy(f, bofe);
		ra6 = new RuleAccuracy(f, bofe);

	}

	@Test
	void testcalcAccuracy() {
		setUp();

		ra1.calcAccuracy();
		ra2.calcAccuracy();
		ra3.calcAccuracy();
		ra4.calcAccuracy();
		ra5.calcAccuracy();
		ra6.calcAccuracy();

	}

}
