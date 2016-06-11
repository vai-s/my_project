package com.qkn.automation.pages;

import io.appium.java_client.AndroidKeyCode;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.IOSKeyCode;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.applitools.eyes.Eyes;
import com.qkn.automation.utilities.TestConstants;
import com.thoughtworks.selenium.Wait;

public  class LoginPage extends Page{
	private String env;
	private WebDriver pageDriver;
	//private AppiumDriver pageDriver;
	private java.util.Properties pageprops;
	Logger MintLogger = Logger.getLogger("MyLogger");
	private Eyes eyes;




	//added by ashwini for aplitools 


	public LoginPage(String env,WebDriver driver,java.util.Properties props,Eyes eyes ){
		this.env = env;
		this.pageDriver = driver;
		this.pageprops = props;
		this.eyes=eyes;


	}


	public void loginWithValidCredentialsForIos(String email, String password)
			throws Exception {
		try {
			Thread.sleep(5000);

			WebDriverWait wait = new WebDriverWait(pageDriver, 120);
			
			/*if (pageDriver.getPageSource().contains("Ignore")){
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageprops.getProperty("APP_UPGRADE_POPUP"))));
			pageDriver.findElement(By.xpath(pageprops.getProperty("APP_UPGRADE_POPUP"))).click();}*/
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.name(pageprops.getProperty("SIGNIN_BTN"))));
			pageDriver.findElement(By.name(pageprops.getProperty("SIGNIN_BTN")))
			.click();
			Thread.sleep(15000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.name(pageprops
							.getProperty("LOGIN_USERNAME"))));
			findElementByNameclear("UIATextField", "label", "User ID or email");
			findElementByNameAndSendKeys("UIATextField", "label", "User ID or email",email);
			System.out.println("Before sendkeys for password");
			findElementByNameAndSendKeys("UIASecureTextField", "label", "password",password);
			Thread.sleep(10000);	
			JavascriptExecutor jse = (JavascriptExecutor) pageDriver;
			jse.executeScript("UIATarget.localTarget().frontMostApp().keyboard().buttons()['Go'].tap();");		   		
			Thread.sleep(20000);
			/*	wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.name(pageprops
							.getProperty("OK_BTN"))));*/

			if (pageDriver.getPageSource().contains("OK")) {
				pageDriver.findElement(By.name("OK")).click();
			}			

			else{
				Thread.sleep(3000);
			}

			Thread.sleep(10000);

		} catch (Exception e) {
			MintLogger
			.log(Level.INFO,
					"Unable to login");
			e.printStackTrace();
		}
	}




	public void loginIosApplitools(String email, String password)
			throws Exception {
		try {

			WebDriverWait wait = new WebDriverWait(pageDriver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.name(pageprops.getProperty("SIGNIN_BTN"))));
			eyes.checkWindow("IOS Welcome page");
			pageDriver.findElement(By.name(pageprops.getProperty("SIGNIN_BTN")))
			.click();
			Thread.sleep(20000);
			//applitools to test sign in page 
			eyes.checkWindow("IOS Sign in page"); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.name(pageprops
							.getProperty("LOGIN_USERID"))));

			System.out.println("Before send keys for username");
			findElementByNameAndSendKeys("UIATextField", "label", "User ID or email",email);

			System.out.println("Before sendkeys for password");
			findElementByNameAndSendKeys("UIASecureTextField", "label", "password",password);
			Thread.sleep(10000);
			//	wait.until(ExpectedConditions.elementToBeClickable(By.name(pageprops.getProperty("LOGIN_BTN"))));	
			//	pageDriver.findElement(By.xpath(pageprops.getProperty("LOGIN_BTN"))).click();
			//  pageDriver.findElement(By.className("UIAImage")).click();

			JavascriptExecutor jse = (JavascriptExecutor) pageDriver;
			jse.executeScript("UIATarget.localTarget().frontMostApp().keyboard().buttons()['Go'].tap();");		   		
			//Thread.sleep(30000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.name(pageprops
							.getProperty("OK_BTN"))));
			eyes.checkWindow("IOS Notification Popup");
			Thread.sleep(5000);
			if (pageDriver.getPageSource().contains("OK")) {
				pageDriver.findElement(By.name("OK")).click();
			}

			Thread.sleep(23000);

		} catch (Exception e) {
			MintLogger
			.log(Level.INFO,
					"Unable to login");
			e.printStackTrace();
		}
	}



	public void loginViaGetStartedIos(String email, String password)
			throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(pageDriver, 120);
			pageDriver.findElement(By.name(pageprops.getProperty("GET_STARTED_BTN"))).click();
			Thread.sleep(10000);
			Thread.sleep(10000);		
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.name(pageprops.getProperty("SIGNIN_BTN"))));			
			pageDriver.findElement(By.name(pageprops.getProperty("SIGNIN_BTN")))
			.click();
			Thread.sleep(20000);			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.name(pageprops
							.getProperty("LOGIN_USERID"))));
			System.out.println("Before send keys for username");
			findElementByNameAndSendKeys("UIATextField", "label", "User ID or email",email);
			System.out.println("Before sendkeys for password");
			findElementByNameAndSendKeys("UIASecureTextField", "label", "password",password);
			Thread.sleep(10000);
			//	wait.until(ExpectedConditions.elementToBeClickable(By.name(pageprops.getProperty("LOGIN_BTN"))));	
			//	pageDriver.findElement(By.xpath(pageprops.getProperty("LOGIN_BTN"))).click();
			//  pageDriver.findElement(By.className("UIAImage")).click();

			JavascriptExecutor jse = (JavascriptExecutor) pageDriver;
			jse.executeScript("UIATarget.localTarget().frontMostApp().keyboard().buttons()['Go'].tap();");		   		
			Thread.sleep(20000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.name(pageprops
							.getProperty("OK_BTN"))));
			if (pageDriver.getPageSource().contains("OK")) {
				pageDriver.findElement(By.name("OK")).click();
			}
			Thread.sleep(13000);

		} catch (Exception e) {
			MintLogger
			.log(Level.INFO,
					"Unable to login via Get Started");
			e.printStackTrace();
		}
	}



	public void loginWithValidCredentialsForAndroidQKN(String email, String password)
			throws Exception {
		try{
			WebDriverWait wait = new WebDriverWait(pageDriver, 30);
//			pageDriver.findElement(By.name(pageprops.getProperty("SINGUP_BUTTON_LOGINPAGE")))
//			.click();
			findElementByXpathAndClick(pageDriver, pageprops.getProperty("SINGUP_BUTTON_LOGINPAGE"));
//			pageDriver.findElement(By.xpath(pageprops.getProperty("SINGUP_BUTTON_LOGINPAGE"))).click();
		
//			Thread.sleep(TestConstants.MINSLEEPTIME);
			//applitools to test sign in page 
			//	eyes.checkWindow("Sign in page");   
			//
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.id(pageprops
							.getProperty("LOGIN_USERNAME"))));
			pageDriver.findElement(
					By.id(pageprops.getProperty("LOGIN_USERNAME"))).sendKeys(
							Keys.CONTROL + "a");
			pageDriver.findElement(
					By.id(pageprops.getProperty("LOGIN_USERNAME"))).sendKeys(
							Keys.DELETE);
			System.out.println("Before send keys for username");
			pageDriver.findElement(
					By.id(pageprops.getProperty("LOGIN_USERNAME"))).sendKeys(
							email);
			pageDriver.findElement(
					By.id(pageprops.getProperty("LOGIN_PWD"))).sendKeys(
							Keys.CONTROL + "a");
			pageDriver.findElement(
					By.id(pageprops.getProperty("LOGIN_PWD"))).sendKeys(
							Keys.DELETE);
			//	Thread.sleep(3000);
			System.out.println("Before sendkeys for password");
			pageDriver.findElement(By.id(pageprops.getProperty("LOGIN_PWD"))).sendKeys(password);
//			Thread.sleep(5000);

			//Require this to run on local to hide the keyboard not required on sauce labs .
//			pageDriver.navigate().back();
			
			/*JavascriptExecutor js = (JavascriptExecutor) pageDriver;
			HashMap flickObject = new HashMap();
			flickObject.put("endX", 0);
			flickObject.put("endY", 0);
			flickObject.put("touchCount", 1);
			js.executeScript("mobile: swipe", flickObject);*/


			// Added by ashwini
			//  eyes.checkWindow("Sign in Page");   
			findElementByXpathAndClick(pageDriver, pageprops.getProperty("SIGNIN_BTN"));
//			pageDriver.findElement(By.xpath(pageprops.getProperty("SIGNIN_BTN"))).click();
			/*JavascriptExecutor jse = (JavascriptExecutor) pageDriver;
			jse.executeScript("UIATarget.localTarget().frontMostApp().keyboard().buttons()['Go'].tap();");		*/   		
			//	Thread.sleep(20000);

//			Thread.sleep(15000);
			/*wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.name(pageprops
							.getProperty("OK_BTN"))));*/
//            if(pageDriver.findElements(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.Button[1]")).size()!=0)
//            {
//            	MintLogger.log(Level.INFO,"Welcome to quicken screen displayed So click on OK button");
//            	
//            }
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageprops.getProperty("SIGNINOK_BTN"))));
			findElementByXpathAndClick(pageDriver, pageprops.getProperty("SIGNINOK_BTN"));
			QuickenLogger.log(Level.INFO, "Login successfull with "+email+" as username and "+password+" as password");
			
//			if (pageDriver.getPageSource().contains("OK")) {
////				pageDriver.findElement(By.name("OK")).click();
//				pageDriver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.Button[1]")).click();
//				System.out.println("Login successfull with "+email+" as username and "+password+" as password");
//			}

			Thread.sleep(TestConstants.MINSLEEPTIME);
			/*
	if (tabname.equalsIgnoreCase("OVERVIEW")){
		pageDriver.findElement(By.name(pageprops.getProperty("OVERVIEW_TAB")))
		.click();
	       }
	else if(tabname.equalsIgnoreCase("UPDATES")){
		pageDriver.findElement(By.name(pageprops.getProperty("UPDATES_TAB")))
		.click();
                 	}*/
		}

		//added 
		catch(Exception e){
			MintLogger.log(Level.INFO,"Unable to Sign in ");
			e.printStackTrace();
		}
	}




	public void loginWithInValidCredentials(String email, String password)
			throws Exception {
		QuickenLogger.log(Level.INFO,"loginWithInValidCredentials");
		WebDriverWait wait = new WebDriverWait(pageDriver, 30);
		pageDriver.findElement(By.name(pageprops.getProperty("SINGUP_BUTTON_LOGINPAGE")))
		.click();
		Thread.sleep(20000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id(pageprops
						.getProperty("LOGIN_USERNAME"))));
		pageDriver.findElement(
				By.id(pageprops.getProperty("LOGIN_USERNAME"))).sendKeys(
						Keys.CONTROL + "a");
		pageDriver.findElement(
				By.id(pageprops.getProperty("LOGIN_USERNAME"))).sendKeys(
						Keys.DELETE);
		System.out.println("Before send keys for username");
		pageDriver.findElement(
				By.id(pageprops.getProperty("LOGIN_USERNAME"))).sendKeys(
						email);
		pageDriver.findElement(
				By.id(pageprops.getProperty("LOGIN_PWD"))).sendKeys(
						Keys.CONTROL + "a");
		pageDriver.findElement(
				By.id(pageprops.getProperty("LOGIN_PWD"))).sendKeys(
						Keys.DELETE);
		//	Thread.sleep(3000);
		System.out.println("Before sendkeys for password");
		pageDriver.findElement(By.id(pageprops.getProperty("LOGIN_PWD"))).sendKeys(password);
		Thread.sleep(5000);
		pageDriver.navigate().back();

		pageDriver.findElement(By.xpath(pageprops.getProperty("SIGNIN_BTN"))).click();

	}

	public void navigateToTrusteLogo() throws Exception{

		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageprops.getProperty("APP_UPGRADE_POPUP"))));
		pageDriver.findElement(By.xpath(pageprops.getProperty("APP_UPGRADE_POPUP"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageprops.getProperty("TRUSTE_LOGO"))));
		pageDriver.findElement(By.xpath(pageprops.getProperty("TRUSTE_LOGO"))).click();
		Thread.sleep(12000);
		pageDriver.navigate().back();		
		Thread.sleep(16000);
	}

	public void navigateToTrusteLogo_And() throws Exception{

		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageprops.getProperty("TRUSTE_LOGO"))));
		pageDriver.findElement(By.xpath(pageprops.getProperty("TRUSTE_LOGO"))).click();
		Thread.sleep(TestConstants.MINSLEEPTIME);
		pageDriver.navigate().back();		
		Thread.sleep(TestConstants.MINSLEEPTIME);
	}




	//Added by Ashwini
	public void navigateToEndUserLicense() throws Exception{
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageprops.getProperty("APP_UPGRADE_POPUP"))));
		//pageDriver.findElement(By.xpath(pageprops.getProperty("APP_UPGRADE_POPUP"))).click();
		Thread.sleep(TestConstants.MINSLEEPTIME);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageprops.getProperty("LICENSE"))));
		pageDriver.findElement(By.xpath(pageprops.getProperty("LICENSE"))).click();
		Thread.sleep(TestConstants.MINSLEEPTIME);

		//pageDriver.navigate().back();		
		//Thread.sleep(5000);

	}

	//Added by ashwini
	public void DoneEndUserLisence() throws Exception{
        WebDriverWait wait = new WebDriverWait(pageDriver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(pageprops.getProperty("DONE_BTN"))));
        pageDriver.findElement(By.xpath(pageprops.getProperty("DONE_BTN"))).click();
		//	Thread.sleep(5000);

	}


	//Added by ashwini
	public void WelocomeBackIos() throws Exception{

		WebDriverWait wait = new WebDriverWait(pageDriver, 30);
		pageDriver.findElement(By.name("Welcome")).click();
		//	Thread.sleep(5000);

	}

	//Added by ashwini
	public void navigateToGetStarted() throws Exception{
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		pageDriver.findElement(By.xpath(pageprops.getProperty("GET_STARTED_BTN"))).click();
		Thread.sleep(TestConstants.NOMINALSLEEPTIME);
		pageDriver.findElement(By.xpath(pageprops.getProperty("BUY_NOW"))).click();
		Thread.sleep(TestConstants.NOMINALSLEEPTIME);
		String BuyNowUrl= pageDriver.findElement(By.id(pageprops.getProperty("EXPECTED_BUYURL"))).getText();
		String ActualUrl=pageprops.getProperty("BUYNOW_QUICKEN_URL");	   
		Assert.assertEquals(BuyNowUrl, ActualUrl);
		Thread.sleep(TestConstants.NOMINALSLEEPTIME);
		pageDriver.navigate().back();
		Thread.sleep(TestConstants.MINSLEEPTIME);
		pageDriver.navigate().back();	
		Thread.sleep(TestConstants.NOMINALSLEEPTIME);


	}

	public void navigateToLearnMoreIos() throws Exception{
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		pageDriver.findElement(By.name(pageprops.getProperty("GET_STARTED_BTN"))).click();
		Thread.sleep(10000);
		eyes.checkWindow("GET_STARTED");
		pageDriver.findElement(By.name(pageprops.getProperty("LEARN_MORE"))).click();
		Thread.sleep(10000);
		eyes.checkWindow("LEARN_MORE");
		Thread.sleep(15000);
		pageDriver.navigate().back();
		Thread.sleep(10000);
		pageDriver.navigate().back();	
		Thread.sleep(10000);


	}

	public void loginViaGetStarted(String email, String password) throws Exception{
		MintLogger.log(Level.INFO,"loginWithInValidCredentials");
		WebDriverWait wait = new WebDriverWait(pageDriver, 30);
		pageDriver.findElement(By.name("Get started")).click();
		Thread.sleep(4000);		
		/*JavascriptExecutor js = (JavascriptExecutor) pageDriver;
		HashMap flickObject = new HashMap();
		flickObject.put("endX", 0);
		flickObject.put("endY", 0);
		flickObject.put("touchCount", 1);
		js.executeScript("mobile: swipe", flickObject);
		Thread.sleep(4000);		*/
		pageDriver.findElement(By.name(pageprops.getProperty("SINGUP_BUTTON_GETSTARTEDPAGE")))
		.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id(pageprops
						.getProperty("LOGIN_USERNAME"))));
		pageDriver.findElement(
				By.id(pageprops.getProperty("LOGIN_USERNAME"))).sendKeys(
						Keys.CONTROL + "a");
		pageDriver.findElement(
				By.id(pageprops.getProperty("LOGIN_USERNAME"))).sendKeys(
						Keys.DELETE);
		System.out.println("Before send keys for username");
		pageDriver.findElement(
				By.id(pageprops.getProperty("LOGIN_USERNAME"))).sendKeys(
						email);
		pageDriver.findElement(
				By.id(pageprops.getProperty("LOGIN_PWD"))).sendKeys(
						Keys.CONTROL + "a");
		pageDriver.findElement(
				By.id(pageprops.getProperty("LOGIN_PWD"))).sendKeys(
						Keys.DELETE);
		//		Thread.sleep(3000);
		System.out.println("Before sendkeys for password");
		pageDriver.findElement(By.id(pageprops.getProperty("LOGIN_PWD")))
		.sendKeys(password);
		Thread.sleep(3000);

		pageDriver.navigate().back();
		Thread.sleep(1000);
		pageDriver.findElement(By.xpath(pageprops.getProperty("SIGNIN_BTN"))).click();

		/*		JavascriptExecutor jse = (JavascriptExecutor) pageDriver;
		jse.executeScript("UIATarget.localTarget().frontMostApp().keyboard().buttons()['Go'].tap();");	*/
		Thread.sleep(15000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.name(pageprops
						.getProperty("OK_BTN"))));

		if (pageDriver.getPageSource().contains("OK")) {
			pageDriver.findElement(By.name("OK")).click();
		}

		Thread.sleep(13000);
	}



	//Added by ashwini

	public void validateForgotPasswordLink() throws Exception{
		WebDriverWait wait = new WebDriverWait(pageDriver, 30);
		pageDriver.findElement(By.xpath(pageprops.getProperty("SINGUP_BUTTON_LOGINPAGE")))
		.click();
		Thread.sleep(TestConstants.MINSLEEPTIME);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageprops.getProperty("FORGOTMYID_LINK"))));
		//pageDriver.findElement(By.id("com.intuit.qm2014:id/forgetUserIdPassword_TV")).click();
		pageDriver.findElement(By.xpath(pageprops.getProperty("FORGOTMYID_LINK"))).click();
		Thread.sleep(TestConstants.NOMINALSLEEPTIME);

		/*	String ActualUrl2= pageDriver.findElement(By.id("com.android.browser:id/url")).getText();
		System.out.println(ActualUrl2);
	    String ForgotPasswordUrl=pageprops.getProperty("FORGOT_PASSOWRD_URL");	   
	    Assert.assertEquals(ForgotPasswordUrl, ActualUrl2);
		Thread.sleep(3000);
	    pageDriver.navigate().back();	
		Thread.sleep(3000);*/
		pageDriver.navigate().back();	
		Thread.sleep(TestConstants.NOMINALSLEEPTIME);
	}

	public boolean validateErrorForInvalidLogin() throws Exception{
		boolean retValue = false;
		//	WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]")));
		retValue= (pageDriver.getPageSource().toString().contains("Unable to Sign In"));// && pageDriver.getPageSource().toString().contains("OK") && pageDriver.getPageSource().toString().contains("Your User ID or password is incorrect."));
		return retValue;

	}

	public void navigateBackToLoginPageFromLoginError() throws Exception{
		MintLogger.log(Level.INFO,"navigateBackToLoginPageFromLoginError");
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("OK")));
		System.out.println("popup displayed");
		String msg=pageDriver.findElement(By.id("android:id/message")).getText();
		System.out.println(msg);
		//android:id/alertTitle
		pageDriver.findElement(By.name("OK")).click();
		//id=android:id/button1....android.widget.TextView
		Thread.sleep(3000);
		pageDriver.navigate().back();		
		Thread.sleep(5000);
	}

	//addded by ashwini
	public void navigateBackToSignInPage() throws Exception{
		MintLogger.log(Level.INFO,"navigateBackToSignInPage");
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageprops
				.getProperty("LOGIN_BACKBTN"))));
		pageDriver.findElement(By.xpath(pageprops.getProperty("LOGIN_BACKBTN"))).click();

	}


	public void windatafile() throws Exception{
		MintLogger.log(Level.INFO,"Select the first windows data file");
		pageDriver.findElement(By.name("Windows")).click();
	}

	public void macdatafile() throws Exception{
		MintLogger.log(Level.INFO,"Select the second mac data file");
		pageDriver.findElement(By.name("Mac")).click();
	}

	public void navigateToSignupFromLoginError() throws Exception{
		MintLogger.log(Level.INFO,"navigateToSignupFromLoginError");
		pageDriver.findElement(By.id("android:id/button1")).click();
	}

	//added by ashwini

	public void findElementByNameAndClick(String classType, String searchType,
			String name) {
		List<WebElement> listOfInputs = pageDriver.findElements(By
				.className(classType));
		for (int i = 0; i < listOfInputs.size(); i++) {
			if (listOfInputs.get(i).getAttribute(searchType).equals(name)){
				listOfInputs.get(i).click();
				return;
			}

		}
	}

	public void navigateToSignup() throws Exception{
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.name(pageprops
						.getProperty("SINGUP_BUTTON_LOGINPAGE"))));
		pageDriver.findElement(By.name(pageprops.getProperty("SINGUP_BUTTON_LOGINPAGE"))).click();

	}


	public void findElementByNameAndSendKeys(String classType, String searchType,
			String name,String username) {
		List<WebElement> listOfInputs = pageDriver.findElements(By
				.className(classType));
		for (int i = 0; i < listOfInputs.size(); i++) {
			if (listOfInputs.get(i).getAttribute(searchType).equals(name))
				listOfInputs.get(i).sendKeys(username);;
		}

	}

	public void findElementByNameclear(String classType, String searchType,
			String name) {
		List<WebElement> listOfInputs = pageDriver.findElements(By
				.className(classType));
		for (int i = 0; i < listOfInputs.size(); i++) {
			if (listOfInputs.get(i).getAttribute(searchType).equals(name))
				listOfInputs.get(i).clear();;

		}


	}

}
