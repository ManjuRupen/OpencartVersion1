package TestCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import PageObjects.ForgotPassword;
import PageObjects.HomePage;
import TestBase.BaseCase_Reusable;

public class TC_003_4gotPaswrd extends BaseCase_Reusable {
	
	@Test
	public void test_forgotpassword()
	{
		logger.info("starting test case TC_003_4gotPaswrd ");
		
		
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
			
			ForgotPassword fp= new ForgotPassword (driver);
			fp.forgotpassword();
			
			
			
		}
		catch (Exception e)
		{
			logger.fatal("test failed");
			Assert.fail();
				
		}
		logger.info("finshed test case TC_003_4gotPaswrd");
	}
}
