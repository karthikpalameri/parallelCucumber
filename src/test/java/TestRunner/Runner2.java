package TestRunner;

import org.junit.runner.RunWith;
//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features", glue = { "StepDefinition" },tags= {"@firefoxx"})
public class Runner2 extends AbstractTestNGCucumberTests {

}
