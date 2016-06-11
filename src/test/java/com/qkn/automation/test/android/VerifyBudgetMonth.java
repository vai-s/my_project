package com.qkn.automation.test.android;

import java.util.logging.Level;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qkn.automation.test.BaseTest;

public class VerifyBudgetMonth extends BaseTest{
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
}
