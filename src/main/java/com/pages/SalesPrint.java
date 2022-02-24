package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.factory.DriverFactory;

public class SalesPrint extends DriverFactory{

	
private WebDriver driver=DriverFactory.getDriver();
	
	public SalesPrint(WebDriver driver) {
		this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	
	 public SalesPrint() {
	        this.driver = DriverFactory.getDriver();
	        PageFactory.initElements(this.driver, this);
	        
	    }

	 public void clickprintbutton() throws AWTException, InterruptedException
		{
		 
			//new WebDriverWait(driver, 20).until
			//(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='sidebar']//print-preview-button-strip//div/cr-button[1]"))).click();
			
			//driver.findElement(By.cssSelector("div > cr-button.action-button")).click();
		     
		      Thread.sleep(2000);

		   
		}
	 
	 // Opening a "newTab" and switching back to "parentTab"
	 public void switchParentTab()
	 {

		 			String print_Button="//span[contains(normalize-space(),'Print')]";
		 driver.findElement(By.xpath(print_Button)).click();//click on print button
		
		 
		
		 
		 
			Set<String> allwindowsHandles=driver.getWindowHandles(); //return ids of multiple tabs
			 String parentWindowID=driver.getWindowHandle();
			 for(String currentWindowHandle:allwindowsHandles)
				{
					
					if(!currentWindowHandle.equalsIgnoreCase(parentWindowID))
					{
						driver.switchTo().window(currentWindowHandle);
						
						System.out.println("CurrentWindowHandle ==== "  +  driver.getCurrentUrl());
						//driver.findElement(By.cssSelector("div > cr-button.action-button")).click();
				
						
						
					}
					driver.switchTo().window(currentWindowHandle);
					
				}
				
				driver.switchTo().window(parentWindowID);
	
		 

	 }
}
