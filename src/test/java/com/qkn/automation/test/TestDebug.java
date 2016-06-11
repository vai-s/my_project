package com.qkn.automation.test;

import java.util.logging.Level;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;



public class TestDebug extends BaseTest {
	public static boolean logoutNotNeeded = false;
	
/*	@Test(groups= {"android"})
	public void testSideOptionAccounts(){
		try{
			loginPage().loginWithValidCredentialsForAndroidQKN("mb1_iamtestpass@mailinator.com", "Testing@01");
		    settingsPage().sideOptions_Accounts();
			//assert verify overview text --OVERVIEW	
		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}*/


	//Passed on 01.03.2016
	//Verify the add transaction flow with add attachment from gallery .
	@Test(groups= { "ios"},priority=2)
	public void testAddManualTransWithAttachment() throws InterruptedException {
		QuickenLogger.log(Level.INFO,"testAddManualTransaction");
		Thread.sleep(8000);
		logoutNotNeeded = true;
		try{
			loginPage().loginWithValidCredentialsForIos("mb1_iamtestpass@mailinator.com", "Testing@01");
			Thread.sleep(8000);
			overviewPage().navigateToAddTransactionIOS();
			Thread.sleep(2000);
			transactionPage().addTransaction_IOS();	
		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}
	
	
	
/*	//Verify the Accounts option from the side bar
	@Test(groups= {"android"})
	public void testSideOptionEarnedSpent(){
		try{
			loginPage().loginWithValidCredentialsForAndroidQKN("mb1_iamtestpass@mailinator.com", "Testing@01");
		    settingsPage().sideOptions_Alerts();
			//assert verify overview text --OVERVIEW	
		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}*/
	
	
	
	/*//Passed on 27 april 2016
		@Test(groups= { "android"},priority =1)
		public void testNavigateToAllAccounts() throws InterruptedException {

			try{
				QuickenLogger.info("testAllAccountsPageContent");
				loginPage().loginWithValidCredentialsForAndroidQKN("mb1_iamtestpass@mailinator.com", "Testing@01");
				Thread.sleep(10000);
				overviewPage().CheckAnypopus();
			    Thread.sleep(10000);
			//	eyes.checkWindow("OverView Page");
				overviewPage().navigateToAccounts();
				Thread.sleep(10000);
				accountsPage().navigateToAllAccounts();
				Thread.sleep(10000);
				allAccountPage().navigateToFirstTXN();
				Thread.sleep(10000);
			//	eyes.close();

			//Assert.assertTrue(accountsPage().validateAllAccountsPageSections());
			//	accountsPage().navigateToAllAccounts();
			}
			catch(Exception e){
				QuickenLogger.log(Level.SEVERE,"Exceptions happen!!");
				e.printStackTrace();
				logFailure(e.getMessage());
			}
		}*/
	
/*
	
	//failed 
	@Test(groups= {"android"})
	public void testEditBudgets(){
		try{
			loginPage().loginWithValidCredentialsForAndroidQKN("mb1_iamtestpass@mailinator.com", "Testing@01");
			overviewPage().navigateToBudgets();
			Thread.sleep(7000);
			budgetPage().editBudget();
		//	budgetPage().deleteBudget("Auto Insurance");
		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}
	 

	
	@Test(groups= {"android"})
	public void testEditBudgets(){
		try{
			loginPage().loginWithValidCredentialsForAndroidQKN("mb1_iamtestpass@mailinator.com", "Testing@01");
            settingsPage().runAppinBackground();
		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}
	*/
	
	
	
	
	

	/*//Failed
	//Test to verify invalid login message
	@Test(priority = 4,groups= {"android"})
	public void testInvalidLogin() throws InterruptedException {
		try{
			QuickenLogger.log(Level.INFO,"testInvalidLogin");
			logoutNotNeeded = true;
			loginPage().loginWithValidCredentialsForAndroidQKN("test", "test");
			Thread.sleep(15000);
			
		//	Assert.assertTrue(loginPage().validateErrorForInvalidLogin(),"Invalid Login error message is not showing up");
			Thread.sleep(13000);
			loginPage().navigateBackToLoginPageFromLoginError();
			Thread.sleep(3000);	
			logoutNotNeeded = true;

		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}

	}*/
	

	/*//Failed
	@Test(groups= { "ios"})
	public void testEditTag() throws InterruptedException {
		QuickenLogger.log(Level.INFO,"testEditTransactionTag");
		try{
			loginPage().loginWithValidCredentialsForIos("autotest1@test.intuit.com", "testing01");
			Thread.sleep(8000);
			overviewPage().navigateToAccountsIOS();
			accountsPage().navigateToCD();
			System.out.println("*********** Navigated to My CD accnt*******");
			Thread.sleep(5000);
			allAccountPage().navigateToFirstTXN();
			Thread.sleep(3000);
			txnDetailPage().updateTag();
			Thread.sleep(3000);
			txnDetailPage().navigateBackToAccountsFromCD();
			allAccountPage().navigateBackToAccountsPage();
			Thread.sleep(2000);
			accountsPage().navigateBackToOverviewPage();
			Thread.sleep(5000);
		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}*/


	//Failed
	/*
	@Test(groups= {"ios"})
	public void testEditBudget(){
		try{

			loginPage().loginWithValidCredentialsForIos("ash12@mailinator.com", "Testing@01");
			QuickenLogger.info("Logginng  from sign up page");
			Thread.sleep(10000);	
			overviewPage().navigateToBudgetsIOS();
			Thread.sleep(5000);
			budgetPage().editBudget();
			Thread.sleep(5000);
		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}*/






	@AfterMethod(groups= {"ios", "android"})
	public void logoutAfterTest(){
		if(!logoutNotNeeded)
			overviewPage().verifyAndLogOut();
	}
}