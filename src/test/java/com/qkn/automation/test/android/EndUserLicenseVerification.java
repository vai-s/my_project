package com.qkn.automation.test.android;

import org.testng.annotations.Test;

import com.qkn.automation.test.BaseTest;
import com.qkn.automation.utilities.TestConstants;

public class EndUserLicenseVerification extends BaseTest {
	//Passed on 01.03.2016
	//Verify the End User License Agreement android 
	@Test(groups= {"android"})
	public void testEndUserLicence() throws InterruptedException {
		try{
			//	overviewPage().scrollToBottomOfPage();
			//	Thread.sleep(6000);
			loginPage().navigateToEndUserLicense();
			for (int i=0;i<=112;i++){
			}
			Thread.sleep(TestConstants.MINSLEEPTIME);
			loginPage().DoneEndUserLisence();
			//				logoutNotNeeded = true;

		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}
}
