package com.qkn.automation.test;

import io.appium.java_client.AndroidKeyCode;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.applitools.eyes.Eyes;
import com.qkn.automation.pages.AccountsPage;
import com.qkn.automation.pages.AllAccountsPage;
import com.qkn.automation.pages.BudgetsPage;
import com.qkn.automation.pages.LoginPage;
import com.qkn.automation.pages.MenuPage;
import com.qkn.automation.pages.OverviewPage;
import com.qkn.automation.pages.SettingsPage;
import com.qkn.automation.pages.SignUpPage;
import com.qkn.automation.pages.TestProperties;
import com.qkn.automation.pages.TransactionDetailPage;
import com.qkn.automation.pages.TransactionPage;
import com.qkn.automation.utilities.TestConstants;
import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.testng.SauceOnDemandAuthenticationProvider;
import com.saucelabs.testng.SauceOnDemandTestListener;




public class BaseTest {

	StringBuffer logExceptionBuffer;

	private WebDriver driver;//
	private String platform;
	private String app;
	private String appName;
	private String env;
	private Properties props = null;

	protected boolean ApplitoolsFlag;

	private LoginPage loginPage;
	private OverviewPage overviewPage;
	private SignUpPage signupPage;
	private BudgetsPage budgetPage;
	private TransactionPage transactionPage;
	private AccountsPage accountsPage;
	private SettingsPage settingsPage;
	private MenuPage menuPage;
	private AllAccountsPage allAccountsPage;
	private TransactionDetailPage txnDetailPage;
	//private CreditScorePage creditScorePage;
	//private CashFlowPage cashFlowPage;

	public String loginUserid="autotest1@test.intuit.com";
	public String loginPassword="testing01";


	//added by ashwini for aplitools
	protected Eyes eyes;
	//private Eyes eyes;


	protected Logger QuickenLogger = Logger.getLogger("MyLogger");

	@BeforeTest(groups = { "ios", "android", "dev","aws" })
	public void setup() {
		//		platform = System.getProperty("platform");
		//		app = System.getProperty("app");
		//		env = System.getProperty("env");
		//		appName = System.getProperty("appname");
		loadtestEnvironmentVariables();
		platform = "android";
		env = "prod";
		appName = "";


		boolean runOnCloud = false;
		runOnCloud = new Boolean(System.getProperty("runoncloud"));

		QuickenLogger.log(Level.INFO, "Environment: " + platform + " App : " + app
				+ " run on cloud" + runOnCloud + "env  " + env);

		loadProperties();

		try {
			if (platform.equals(TestProperties.ANDROID)) {
				QuickenLogger.log(Level.INFO,
						"Loading Android  Desired Capabilities");
				///	eyes = new Eyes();
				// This is your api key, make sure you use it in all your tests.
				///   eyes.setApiKey("H983jIA72VeNutvJHtUQ67FL1059GIOtyNOBEGOoVQ106107z4110");

				DesiredCapabilities capabilities = new DesiredCapabilities();

/*		//to run on local

				File app=new File("/Users/vs/Downloads/Quicken32.apk");
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
				capabilities.setCapability("deviceName", "Nexus_6_API_21");
				//capabilities.setCapability("deviceName", "Galaxy S6");
				capabilities.setCapability("platformVersion", "5.0");
				capabilities.setCapability("platformName", "android");
				capabilities.setCapability("device ID", "emulator-5556");
				capabilities.setCapability("app",app.getAbsolutePath());
				capabilities.setCapability("appPackage","com.quicken.qm2014");//added by ashwini
				//	capabilities.setCapability("app-wait-activity","com.intuit.qm2014.QkLoginActivity");
				capabilities.setCapability("appActivity","com.quicken.qm2014.QkLoginActivity");
				capabilities.setCapability("fullReset","true");*/

			//to run on sauce labs 
												
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
				capabilities.setCapability("appiumVersion", "1.4.16");
				capabilities.setCapability(CapabilityType.PLATFORM, "mac");
				capabilities.setCapability("platformName", "android");
				capabilities.setCapability("deviceName", "Android Emulator");
				capabilities.setCapability("platformVersion", "5.1");
				capabilities.setCapability("app", "sauce-storage:Quicken32.apk");
				capabilities.setCapability("appPackage", "com.quicken.qm2014");
				capabilities.setCapability("appActivity", "com.quicken.qm2014.QkLoginActivity");
				capabilities.setCapability("username", "ashwini_sutrave@intuit.com");
				capabilities.setCapability("access-key","8ba3d2ed-c8e9-4488-9d18-8026488ac306");
				capabilities.setCapability("name", "Android_Test");
				capabilities.setCapability("build", "build-4.1.32");
				capabilities.setCapability("build", System.getenv("JOB_NAME") + "__" + System.getenv("BUILD_NUMBER"));
				capabilities.setCapability("passed","true");

				 


				//for jenkins 
				/*		File app=new File("/Users/Shared/Jenkins/Home/jobs/Quicken_Android_TestAutomation/workspace/output/Quickencom.apk");
				capabilities.setCapability("app",app.getAbsolutePath());	*/

				//capabilities.SetCapability("udid", "emulator-5554");
				//capabilities.setCapability("deviceName", "emulator-5554");
				//  capabilities.setCapability("app", app);
				//	capabilities.setCapability("command-timeout", 200);

				/*
				capabilities.setCapability("appPackage","com.quicken.qm2014");
				capabilities.setCapability("app-wait-activity","com.quicken.qm2014.QkLoginActivity");
				capabilities.setCapability("appActivity","com.quicken.qm2014.QkLoginActivity");
				 */

				if (runOnCloud) {

					driver = new RemoteWebDriver(new URL(
							"http://ondemand.saucelabs.com:80/wd/hub"),
							capabilities);
					//	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				} else
					driver = new RemoteWebDriver(new URL(
							"http://127.0.0.1:4723/wd/hub"), capabilities);
				// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				/*	driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);*/
				//  added by ashwini to test applitools 
				////	driver= eyes.open(driver, "Quicken_MobileApp", "Android");
				//
				Thread.sleep(TestConstants.MINSLEEPTIME);
			} else {
				QuickenLogger.log(Level.INFO, "Loading IOS  Desired Capabilities");

				//  eyes = new Eyes();
				//	eyes.setApiKey("H983jIA72VeNutvJHtUQ67FL1059GIOtyNOBEGOoVQ106107z4110");

				
				//To Run on SauceLabs
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("appiumVersion", "1.4.16");
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
				capabilities.setCapability(CapabilityType.PLATFORM, "mac");
				capabilities.setCapability("platformName", "iOS");
				capabilities.setCapability("deviceName", "iPhone Simulator");
				//capabilities.setCapability("deviceName", "iPad Simulator");

				capabilities.setCapability("platformVersion", "9.2");
				//capabilities.setCapability("platformVersion", "8.4");
				capabilities.setCapability("app","sauce-storage:Quicken_IOSApp.zip");
				capabilities.setCapability("app",app);				
				capabilities.setCapability("username", "ashwini_sutrave@intuit.com");
				capabilities.setCapability("access-key","8ba3d2ed-c8e9-4488-9d18-8026488ac306");
				capabilities.setCapability("name", "IOS_Test");
				capabilities.setCapability("build", "build-4.2.0");
				capabilities.setCapability("build", System.getenv("JOB_NAME") + "__" + System.getenv("BUILD_NUMBER"));
				capabilities.setCapability("passed","true");
				//capabilities.setCapability("idleTimeout", "360");
				//capabilities.setCapability("command-timeout", "600"); 

				 
	/*			//To Run on local machine
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("appiumVersion", "1.4.16");
				capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
				capabilities.setCapability(CapabilityType.PLATFORM, "mac");
				capabilities.setCapability("platformName", "iOS");
				//capabilities.setCapability("deviceName", "iPhone 5s");
				capabilities.setCapability("deviceName", "iPhone 6");
				//capabilities.setCapability("deviceName", "iPhone 6 Plus");
				//capabilities.setCapability("deviceName", "iPad Air");
				//capabilities.setCapability("deviceName", "Ashwini's iPhone");
				capabilities.setCapability("platformVersion", "9.2");
				//capabilities.setCapability("platformVersion", "8.4");
				//capabilities.setCapability("udid","9604D613D6DA1EA4A46776C29A693B932E7D91E8");
				//capabilities.setCapability("bundleid", "com.intuit.quickencompanion.ios");
				//	capabilities.setCapability("command-timeout", "7200");
				//	capabilities.setCapability("autoAcceptAlerts", true);
				//capabilities.setCapability("noReset",true);
				File app=new File("/Users/balaji/Documents/NewQuicken/Quicken.app");
				capabilities.setCapability("app",app.getAbsolutePath()); */


				//Jenkins configuration
				/*		File app=new File("/Users/Shared/Jenkins/Home/jobs/Quicken_IOS_TestAutomation/workspace/Quicken.app");
				capabilities.setCapability("app",app.getAbsolutePath());*/

				//“locationServicesEnabled”: “true”
				//locationContextEnabled=false


				if (runOnCloud)
					driver = new RemoteWebDriver(new URL(
							"http://ondemand.saucelabs.com:80/wd/hub"),
							capabilities);
				else
					driver = new RemoteWebDriver(new URL(
							"http://0.0.0.0:4723/wd/hub"), capabilities);

				/*driver = new RemoteWebDriver(new URL(
							"http://127.0.0.1:4723/wd/hub"), capabilities);
				 */
				//	driver= eyes.open(driver, "Quicken_MobileApp", "IOS_iPhone_5s");
				//driver= eyes.open(driver, "Quicken_MobileApp", "IOS_iPhone6");
				//driver= eyes.open(driver, "Quicken_MobileApp", "IOS_iPhone6_Plus");
				//driver= eyes.open(driver, "Quicken_MobileApp", "IOS_iPad_Air");


				Thread.sleep(5000);

			}
			//	Thread.sleep(5000);
			//Commented by Ashwini as this flow is not implemented of switching to the different env 
			//by clicking on the  quicken logo using the debug build is not implemented 

			/*if(env.equals("aws"))
				updateEnvWithCustomEndPoints();
			else
				updateEnvironment();*/

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		QuickenLogger.log(Level.INFO, "End of Desired Capabilities");

	}

	private void loadtestEnvironmentVariables() {
		// TODO Auto-generated method stub

	}

	@AfterTest(groups = { "ios", "android", "dev","aws" })
	public void tearDown() {
		try {
			//Added by ashwini for applitools 
			///	eyes.abortIfNotClosed();
			System.out.println("****************In After Test  for SauceLab reporting on Jenkins *********");
			String message = String.format("SauceOnDemandSessionID=%1$s job-name=%2$s",
					(((RemoteWebDriver) driver).getSessionId()).toString(), "IOS_Test");
			System.out.println(message);
			driver.quit();
			System.out.println("****************driver quit*********");


		} catch (Exception e) {
			System.out.println("*******************exception in  aftertest method *********");
			e.printStackTrace();

		}
	}

	public void logFailure(String sLineMsg) {
		logExceptionBuffer.append(sLineMsg);
		Assert.fail(logExceptionBuffer.toString() + "\n");
	}

	public String getUniqueName() {
		String uniquename = getTimeStamp();
		return uniquename;
	}

	public String getTimeStamp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyhmmss");
		String formattedDate = sdf.format(date);
		return (formattedDate);
	}

	private void loadProperties() {
		props = new Properties();

		try {
			QuickenLogger.log(Level.INFO, "Loading Properties for " + platform);
			String current = new java.io.File(".").getCanonicalPath();
			InputStream input = new FileInputStream(
					platform.equals("android") ? current
							+ "//src/main/java/resources/Android.properties"
							: current
							+ "//src/main/java/resources/Ios.properties");
			props.load(input);
			input.close();
			TestConstants.setWaitTimemultiplier(Integer.parseInt(props.getProperty("APPLICATIONSLOWNESSQUOTIENT")));

		} catch (IOException e) {

			QuickenLogger.log(Level.INFO, "Exception loading " + platform
					+ " properties file");
			e.printStackTrace();
		}

	}

	public void updateEnvWithCustomEndPoints() {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		if (platform.equals("android")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.name("Custom endpoints")));
			driver.findElement(By.name("Custom endpoints")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.name("Mint endpoint")));
			for (int i = 0; i < 9; i++) {
				driver.findElement(By.name("Mint endpoint")).sendKeys(
						Keys.DELETE);
			}
			driver.findElement(By.name("Mint endpoint")).sendKeys(
					Keys.BACK_SPACE);
			// .findElement(By.name("Mint endpoint")).clear();
			driver.findElement(By.name("Mint endpoint")).sendKeys(
					"https://dev.aws.mint.com/");
			for (int i = 0; i < 9; i++) {
				driver.findElement(By.name("Oauth endpoint")).sendKeys(
						Keys.DELETE);
			}
			driver.findElement(By.name("Oauth endpoint")).sendKeys(
					"https://oauth-e2e.platform.intuit.com/");
			for (int i = 0; i < 9; i++) {
				driver.findElement(By.name("FDP endpoint")).sendKeys(
						Keys.DELETE);
			}
			//		driver.findElement(By.name("FDP endpoint")).sendKeys(Keys.DELETE);
			driver.findElement(By.name("FDP endpoint"))
			.sendKeys(
					"https://financialdocument-e2e-qydc.platform.intuit.net/v1/documents");
			for (int i = 0; i < 9; i++) {
				driver.findElement(By.name("Forgot pwd endpoint")).sendKeys(
						Keys.DELETE);
			}

			driver.findElement(By.name("Forgot pwd endpoint")).sendKeys(
					"https://stage-mini.mint.com/recovery.event");
			for (int i = 0; i < 9; i++) {
				driver.findElement(By.name("REST endpoint")).sendKeys(
						Keys.DELETE);
			}
			//		driver.findElement(By.name("REST endpoint")).sendKeys(Keys.DELETE);
			driver.findElement(By.name("REST endpoint")).sendKeys(
					"https://mint-e2e.finance.intuit.com");
			driver.findElement(By.name("Oauth app token"))
			.sendKeys(Keys.DELETE);
			driver.findElement(By.name("Oauth app token")).sendKeys(
					"preprdMintAndroidMobileAppToken");
			driver.findElement(By.name("Save custom endpoints")).click();
		} else {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.name(props.getProperty("MINT_LOGO"))));
			driver.findElement(By.name(props.getProperty("MINT_LOGO"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.name("Stage-mini")));
			findElementByNameAndClick("UIAStaticText","name","Other");
			findElelemntByIndexAndSendKeys("UIATextField", 0,
					"https://dev.aws.mint.com/");
			driver.findElement(By.name("E2E")).click();
			scroll();
			driver.findElement(By.name("Disabled")).click();
			driver.findElement(By.name("Never")).click();
			driver.findElement(By.xpath(props.getProperty("KIIP_REWARDS")))
			.click();
			driver.findElement(By.name("Done")).click();
		}

	}

	public void updateEnvironment() throws Exception {
		if (env.equals("stage-mini") && platform.equals("ios"))
			env = "Stage-mini";
		WebDriverWait wait = new WebDriverWait(driver, 120);
		if (platform.equals(TestProperties.ANDROID)) {
			QuickenLogger.log(Level.INFO, "Switching envionrment for " + platform
					+ " to " + env);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.id("com.mint:id/titleLogo")));
			driver.findElement(By.id("com.mint:id/titleLogo")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.name(env)));
			driver.findElement(By.name(env)).click();
		} else {
			QuickenLogger.log(Level.INFO, "Switching envionrment for " + platform
					+ " to " + env);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.name(props.getProperty("MINT_LOGO"))));
			driver.findElement(By.name(props.getProperty("MINT_LOGO"))).click();
			if (!env.equals("prod")) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.name(env)));
				driver.findElement(By.name(env)).click();
				driver.findElement(By.name("E2E")).click();
			}
			scroll();
			driver.findElement(By.name("Disabled")).click();
			driver.findElement(By.name("Never")).click();
			driver.findElement(By.xpath(props.getProperty("KIIP_REWARDS")))
			.click();
			driver.findElement(By.name("Done")).click();
		}

	}

	public void findElelemntByIndexAndClick(String classType, int index) {
		/*
		Looping thru elements is not working because there are more than1 image and
		 images dont have names to them.So forced to use index
		 */
		QuickenLogger.log(Level.INFO,"findElelemntByIndexAndSendKeys to click floating icon");
		List<WebElement> listOfInputs = driver.findElements(By
				.className(classType));
		listOfInputs.get(index).click();
	}

	public void findElementByNameAndClick(String classType, String searchType,
			String name) {
		List<WebElement> listOfInputs = driver.findElements(By
				.className(classType));
		for (int i = 0; i < listOfInputs.size(); i++) {
			if (listOfInputs.get(i).getAttribute(searchType).equals(name)){
				System.out.println("CLICKING OF ELEMENAT");
				listOfInputs.get(i).click();
				return;
			}

		}

	}

	public void findElelemntByIndexAndSendKeys(String classType, int index,String url) {
		/*
		Looping thru elements is not working because there are more than1 image and
		 images dont have names to them.So forced to use index
		 */
		QuickenLogger.log(Level.INFO,"findElelemntByIndexAndSendKeys to click floating icon");
		List<WebElement> listOfInputs = driver.findElements(By
				.className(classType));
		listOfInputs.get(index).sendKeys(url);
	}

	public void findElelemntByIndexAndSendKeys(String classType, int index,Keys key) {
		/*
		Looping thru elements is not working because there are more than1 image and
		 images dont have names to them.So forced to use index
		 */
		QuickenLogger.log(Level.INFO,"findElelemntByIndexAndSendKeys to click floating icon");
		List<WebElement> listOfInputs = driver.findElements(By
				.className(classType));
		listOfInputs.get(index).sendKeys(key);
	}

	private void scroll() {
		System.out.println("Before scroll");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap flickObject = new HashMap();
		flickObject.put("endX", 0);
		flickObject.put("endY", 0);
		flickObject.put("touchCount", 1);
		js.executeScript("mobile: swipe", flickObject);
		System.out.println("After scroll");
	}
	/*	*//**
	 * Marks a Sauce Job as 'passed'.
	 *
	 * @param jobId the Sauce Job Id, typically equal to the Selenium/WebDriver sessionId
	 *//*
    public void jobPassed(String jobId) {
        Map<String, Object> updates = new HashMap<String, Object>();
        updates.put("passed", true);
        updateJobInfo(jobId, updates);
    }

	  *//**
	  * Marks a Sauce Job as 'failed'.
	  *
	  * @param jobId the Sauce Job Id, typically equal to the Selenium/WebDriver sessionId
	  *//*
    public void jobFailed(String jobId) {
        Map<String, Object> updates = new HashMap<String, Object>();
        updates.put("passed", false);
        updateJobInfo(jobId, updates);

    }*/
	//added by ashwini
	public void runAppinBackground(){

	}


	public WebDriver getDriver() {
		return driver;
	}

	//
	public Properties getProperties() {
		return props;
	}

	public WebDriver getPageDriver() {
		return driver;
	}

	public String getEnvironment() {
		return platform;
	}

	// Page library initialization
	public LoginPage loginPage() {
		if (loginPage == null)
			loginPage = new LoginPage(platform, driver, props,eyes);
		return loginPage;
	}

	public OverviewPage overviewPage() {
		if (overviewPage == null)
			overviewPage = new OverviewPage(platform, driver, props,eyes);
		return overviewPage;
	}

	public SignUpPage signupPage() {
		if (signupPage == null)
			signupPage = new SignUpPage(platform, driver, props);
		return signupPage;
	}

	public BudgetsPage budgetPage() {
		if (budgetPage == null)
			budgetPage = new BudgetsPage(platform, driver, props);
		return budgetPage;
	}

	public TransactionPage transactionPage() {
		if (transactionPage == null)
			transactionPage = new TransactionPage(platform, driver, props);
		return transactionPage;
	}

	public AccountsPage accountsPage() {
		if (accountsPage == null)
			accountsPage = new AccountsPage(platform, driver, props);
		return accountsPage;
	}

	public SettingsPage settingsPage() {
		if (settingsPage == null)
			settingsPage = new SettingsPage(platform, driver, props,eyes);
		return settingsPage;
	}

	public MenuPage menuPage() {
		if (menuPage == null)
			menuPage = new MenuPage(platform, driver, props);
		return menuPage;
	}

	public AllAccountsPage allAccountPage() {
		if (allAccountsPage == null)
			allAccountsPage = new AllAccountsPage(platform, driver, props);
		return allAccountsPage;
	}

	public TransactionDetailPage txnDetailPage() {
		if (txnDetailPage == null)
			txnDetailPage = new TransactionDetailPage(platform, driver, props);
		return txnDetailPage;
	}

	/*	public Eyes getEyes() {
		return eyes;
	}

	public void setEyes(Eyes eyes) {
		this.eyes = eyes;
	}*/

	/*public CreditScorePage getCreditScorePage() {
		if (creditScorePage == null)
			creditScorePage = new CreditScorePage(platform, driver, props);
		return creditScorePage;
	}

	public CashFlowPage getCashFlowPage() {
		if (cashFlowPage == null)
			cashFlowPage = new CashFlowPage(platform, driver, props);
		return cashFlowPage;
	}*/


}
