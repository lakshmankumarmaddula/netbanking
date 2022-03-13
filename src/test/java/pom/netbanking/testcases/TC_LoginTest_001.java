package pom.netbanking.testcases;


import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.netbanking.pageobjects.Loginpage;

public class TC_LoginTest_001 extends BaseClass {
	
	
	@Test
	public void LoginTest() throws InterruptedException, IOException {
		
		Loginpage lp=new Loginpage(driver);
		lp.setUserName(username);		
		lp.setPassword(password);
		lp.clickLogin();
		Thread.sleep(5000);
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
		}
		
		else
		{
			captureScreen(driver,"LoginTest");
			Assert.assertTrue(false);
			
		}
		
	}
}


