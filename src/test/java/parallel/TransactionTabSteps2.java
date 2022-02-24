package parallel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.pages.BhimanHomePage;
import com.pages.BhimanPage;
import com.pages.SalesPrint;
import com.pages.Transactions;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class TransactionTabSteps2 {

	private static WebDriver driver=DriverFactory.getDriver();
	private BhimanHomePage bhimanhome = new BhimanHomePage(DriverFactory.getDriver());
	private Transactions trans = new Transactions(DriverFactory.getDriver());
	BhimanPage bhimanpage;
	private SalesPrint saleprnt=new SalesPrint(DriverFactory.getDriver());
	private static String title;
	
	//=================================================================================
	
	@Given("Login_In_BhimanApplication")
	public void login_in_bhiman_application() {
		DriverFactory.getDriver().get("http://103.50.162.196/testing/user-login.php");;
	}
	
	


	@When("User logs_BHiman_Username")
	public void user_logs_b_himan_username() throws InterruptedException {
		trans  =PageFactory.initElements(DriverFactory.getDriver(),Transactions.class);
		trans.enterusername();
	}

	@When("User logs_BHiman_Password")
	public void user_logs_b_himan_password() {
		trans.enterspassword();
	}

	@When("Clicks on_Bhiman Login-Button")
	public void clicks_on_bhiman_login_button() {
		 trans.clickloginButton();
	}

	@When("User Mouse Howers the_Transaction-Tab and click-Sales")
	public void user_mouse_howers_the_transaction_tab_and_click_sales() {
		trans.transactiontab();
	}

	@When("User Clicks on Print-Button & Opens-Browser in New_Tab")
	public void user_clicks_on_print_button_opens_browser_in_new_tab() {
		trans.clickPrint();  
	}

	@When("User Navigates back to SalesTab")
	public void user_navigates_back_to_sales_tab() {
		saleprnt.switchParentTab();
	}

}
