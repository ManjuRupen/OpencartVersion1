package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword {
	
WebDriver driver;
	
	public ForgotPassword(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='form-group']//a[normalize-space()='Forgotten Password']")
	WebElement forgot_password;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement Enter_email_2stPwd;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continueBtn;
	
	public void forgotpassword()
	{
		forgot_password.click();
	}
	
	public void EnterEmail(String email)
	{
		Enter_email_2stPwd.sendKeys(email);
	}
	
	public void clickLogin()
	{
		continueBtn.click();
	}
	

}
