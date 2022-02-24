package parallel;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.pages.AddBankDetails;
import com.pages.BhimanHomePage;
import com.pages.BhimanPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddBankDetailsSteps2 {
	private WebDriver driver=DriverFactory.getDriver();
	BhimanHomePage bhimanhome;
	BhimanPage bhimanpage;
	private AddBankDetails addbankdetails = new AddBankDetails(DriverFactory.getDriver());
	
	@Given("User is on_LoginPage")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("http://103.50.162.196/testing/user-login.php");
	}

	@When("User EntersUsername")
	public void user_enters_username() throws InterruptedException {
		bhimanpage  =PageFactory.initElements(DriverFactory.getDriver(), BhimanPage.class);
		bhimanpage.enterusername();
	}

	@When("User EntersPassword")
	public void user_enters_password() {
		  bhimanpage.enterspassword();
	}

	@When("User Clicks_Login_Button")
	public void user_clicks_login_button() {
		 bhimanpage.clickloginButton();
	}

	@Then("User Verifies_the LoginPage title")
	public void user_verifies_the_login_page_title() {
		bhimanhome=new BhimanHomePage(driver);
		String expectedTitleName="Bhiman Admin Login page";
	 String title=  bhimanhome.getHomePageTitle();
	 System.out.println("=========================================");
	 System.out.println("Bhiman home Page title "+title);
	 System.out.println("=========================================");
	Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Given("User is Navigated_HomePage")
	public void user_is_navigated_home_page() {
		bhimanhome = new BhimanHomePage(DriverFactory.getDriver());
	}

	@When("User MOuse howers on Masters_Tab and click on_BanksLink")
	public void user_m_ouse_howers_on_masters_tab_and_click_on_banks_link() throws IOException {
		bhimanhome.BankLink();	
	}

	@When("User Clicks_AddBankButton")
	public void user_clicks_add_bank_button() {
		 //bhimanhome.clickAddbank();
		   addbankdetails= bhimanhome.enterbankdetails();
	}

	@Then("User is navigated to_AddBankPage")
	public void user_is_navigated_to_add_bank_page() {
		addbankdetails=new AddBankDetails(driver);	
		 System.out.println("========================================="); 
		boolean banklogo= addbankdetails.banklogo();
		 Assert.assertTrue(addbankdetails.banklogo());
	}

	@Then("User Verifies the AddBank_Title")
	public void user_verifies_the_add_bank_title() {
		addbankdetails=new AddBankDetails(driver);	
		addbankdetails = new AddBankDetails(DriverFactory.getDriver());
		String expectedTitleName="Banks";
		 String banktitle=  bhimanhome.getHomePageTitle();
		 System.out.println("=========================================");
		 System.out.println("Bhiman home Page title ===== "  + banktitle);
		 System.out.println("=========================================");
		 Assert.assertTrue(banktitle.contains(expectedTitleName));  
	}

	@Given("User is on_AddBankPage")
	public void user_is_on_add_bank_page() {
		addbankdetails = new AddBankDetails(DriverFactory.getDriver());
	}


}
