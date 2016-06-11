package com.qkn.automation.test.android;

import org.testng.annotations.Test;

import com.qkn.automation.test.BaseTest;

public class VerifyForgotPasswordLink extends BaseTest {

	//passed on may 10-2016
	//Verify the Forgot password link navigation 
	@Test(groups= {"android"})
	public void testForgotPasswordLink() throws InterruptedException {
		try{
//			logoutNotNeeded = true;
			loginPage().validateForgotPasswordLink();
			Thread.sleep(3000);


		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());

		}
	}

}
