package com.qkn.automation.test.android;

import org.testng.annotations.Test;
import com.qkn.automation.pages.LoginPage;
import com.qkn.automation.test.BaseTest;
import com.qkn.automation.utilities.TestConstants;

public class LoginVerification extends BaseTest{


	//Passed on 24 april 2016
	//Verify Login with valid credentails and logout
	@Test(groups= {"android"},priority=1)
	public void testLoginWithValidCredentails() throws InterruptedException {
		try{
			//			Thread.sleep(10000);
			//added by ashwini for applitools
			//eyes.checkWindow("Welcome Screen");
			loginPage().loginWithValidCredentialsForAndroidQKN("mb1_iamtestpass@mailinator.com", "Testing@01");
			Thread.sleep(TestConstants.MINSLEEPTIME);

			overviewPage().CheckAnypopus();
			Thread.sleep(TestConstants.MINSLEEPTIME);
			//eyes.close();
		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}




}
