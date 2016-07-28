package com.qkn.automation.pages;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.applitools.eyes.Eyes;
import com.qkn.automation.utilities.TestConstants;

public class OverviewPage extends Page {
	private String env;
	private WebDriver pageDriver;
	private java.util.Properties pageprops;
	private Eyes eyes;


	public OverviewPage(String env, WebDriver driver, java.util.Properties props,Eyes eyes) {
		this.env = env;
		this.pageDriver = driver;
		this.pageprops = props;
		this.eyes=eyes;
	}



	public void CheckAnypopus() {
		QuickenLogger.log(Level.INFO, "Checking for any pop ups in overview page");
		try {

			if (pageDriver.getPageSource().contains("OK")) {
				pageDriver.findElement(By.name("OK")).click();
				Thread.sleep(TestConstants.NOMINALSLEEPTIME);
			}
			if (pageDriver.getPageSource().contains("Welcome to Quicken!")) {
				Thread.sleep(3000);
				List<WebElement> listOfInputs1 = pageDriver.findElements(By
						.className("android.widget.Button"));
				for (int i = 0; i < listOfInputs1.size(); i++) {
					if (listOfInputs1.get(i).getText().equals("OK")) {
						listOfInputs1.get(i).click();
					}
				}
				Thread.sleep(TestConstants.NOMINALSLEEPTIME);

			}
			Thread.sleep(TestConstants.NOMINALSLEEPTIME);
			/*if (pageDriver.findElement(By.id("android:id/button1"))
					.isDisplayed()) {
				pageDriver.findElement(By.id("android:id/button1")).click();
				Thread.sleep(2000);
			}*/

		} catch (ElementNotVisibleException e1) {
			QuickenLogger.log(
					Level.INFO,
					"ElementNotVisible Exception!! But ignore this : "
							+ e1.getMessage());

		} catch (Exception e) {
			QuickenLogger.log(Level.INFO,
					"No Popups !!! But ignore this : " + e.getMessage());
		}

	}

	public void navigateToAccounts() throws Exception {
		//CheckAnypopus();commented by ashwini
		/*	WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.name(pageprops.getProperty("OVERVIEW"))));
		pageDriver.findElement(
				By.name(pageprops.getProperty("OVERVIEW"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.name(pageprops.getProperty("Accounts"))));
		pageDriver.findElement(
				By.name(pageprops.getProperty("Accounts"))).click();
		Thread.sleep(5000);*/
		try
		{
			CheckAnypopus();
			WebDriverWait wait = new WebDriverWait(pageDriver, 120);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(pageprops.getProperty("OVERVIEW_ACCOUNTS"))));
			pageDriver.findElement(
					By.xpath(pageprops.getProperty("OVERVIEW_ACCOUNTS"))).click();
			Thread.sleep(TestConstants.NOMINALSLEEPTIME);
			QuickenLogger.log(Level.INFO, "Navigate to accounts was successfull ");
		}
		catch(Exception ex)
		{
			QuickenLogger.log(Level.SEVERE, "Navigate to accounts was not successfull "+ex.getMessage());
			ex.printStackTrace();
		}
	}


	public void navigateToAccountsIOS() throws Exception {
		//CheckAnypopus();
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.name(pageprops.getProperty("OVERVIEW_ACCOUNTS"))));
		pageDriver.findElement(
				By.name(pageprops.getProperty("OVERVIEW_ACCOUNTS"))).click();
		Thread.sleep(5000);
	}

	public void navigateToBudgets() throws Exception {
		CheckAnypopus();
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		QuickenLogger.log(Level.INFO, "Navigate to Budgets");
//		FindElementByTagNameAndClick(pageDriver, "android.widget.TextView",
//				"text", "No Zero state budget message on the screens");	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(pageprops.getProperty("OVERVIEW_BUDGETS"))));
		pageDriver.findElement(
				By.xpath(pageprops.getProperty("OVERVIEW_BUDGETS"))).click();
	}

	public void navigateToBudgetsIOS() throws Exception {
		//CheckAnypopus();
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		QuickenLogger.log(Level.INFO, "Navigate to Budgets");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(pageprops.getProperty("OVERVIEW_BUDGETS"))));
		pageDriver.findElement(
				By.xpath(pageprops.getProperty("OVERVIEW_BUDGETS"))).click();
	}

	public void navigateToCashFlow() throws Exception {
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.name(pageprops.getProperty("OVERVIEW_CASHFLOW"))));
		pageDriver.findElement(
				By.name(pageprops.getProperty("OVERVIEW_CASHFLOW"))).click();
		Thread.sleep(5000);

	}

	public void navigateToInvestments() throws Exception {
		scrollToBottomOfPage();
		Thread.sleep(5000);
		scrollToBottomOfPage();
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.name(pageprops.getProperty("OVERVIEW_INVESTMENTS"))));
		pageDriver.findElement(
				By.name(pageprops.getProperty("OVERVIEW_INVESTMENTS"))).click();
		Thread.sleep(5000);

	}

	public void scrollToBottomOfPage() {
		JavascriptExecutor js = (JavascriptExecutor) pageDriver;
		HashMap flickObject = new HashMap();
		flickObject.put("endX", 0);
		flickObject.put("endY", 0);
		flickObject.put("touchCount", 1);
		js.executeScript("mobile: swipe", flickObject);
	}

	public void navigateToSettings() throws Exception {
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		if (env.equals(TestProperties.ANDROID)) {
			Thread.sleep(10000);
			navigateToMenu();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.name(pageprops.getProperty("SETTINGS"))));
			pageDriver.findElement(By.name(pageprops.getProperty("SETTINGS")))
			.click();
		}

	}

	public void navigateToSettingsForIOS() throws Exception {
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.name(pageprops.getProperty("SETTINGS"))));
		pageDriver.findElement(By.name(pageprops.getProperty("SETTINGS")))
		.click();
	}

	public void navigateToAddTransaction() throws Exception {
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		// if (env.equals(TestProperties.ANDROID)) {
		waitTillOverviewPageIsrefreshed();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(pageprops.getProperty("MORE_OPTIONS"))));
		findElementByXpathAndClick(pageDriver,pageprops.getProperty("MORE_OPTIONS"));
		
		if (env.equals(TestProperties.ANDROID)) {
			FindElementByTagNameAndClick(pageDriver,"android.widget.TextView", "text", "Add transaction");
		} else {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(pageprops.getProperty("MORE_OPTIONS_ADD_TRANSACTION"))));
			findElementByXpathAndClick(pageDriver, pageprops
							.getProperty("MORE_OPTIONS_ADD_TRANSACTION"));
			
//			pageDriver.findElement(
//					By.name(pageprops
//							.getProperty("MORE_OPTIONS_ADD_TRANSACTION")))
//			.click();
//			Thread.sleep(TestConstants.MINSLEEPTIME);
			System.out.println("Before dont allow button click");
			//	pageDriver.findElement(By.name("Don’t Allow")).click();//Commented by Ashwini
//			Thread.sleep(TestConstants.MINSLEEPTIME);
		}
		// }
	}

	public void navigateToAddTransactionIOS() throws Exception {
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		FindElementByTagNameAndClick(pageDriver,"UIAButton","label","Add");
		Thread.sleep(3000);	
		//plusBarButton
		if (pageDriver.getPageSource().contains("Allow")){
				pageDriver.findElement(By.name("Allow")).click();
		}
			
		else
		{
			Thread.sleep(3000);
		}
		}


	public boolean validateOverviewPageWithNoAccounts() throws Exception {
		Thread.sleep(TestConstants.NOMINALSLEEPTIME);
		//	if (env.equals(TestProperties.ANDROID))
		return(pageDriver.getPageSource().toString()
				.contains("You haven't added any") && pageDriver.getPageSource().toString()
				.contains("Please add accounts from your desktop."));
		/*else
			return pageDriver.getPageSource().toString()
					.contains("Getting started is easy!");*/
	}

	public boolean validateSearchOptionNotExist() throws Exception {
		Thread.sleep(10000);
		pageDriver.findElement(By.name(pageprops.getProperty("MORE_OPTIONS")))
		.click();
		Thread.sleep(3000);
		return (pageDriver.getPageSource().toString().contains("Search") && pageDriver.getPageSource().toString().contains("Add transaction"));
	}

	public void verifyAndLogOut() {
		QuickenLogger.log(Level.INFO, "verifyAndLogOut()");
		try {

			WebDriverWait wait = new WebDriverWait(pageDriver, 120);
			if (env.equals(TestProperties.ANDROID)) {
				Thread.sleep(5000);
				navigateToMoreOptions();
				Thread.sleep(3000);
				List<WebElement> listOfInputs = pageDriver.findElements(By
						.className("android.widget.TextView"));
				for (int i = 0; i < listOfInputs.size(); i++) {
					if (listOfInputs.get(i).getAttribute("text")
							.equals("Settings"))
						listOfInputs.get(i).click();

				}
				FindElementByTagNameAndClick(pageDriver,"android.widget.TextView","text","Logout");
				//commented by ashwini
				/*wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(pageprops.getProperty("LOGOUT_BEFOREPOPUP"))));
				pageDriver
						.findElement(
								By.xpath((pageprops
										.getProperty("LOGOUT_BEFOREPOPUP"))))
						.click();*/

				//				wait.until(ExpectedConditions.visibilityOfElementLocated(By
				//.name(pageprops.getProperty("LOGIN_USERNAME"))));

				//added by ashwini 
				wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.id("android:id/title")));
				pageDriver.findElement(By.id("android:id/title")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.id("android:id/button1")));
				pageDriver.findElement(By.id("android:id/button1")).click();
				Thread.sleep(10000);
				
				
			/*	wd.findElement(By.name("More options")).click();
				wd.findElement(By.xpath("//android.widget.ListView[1]/android.widget.LinearLayout[4]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")).click();
				wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[4]/android.widget.RelativeLayout[1]/android.widget.TextView[1]")).click();
				wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]")).click();
				wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]")).click();
				wd.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.Button[2]")).click();
				
				*/

			}

			else {
				navigateToSettingsForIOS();
				Thread.sleep(3000);

				Thread.sleep(1000);
				pageDriver
				.findElement(By.name(pageprops.getProperty("SIGNOUT")))
				.click();
				Thread.sleep(2000);
				// wait.until(ExpectedConditions.visibilityOfElementLocated(By
				// .name(pageprops.getProperty("SIGNOUT_POPUP"))));
				// pageDriver.findElement(By.name(pageprops.getProperty("SIGNOUT_POPUP"))).click();
				Thread.sleep(5000);
				pageDriver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]")).click();
				/*List<WebElement> listOfInputs1 = pageDriver.findElements(By
						.className("UIATableCell"));
				System.out.println("SIZE " + listOfInputs1.size());
				for (int i = 0; i < listOfInputs1.size(); i++) {
					if (listOfInputs1.get(i).getAttribute("label")
							.equals("Sign out"))
						listOfInputs1.get(i).click();*/
				Thread.sleep(5000);

			}
			//	}

		} 


		catch (Exception e) {
			QuickenLogger.log(Level.INFO,
					"ElementNotVisible Exception!! But ignore this : ",
					e.getMessage());
			e.printStackTrace();

		}

	}



	public void LogOutIosApplitools() {
		QuickenLogger.log(Level.INFO, "LogOutIOSApplitools()");
		try {
			pageDriver
			.findElement(By.name(pageprops.getProperty("SIGNOUT")))
			.click();
			Thread.sleep(10000);
			eyes.checkWindow("IOS SignOut_Popup");
			Thread.sleep(15000);
			pageDriver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]")).click();
			Thread.sleep(5000);

		}
		catch (Exception e) {
			QuickenLogger.log(Level.INFO,
					"ElementNotVisible Exception!! But ignore this : ",
					e.getMessage());
			e.printStackTrace();

		}

	}



	//Updated by Ashwini
	public boolean validateOverviewPageSections() {
		QuickenLogger.log(Level.INFO, "validateOverviewPageSections");
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		findElementByXpathAndClick(pageDriver, pageprops.getProperty("OVERVIEW_TAB"));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(pageprops.getProperty("OVERVIEW_ACCOUNTS"))));
		return (existsElementByXPATH(pageDriver,pageprops.getProperty("OVERVIEW_ACCOUNTS"))
				&& existsElementByXPATH(pageDriver,pageprops
						.getProperty("OVERVIEW_BUDGETS")) && existsElementByXPATH(pageDriver,pageprops
								.getProperty("OVERVIEW_EARNED_SPENT"))&& existsElementByXPATH(pageDriver,pageprops
										.getProperty("OVERVIEW_ALERTS")));
	}

	public boolean validateOverviewPageSectionsForNet() throws Exception {
		scrollToBottomOfPage();
		Thread.sleep(5000);
		scrollToBottomOfPage();
		return (existsElementByName(pageprops.getProperty("OVERVIEW_SPENDING")));
	}

	public void navigateToMenu() {
		pageDriver.findElement(By.name(pageprops.getProperty("HAMBURGER")))
		.click();
	}

	public void navigateToMoreOptions() {
		pageDriver.findElement(By.name(pageprops.getProperty("MORE_OPTIONS")))
		.click();
	//	eyes.checkWindow("More Options");
	}

	private boolean existsElementByName(String name) {
		try {
			pageDriver.findElement(By.name(name));
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

	private boolean existsElementByID(String ID) {
		System.out.println("Exist element called");
		try {
			pageDriver.findElement(By.id(ID));
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

	public void navigateToOverviewFromFeeds() {
		QuickenLogger.log(Level.INFO, "navigateToOverviewFromFeeds");
		pageDriver.findElement(
				By.name(pageprops.getProperty("OVERVIEW_OVERVIEWPAGE")))
		.click();
	}


	public void navigateToUdatesFromFeeds() {
		QuickenLogger.log(Level.INFO, "navigateToUpdatesFromFeeds");
		pageDriver.findElement(By.name(pageprops
				.getProperty("UPDATES_OVERVIEWPAGE")));
	}

	public void navigateToAddBudgetForIos() {
		QuickenLogger.log(Level.INFO, "navigateToAddBudgetForIos");
		pageDriver.findElement(
				By.name(pageprops.getProperty("OVERVIEW_PLUS_ICON"))).click();
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(pageprops
				.getProperty("OVERVIEW_POPUP_CREATE_BUDGET"))));
		pageDriver.findElement(
				By.name(pageprops.getProperty("OVERVIEW_POPUP_CREATE_BUDGET")))
		.click();
	}

	public void navigateToOverviewTab() {
		if (env.equals(TestProperties.ANDROID)) {

			FindElementByTagNameAndClick(pageDriver,"android.widget.TextView", "text", "OVERVIEW");
		}
		else
		{
			pageDriver.findElement(By.xpath(pageprops.getProperty("OVERVIEW"))).click();
		}

		/*WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(pageprops
				.getProperty("OVERVIEW"))));
		pageDriver.findElement(
				By.name(pageprops.getProperty("OVERVIEW")))
				.click();
		 */

	}

	public void navigateToUpdatedTab() {
		FindElementByTagNameAndClick(pageDriver,"android.widget.CompoundButton", "text", "UPDATES");
	}

	public void findElelemntByIndexAndClick(String classType, int index) {
		/*
		Looping thru elements is not working because there are more than1 image and
		 images dont have names to them.So forced to use index
		 */
		QuickenLogger.log(Level.INFO,"findElelemntByIndexAndClick to click floating icon");
		List<WebElement> listOfInputs = pageDriver.findElements(By
				.className(classType));
		listOfInputs.get(4).click();
	}


	public void clickOnFloatingIcon() {
		findElelemntByIndexAndClick("android.widget.ImageView", 1);
	}

	public void navigateToCreditScoreForRegisteredUser() throws Exception{
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		QuickenLogger.log(Level.INFO, "navigateToCreditScore");
		Thread.sleep(5000);
		FindElementByTagNameAndClick(pageDriver,"UIAStaticText", "label", "Credit Score");
		Thread.sleep(3000);

	}

	public void navigateToCreditScoreForNotRegisteredUser() throws Exception{
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		QuickenLogger.log(Level.INFO, "navigateToCreditScore");
		Thread.sleep(5000);
		FindElementByTagNameAndClick(pageDriver,"UIAStaticText", "label", "Credit Score");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.name("Skip"))).click();

	}

	public void navigateToBillReminders() throws Exception{
		QuickenLogger.log(Level.INFO, "navigateToBillReminders");
		scrollToBottomOfPage();
		Thread.sleep(5000);
		scrollToBottomOfPage();
		FindElementByTagNameAndClick(pageDriver,pageprops.getProperty("BILL_REMINDER"));
	}

	public boolean validateBillReminderInUpdates() throws Exception{
		return pageDriver.getPageSource().contains("Upcoming Bills");
	}

	public boolean validateBillReminderForAndroid() throws Exception{
		return pageDriver.getPageSource().contains("Progressive") && pageDriver.getPageSource().contains("Verizon Wireless");
	}

	public void navigateToViewAllBillReminders() throws Exception{
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		Thread.sleep(3000);
		pageDriver.findElement(By.name("Card Button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.name("Updates"))).click();
	}

	public boolean validateCashFlowInOverviewPage() throws Exception{	
		Thread.sleep(3000);
		scrollToBottomOfPage();
		return (pageDriver.getPageSource().contains("Cash flow") && pageDriver.getPageSource().contains("Earned") && pageDriver.getPageSource().contains("Spent"));
	}

	public void scrollUp() throws Exception {
		System.out.println("Waiting to scroll up");
		JavascriptExecutor js = (JavascriptExecutor) pageDriver;
		HashMap flickObject = new HashMap();
		flickObject.put("startX", 250);
		flickObject.put("startY", 250);
		flickObject.put("touchCount", 1);
		js.executeScript("mobile: swipe", flickObject);

	}

	public void scrollToElement(String ElementName){
		WebElement element = pageDriver.findElement(By.name(ElementName));
		Actions actions = new Actions(pageDriver);
		actions.moveToElement(element);
	}
	
	public void waitTillOverviewPageIsrefreshed(){
		QuickenLogger.log(Level.INFO, "Started waitTillOverviewPageIsrefreshed");
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageprops.getProperty("OVERVIEWPAGE_REFRESHED"))));
		QuickenLogger.log(Level.INFO, "OverviewPage Is fully refreshed");
	}
	
	//Added by vaishnavi
	public void clickRefresh(){
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageprops.getProperty("OVERVIEWPAGE_REFRESHED"))));
		pageDriver.findElement(By.xpath(pageprops.getProperty("OVERVIEWPAGE_REFRESHED"))).click();
		//WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageprops.getProperty("OVERVIEWPAGE_REFRESHED"))));

	}


}


