package com.qkn.automation.test;

import java.util.logging.Level;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;



public class BudgetTest extends BaseTest {

	/*
	//Passed on 03.03.2016 
	//Verify the zero state message for the budget 
	@Test(groups= {"ios"})
	public void testZeroStateBudgetIOS() throws InterruptedException {
		try{

			loginPage().loginWithValidCredentialsForIos("iosautotest+2@gmail.com", "Testing1");		
			Thread.sleep(10000);
			//overviewPage().navigateToOverviewTab();
			Thread.sleep(5000);
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
	 */
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
	/*

	//Passed on may 01-2016
		//Verify that current month is displayed under budget section in Overview page 
		@Test(groups= {"android"})
		public void testBudgetMonth() throws InterruptedException {
			try{

				loginPage().loginWithValidCredentialsForAndroidQKN("mb1_iamtestpass@mailinator.com", "Testing@01");
				QuickenLogger.info("Logginng  from sign up page");
				Thread.sleep(10000);
	            int s= budgetPage().validateBudgetMonth();

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


	/*	//failed 
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

	 */




	/*
			@Test(groups= {"ios"})
		public void testAddAndDeleteBudget() throws InterruptedException {
			try{
				loginPage().loginWithValidCredentialsForIos("iosautotest+2@gmail.com", "Testing1");
				QuickenLogger.info("Logginng  from sign up page");
				Thread.sleep(10000);
				overviewPage().CheckAnypopus();
				overviewPage().navigateToOverviewFromFeeds();
				overviewPage().navigateToAddBudgetForIos();
				budgetPage().addBudget("Parking", 10);
				Thread.sleep(7000);
				budgetPage().deleteBudget("Parking");
			}
			catch(Exception e){
				QuickenLogger.log(Level.SEVERE,"Exceptions happen!!");
				e.printStackTrace();
				logFailure(e.getMessage());
			}
		}
	 */



	@AfterMethod(groups= {"ios", "android","dev"})
	public void logoutAfterTest(){
		overviewPage().verifyAndLogOut();
	}

}