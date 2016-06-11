package com.qkn.automation.test.android;

import java.util.logging.Level;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qkn.automation.test.BaseTest;
import com.qkn.automation.utilities.TestConstants;

public class VerifyTransaction extends BaseTest{
	
	//Passed on may 05 -2015
		@Test(groups= {"android"},priority=1)
		public void testAddManualTransaction() throws InterruptedException {

			try{
				loginPage().loginWithValidCredentialsForAndroidQKN("mb1_iamtestpass@mailinator.com", "Testing@01");
				Thread.sleep(TestConstants.MINSLEEPTIME);
				overviewPage().navigateToAddTransaction();
				transactionPage().addTransaction_Android();

			}
			catch(Exception e){
				e.printStackTrace();
				logFailure(e.getMessage());
			}
		}

		//Passed on may 05 -2016 
		@Test(groups= { "android"},priority=2)
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
		@Test(groups= { "android"},priority=3)
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

}
