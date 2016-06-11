package com.qkn.automation.test.android;

import org.testng.annotations.Test;

import com.qkn.automation.test.BaseTest;

public class VerifyGettingStarted extends BaseTest {
	//Verify the Get started options android
	//Passed on 01.03.2016
	@Test(groups= {"android"})
	public void testGetStarted() throws InterruptedException {
		try{

			loginPage().navigateToGetStarted();
			//				logoutNotNeeded = true;

		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}

	}
}
