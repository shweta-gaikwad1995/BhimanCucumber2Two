package parallel;

import org.openqa.selenium.support.PageFactory;

import com.pages.BhimanPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class BhimanLogo2Steps {
	
	private static String title;
	private BhimanPage bhimanpage = new BhimanPage(DriverFactory.getDriver());
	
	@Given("user is on Bhiman BhimanApplication")
	public void user_is_on_bhiman_bhiman_application() {
		   
				DriverFactory.getDriver().get("http://103.50.162.196/testing/user-login.php");
	}

	@When("user enters_username")
	public void user_enters_username() throws InterruptedException {
		bhimanpage  =PageFactory.initElements(DriverFactory.getDriver(), BhimanPage.class);
		bhimanpage.enterusername();
	}

	@When("user entesr_password")
	public void user_entesr_password() {
		 bhimanpage.enterspassword();
	}

	@When("user clicks on_loginButton")
	public void user_clicks_on_login_button() {
		   bhimanpage.clickloginButton();
	}

	@When("user enters Invalid_password")
	public void user_enters_invalid_password() {
		bhimanpage.invalidPassword();
	}
}
