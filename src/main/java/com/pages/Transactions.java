package com.pages;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.factory.DriverFactory;

public class Transactions extends DriverFactory{
	
	
	private static  WebDriver driver=DriverFactory.getDriver();
	
	public Transactions(WebDriver driver) {
		this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	
	 public Transactions() {
	        this.driver = DriverFactory.getDriver();
	        PageFactory.initElements(this.driver, this);
	        
	    }
	 
		@FindBy(xpath="//input[@name='username']")
		WebElement username;
	 
	 	@FindBy(xpath="//input[@id='password']")
		WebElement password;
		
		@FindBy(xpath="//button[normalize-space()='Login']")
		WebElement loginBtn;
		
		@FindBy(xpath="//span[contains(text(),'Transactions')]")	
		WebElement Transaction_Tab;
		
		@FindBy(xpath="//a[normalize-space()='Sales']")
		WebElement Sales_Link;
		
		
		
		
		@FindBy(xpath="//a[@id='add_btn']")
		WebElement clicksales;
		
		String print_Button="//span[contains(normalize-space(),'Print')]";
	 
		public String getLoginPageTitle() {
			return driver.getTitle();
		}
	 
	 
	 public void enterusername() throws InterruptedException
	 {
		 
		
		 username.sendKeys("9876543211");
	 }
	 
	 public void enterspassword()
	 {
	
		 password.sendKeys("admin");
	 }
	 
	 
	 public void invalidPassword()
	 {
		 password.sendKeys("admin123");
	 }
	 
	 public void clickloginButton()
	 {
		 loginBtn.click();
	 }
	 
	 public void transactiontab()
	 {
		 Actions action=new Actions(driver);
			new WebDriverWait(driver, 2000).until(ExpectedConditions.visibilityOf(Transaction_Tab));
			action.moveToElement(Transaction_Tab).build().perform();
			Sales_Link.click();
		//return new Transactions();
		 
	 }
	 public SalesPrint clickPrint()
	 {
	driver.findElement(By.xpath(print_Button)).click();//click on print button
	Set<String> windowsIDs=driver.getWindowHandles(); //return ids of multiple tabs
	
	Iterator<String> it=windowsIDs.iterator();
	
	 String parentWindowID=it.next();
	 String childWindowId=it.next();
	 
	 System.out.println("Parent Window Id " +parentWindowID);
	 System.out.println("Child Window Id " +childWindowId);
	return new SalesPrint();
		
		 
	 }
	 
	 
	 public SalesNumericTextbox clickSalesButton()
	 {
		 clicksales.click();
		return new SalesNumericTextbox();
		 
	 }
	
}
