package com.qkn.automation.test.android;

import java.util.logging.Level;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qkn.automation.test.BaseTest;

public class VerifyZeroStateBudget extends BaseTest {
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
}
