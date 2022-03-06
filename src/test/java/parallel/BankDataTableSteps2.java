package parallel;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.pages.AddBankDetails;
import com.pages.BhimanHomePage;
import com.pages.BhimanPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BankDataTableSteps2 {
private WebDriver driver=DriverFactory.getDriver();


	
	private static String title;
	BhimanHomePage bhimanhome;
	BhimanPage bhimanpage;
	private AddBankDetails addbankdetails = new AddBankDetails(DriverFactory.getDriver());
	
	@Given("Add-BankPage")
	public void add_bank_page() {
		DriverFactory.getDriver().get("http://103.50.162.196/testing/user-login.php"); 
	}

	@When("user logs in with_username")
	public void user_logs_in_with_username() throws InterruptedException {
		bhimanpage  =PageFactory.initElements(DriverFactory.getDriver(), BhimanPage.class);
		bhimanpage.enterusername();
	}

	@When("user logs in with_password")
	public void user_logs_in_with_password() {
		bhimanpage.enterspassword();
	}

	@When("users clicks on login-Button")
	public void users_clicks_on_login_button() {
		 bhimanpage.clickloginButton();
	}
/*
	@Then("users checks the HomePage-Title")
	public void users_checks_the_home_page_title() {
		title=bhimanhome.getHomePageTitle();
		System.out.println("==================================");
		System.out.println(" Bhiman===Home==title " +title);
	}
*/
	@Then("users checks the HomePage-Title {string}")
	public void users_checks_the_home_page_title(String expectedTitleName) {
		bhimanhome=new BhimanHomePage(driver);
	 expectedTitleName="Bhiman Admin Login page";
	 String title=  bhimanhome.getHomePageTitle();
	 System.out.println("=========================================");
	 System.out.println("Bhiman home Page title "+title);
	 System.out.println("=========================================");
	Assert.assertTrue(title.contains(expectedTitleName));
	}

	@When("user navigates to-bankPage")
	public void user_navigates_to_bank_page() throws IOException {
		bhimanhome.BankLink();	
	}

	@When("user clicks on-AddBankButton")
	public void user_clicks_on_add_bank_button() {
		//bhimanhome.clickAddbank();
		   addbankdetails= bhimanhome.enterbankdetails();
	}

	@When("user enters bank-Form-details")
	public void user_enters_bank_form_details(DataTable dataTable) {
	    
	}
	
	
	@When("Click-submit button")
	public void click_submit_button() {
	   
	}
	
	@When("Click-Okay Button")
	public void click_okay_button() {
	  
	}
}
