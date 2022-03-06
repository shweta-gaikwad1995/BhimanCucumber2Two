package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		publish=true,
		dryRun=false,
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/",
				"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
				"json:target/cucumber-report/cucumber.json"
				
				
				}, 
		monochrome = true,
		glue = {"parallel"},
		features = { "src/test/resources/parallel/BankDataTable2.feature" }
		
		)



public class ParallelRun extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
