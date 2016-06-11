package com.qkn.automation.test.android;

import org.testng.annotations.Test;

import com.qkn.automation.test.BaseTest;

public class TrustLogoVerification extends BaseTest {

	//Passed on 01.03.2016
	//Verify the Truste logo
	@Test(groups= {"android"},priority = 1)
	public void testTrusteLogo() throws InterruptedException {
		try{
			//overviewPage().scrollToBottomOfPage();
			//	Thread.sleep(6000);
			loginPage().navigateToTrusteLogo_And();


		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}
}
