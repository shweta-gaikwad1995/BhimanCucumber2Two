package parallel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.pages.AddBankDetails;
import com.pages.BhimanLoginData;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class BhimanLoginDataSteps2 {
	
	
	
	
	private WebDriver driver=DriverFactory.getDriver();
	private BhimanLoginData bhimandata = new BhimanLoginData(DriverFactory.getDriver());
	
	@Given("user navigates  Login Page")
	public void user_navigates_login_page() {
		DriverFactory.getDriver().get("http://103.50.162.196/testing/user-login.php"); 
	}

	@When("user fills the Login_form from given sheetname {string} and rownumber {int}")
	public void user_fills_the_login_form_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws InterruptedException, InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		Thread.sleep(10,000);

List<Map<String,String>> testData = reader.getData("D:\\automation1\\bhimanautomation.xlsx", sheetName);
//reader.getData("D:\\automation1", sheetName);
	
String heading = testData.get(rowNumber).get("subjectheading");
String email = testData.get(rowNumber).get("email");
bhimandata.fillContactUsForm(heading, email);

	}

	}

