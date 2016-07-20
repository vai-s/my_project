package com.qkn.automation.test.android;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.qkn.automation.test.BaseTest;
import com.qkn.automation.utilities.TestConstants;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.Level;

public class SyncTest extends BaseTest{

//added by vaishnavi
	//Test to compare the tag sync from qm to qd
	@Test(groups= {"android"},priority=1)
	public void testCompareTag() throws InterruptedException {
				
		try{
			
			loginPage().loginWithValidCredentialsForAndroidQKN2("silk_iamtestpass@mailinator.com", "Intuit!1");
			Thread.sleep(TestConstants.MINSLEEPTIME);
			overviewPage().CheckAnypopus();
			Thread.sleep(TestConstants.MINSLEEPTIME);
			overviewPage().clickRefresh();
			Thread.sleep(5000);
			overviewPage().navigateToAccounts();
			Thread.sleep(5000);
			accountsPage().navigateToAllAccounts();
			Thread.sleep(5000);
			allAccountPage().navigateToFirstTXN_1();
			Thread.sleep(5000);
			txnDetailPage().compareTag();
			Thread.sleep(5000);
			txnDetailPage().logOut();
		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}

//	//Test to compare the category sync from qm to qd
//	@Test(groups= {"android"},priority=2)
//	public void testCompareCategory() throws InterruptedException {
//		QuickenLogger.log(Level.INFO,"testCompareCategory");
//		try{
//			
//			loginPage().loginWithValidCredentialsForAndroidQKN2("mb1_iamtestpass@mailinator.com", "Testing@01");
//			Thread.sleep(TestConstants.MINSLEEPTIME);
//			overviewPage().CheckAnypopus();
//			Thread.sleep(TestConstants.MINSLEEPTIME);
//			overviewPage().clickRefresh();	
//			Thread.sleep(5000);
//			overviewPage().navigateToAccounts();
//			Thread.sleep(5000);
//			accountsPage().navigateToAllAccounts();
//			Thread.sleep(5000);
//			allAccountPage().navigateToFirstTXN_1();
//			Thread.sleep(5000);
//			txnDetailPage().compareCategory();
//			Thread.sleep(5000);
//			txnDetailPage().logOut();
//		}
//		catch(Exception e){
//			e.printStackTrace();
//			logFailure(e.getMessage());
//		}
//	}
//
//	//Test to compare the memo sync from qm to qd
//	@Test(groups= {"android"},priority=3)
//	public void testCompareMemo() throws InterruptedException {
//		QuickenLogger.log(Level.INFO,"testCompareMemo");
//		try{
//			
//			loginPage().loginWithValidCredentialsForAndroidQKN2("mb1_iamtestpass@mailinator.com", "Testing@01");
//			Thread.sleep(TestConstants.MINSLEEPTIME);
//			overviewPage().CheckAnypopus();
//			Thread.sleep(TestConstants.MINSLEEPTIME);
//			overviewPage().clickRefresh();
//			Thread.sleep(5000);
//			overviewPage().navigateToAccounts();
//			Thread.sleep(5000);
//			accountsPage().navigateToAllAccounts();
//			Thread.sleep(5000);
//			allAccountPage().navigateToFirstTXN_1();
//			Thread.sleep(5000);
//			txnDetailPage().compareMemo();
//			Thread.sleep(5000);
//			txnDetailPage().logOut();
//		}
//		catch(Exception e){
//			e.printStackTrace();
//			logFailure(e.getMessage());
//		}
//	}
//
//	//Test to compare payee name
//	@Test(groups= {"android"},priority=4)
//	public void testComparePayee() throws InterruptedException {
//		QuickenLogger.log(Level.INFO,"testComparePayee");
//		try{
//			
//			loginPage().loginWithValidCredentialsForAndroidQKN2("mb1_iamtestpass@mailinator.com", "Testing@01");
//			Thread.sleep(TestConstants.MINSLEEPTIME);
//			overviewPage().CheckAnypopus();
//			Thread.sleep(TestConstants.MINSLEEPTIME);
//			overviewPage().clickRefresh();
//			Thread.sleep(5000);
//			overviewPage().navigateToAccounts();
//			Thread.sleep(5000);
//			accountsPage().navigateToAllAccounts();
//			Thread.sleep(5000);
//			allAccountPage().navigateToFirstTXN_1();
//			Thread.sleep(5000);
//			txnDetailPage().comparePayee();
//			Thread.sleep(5000);
//			txnDetailPage().logOut();
//		}
//		catch(Exception e){
//			e.printStackTrace();
//			logFailure(e.getMessage());
//		}
//	}
//	/*
//	@AfterMethod(alwaysRun=true)
//	public void afterTests() throws InterruptedException{
//		Thread.sleep(5000);
//	}
//*/
//	//Test to compare amount
//	@Test(groups= {"android"},priority=5)
//	public void testCompareAmount() throws InterruptedException {
//		QuickenLogger.log(Level.INFO,"testCompareAmount");
//		try{
//			
//			loginPage().loginWithValidCredentialsForAndroidQKN2("mb1_iamtestpass@mailinator.com", "Testing@01");
//			Thread.sleep(TestConstants.MINSLEEPTIME);
//			overviewPage().CheckAnypopus();
//			Thread.sleep(TestConstants.MINSLEEPTIME);
//			overviewPage().clickRefresh();
//			Thread.sleep(5000);
//			overviewPage().navigateToAccounts();
//			Thread.sleep(5000);
//			accountsPage().navigateToAllAccounts();
//			Thread.sleep(5000);
//			allAccountPage().navigateToFirstTXN_1();
//			Thread.sleep(5000);
//			txnDetailPage().compareAmount();
//			Thread.sleep(5000);
//			txnDetailPage().logOut();
//		}
//		catch(Exception e){
//			e.printStackTrace();
//			logFailure(e.getMessage());
//		}finally{
//			
//		}
//	}

}
