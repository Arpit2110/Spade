package com.spade.utility;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;


public class BaseClass {
	
	public static WebDriver driver=null;
	
	public static void Login() throws InterruptedException, EncryptedDocumentException, IOException {
	    
		  System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  //implicit wait
		  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		  
	// Login details will read from code	 
		  
		/*  driver.get("http://192.168.11.125:8039/MotorInsuranceApp/#/Login");
		  System.out.println();
		  driver.findElement(By.id("username")).clear();
		  driver.findElement(By.id("username")).sendKeys("aa");
		  driver.findElement(By.id("Password")).clear();
		  driver.findElement(By.id("Password")).sendKeys("aa");
		  driver.findElement(By.id("loginButtonid")).click(); */
		  
   // Login details will from Excel
		  
		  driver.get("http://192.168.11.125:8039/MotorInsuranceApp/#/Login");
		  System.out.println();
		  driver.findElement(By.id("username")).clear();
		  driver.findElement(By.id("username")).sendKeys(ReadExcel.getvalue(1, 0,"login_motor"));
		  driver.findElement(By.id("Password")).clear();
		  driver.findElement(By.id("Password")).sendKeys(ReadExcel.getvalue(1, 1,"login_motor"));
		  driver.findElement(By.id("loginButtonid")).click(); 

	  }
	
	  public static void getRegID(String regIdMessage) {
		  System.out.println(">>>>>>>>>>>>>inside getRegId method: "+regIdMessage);
	
		  if(regIdMessage != null && !(regIdMessage.trim().equals(""))) {
			  Pattern p = Pattern.compile("\\d+");
			  Matcher m = p.matcher(regIdMessage);
			  String regIdStr = null;
			  while(m.find())
			  {
			      regIdStr = m.group();
			      System.out.println(regIdStr);
			      break;
			  }
			  if(regIdStr != null) {
				  int regId = Integer.parseInt(regIdStr);
				  System.out.println(regId);
			  }
			 			 
		  }
		 
		  
	  }
	 	  
	  public static void closebrowser() throws InterruptedException {

		  Thread.sleep(5000);
		  driver.quit();
	  }

	  public static void Takescreeshot(String filename) throws IOException {

		  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  File dest=new File(".src\\test\\java\\com\\spade\\screenshots\\screeshot1.png");
		 Files.copy(src, dest);

				}
}
