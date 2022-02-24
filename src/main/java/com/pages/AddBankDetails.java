package com.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
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


public class AddBankDetails extends DriverFactory{
	
     private static XSSFWorkbook workbook;
     private static XSSFSheet sheet;
     private static XSSFCell cell;
     

		//WebDriver
	
 static WebDriver driver=DriverFactory.getDriver();
	
	
	private By bankname1 = By.xpath("//input[@id='bank_name']");
	private By accountname1=By.xpath("//input[@id='account_name']");
	
	
	private By bankAlertText=By.cssSelector("#bankerr");
	
	private By banklogo=By.xpath("(//h2)[1]");
	public static String AlertMessages="//label//span";
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement submit;
	
	private By accountno2=By.xpath("//input[@id='account_no']");
	
	
	
	//=================== Elements Intialization
	public AddBankDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		
	}
	 public AddBankDetails() {
	        this.driver = DriverFactory.getDriver();
	        PageFactory.initElements(this.driver, this);
	       
	    }
	 
	
	// 3. page actions: features(behavior) of the page the form of methods:

			public String getAddBankTitle()
			{
				return driver.getTitle();
			}

			public boolean banklogo()
			{
				
				return driver.findElement(banklogo).isDisplayed();
			}
			
		//===================Enter Bank Details=========================	
		
			public void enteraccountnum(String accountno) {
				driver.findElement(accountno2).sendKeys(accountno);
			}
			
			public void enterBankName(String bankname) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(bankname1).sendKeys(bankname);
			}
		
			public void bankAlertText(String bankalert)
			{
		        
				driver.findElement(bankAlertText).sendKeys(bankalert);
			}
			
		
			public void submitButton() {
				new WebDriverWait(driver, 2000).
				until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Submit']"))).click();
				
				
			}
			
			 public void BankForm(String bankna, String acc_name) {
					
					driver.findElement(bankname1).sendKeys(bankna);
					driver.findElement(accountname1).sendKeys(acc_name);
				
				}
			 
			
			 public void accountdata() throws IOException
			 {
				
				 FileInputStream fis = new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\BhimanCucumber\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCrmTestData.xlsx");
			        XSSFWorkbook wb = new XSSFWorkbook(fis);
			        XSSFSheet sheet = wb.getSheet("addbank");
			        int rowCount = sheet.getLastRowNum();
			     
				
			        System.out.println("the no of rows are : " + rowCount);
				
				for (int row=1; row<=rowCount; row++)
				{ 
					String bankname = sheet.getRow(row).getCell(0).getStringCellValue();
				 String accountholder = sheet.getRow(row).getCell(1).getStringCellValue();

				 int accountno=(int) sheet.getRow(row).getCell(2).getNumericCellValue();
				 String accountype = sheet.getRow(row).getCell(3).getStringCellValue();

				 System.out.println(bankname + " , " + accountholder + " , " +accountno + " , "+accountype);
				 }
			 }
			public void  bankFomr() throws IOException
			{
				
				File file =new File("C:\\Users\\admin\\eclipse-workspace\\BhimanCucumber\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCrmTestData.xlsx");
		        FileInputStream fis=new FileInputStream(file);
		        workbook =new XSSFWorkbook(fis);
		   
		        sheet = workbook.getSheet("addbank");
		      cell= sheet.getRow(1).getCell(2);
		        DataFormatter dd=new DataFormatter();
		        String accounttype= dd.formatCellValue(cell);
		        cell= sheet.getRow(2).getCell(2);
		        accounttype=dd.formatCellValue(cell);
		        driver.findElement(By.xpath("//input[@id='account_no']")).sendKeys(accounttype);
			
		     
		 
			
			}
			
			
			//SubmitButton
			public void bankpage()
			{
				
				new WebDriverWait(driver, 20).until
				(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Submit']"))).click();
				 // identify element
			      driver.findElement(By.xpath("//input[@value='Submit']")).click();
			      // Alert interface and switchTo().alert() method
			      Alert al = driver.switchTo().alert();
			      // click on OK to accept with accept()
			      al.accept();
	
			}
			
			//Navigation back to banks Page
			public BanksPage clickokay() throws InterruptedException
			{
				//BanksPage Url
				String banksUrl = "http://103.50.162.196/testing/bank.php";
				driver.get(banksUrl);

				//Selemium TimeOutException
				WebDriverWait wait__mob = new WebDriverWait(driver, 20);
				try {
				    
				    wait__mob.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div/div/button[1]"))).sendKeys(Keys.ENTER);
				    driver.navigate().to(banksUrl);
				} catch (TimeoutException e) {
				    System.out.println(e.getMessage());
				} 
				
				 //Click on Okay Button
				//driver.findElement(By.xpath("//body/div/div/button[1]")).sendKeys(Keys.ENTER);
			
				// Go back to Home Page
				//driver.navigate().to(banksUrl);
				return new BanksPage();
				
			}
			
			
			
			
}

