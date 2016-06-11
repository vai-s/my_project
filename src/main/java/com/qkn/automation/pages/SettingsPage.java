package com.qkn.automation.pages;

import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.applitools.eyes.Eyes;

public class SettingsPage extends Page{

	private String env;
	private WebDriver pageDriver;
	private java.util.Properties pageProps;
	private Eyes eyes;

	public SettingsPage(String env,WebDriver driver,java.util.Properties props,Eyes eyes){
		this.env = env;
		this.pageDriver = driver;
		this.pageProps = props;
		this.eyes=eyes;
	}



	public void navigateToSettings() throws Exception{
		QuickenLogger.log(Level.INFO,"navigateToSettings");
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(pageProps.getProperty("MORE_OPTIONS"))));
		pageDriver.findElement(By.name(pageProps.getProperty("MORE_OPTIONS"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.name(pageProps
						.getProperty("SETTINGS"))));
		pageDriver.findElement(
				By.name(pageProps.getProperty("SETTINGS"))).click();

	}

	public void navigateToSettingsWithNoAccounts() throws Exception{
		QuickenLogger.log(Level.INFO,"navigateToSettingsWithNoAccounts");
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("More options")));
		pageDriver.findElement(By.name("More options")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(pageProps
						.getProperty("SETINGS_NOACCOUNT"))));
		pageDriver.findElement(
				By.xpath(pageProps.getProperty("SETINGS_NOACCOUNT"))).click();

	}

	public void naviogateToAccountsFromSettings(){
		QuickenLogger.log(Level.INFO,"naviogateToAccountsFromSettings");
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		/*wait.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath(pageProps
								.getProperty("SETTINGS_ACCOUNTS"))));
				pageDriver.findElement(
						By.xpath(pageProps.getProperty("SETTINGS_ACCOUNTS"))).click();

		 */
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.name(pageProps
						.getProperty("SETTINGS_ACCOUNTS"))));
		pageDriver.findElement(
				By.name(pageProps.getProperty("SETTINGS_ACCOUNTS"))).click();


	}
	//Added by Ashwini
	public void navigateToAccountsFromMoreoptions() throws Exception{
		QuickenLogger.log(Level.INFO,"navigateToSettingsWithNoAccounts");
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("More options")));
		pageDriver.findElement(By.name("More options")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.name(pageProps
						.getProperty("MORE_OPTIONS_ACCOUNTS"))));
		pageDriver.findElement(
				By.name(pageProps.getProperty("MORE_OPTIONS_ACCOUNTS"))).click();

	}


	public boolean validateAddAccountWithNoAccounts(){
		QuickenLogger.log(Level.INFO,"validateAddAccountWithNoAccounts");
		return pageDriver.getPageSource().toString().contains("No accounts");
	}

	public void addAccount() throws Exception{
		QuickenLogger.log(Level.INFO,"addAccount");
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Add")));
		pageDriver.findElement(By.name("Add")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Bank name")));
		pageDriver.findElement(By.name("Bank name")).sendKeys("Customer Central Bank");
		Thread.sleep(5000);
		pageDriver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]")).click();
		QuickenLogger.log(Level.INFO, "Exit: Found Search Results");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Password")));
		pageDriver.findElement(By.name("Password")).sendKeys("test");
		pageDriver.findElement(By.name("Text")).sendKeys("test");
		Thread.sleep(2000);
		pageDriver.findElement(By.name("Add")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button2")));
		pageDriver.findElement(By.id("android:id/button2")).click();

	}


	public void addDuplicateAccount() throws Exception {
		QuickenLogger.log(Level.INFO, "addAccount");
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Add")));
		pageDriver.findElement(By.name("Add")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.name("Bank name")));
		pageDriver.findElement(By.name("Bank name")).sendKeys(
				"Customer Central Bank");
		Thread.sleep(5000);
		pageDriver
		.findElement(
				By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]"))
		.click();
		QuickenLogger.log(Level.INFO, "Exit: Found Search Results");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.name("Password")));
		pageDriver.findElement(By.name("Password")).sendKeys("test");
		pageDriver.findElement(By.name("Text")).sendKeys("test");
		Thread.sleep(2000);
		pageDriver.findElement(By.name("Add")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("android:id/button1")));
		pageDriver.findElement(By.id("android:id/button1")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("android:id/button2")));
		pageDriver.findElement(By.id("android:id/button2")).click();

	}


	public void deleteAccount(){
		QuickenLogger.log(Level.INFO,"deleteAccount");
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageProps.getProperty("CUSTOMER_CENTRAL_BANK"))));
		pageDriver.findElement(By.xpath(pageProps.getProperty("CUSTOMER_CENTRAL_BANK"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("More")));
		pageDriver.findElement(By.name("More")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageProps.getProperty("DELETE_ACCOUNT_FROM_MORE_OPTIONS"))));
		pageDriver.findElement(By.xpath(pageProps.getProperty("DELETE_ACCOUNT_FROM_MORE_OPTIONS"))).click();
		pageDriver.findElement(By.id("android:id/button1")).click();

	}


	public void navigateToOverviewPageFromAddAccount(){
		QuickenLogger.log(Level.INFO,"navigateToOverviewPageFromAddAccount");
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageProps.getProperty("SETTINGS_TEXT_ADD_ACCOUNT"))));
		pageDriver.findElement(By.xpath(pageProps.getProperty("SETTINGS_TEXT_ADD_ACCOUNT"))).click();
	}

	//Added by Ashwini

	public void navigateToOverviewPageFromSettings(){
		QuickenLogger.log(Level.INFO,"navigateToOverviewPageFromSettings");
		WebDriverWait wait =  new WebDriverWait(pageDriver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(pageProps.getProperty("BACK_SETTINGS"))));

		pageDriver.findElement(By.className(pageProps.getProperty("BACK_SETTINGS"))).click();
	}

	public boolean validteAllAccountsPageContent() {
		QuickenLogger.log(Level.INFO,"validteAllAccountsPageContent");
		//return (pageDriver.getPageSource().toString().contains("My Line of Credit"));

		return (pageDriver.getPageSource().toString().contains("MONEY MARKET") && pageDriver.getPageSource().toString().contains("My Checking") &&
				pageDriver.getPageSource().toString().contains("My CD") && pageDriver.getPageSource().toString().contains("Overdraft") && pageDriver.getPageSource().toString().contains("My Savings")); 
	}

	//Android
	public void changePasscode_Android() throws Exception{
		QuickenLogger.log(Level.INFO,"changePasscode");
		pageDriver.findElement(By.name("Security")).click();
		Thread.sleep(2000);
		FindElementByTagNameAndClick(pageDriver,"android.widget.TextView", "text", "Use passcode");

		Thread.sleep(10000);
		pageDriver.findElement(By.id(pageProps.getProperty("PASSCODE"))).sendKeys("1234");
		Thread.sleep(5000);
		pageDriver.findElement(By.id(pageProps.getProperty("PASSCODE"))).sendKeys("1234");
		Thread.sleep(5000);
		pageDriver.findElement(By.name("Security")).click();
		Thread.sleep(2000);
		FindElementByTagNameAndClick(pageDriver,"android.widget.TextView", "text", "Use passcode");
		Thread.sleep(10000);
		pageDriver.findElement(By.id(pageProps.getProperty("PASSCODE"))).sendKeys("1234");
		Thread.sleep(5000);
		pageDriver.findElement(By.id(pageProps.getProperty("PASSCODE"))).sendKeys("4567");
		Thread.sleep(5000);
		pageDriver.findElement(By.id(pageProps.getProperty("PASSCODE"))).sendKeys("4567");
		Thread.sleep(5000);

	}

	//Added by Ashwini android
	public void setPasscode_Android() throws Exception{
		QuickenLogger.log(Level.INFO,"changePasscode");
		pageDriver.findElement(By.name("Security")).click();
		Thread.sleep(2000);
		FindElementByTagNameAndClick(pageDriver,"android.widget.TextView", "text", "Use passcode");
		Thread.sleep(10000);
		pageDriver.findElement(By.id(pageProps.getProperty("PASSCODE"))).sendKeys("1234");
		Thread.sleep(5000);
		pageDriver.findElement(By.id(pageProps.getProperty("PASSCODE"))).sendKeys("1234");

	}



	//Added by Ashwini 
	public void setPasscode_IOS() throws Exception{
		QuickenLogger.log(Level.INFO,"SetPasscode");
		pageDriver.findElement(By.name("Passcode")).click();
		Thread.sleep(2000);
		pageDriver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIASwitch[1]")).click();
		Thread.sleep(5000);
		pageDriver.findElement(By.name("1")).click();
		pageDriver.findElement(By.name("2")).click();
		pageDriver.findElement(By.name("3")).click();
		pageDriver.findElement(By.name("4")).click();

		if (pageDriver.getPageSource().contains("Confirm Passcode")){
			pageDriver.findElement(By.name("1")).click();
			pageDriver.findElement(By.name("2")).click();
			pageDriver.findElement(By.name("3")).click();
			pageDriver.findElement(By.name("4")).click();
		}
		else
		{
			System.out.println("No Confirm passcode screen");
		}
	}


	//Added by Ashwini 
	public void changePasscode_IOS() throws Exception{
		QuickenLogger.log(Level.INFO,"changePasscode");
		pageDriver.findElement(By.name("Passcode")).click();
		Thread.sleep(2000);
		pageDriver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIASwitch[1]")).click();
		Thread.sleep(5000);
		pageDriver.findElement(By.name("1")).click();
		pageDriver.findElement(By.name("2")).click();
		pageDriver.findElement(By.name("3")).click();
		pageDriver.findElement(By.name("4")).click();

		if (pageDriver.getPageSource().contains("Confirm Passcode")){
			pageDriver.findElement(By.name("1")).click();
			pageDriver.findElement(By.name("2")).click();
			pageDriver.findElement(By.name("3")).click();
			pageDriver.findElement(By.name("4")).click();
		}
		else
		{
			System.out.println("No Confirm passcode screen");
		}

		pageDriver.findElement(By.name("Change Passcode")).click();
		pageDriver.findElement(By.name("1")).click();
		pageDriver.findElement(By.name("2")).click();
		pageDriver.findElement(By.name("3")).click();
		pageDriver.findElement(By.name("4")).click();

		if (pageDriver.getPageSource().contains("Enter new Passcode")){
			pageDriver.findElement(By.name("5")).click();
			pageDriver.findElement(By.name("5")).click();
			pageDriver.findElement(By.name("5")).click();
			pageDriver.findElement(By.name("5")).click();
		}
		else
		{
			System.out.println("No Enter new Passcode screen");
		}
		pageDriver.findElement(By.name("5")).click();
		pageDriver.findElement(By.name("5")).click();
		pageDriver.findElement(By.name("5")).click();
		pageDriver.findElement(By.name("5")).click();

	}


	public void navigateToHelpandLegal() throws Exception{
		QuickenLogger.log(Level.INFO,"HelpandLegal");
		pageDriver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]")).click();
		Thread.sleep(2000);
		eyes.checkWindow("HelpandLegal");
		pageDriver.findElement(By.name("Settings")).click();
		Thread.sleep(2000);

	}


	//Added by Ashwini
	public void runAppinBackground() throws Exception{
		
     

	}
	
	public void sideOptions_Overview() throws Exception{
		pageDriver.findElement(By.name("Open")).click();
		pageDriver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[1]")).click();
	}
		
	public void sideOptions_Accounts() throws Exception{
		pageDriver.findElement(By.name("Open")).click();
		pageDriver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[2]")).click();
		pageDriver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[1]")).click();
		pageDriver.findElement(By.name("Navigate up")).click();
		
	}
	
	public void sideOptions_Budgets() throws Exception{
		pageDriver.findElement(By.name("Open")).click();
		pageDriver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[3]")).click();
		pageDriver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.LinearLayout[1]")).click();
		pageDriver.findElement(By.name("Navigate up")).click();
		
	}
		/*pageDriver.findElement(By.name("Open")).click();
		pageDriver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[4]")).click();
		pageDriver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[1]")).click();
		pageDriver.findElement(By.name("Navigate up")).click();
		pageDriver.findElement(By.name("Open")).click();
		pageDriver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[5]")).click();
		pageDriver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[1]")).click();
		pageDriver.findElement(By.name("Navigate up")).click();
		pageDriver.findElement(By.name("Open")).click();
		pageDriver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[6]")).click();
		pageDriver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[1]")).click();
		pageDriver.findElement(By.name("Navigate up")).click();
	}*/
	
	
	public void sideOptions_Alerts() throws Exception{
		pageDriver.findElement(By.name("Open")).click();
		pageDriver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[3]")).click();
		
	}
		
	
	

	public void logOut() throws Exception{
		QuickenLogger.log(Level.INFO,"logOut");
		pageDriver.findElement(By.name("Log Out")).click();
		Thread.sleep(3000);
		pageDriver.findElement(By.name("Log Out")).click();
	}
}
