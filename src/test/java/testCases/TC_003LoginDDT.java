package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	
	public void test_TC_003LoginDDT(String email, String password , String exp)  {
		
		try {	
		logger.info("****Starting TC_002LoginTest*****");
		HomePage hp = new HomePage(driver);
		hp.clickMyaccount();
		
		hp.clickLogin();
	
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setEmail(email);
		lp.setPassword(password);
		
		lp.clickLogin();
		
		
		MyAccountPage myaccount = new MyAccountPage(driver);
		boolean targetpage =myaccount.isMyAccountPageExists();
		
		if(exp.equals("valid")){
			
			if(targetpage==true) {
				myaccount.clickLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(true);
			}
			
			
		}
		
           if(exp.equals("Invalid")){
			
			if(targetpage==true) {
				myaccount.clickLogout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
			
			
		}
		}
		catch(Exception e) {
			
			Assert.fail(); 
		}
		
		logger.info("****Finished TC_002LoginTest*****"); 
		
			}
		
}
