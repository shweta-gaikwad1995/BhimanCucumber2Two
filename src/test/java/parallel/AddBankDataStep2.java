package parallel;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.pages.AddBankDetails;
import com.pages.BhimanHomePage;
import com.pages.BhimanPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddBankDataStep2 {
	private WebDriver driver=DriverFactory.getDriver();
	private AddBankDetails addbankdetails = new AddBankDetails(DriverFactory.getDriver());
	BhimanHomePage bhimanhome= new BhimanHomePage(DriverFactory.getDriver());;
	BhimanPage bhimanpage;
	private static String title;
	

	
	
	@Given("User is on_Login_Page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver().get("http://103.50.162.196/testing/user-login.php");
	}

	@When("User Enters__Username")
	public void user_enters__username() throws InterruptedException {
		bhimanpage  =PageFactory.initElements(DriverFactory.getDriver(), BhimanPage.class);
		bhimanpage.enterusername();
	}

	@When("User Enters--Password")
	public void user_enters_password() {
		bhimanpage.enterspassword();
	}

	@When("User Clicks on__Login-Button")
	public void user_clicks_on__login_button() {
		 bhimanpage.clickloginButton();
	}

	@Given("User is on_Home-Page")
	public void user_is_on_home_page() {
		bhimanhome = new BhimanHomePage(DriverFactory.getDriver());
	}

	@Then("User_Verifies the Home-Page Title")
	public void user_verifies_the_home_page_title() {
		title=bhimanhome.getHomePageTitle();
		System.out.println("==================================");
		System.out.println(" Bhiman===Home==title " +title);
	}

	@When("User_Mouse-Howers on Masters-Tab & click-on-BanksLink")
	public void user_mouse_howers_on_masters_tab_click_on_banks_link() throws IOException {
		bhimanhome.BankLink();	
	}

	@Then("User_is Navigated to BanksPage Verify title {string}")
	public void user_is_navigated_to_banks_page_verify_title(String expectedtitle) {
		bhimanhome=new BhimanHomePage(driver);
		expectedtitle="Banks";
		String actual=  bhimanhome.getHomePageTitle();
		System.out.println("====================================");
		System.out.println("Bank Page title  " +actual);
		System.out.println("====================================");
		Assert.assertTrue(actual.contains(expectedtitle));
		System.out.println("====================================");
	}

	@Then("User_is Navigated to AddBanks Page")
	public void user_is_navigated_to_add_banks_page() {
		addbankdetails= bhimanhome.enterbankdetails();
	}

	@When("user_enters Bank-Name {string}")
	public void user_enters_bank_name(String bankname) throws InterruptedException {
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.cssSelector("#bank_name")).sendKeys(bankname);
	}

	@When("Alert-Message_is {string} displayed")
	public void alert_message_is_displayed(String exp) {
		 String bankalert="//span[@id='bankerr']";
		//expected error text
			    exp = "Please Enter Proper Bank Name";
		//identify actual error message
			     WebElement m = driver.findElement(By.xpath(bankalert));
			     String act = m.getText();
				 System.out.println("Error message is: "+ act);
		//verify error message with Assertion
			      Assert.assertEquals(exp, act);
	}

	
}
