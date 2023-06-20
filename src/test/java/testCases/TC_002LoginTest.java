package testCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.BasePage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC_002LoginTest extends BaseClass {

	
	@Test(groups= {"Sanity","Master"})
	
	public void test_login() {
		try {
			
		logger.info("****Starting TC_002LoginTest*****");
	HomePage hp = new HomePage(driver);
	hp.clickMyaccount();
	logger.info("clicked on my account");
	hp.clickLogin();
	logger.info("clicked on login link");
	
	LoginPage lp = new LoginPage(driver);
	logger.info("providing login details");
	lp.setEmail(rb.getString("email"));
	lp.setPassword(rb.getString("password"));
	
	lp.clickLogin();
	logger.info("clicked on login button");
		
	MyAccountPage myaccount = new MyAccountPage(driver);
	boolean targetpage =myaccount.isMyAccountPageExists();
	Assert.assertEquals(targetpage, true);
		}
		
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("**** Finished TC_002LoginTest*****");
	}
	
}
