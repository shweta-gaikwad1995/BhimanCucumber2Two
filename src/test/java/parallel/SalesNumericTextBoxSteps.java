package parallel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.pages.BhimanHomePage;
import com.pages.BhimanPage;
import com.pages.SalesNumericTextbox;
import com.pages.SalesPrint;
import com.pages.Transactions;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class SalesNumericTextBoxSteps {

	//private WebDriver driver=DriverFactory.getDriver();
	private static  WebDriver driver=DriverFactory.getDriver();
	private BhimanHomePage bhimanhome = new BhimanHomePage(DriverFactory.getDriver());
	private Transactions trans = new Transactions(DriverFactory.getDriver());
	BhimanPage bhimanpage;
	private SalesPrint saleprnt=new SalesPrint(DriverFactory.getDriver());
	private static String title;
	private static SalesNumericTextbox salesnum=new SalesNumericTextbox(DriverFactory.getDriver());
	
	
//====================================================================================	
	@Given("Login_In_BhimanApplications")
	public void login_in_bhiman_applications() {
		DriverFactory.getDriver().get("http://103.50.162.196/testing/user-login.php");
	}

	

	@When("User logs_BHiman_Usernames")
	public void user_logs_b_himan_usernames() throws InterruptedException {
		trans  =PageFactory.initElements(DriverFactory.getDriver(),Transactions.class);
		trans.enterusername();
	}

	@When("User logs_BHiman_Passwords")
	public void user_logs_b_himan_passwords() {
		trans.enterspassword();
	}

	@When("Clicks on_Bhimans Login-Button")
	public void clicks_on_bhimans_login_button() {
		 trans.clickloginButton();
	}

	@When("User Mouse Howers the_Transaction-Tabs and click-Sales")
	public void user_mouse_howers_the_transaction_tabs_and_click_sales() {
		trans.transactiontab();
	}
	
	@When("User Clicks on AddSales-Button")
	public void user_clicks_on_add_sales_button() {
	  trans.clickSalesButton();
	}

	
	@When("User Clicks the BrokersValue")
	public void user_clicks_the_brokers_value() {
		salesnum.clickBrokersNumericTextBox();
	}
	
}
