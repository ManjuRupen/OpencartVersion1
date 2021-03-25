package TestCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.AccountRegistrationPage;
import PageObjects.HomePage;
import TestBase.BaseCase_Reusable;
import io.github.bonigarcia.wdm.WebDriverManager;
// adding to see second round of add and push command in GItHub
public class TC_001_AccountRegistration extends BaseCase_Reusable{
	
	@Test
	public void test_account_registration()
	{
		logger.info("TC_001_AccountRegistration");
		try
		{
			driver.get(rb.getString("appURL"));
			logger.info("home page displayed");
			
			driver.manage().window().maximize();
			
			HomePage hp=new HomePage (driver);
			hp.clickMyAccount();
			logger.info("clicked on my account");
			hp.clickRegister();
			
			AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
			regpage.setFirstName("Audrey");
			logger.info("Provided first Name");
			
			regpage.setLastName("Hepburn");
			logger.info("Provided last Name");
			regpage.setEmail(randomestring()+"@gmail.com");
			logger.info("Provided Email Address");
			regpage.setTelephone("65656565");
			logger.info("Provided Telephone number");
			regpage.setPassword("abcxyz");
			logger.info("Provided password");
			regpage.setConfirmPassword("abcxyz");
			logger.info("Provided  password  to confirm");
			regpage.setPrivacyPolicy();
			logger.info("accepted policy");
			
			regpage.clickContinue();
			logger.info("Clicked on continue button");

			String confmsg= regpage.getConfirmationMsg();
			
			 if(confmsg.equalsIgnoreCase("Your Account Has Been Created!"))
			 {
				logger.info("Account registration success");
				Assert.assertTrue(true); 
			 }
			 else
			 {
				 captureScreen(driver, "TC_001_AccountRegistratio");
				 logger.info("Account registration failed");
				 Assert.assertTrue(false);
			 }
		}
			catch (Exception e)
			{
				logger.fatal("account registration fail");
				Assert.fail();
			}
		logger.info("Finished TC_001_AccountRegistration");
		}
			 
	}
	
	
	

