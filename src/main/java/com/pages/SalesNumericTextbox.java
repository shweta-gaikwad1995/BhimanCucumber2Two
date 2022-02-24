package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.factory.DriverFactory;

public class SalesNumericTextbox extends DriverFactory{

	
	
	
	private static  WebDriver driver=DriverFactory.getDriver();
	
	//==================================================================================
	
	public SalesNumericTextbox(WebDriver driver) {
		this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	
	 public SalesNumericTextbox() {
		 this.driver = DriverFactory.getDriver();
	      
	        PageFactory.initElements(this.driver, this);
	        
	    }
	 
	//===============================WebElements ============================ 
	
	 @FindBy(xpath="//input[@id='commission']")
	 WebElement brokerstextbox;
	 
	 
	 
	 
	//=============================Actions=========================================== 
	 
	 public void clickBrokersNumericTextBox() {
		 for(int i = 10; i <40 ; i++) {
			 brokerstextbox.sendKeys(Keys.ARROW_UP);
			}
	 }
	 
	 
	 
}
