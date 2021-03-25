package TestCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import TestBase.BaseCase_Reusable;

public class TC_002_Login extends BaseCase_Reusable{
	
	@Test
	public void test_login()
	{
		logger.info("starting test case TC_002_Login");
		
		
		try
		{
			driver.get(rb.getString("appURL"));
			logger.info("home page displyed");
			
			driver.manage().window().maximize();
			
			HomePage hp=new HomePage (driver);
			hp.clickMyAccount();
			logger.info("clicked in my a/c");
			hp.clickLogin();
			logger.info("clicked on login");
			
			LoginPage lp= new LoginPage(driver);
			
			lp.setEmail(rb.getString("email"));
			logger.info("email entered");
			
			lp.setPassword(rb.getString("password"));
			logger.info("pwd entered");
			
			lp.clickLogin();
			logger.info("clicked on login");
			
			boolean targetpage=lp.isMyAccountPageExsits();
			if (targetpage==true)
			{
				logger.info(" login successful");
				Assert.assertTrue(true);
			}
			else
			{
				logger.info(" login unsuccessful");
				captureScreen(driver,"test_Login");
				Assert.assertTrue(false);
			}
		}
		catch (Exception e)
		{
			logger.fatal("login failed");
			Assert.fail();
				
		}
		logger.info("finshed test case TC_002_Login");
	}
}
