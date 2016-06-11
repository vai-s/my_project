package com.qkn.automation.test;


import java.util.logging.Level;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SmokeTestAndroid extends BaseTest {
	public static boolean logoutNotNeeded = false;

	//Passed on 24 april 2016
	//Verify Login with valid credentails and logout
	@Test(groups= {"android"})
	public void testLoginWithValidCredentails() throws InterruptedException {
		try{
			Thread.sleep(10000);
			//added by ashwini for applitools
			//eyes.checkWindow("Welcome Screen");
			loginPage().loginWithValidCredentialsForAndroidQKN("mb1_iamtestpass@mailinator.com", "Testing@01");
			Thread.sleep(10000);

			overviewPage().CheckAnypopus();
			Thread.sleep(10000);
			//eyes.close();
		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}


	//Passed on 01.03.2016
	//Verify the Truste logo
	@Test(groups= {"android"},priority = 1)
	public void testTrusteLogo() throws InterruptedException {
		try{
			//overviewPage().scrollToBottomOfPage();
			//	Thread.sleep(6000);
			loginPage().navigateToTrusteLogo_And();
			logoutNotNeeded = true;

		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}



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
			Thread.sleep(1000);
			loginPage().DoneEndUserLisence();
			logoutNotNeeded = true;

		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}



	//Verify the Get started options android
	//Passed on 01.03.2016
	@Test(groups= {"android"})
	public void testGetStarted() throws InterruptedException {
		try{

			loginPage().navigateToGetStarted();
			logoutNotNeeded = true;

		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}

	}



	//passed on may 10-2016
	//Verify the Forgot password link navigation 
	@Test(groups= {"android"})
	public void testForgotPasswordLink() throws InterruptedException {
		try{
			logoutNotNeeded = true;
			loginPage().validateForgotPasswordLink();
			Thread.sleep(3000);


		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());

		}
	}


	//Passed on may 01-2016
	//Verify that current month is displayed under budget section in Overview page 
	@Test(groups= {"android"})
	public void testBudgetMonth() throws InterruptedException {
		try{

			loginPage().loginWithValidCredentialsForAndroidQKN("mb1_iamtestpass@mailinator.com", "Testing@01");
			QuickenLogger.info("Logginng  from sign up page");
			Thread.sleep(10000);
			overviewPage().CheckAnypopus();
			Thread.sleep(10000);
			int s= budgetPage().validateBudgetMonth();
			Thread.sleep(3000);
			if(s==0){

				Assert.assertTrue(true, "Correct month is displayed");
			}

			else{
				Assert.assertTrue(false, "Incorrect month is displayed");
			}
		}
		catch(Exception e){
			QuickenLogger.log(Level.SEVERE,"Exceptions happen!!");
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}



	//Passed on may 10 -2016
	//Verify the zero state message for the budget 
	@Test(groups= {"android"})
	public void testZeroStateBudget() throws InterruptedException {
		try{

			loginPage().loginWithValidCredentialsForAndroidQKN("mb2_iamtestpass@mailinator.com", "Testing@01");
			QuickenLogger.info("Logginng  from sign up page");
			Thread.sleep(10000);
			overviewPage().navigateToBudgets();
			Thread.sleep(5000);
			budgetPage().zeroStateBudget();
			Thread.sleep(3000);
			Assert.assertTrue(budgetPage().validateZeroStateTextinBudgetPage());

		}
		catch(Exception e){
			QuickenLogger.log(Level.SEVERE,"Exceptions happen!!");
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}
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

	//Passed need to launch app from background 
	@Test(groups= {"android"})
	public void testChangePasscode() throws InterruptedException {
		try{
			loginPage().loginWithValidCredentialsForAndroidQKN("autotest1@test.intuit.com", "testing01");
			Thread.sleep(15000);
			overviewPage().CheckAnypopus();
			Thread.sleep(5000);
			settingsPage().navigateToSettings();
			Thread.sleep(5000);
			settingsPage().changePasscode_Android();
			Thread.sleep(5000);
			//	settingsPage().logOut();
			Thread.sleep(5000);


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
			Thread.sleep(15000);
			overviewPage().CheckAnypopus();
			Thread.sleep(5000);
			settingsPage().navigateToSettings();
			Thread.sleep(5000);
			settingsPage().setPasscode_Android();
			Thread.sleep(5000);		

		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}

	//Passed on may 05 -2015
	@Test(groups= {"android"})
	public void testAddManualTransaction() throws InterruptedException {

		try{
			loginPage().loginWithValidCredentialsForAndroidQKN("mb1_iamtestpass@mailinator.com", "Testing@01");
			Thread.sleep(15000);
			overviewPage().navigateToAddTransaction();
			transactionPage().addTransaction_Android();

		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}

	//Passed on may 05 -2016 
	@Test(groups= { "android"})
	public void testEditTransactionNotes() throws InterruptedException {
		QuickenLogger.log(Level.INFO,"testEditTransactionNotes");
		try{
			loginPage().loginWithValidCredentialsForAndroidQKN("mb1_iamtestpass@mailinator.com", "Testing@01");
			overviewPage().CheckAnypopus();
			Thread.sleep(5000);
			overviewPage().navigateToAccounts();
			Thread.sleep(5000);
			accountsPage().navigateToCD();
			Thread.sleep(5000);
			allAccountPage().navigateToFirstTXN();
			Thread.sleep(5000);
			txnDetailPage().updateNotes("Test");
			Thread.sleep(10000);
			Assert.assertTrue(txnDetailPage().validateUpdatedContent("Test"));
			txnDetailPage().updateNotes("");



		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}

	//passed on 06-may-2016
	@Test(groups= { "android"})
	public void testEditTransactionTag() throws InterruptedException {
		QuickenLogger.log(Level.INFO,"testEditTransactionTag");
		try{
			loginPage().loginWithValidCredentialsForAndroidQKN("mb1_iamtestpass@mailinator.com", "Testing@01");
			overviewPage().CheckAnypopus();
			Thread.sleep(5000);
			overviewPage().navigateToAccounts();
			Thread.sleep(5000);
			accountsPage().navigateToCD();
			Thread.sleep(5000);
			allAccountPage().navigateToFirstTXN();
			Thread.sleep(5000);
			txnDetailPage().updateTag();
			Assert.assertTrue(txnDetailPage().validateUpdatedContent("Reimbursable,Tax Releated,Vacation"));
			Thread.sleep(5000);
			txnDetailPage().updateTag();
		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}


	//Passed on 27 april 2016
	@Test(groups= { "android"})
	public void testNavigateToAllAccounts() throws InterruptedException {

		try{
			QuickenLogger.info("testAllAccountsPageContent");
			Thread.sleep(5000);
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
	}
	//Passed on may 01-2016 
	@Test(groups= {"android"})
	public void testAllAccountsFrom3dost() throws InterruptedException {
		try{

			QuickenLogger.info("testAllAccountsPageContentfrom3dots");
			Thread.sleep(5000);
			loginPage().loginWithValidCredentialsForAndroidQKN("mb1_iamtestpass@mailinator.com", "Testing@01");
			Thread.sleep(10000);
			overviewPage().CheckAnypopus();
			Thread.sleep(10000);
			settingsPage().navigateToAccountsFromMoreoptions();
			Thread.sleep(15000);
			//	eyes.checkWindow("AllAccounts_FromAccounts");
			Thread.sleep(3000);		
			Assert.assertTrue(settingsPage().validteAllAccountsPageContent());
			Thread.sleep(15000);
			accountsPage().navigateBackToHomePageFromAccts();
			Thread.sleep(5000);
			//	eyes.close();

		}
		catch(Exception e){
			QuickenLogger.log(Level.SEVERE,"Exceptions happen!!");
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}

	//passed on may 01-2016
	@Test(groups= {"android"})
	public void testOnlineBalance() throws InterruptedException {
		String MobileOnlineBalance=null;
		try{
			Thread.sleep(5000);
			loginPage().loginWithValidCredentialsForAndroidQKN("mb1_iamtestpass@mailinator.com", "Testing@01");
			Thread.sleep(10000);
			overviewPage().CheckAnypopus();
			Thread.sleep(10000);
			overviewPage().navigateToAccounts();
			Thread.sleep(12000);
			MobileOnlineBalance=accountsPage().onlineBalance();
			System.out.println("*********Online balance for the accout is ************ :" + MobileOnlineBalance);
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
			Thread.sleep(5000);
			loginPage().loginWithValidCredentialsForAndroidQKN("mb1_iamtestpass@mailinator.com", "Testing@01");
			Thread.sleep(10000);
			overviewPage().CheckAnypopus();
			Thread.sleep(5000);
			overviewPage().navigateToAccounts();
		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}







	@AfterMethod(groups= {"ios", "android", "dev","aws"})
	public void logoutAfterTest(){		
		if(!logoutNotNeeded)
			overviewPage().verifyAndLogOut();	
	}



}


