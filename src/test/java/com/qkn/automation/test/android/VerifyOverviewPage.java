package com.qkn.automation.test.android;

import java.util.logging.Level;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qkn.automation.test.BaseTest;
import com.qkn.automation.utilities.TestConstants;

public class VerifyOverviewPage extends BaseTest {
	//Passed on may 01-2016
	//Verify the sections in overview page
	@Test(groups= {"android"},priority=1)
	public void testOverviewPageContent() throws InterruptedException {
		try{
			QuickenLogger.info("testOverviewPageContents");
			loginPage().loginWithValidCredentialsForAndroidQKN("mb1_iamtestpass@mailinator.com", "Testing@01");
			Thread.sleep(TestConstants.NOMINALSLEEPTIME);
			overviewPage().CheckAnypopus();

			Thread.sleep(TestConstants.NOMINALSLEEPTIME);
			Assert.assertTrue(overviewPage().validateOverviewPageSections());			

		}
		catch(Exception e){
			QuickenLogger.log(Level.SEVERE,"Exceptions happen!!");
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}

	//Passed
	//Verify the Zero state message when no accounts are added to the data file .
	@Test (groups= {"android"},priority=2)
	public void testOverviewPageWithNoAccounts() {

		QuickenLogger.log(Level.FINE,"testOverviewPageWithNoAccounts");
		try{
			loginPage().loginWithValidCredentialsForAndroidQKN("mb2_iamtestpass@mailinator.com", "Testing@01");
			Thread.sleep(TestConstants.NOMINALSLEEPTIME);
			overviewPage().CheckAnypopus();
			Thread.sleep(TestConstants.NOMINALSLEEPTIME);
			Assert.assertTrue(overviewPage().validateOverviewPageWithNoAccounts(),"Overview page should show message that no accounts were added if the user did not add any bank accounts");
		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}
}
