package testes;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({ BuildObjectsFromExcelTest.class, RuleAccuracyTest.class})
public class AllTests {

}
