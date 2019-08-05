package com.spade.utility;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;


public class BaseClass {
	
	public static WebDriver driver=null;
	
	public static void Login() throws InterruptedException {
	    
		  System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  //implicit wait
		  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		  driver.get("http://192.168.11.125:8039/MotorInsuranceApp/#/Login");
		  driver.findElement(By.id("username")).clear();
		  driver.findElement(By.id("username")).sendKeys("aa");
		  driver.findElement(By.id("Password")).clear();
		  driver.findElement(By.id("Password")).sendKeys("aa");
		  driver.findElement(By.id("loginButtonid")).click();
		 		  
	
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
