package parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.pages.BhimanHomePage;
import com.pages.BhimanPage;
import com.pages.SalesPrint;
import com.pages.Transactions;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class SwitchToParentTabSteps {
	private static WebDriver driver=DriverFactory.getDriver();
	private BhimanHomePage bhimanhome = new BhimanHomePage(DriverFactory.getDriver());
	private Transactions trans = new Transactions(DriverFactory.getDriver());
	BhimanPage bhimanpage;
	private SalesPrint saleprnt=new SalesPrint(DriverFactory.getDriver());
	private static String title;
	
	
	@Given("Logs_In_BhimanApplication")
	public void logs_in_bhiman_application() {
		DriverFactory.getDriver().get("http://103.50.162.196/testing/user-login.php");;
	}

	@When("User _logs_BHiman_Username")
	public void user__logs_b_himan_username() throws InterruptedException {
		trans  =PageFactory.initElements(DriverFactory.getDriver(),Transactions.class);
		trans.enterusername();
	}

	@When("User _logs_BHiman_Password")
	public void user__logs_b_himan_password() {
		trans.enterspassword();
	}

	@When("Clicks _on_Bhiman Login-Button")
	public void clicks__on_bhiman_login_button() {
		 trans.clickloginButton();
	}

	@When("User Mouse_-Howers the_Transaction-Tab and click-Sales")
	public void user_mouse_howers_the_transaction_tab_and_click_sales() {
		trans.transactiontab();
	}

	@When("User Clicks_on_Print-Button & Opens-Browser in New_Tab")
	public void user_clicks_on_print_button_opens_browser_in_new_tab() {
		//Click on the Print Button
		driver.findElement(By.xpath("//button[@class='dt-button buttons-print']/span")).click();

	
	}

	@When("User Navigates_back to_SalesTab")
	public void user_navigates_back_to_sales_tab() {
		//Click on the Print Button
	   driver.findElement(By.xpath("//button[@class='dt-button buttons-print']/span")).click();
		Set<String> windowsIds=driver.getWindowHandles();
		List<String> windowsList=new ArrayList(windowsIds);

		String parentWindowsTab=windowsList.get(0);
		String childWindowsTab=windowsList.get(1);
		
		
		for(String windowsId:windowsList)
		{
			String sale="Sales";
			String title=driver.switchTo().window(windowsId).getTitle();
			
			String childTaburl="about:blank";
			
		String Url=	driver.switchTo().window(windowsId).getCurrentUrl();
		
		
		if(Url.equals(childTaburl))
		{
			driver.close();
		}

		
			if(title.equals(sale))
			{
				
				driver.switchTo().window(parentWindowsTab);
			}
			
			
			

			
		}

	}
}
