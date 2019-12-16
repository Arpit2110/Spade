package com.spade.tescases;

import com.spade.utility.BaseClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;




public class TC_LoginTest extends BaseClass{
	
	@BeforeMethod
	public void login() throws InterruptedException, EncryptedDocumentException, IOException {
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
