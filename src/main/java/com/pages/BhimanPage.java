package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.factory.DriverFactory;

public class BhimanPage extends DriverFactory{

	
	private WebDriver driver=DriverFactory.getDriver();
	
	public BhimanPage(WebDriver driver) {
		this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	
	 public BhimanPage() {
	        this.driver = DriverFactory.getDriver();
	        PageFactory.initElements(this.driver, this);
	    }
	 
	 
	 	@FindBy(xpath="//input[@name='username']")
		WebElement username;
	 
	 	@FindBy(xpath="//input[@id='password']")
		WebElement password;
		
		@FindBy(xpath="//button[normalize-space()='Login']")
		WebElement loginBtn;
	 
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
	 
	 public BhimanHomePage dologin() throws InterruptedException
	 {
		 //enterusername();
		// enterspassword();
		 clickloginButton();
		 
		return new BhimanHomePage();
		 
	 }
	 

}
