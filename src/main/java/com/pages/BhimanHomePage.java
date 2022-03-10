package com.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.qa.factory.DriverFactory;

public class BhimanHomePage extends DriverFactory{
	
	
	
	private WebDriver driver=DriverFactory.getDriver();
	
	private By bankname1 = By.xpath("//input[@id='bank_name']");
	private By accountname1=By.xpath("//input[@id='account_name']");
	private By accountno1=By.xpath("//input[@id='account_no']");
	private By ifsc_code1=By.xpath("//input[@id='ifsc_code']");
	private By micr_code1=By.xpath("//input[@id='micr_code']");
	
	
	//===========================================================
	
	@FindBy(xpath="//a[@id='add_btn']")
	WebElement addbankbtn;
	
	@FindBy(xpath="//body/div[3]/nav[1]/ul[1]/li[2]/a[1]")
	WebElement MastersTab;
	
	@FindBy(xpath="//a[starts-with(text(),'Banks ')]")
	WebElement BanksLink;
	
	@FindBy(xpath="//li[1]//a[1]//span[1]")	
	WebElement Transaction_Tab;
	
	@FindBy(xpath="//a[normalize-space()='Sales']")
	WebElement Sales_Link;
	
	

	
	public BhimanHomePage(WebDriver driver) {
		this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	
	 public BhimanHomePage() {
	        this.driver = DriverFactory.getDriver();
	        PageFactory.initElements(this.driver, this);
	        
	    }
	 
	
	// 3. page actions: features(behavior) of the page the form of methods:

		public String getHomePageTitle()
		{
			return driver.getTitle();
		}


		//========== Mouse Hower on MastersTab ==============
	
		
		public void BankLink() throws IOException
		{
			Actions action=new Actions(driver);
			new WebDriverWait(driver, 2000).until(ExpectedConditions.visibilityOf(MastersTab));
			action.moveToElement(MastersTab).build().perform();
			
			
			// new WebDriverWait(driver, 2000).until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@formcontrolname='reportingDealPermission']"))); 
			//((JavascriptExecutor)driver).executeScript("arguments[0].click();", BanksLink);
			BanksLink.click();	
			
		}
		
		
		
//=============Click on AddBankButton and navigate on AddBankPage==================
		
		public AddBankDetails enterbankdetails()
		{
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='add_btn']")));
			 
		addbankbtn.click();
			return new AddBankDetails();
			
		}


		public void clickAddbank()
		{
			//new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='add_btn']")));	
			((JavascriptExecutor)driver).executeScript("arguments[0].click();",addbankbtn);
			addbankbtn.click();
		}
		
		 public void BankForm(String bankna, String acc_name,
		String acc_num,String accountno,String accounttype,String ifsc,
				  String micr  ) {
			 new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='bank_name']"))).sendKeys(bankna);	
			//	driver.findElement(bankname1).sendKeys(bankna);
				driver.findElement(accountname1).sendKeys(acc_name);
				
				driver.findElement(accountno1).sendKeys(accountno);
				Select select=new Select(driver.findElement(By.xpath("//select[@id='bank_account_type']")));
				select.selectByVisibleText(accounttype);
				driver.findElement(ifsc_code1).sendKeys(ifsc);
				driver.findElement(micr_code1).sendKeys(micr);
			
			}
		 
		 public void transactiontab()
		 {
			 Actions action=new Actions(driver);
				new WebDriverWait(driver, 2000).until(ExpectedConditions.visibilityOf(Transaction_Tab));
				action.moveToElement(Transaction_Tab).build().perform();
				Sales_Link.click();
			//return new Transactions();
			 
		 }
		
		
}
