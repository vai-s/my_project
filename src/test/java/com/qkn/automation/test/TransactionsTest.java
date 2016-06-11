package com.qkn.automation.test;

import java.util.logging.Level;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;



public class TransactionsTest extends BaseTest {

	/* //Passed on 01/31/2016
		//Verify the add transaction flow with add attachment from gallery .
		@Test(groups= { "ios"})
		public void testAddManualTransaction() throws InterruptedException {
			QuickenLogger.log(Level.INFO,"testAddManualTransaction");
			try{
				loginPage().loginWithValidCredentialsForIos("autotest1@test.intuit.com", "testing01");
				Thread.sleep(10000);
				overviewPage().navigateToAddTransactionIOS();
				Thread.sleep(2000);
				transactionPage().addTransaction();
				//Thread.sleep(27000);			
			}
			catch(Exception e){
				e.printStackTrace();
				logFailure(e.getMessage());
			}
		}*/


	
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
		
		/* //Passed on may 05 -2016 
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
*/

           /*    //This feature is not available in quicken yet

				@Test(groups= { "android"})
				public void testEditTransactionMerchant() throws InterruptedException {
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
						txnDetailPage().updateMerchant("Creditcard Credit 35");
						Thread.sleep(5000);
						Assert.assertTrue(txnDetailPage().validateUpdatedContent("Creditcard Credit 35"));
						txnDetailPage().updateMerchant("Cd");
					}
					catch(Exception e){
						e.printStackTrace();
						logFailure(e.getMessage());
					}
				}*/
				
				




	 

	@AfterMethod(groups= {"ios", "android","dev"})
	public void logoutAfterTest() throws Exception{
		overviewPage().verifyAndLogOut();
	}
}