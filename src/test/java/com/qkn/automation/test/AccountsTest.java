package com.qkn.automation.test;

import java.util.logging.Level;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AccountsTest extends BaseTest {


	//Passed on 27 april 2016
	@Test(groups= { "android"},priority =1)
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
	@Test(groups= {"android"},priority = 0)
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
	@Test(groups= {"android"},priority =3)
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
	@Test (groups= {"android"},priority =2)
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

	@AfterMethod(groups= {"ios", "android","dev"})
	public void logoutAfterTest(){
		overviewPage().verifyAndLogOut();

	}

}