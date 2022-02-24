package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.factory.DriverFactory;

public class BhimanLoginData extends DriverFactory{

	
	//private WebDriver driver;
	private WebDriver driver=DriverFactory.getDriver();
	
	
	private By subjectHeading = By.xpath("//input[@id='username']");
	private By email = By.xpath("//input[@id='password']");
	
	
	
	
	public BhimanLoginData(WebDriver driver) {
		this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	
	 public BhimanLoginData() {
	        this.driver = DriverFactory.getDriver();
	        PageFactory.initElements(this.driver, this);
	        
	    }
	 
	 public void fillContactUsForm(String heading, String emailId) {
		
			driver.findElement(subjectHeading).sendKeys(heading);
			driver.findElement(email).sendKeys(emailId);
		
		}

	 
}
