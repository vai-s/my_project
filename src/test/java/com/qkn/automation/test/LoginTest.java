package com.qkn.automation.test;


import java.util.logging.Level;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {
	public static boolean logoutNotNeeded = false;

/*	
   //passed
   //Verifies all the static screens using Applitools .also covers get started page 
	@Test(priority = 0,groups= {"ios"})
	public void testApplitoolsAllScreensIOS() throws InterruptedException {
		   logoutNotNeeded = true;

		try{
			loginPage().loginIosApplitools("autotest1@test.intuit.com", "testing01");
			Thread.sleep(10000);
			eyes.checkWindow("IOS Welcome Popup");
			overviewPage().CheckAnypopus();
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
	}*/
	 //Added a line to check
	/*
	//Passed
		//Verify the Truste logo for IOS 
		@Test(groups= {"ios"})
		public void testTrusteLogoios() throws InterruptedException {
			try{
				loginPage().navigateToTrusteLogo();
				logoutNotNeeded = true;

			}
			catch(Exception e){
				e.printStackTrace();
				logFailure(e.getMessage());
			}
		}*/

	/*
		//Passed
		//Verify the End User License Agreement ios
		@Test(groups= {"ios"})
		public void testEndUserLicenceIOS() throws InterruptedException {
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
	 */


	/*//Verify login via getstarted page ios
		@Test(priority = 2,groups= {"ios"})
		public void testloginViaGetStarted() throws InterruptedException {
			try{

				loginPage().loginViaGetStartedIos("autotest1@test.intuit.com", "testing01");
				Thread.sleep(10000);
				overviewPage().CheckAnypopus();
				Thread.sleep(10000);
				ApplitoolsFlag = "false";
			}

			catch(Exception e){
				e.printStackTrace();
				logFailure(e.getMessage());
			}
		}

	 */
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

	/*//Failed
	//Verify Login to access windows data file when 2 data file is associated with the same Intuit id .
		@Test(priority = 0,groups= {"android"})
		public void testLogintoWindowsDatafile() throws InterruptedException {
			try{
				loginPage().loginWithValidCredentialsForAndroidQKN("betamobile@test.intuit.com", "testing01");
				Thread.sleep(15000);
				loginPage().windatafile();
				Thread.sleep(5000);
				overviewPage().CheckAnypopus();
				Thread.sleep(10000);

			}
			catch(Exception e){
				e.printStackTrace();
				logFailure(e.getMessage());
			}
		}*/
	/* //Failed
		//Verify Login with valid credentails with a id having 2 data files associated 
				@Test(priority = 1,groups= {"android"})
				public void testLogintoMacDatafile() throws InterruptedException {
					try{
						loginPage().loginWithValidCredentialsForAndroidQKN("betamobile@test.intuit.com", "testing01");
						Thread.sleep(15000);
						loginPage().macdatafile();
						Thread.sleep(5000);
						overviewPage().CheckAnypopus();
						Thread.sleep(10000);

					}
					catch(Exception e){
						e.printStackTrace();
						logFailure(e.getMessage());
					}
				}*/

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
		
		
		 
/*	//Passed on 25-april 2016//failed in suite mode
	//Verify login via getstarted page
	@Test(priority = 3,groups= {"android"})
	public void testloginViaGetStarted() throws InterruptedException {
		try{

			loginPage().loginViaGetStarted("mb1_iamtestpass@mailinator.com", "Testing@01");
			Thread.sleep(10000);
		
		}

		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}
	}*/

						
						
	/*
	//failed
	//Test to verify invalid login message
	@Test(priority = 4,groups= {"android"})
	public void testInvalidLogin() throws InterruptedException {
		try{
			QuickenLogger.log(Level.INFO,"testInvalidLogin");
			logoutNotNeeded = true;
			loginPage().loginWithInValidCredentials("test", "test");
			Thread.sleep(15000);
			Assert.assertTrue(loginPage().validateErrorForInvalidLogin(),"Invalid Login error message is not showing up");
			Thread.sleep(3000);
			loginPage().navigateBackToLoginPageFromLoginError();
			Thread.sleep(3000);	

		}
		catch(Exception e){
			e.printStackTrace();
			logFailure(e.getMessage());
		}

	}

	 */

	@AfterMethod(groups= {"ios", "android"})
	public void logoutAfterTest(){
		if(!logoutNotNeeded)
			overviewPage().verifyAndLogOut();	

		//driver.quit();

	}

}