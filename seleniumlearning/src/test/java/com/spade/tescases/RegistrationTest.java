package com.spade.tescases;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;
import com.spade.utility.BaseClass;
import com.spade.utility.ReadExcel;

public class RegistrationTest extends BaseClass{
	
	WebDriverWait wait1 = null;
	@BeforeTest
	public void loginintomotorTest() throws InterruptedException, EncryptedDocumentException, IOException {
		Login();
		this.wait1 = new WebDriverWait(driver, 20);
	}
	
	@AfterTest
	public void close() throws InterruptedException {
		closebrowser();
	}

	 @Test(priority=1)
	  public void  verify_registrationpage() throws IOException, InterruptedException {
		 Thread.sleep(2000);
		 driver.findElement(By.id("Registration-link")).click();
		 String Actualtitle=  driver.getCurrentUrl();
		String expected="http://192.168.11.125:8039/MotorInsuranceApp/#/Registration";
		assertEquals(Actualtitle, expected);
	    System.out.println("\n Registration module Title verified");	
	    }
		
		
  @Test(priority=2)
  //public void loginintotheApplication() throws InterruptedException{}
  
  public void registration() throws InterruptedException, IOException {
	  Thread.sleep(4000);	 
	 driver.findElement(By.xpath("//input[@value='New']")).click(); 
	 
	 		 
 //New registration credentials dialog for Own Damage Claim Type
	 Thread.sleep(2000);
	// driver.findElement(By.id("POLICY_NUMBER")).sendKeys("P/102/06/5011/2016/500/459");
	 driver.findElement(By.id("POLICY_NUMBER")).sendKeys(ReadExcel.getAccTabValue(1, 0,"policy_details"));
	//driver.findElement(By.id("sequenceId")).sendKeys("585273010");
	 driver.findElement(By.id("sequenceId")).sendKeys(ReadExcel.getsequenceId());
	 driver.findElement(By.xpath("//span[@aria-owns='AccidentTypeDropDown_listbox']")).click();
     WebElement AccList = wait1.until(ExpectedConditions.elementToBeClickable((By.xpath("//ul[@id='AccidentTypeDropDown_listbox']/li[2]")))); 
     AccList.click();
	// driver.findElement(By.id("ACCIDENT_DATE")).sendKeys("05/09/2017");
     driver.findElement(By.id("ACCIDENT_DATE")).sendKeys(ReadExcel.getAccTabValue(1, 2,"policy_details"));
	 driver.findElement(By.xpath("//input[@value='Create']")).click();
	 Thread.sleep(4000);
  	 
// Accident Data tab
	 
	driver.findElement(By.xpath("//b[text()='Accident Data']")).click(); 
	 //driver.findElement(By.xpath("//li[@id='accidentData']")).click(); 
	 Thread.sleep(4000);
	 driver.findElement(By.xpath("//input[@name='PoliceReportNumber']")).sendKeys("1654545");
	 
//Intimation Date
	 
	 driver.findElement(By.xpath("(//span[@class='k-icon k-i-calendar'])[4]")).click();
    // Thread.sleep(4000);     
     WebElement IntimationDate  = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='December 2019']")));
     IntimationDate.click();     
   //  driver.findElement(By.xpath("//a[text()='November 2019']")).click();
   //  Thread.sleep(2000);
     driver.findElement(By.xpath("(//span[@class='k-icon k-i-arrow-w'])[5]")).click();
     Thread.sleep(2000);
     driver.findElement(By.xpath("(//span[@class='k-icon k-i-arrow-w'])[5]")).click();
     Thread.sleep(3000);
     driver.findElement(By.xpath("//a[contains(.,'Sep')]")).click();
     Thread.sleep(3000);
     driver.findElement(By.xpath("//a[contains(.,'18')]")).click();
     Thread.sleep(2000);
	 
   
//Select check box
	 WebElement Hit_Run = driver.findElement(By.id("HIT_RUN_CASE_YN"));
	 Hit_Run.click();
	 
	 WebElement Theft = driver.findElement(By.id("VTheft"));
	 Theft.click();
	 
	 
 //Select radio button
	// WebElement radio1 = driver.findElement(By.id("eq27"));
	// radio1.click();
	 
				 
 //Accident City Code 1 	
	 driver.findElement(By.xpath("//span[text()='Select Accident City']")).click();
     Thread.sleep(2000);
     WebElement accCityDropdown = driver.findElement(By.xpath("(//li[contains(.,'ARAR')])[2]"));
     accCityDropdown.click();
     Thread.sleep(2000);

	   
 //Natural Peril
   	 WebElement NaturalPeril = driver.findElement(By.id("NATURAL_PERIL_YN"));
   	 NaturalPeril.click();	 
   	 driver.findElement(By.xpath("//div[@id='padBoxes']//div[8]")).click();
   	 Thread.sleep(4000);
   	 WebElement city =	driver.findElement(By.xpath("//input[@aria-owns='naturalPerilDropDown_listbox']"));
     city.sendKeys("VOLCANO");
     Thread.sleep(2000);
     city.sendKeys(Keys.ENTER);
   	 Thread.sleep(2000);
   	 driver.findElement(By.xpath("(//span[@class='k-icon k-i-arrow-s'])[21]")).click();
   	 Thread.sleep(3000);
   	 driver.findElement(By.xpath("//div[@id='eventCodeDropDown-list']/div/ul/li[1]")).click();
   	 System.out.println("\n Natural Peril Type and Event selected");
    	    	 
   
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
	 
	 
// Liability
	 
	 driver.findElement(By.xpath("//span[@aria-owns='LiabilityPctDropDown_listbox']"));
	 WebElement Liability = wait1.until(ExpectedConditions.elementToBeClickable((By.xpath("(//span[@class='k-icon k-i-arrow-s'])[22]"))));
     Liability.click();
     Thread.sleep(2000);
     driver.findElement(By.xpath("(//ul[@id='LiabilityPctDropDown_listbox']/li[4])[2]")).click();
     System.out.println("\n Liability seleceted");
	 //wait1.until(ExpectedConditions.elementToBeClickable((By.xpath("(//li[contains(.,'25')])[3]"))));
	 //driver.findElement(By.xpath("(//li[contains(.,'25')])[3]")).click();
	 
	 
// Email
	 driver.findElement(By.id("EMAIL")).clear();
	 driver.findElement(By.id("EMAIL")).sendKeys("hello@gmail.com");
		 
		 
//Bank Details
	 WebElement Cheque = driver.findElement(By.id("CHEQUE_NEEDED"));
	 Cheque.click();
	
//Estimate Amount 	 
	 System.out.println(driver.findElement(By.xpath("//span[@class='k-numeric-wrap k-state-default']/input[1]")).isDisplayed());      
     driver.findElement(By.xpath("//span[@class='k-numeric-wrap k-state-default']/input[1]")).sendKeys("75000");
	 	
// Required Docs: Own Damage
    Thread.sleep(2000);
     driver.findElement(By.xpath("//b[contains(text(),'Required Docs')]")).click();
     Thread.sleep(2000);
     driver.findElement(By.id("mdoc_0")).click();
 	 Thread.sleep(500);driver.findElement(By.id("mdoc_1")).click();
 	 Thread.sleep(500);driver.findElement(By.id("mdoc_2")).click();
 	 Thread.sleep(500);driver.findElement(By.id("mdoc_3")).click();
 	 Thread.sleep(500);driver.findElement(By.id("mdoc_4")).click();
 	 Thread.sleep(500);driver.findElement(By.id("mdoc_5")).click();
 	 Thread.sleep(500);driver.findElement(By.id("mdoc_6")).click();
 	 Thread.sleep(500);driver.findElement(By.id("mdoc_7")).click();
 	 Thread.sleep(500);

   	 
// Attachment Tab
   	Thread.sleep(2000);
    driver.findElement(By.xpath("//b[contains(text(),'Attachment')]")).click();
    Thread.sleep(2000);
    WebElement attachment =  driver.findElement(By.id("attachControl"));
    Thread.sleep(4000);
    attachment.sendKeys("C:\\Users\\arpit\\Pictures\\selenium\\mclaren.jpg");
    Thread.sleep(4000);
	//attachment.sendKeys(Keys.ENTER);
    
// SMS Tab
    System.out.println("\n Entering SMS now");
    driver.findElement(By.id("SMS")).click();
    WebElement SMSList = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='SMSTab']/div/div/div[2]/span")));
    SMSList.click();
	WebElement SMS = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='manualSMSDropDown_listbox']/li[2]")));
	SMS.click();
	Thread.sleep(200);
    System.out.println("\n SMS: Drop down select successful");
  	WebElement SendButton = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Send']")));
  	SendButton.click();
    System.out.println("\n SMS: Send successful");
    
// Archive Tab
   
    System.out.println("\n Entering Archive");
    WebElement Archive = wait1.until(ExpectedConditions.elementToBeClickable(By.id("archive")));
    Archive.click();
    driver.findElement(By.id("archiveNo")).sendKeys("Registration Archive");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//form[@id='ArchiveTabNew']/div/div/div/input[@type='button']")).click();
    Thread.sleep(2000);
    System.out.println("\n Archive entered");
	 
// Remarks Tab
	System.out.println("\n Entering Remarks");
	 WebElement Remarks = wait1.until(ExpectedConditions.elementToBeClickable(By.id("registrationRemarksTab")));
	 Remarks.click();
	 Thread.sleep(500);
	 driver.findElement(By.xpath("//textarea[@name='RemarkSend']")).sendKeys("Remarks for NEW Registration Claim");	 
	 Thread.sleep(500);
	 driver.findElement(By.xpath("//input[@value='Add Remarks']")).click();
	 System.out.println("\n Remarks added"); 
	 
//Get registration ID by clicking on SAVE button
	  driver.findElement(By.xpath("//input[@id=\'saveId\']")).click();	  
	  Thread.sleep(2000);
	  driver.findElement(By.id("yesButton")).click();
	  Thread.sleep(4000);
	 wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Save success']")))) ;
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  File dest=new File(".\\src\\main\\java\\com\\spade\\screenshots\\screeshot1.png");
	 Files.copy(src, dest);
	 String RegId=driver.findElement(By.xpath("//div[@id='myDialogWindow']/div/div")).getText();
	 System.out.println("RegID :"+RegId);
	 getRegID(RegId);
	 driver.findElement(By.id("okButton")).click();
	 
  }
}
// Extra Code
// dynamic xpath identification
// ul[@class="ng-pristine ng-untouched ng-valid k-tabstrip-items
// k-reset"]/li[3]/span[2]/b

// get number of elements in page
// List<WebElement> linkcount= driver.findElements(By.xpath("//a"));
// System.out.println(linkcount.size());

/*
 * FluentWait<WebDriver> wait = null;
 * wait.until(ExpectedConditions.visibilityOf(accCityDropdown));
 * accCityDropdown.sendKeys("ABHA"); accCityDropdown.sendKeys(Keys.ENTER);
 * 
 */
