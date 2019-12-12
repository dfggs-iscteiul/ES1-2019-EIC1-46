package testes;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

import code.CustomDataEntry;

@RunWith(JUnitPlatform.class)
@SelectClasses({ BuildObjectsFromExcelTest.class, ExcelAccuracyTest.class, RuleAccuracyTest.class, CustomDataEntryTest.class, CustomRuleTest.class, DefectCalculatorTest.class, DetectedDefectTest.class})
public class AllTests {

}
