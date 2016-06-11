package com.qkn.automation.test;

import java.util.logging.Level;

import org.junit.Ignore;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;



public class OverviewTest extends BaseTest {



	//Passed on may 01-2016
		//Verify the sections in overview page
		@Test(groups= {"android"})
		public void testOverviewPageContent() throws InterruptedException {
			try{
				QuickenLogger.info("testOverviewPageContents");
				loginPage().loginWithValidCredentialsForAndroidQKN("mb1_iamtestpass@mailinator.com", "Testing@01");
				Thread.sleep(10000);
				overviewPage().CheckAnypopus();
		
				Thread.sleep(10000);
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
	@Test (groups= {"android"})
	public void testOverviewPageWithNoAccounts() {

		QuickenLogger.log(Level.INFO,"testOverviewPageWithNoAccounts");
		try{
			loginPage().loginWithValidCredentialsForAndroidQKN("autotest2@test.intuit.com", "Testing@01");
			Thread.sleep(10000);
			overviewPage().CheckAnypopus();
			Thread.sleep(10000);
			Assert.assertTrue(overviewPage().validateOverviewPageWithNoAccounts(),"Overview page should show message that no accounts were added if the user did not add any bank accounts");
		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}


	//Passed 
	//Verify that Add transaction and Search options are not available when there are no accounts in the data file
	@Test (groups= {"android"})
	public void testSearchOptionDisabledWhenNoAccountsAdded() {

		QuickenLogger.log(Level.INFO,"testSearchOptionDisabledWhenNoAccountsAdded");
		try{
			loginPage().loginWithValidCredentialsForAndroidQKN("autotest2@test.intuit.com", "Testing@01");

			overviewPage().CheckAnypopus();
			Thread.sleep(10000);
			Assert.assertFalse(overviewPage().validateSearchOptionNotExist(),"Search and Add transaction option should not be visible to the user when no accoounts were added");
			Thread.sleep(10000);
		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}


	//Passed on may 01-2016
		//Verify when the user taps on accounts section on overview page its navigated to All accounts page
		@Test (groups= {"android"})
		public void testnavigateToAccounts() {
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
		
		
		
		
	


	/*//Passed on 09-april-2016

			@Test (groups= {"ios"},priority=5)
			public void testnavigateToAccountsPage() {
				QuickenLogger.log(Level.INFO,"testnavigateToAccountsPage");
				try{
					loginPage().loginWithValidCredentialsForIos("autotest1@test.intuit.com", "testing01");
					Thread.sleep(8000);
					overviewPage().navigateToAccounts();
					accountsPage().navigateBackToOverviewPage();
				}
				catch(Exception e){
					e.printStackTrace();
					logFailure(e.getMessage());
				}
			}
	 */

	/*@Ignore
	//This feature is not in quicken
	@Test (groups= {"android"})
	public void testnavigateToInvestments() {
		QuickenLogger.log(Level.INFO,"testnavigateToAccounts");
		try{
			loginPage().loginWithValidCredentialsForAndroid("iosautotest+2@gmail.com", "Testing1");
			overviewPage().navigateToInvestments();
		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}
	 */

	/*
	//Failed need to create scripts
	@Test (groups= {"android"})
	public void testValidateOverviewForNetSpending() {
		QuickenLogger.log(Level.INFO,"testValidateOverviewForNetSpending");
		try{
			loginPage().loginWithValidCredentialsForAndroidQKN(loginUserid, loginPassword);
			overviewPage().CheckAnypopus();
			Assert.assertTrue(overviewPage().validateOverviewPageSectionsForNet());
		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}*/


	@AfterMethod(groups= {"ios", "android", "dev"})
	public void logoutAfterTest(){
		overviewPage().verifyAndLogOut();
	}

}