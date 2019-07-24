package com.spade.tescases;

import org.testng.annotations.Test;

import com.spade.utility.BaseClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;




public class RegistrationTest extends BaseClass{

	
	@BeforeMethod
	public void loginintomotorTest() {
		Login();
	}
	
	@AfterMethod
	public void close() throws InterruptedException {
		closebrowser();
	}

  @Test(priority=1)
  //public void loginintotheApplication() throws InterruptedException{}
  public void Registration() throws InterruptedException {
	  
	 Thread.sleep(2000);
	 driver.findElement(By.id("Registration-link")).click();
	 driver.findElement(By.xpath("//input[@value='New']")).click(); 
	//get number of elements in page
	 //List<WebElement> linkcount= driver.findElements(By.xpath("//a"));
	 //System.out.println(linkcount.size());
	 
 //New registration credentials dialog
	 Thread.sleep(2000);
	 driver.findElement(By.id("POLICY_NUMBER")).sendKeys("P/102/06/5011/2016/500/459");
	 driver.findElement(By.id("sequenceId")).sendKeys("585273010");
	 driver.findElement(By.xpath("//span[@aria-owns='AccidentTypeDropDown_listbox']")).click();
     Thread.sleep(2000);
     driver.findElement(By.xpath("//ul[@id='AccidentTypeDropDown_listbox']/li[2]")).click();
	 driver.findElement(By.id("ACCIDENT_DATE")).sendKeys("05/09/2017");
	 driver.findElement(By.xpath("//input[@value='Create']")).click();
	 Thread.sleep(4000);
	 
 // Accident Data tab
	 driver.findElement(By.xpath("//b[text()='Accident Data']")).click();
	 Thread.sleep(4000);
	 
//Select check box
	 WebElement Hit_Run = driver.findElement(By.id("HIT_RUN_CASE_YN"));
	 Hit_Run.click();
	 
	 WebElement Theft = driver.findElement(By.id("VTheft"));
	 Theft.click();
	 
	 
	 
 //Select radio button
	/* WebElement radio1 = driver.findElement(By.id("eq27"));
	 radio1.click();
	 */
		//Thread.sleep(800);driver.findElement(By.xpath("(//div[@id='comboDateDropDown']/span/span/span)[26]")).click();
		// driver.findElement(By.xpath("//*[@id='comboDateDropDown']/span/span/span[1]")).click();
	 
		
	 //driver.findElement(By.id("INTIMATION_DATE")).sendKeys("06/09/2017");
	//driver.findElement(By.id("POLICE_REPORT_NO")).sendKeys("1654545");
	 
 //Accident City	Code 1 
	 /*driver.findElement(By.xpath("//span[@aria-owns='accCityDropDown_listbox']")).click();
     Thread.sleep(2000);
     driver.findElement(By.xpath("//ul[@id='accCityDropDown_listbox']/li[2]")).click();*/
	 
	//Accident City	Code 2 
	/* WebDriverWait wait1 = new WebDriverWait(driver, 20);
	 WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@aria-owns='accCityDropDown_listbox']")));
	 element1.click();*/
     
// Claimant Details	 
  	 driver.findElement(By.id("CLAIMANT_ID")).sendKeys("1452365895");
	 driver.findElement(By.id("CLAIMANT_NAME")).sendKeys("Sameer");
	 driver.findElement(By.id("MOBILE_NO")).sendKeys("0542356895");
	 
// Leased Vehicle Details
	 WebElement Leased = driver.findElement(By.id("LEASED_VEHICLE_YN"));
	 Leased.click();
	 driver.findElement(By.id("LEASED_CLIENT_ID")).sendKeys("1452356895");
	 driver.findElement(By.id("LEASED_CLIENT_NAME")).sendKeys("Sohan");
	 driver.findElement(By.id("LEASED_MOBILE_NO")).sendKeys("0578596568");	
	 
//Bank Details
	 WebElement Cheque = driver.findElement(By.id("CHEQUE_NEEDED"));
	 Cheque.click();
	 driver.findElement(By.id("ESTIMATE_AMOUNT")).sendKeys("80000");
	 
//Get registration ID by clicking on SAVE button
	/* driver.findElement(By.xpath("//input[@id=\'saveId\']")).click();
	 Thread.sleep(10000);*/
	
	 // dynamic xpath identification
	//ul[@class="ng-pristine ng-untouched ng-valid k-tabstrip-items k-reset"]/li[3]/span[2]/b
	 
	 
	 
	 
	 
	 
  }
 


}
