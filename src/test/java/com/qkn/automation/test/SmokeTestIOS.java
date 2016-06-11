package com.qkn.automation.test;


import java.util.logging.Level;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SmokeTestIOS extends BaseTest {
	public static boolean logoutNotNeeded = false;


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

	//Passed on 01.03.2016
	//Verify add transaction flow without attachment 
	@Test(groups= { "ios"},priority=3)
	public void testAddManualTransactionWithoutAttachment() throws InterruptedException {
		System.out.println("**********start of  withoutattachment *********");
		logoutNotNeeded = false;
		Thread.sleep(1000);
		QuickenLogger.log(Level.INFO,"testAddManualTransaction");
		try{
			//	loginPage().loginWithValidCredentialsForIos("mb1_iamtestpass@mailinator.com", "Testing@01");
			//	System.out.println("**********signedin *********");
			//	Thread.sleep(10000);
			overviewPage().navigateToAddTransactionIOS();
			Thread.sleep(2000);
			transactionPage().addTransactionWithoutAttachment_IOS();						
		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}

	//Verify the zero state budget message
	@Test(groups= {"ios"},priority=4)
	public void testZeroStateBudgetIOS() throws InterruptedException {
		try{

			loginPage().loginWithValidCredentialsForIos("ash11@mailinator.com", "Testing@01");		
			Thread.sleep(8000);
			overviewPage().navigateToBudgetsIOS();
			Thread.sleep(5000);
			Assert.assertTrue(budgetPage().validateZeroStateTextinBudgetPage());
			Thread.sleep(3000);
			budgetPage().navigateBacktoOverviewFromBudget();


		}
		catch(Exception e){
			QuickenLogger.log(Level.SEVERE,"Exceptions happen!!");
			e.printStackTrace();
			logFailure(e.getMessage());
		}

	}


	//Passed
	@Test (groups= {"ios"},priority=5)
	public void testnavigateToAccountsPage() {
		QuickenLogger.log(Level.INFO,"testnavigateToAccountsPage");
		try{
			loginPage().loginWithValidCredentialsForIos("mb1_iamtestpass@mailinator.com", "Testing@01");
			Thread.sleep(8000);
			overviewPage().navigateToAccounts();
			accountsPage().navigateBackToOverviewPage();
		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}


	//passed on 9-4-2016
	//Verify the set passcode
	@Test(groups= {"ios"},priority=6)
	public void SetPasscodeTest() throws InterruptedException {
		try{
			logoutNotNeeded = false;
			loginPage().loginWithValidCredentialsForIos("mb1_iamtestpass@mailinator.com", "Testing@01");
			Thread.sleep(10000);
			overviewPage().navigateToSettingsForIOS();
			settingsPage().setPasscode_IOS();					
		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}

	//passed on 9-4-2016
	//Verify the change passcode
	@Test(groups= {"ios"},priority=7)
	public void ChangePasscodeTest() throws InterruptedException {
		try{
			logoutNotNeeded = false;
			loginPage().loginWithValidCredentialsForIos("mb1_iamtestpass@mailinator.com", "Testing@01");
			Thread.sleep(10000);
			overviewPage().navigateToSettingsForIOS();
			settingsPage().changePasscode_IOS();

		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}

	/*

   //Verifies all the static screens using Applitools .also covers get started page 
	@Test(priority = 0,groups= {"ios"})
	public void testApplitoolsAllScreensIOS() throws InterruptedException {
		   logoutNotNeeded = true;

		try{
			loginPage().loginIosApplitools("autotest1@test.intuit.com", "testing01");
			Thread.sleep(10000);
			eyes.checkWindow("IOS Welcome Popup");
		//	overviewPage().CheckAnypopus();
			Thread.sleep(8000);
			//overviewPage().navigateToOverviewTab();
			eyes.checkWindow("Overview");
			overviewPage().navigateToSettingsForIOS();
			Thread.sleep(10000);
			eyes.checkWindow("IOS Settings");
			settingsPage().navigateToHelpandLegal();
			Thread.sleep(5000);
			overviewPage().LogOutIosApplitools();
			Thread.sleep(4000);
			loginPage().navigateToLearnMoreIos();
			Thread.sleep(4000);
			eyes.close();	

		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}
	 */

	//Passed
	//Verify the Truste logo for IOS 
	@Test(groups= {"ios"},priority=0)
	public void testTrusteLogoios() throws InterruptedException {
		Thread.sleep(5000);
		try{
			loginPage().navigateToTrusteLogo();
			logoutNotNeeded = true;

		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}


	//Passed
	//Verify the End User License Agreement ios
	@Test(groups= {"ios"},priority=1)
	public void testEndUserLicenceIOS() throws InterruptedException {
		Thread.sleep(5000);
		try{
			loginPage().navigateToEndUserLicense();
			Thread.sleep(5000);		
			loginPage().WelocomeBackIos();
			logoutNotNeeded = true;


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


