package PageFac1;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// login

@CucumberOptions (features = "src/test/java/PageFac1",glue = "PageFac1",plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class TestRunnerPg extends AbstractTestNGCucumberTests {

}