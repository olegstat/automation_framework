package cucumberOptions;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
//import org.junit.runner.RunWith;

//@RunWith(Cucumber.class) (Required for running the JUnit tests)
@CucumberOptions(features = "src/test/java/features", glue = "stepDefinitions")
//Comment the extends part below and import CucumberOptions from junit package to run it with back with JUnit)
public class TestRunner extends AbstractTestNGCucumberTests  {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }
}
