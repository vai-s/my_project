package com.qkn.automation.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;



public class SettingsTest extends BaseTest {

	public static boolean logoutNotNeeded = false;

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

	/*//Failed
	@Test(groups= {"android"})
	public void testSideOptionOverview(){
		try{
			loginPage().loginWithValidCredentialsForAndroidQKN("mb1_iamtestpass@mailinator.com", "Testing@01");
		    settingsPage().sideOptions_Overview();
			//assert verify overview text --OVERVIEW	
		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}*/
	
	/*//Failed
	@Test(groups= {"android"})
	public void testSideOptionBudgets(){
		try{
			loginPage().loginWithValidCredentialsForAndroidQKN("mb1_iamtestpass@mailinator.com", "Testing@01");
		    settingsPage().sideOptions_Budgets();
			//assert verify overview text --OVERVIEW	
		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}
*/
	
	
  /*  //Failed
	@Test(groups= {"android"})
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
	}
	*/
	
	

		//Passed on may 19 2016 
	//Verify the Alerts option from the side bar

	@Test(groups= {"android"})
	public void testSideOptionAlerts(){
		try{
			loginPage().loginWithValidCredentialsForAndroidQKN("mb1_iamtestpass@mailinator.com", "Testing@01");
		    settingsPage().sideOptions_Alerts();
			//assert verify overview text --OVERVIEW	
		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}

	@AfterMethod(groups= {"ios", "android"})
	public void logoutAfterTest(){
		if(! logoutNotNeeded)
			overviewPage().verifyAndLogOut();
	}

}