package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.factory.DriverFactory;

public class BanksPage {
	
	//WebDriver
	
 static WebDriver driver=DriverFactory.getDriver();
	
	//=================== Elements Intialization
		public BanksPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver = driver;
			
		}
		 public BanksPage() {
		        this.driver = DriverFactory.getDriver();
		        PageFactory.initElements(this.driver, this);
		       
		    }
		
}
