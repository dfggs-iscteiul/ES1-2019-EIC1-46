package testes;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({ BuildObjectsFromExcelTest.class, ExcelAccuracyTest.class, RuleAccuracyTest.class, 
	CustomDataEntryTest.class, CustomRuleTest.class, DetectedDefectTest.class , DefectCalculatorTest.class, 
	DataEntryTableModelTest.class, DetectedDefectTableModelTest.class, CustomDataEntryTableModelTest.class,
	ThresholdsTest.class})
public class AllTests {

}
