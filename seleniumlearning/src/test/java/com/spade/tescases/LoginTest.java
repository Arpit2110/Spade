package com.spade.tescases;

import com.spade.utility.BaseClass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;




public class LoginTest extends BaseClass{
	
	@BeforeMethod
	public void login() throws InterruptedException {
		 Login();
	}
	
	@AfterMethod
	public void close() throws InterruptedException {
		closebrowser();
	}

  
  /*
  @Test
  public void verify_homepagetitle() {
	  
	  
	  
  }
  @Test
  public void verify_Homepageurl() {
	  
	  
	  
  }
*/

}
