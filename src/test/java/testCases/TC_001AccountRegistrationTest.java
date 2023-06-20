package testCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_001AccountRegistrationTest extends BaseClass {
	
	
	
	@Test(groups= {"Regression","Master"})
	public void account_registration_test() {
		
		try {
			
			logger.debug("application logs");
		logger.info("**** starting TC_001AccountRegistrationTest *****");
		HomePage hp = new HomePage(driver);
		hp.clickMyaccount();
		logger.info("clicked on my account");
		
		hp.clickRegister();
		logger.info("clicked on register link");
		
		AccountRegistrationPage register = new AccountRegistrationPage(driver);
		
		logger.info("providing custemor data");
		
		register.setFirstname(randamString());
		register.setLastname(randamString());
		register.setEmail(randamString() + "@gmail.com");
		register.setPassword(randamAlpaNumber());
		register.setPrivacyPolicy();
		register.clickContinue();
		logger.info("clicked on continue");
		
		String cnfrmmsg = register.clickConfirmationmsg();
		Assert.assertEquals(cnfrmmsg, "Your Account Has Been Created!");
		logger.info("validating expected msg");
		
		}
	catch(Exception e){
		
		logger.info("test failed");
		Assert.fail();
	}
		
		logger.info("****finished TC_001AccountRegistrationTest *****");
	
	}

}
