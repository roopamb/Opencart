package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	
 
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath= "//span[text()='My Account']")
	WebElement lnkMyaccont;
	
	@FindBy(xpath= "//a[text()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath= "//a[text()='Login']")
	WebElement lnckLogin;
	
	
	
	//Action methods
	public void clickMyaccount() {
		lnkMyaccont.click();
	}
	
	public void clickRegister() {
		lnkRegister.click();
	}
	public void clickLogin() {
		lnckLogin.click();
	}
}
