package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver diver) {
		super(diver);
		
	}
	
	
	@FindBy(css="input[name='firstname']")
	WebElement txtFirstName;
	
	@FindBy(css="input[name='lastname']")
	WebElement txtLasttName;
	
	@FindBy(css="input[name='email']")
	WebElement txtEmail;
	
	@FindBy(css="input[name='password']")
	WebElement txtPassword;
	
	@FindBy(css="input[type='checkbox']")
	WebElement checkPolicy;
	
	@FindBy(xpath="//button[text()='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	
	
	public void setFirstname(String fname) {
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastname(String lname) {
		txtLasttName.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String pswd) {
		txtPassword.sendKeys(pswd);
	}
	
	public void setPrivacyPolicy() {
		checkPolicy.click();
	
	}
	
	public void clickContinue() {
		btnContinue.click();
		
		
		
		
	}
	
	
	public String clickConfirmationmsg() {
		
		
		try {
			return (msgConfirmation.getText());
		}
		catch(Exception e){
			
		return	(e.getMessage());
		}
	}
	

}
