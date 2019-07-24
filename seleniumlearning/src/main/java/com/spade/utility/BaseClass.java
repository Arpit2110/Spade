package com.spade.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseClass {
	
	public static WebDriver driver=null;
	
	public static void Login() {
	    
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

	
}
