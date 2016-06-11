package com.qkn.automation.test.android;

import org.testng.annotations.Test;

import com.qkn.automation.test.BaseTest;
import com.qkn.automation.utilities.TestConstants;

public class VerifyPasscode extends BaseTest {
	//Passed need to launch app from background 
	@Test(groups= {"android"})
	public void testChangePasscode() throws InterruptedException {
		try{
			loginPage().loginWithValidCredentialsForAndroidQKN("autotest1@test.intuit.com", "testing01");
			Thread.sleep(TestConstants.MINSLEEPTIME);

			overviewPage().CheckAnypopus();
			Thread.sleep(TestConstants.MINSLEEPTIME);

			settingsPage().navigateToSettings();
			Thread.sleep(TestConstants.MINSLEEPTIME);

			settingsPage().changePasscode_Android();
			Thread.sleep(TestConstants.MINSLEEPTIME);
			//	settingsPage().logOut();
			//				Thread.sleep(5000);


		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}

	//Passed need app in background to test 
	@Test(groups= {"android"})
	public void testSetPasscode() throws InterruptedException {
		try{
			loginPage().loginWithValidCredentialsForAndroidQKN("autotest1@test.intuit.com", "testing01");
			Thread.sleep(TestConstants.MINSLEEPTIME);

			overviewPage().CheckAnypopus();
			Thread.sleep(TestConstants.MINSLEEPTIME);

			settingsPage().navigateToSettings();
			Thread.sleep(TestConstants.MINSLEEPTIME);

			settingsPage().setPasscode_Android();
			Thread.sleep(TestConstants.MINSLEEPTIME);		

		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}
}
