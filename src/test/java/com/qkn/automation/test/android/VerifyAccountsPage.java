package com.qkn.automation.test.android;

import java.util.logging.Level;

import org.testng.annotations.Test;

import com.qkn.automation.test.BaseTest;

public class VerifyAccountsPage extends BaseTest {

	//Passed on may 01-2016
	//Verify when the user taps on accounts section on overview page its navigated to All accounts page
	@Test (groups= {"android"})
	public void testnavigateToAccounts1() {
		QuickenLogger.log(Level.INFO,"testnavigateToAccounts");
		try{
			loginPage().loginWithValidCredentialsForAndroidQKN("mb1_iamtestpass@mailinator.com", "Testing@01");
			overviewPage().navigateToAccounts();
		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}

}
