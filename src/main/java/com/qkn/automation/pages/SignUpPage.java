package com.qkn.automation.pages;

import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.applitools.eyes.Eyes;

public class SignUpPage extends Page{
	
	private String env;
	private WebDriver pageDriver;
	private java.util.Properties pageProps;
	//private Eyes eyes;
	
	public SignUpPage(String env,WebDriver driver,java.util.Properties props){
		this.env = env;
		this.pageDriver = driver;
		this.pageProps = props;
		//this.eyes=eyes;
	}

	public void signUpForIos(String country, String email, String zipcode,
			String password, String verifyPassword) throws Exception {
		QuickenLogger.log(Level.INFO, "Signing up user" + zipcode);
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.name(pageProps.getProperty("SIGNUP_BUTTON"))));
		Thread.sleep(3000);
		findElementByNameAndSendKeys("UIATextField", "label", "Email",email);
		pageDriver.findElement(By.xpath(pageProps.getProperty("COUNTRY")))
				.click();
		pageDriver.findElement(By.xpath(pageProps.getProperty("COUNTRY_CAN")))
				.sendKeys(country);
		findElementByNameAndSendKeys("UIATextField", "label", "Zip Code",zipcode);
		findElementByNameAndSendKeys("UIASecureTextField", "label", "Password",password);
		findElementByNameAndSendKeys("UIASecureTextField", "label", "Password Verify",verifyPassword);
		pageDriver.findElement(By.name(pageProps.getProperty("SIGNUP_BUTTON")))
				.click();
		Thread.sleep(10000);

	}

	
	public void signUp(String country,String email,String zipcode,String password,String verifyPassword) throws Exception{
		QuickenLogger.log(Level.INFO, "Signing up user" + zipcode);
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(pageProps.getProperty("EMAIL"))));
		 pageDriver.findElement(By.name(pageProps.getProperty("EMAIL"))).sendKeys(email);
		 Thread.sleep(5000);
		 if(env.equals(TestProperties.ANDROID)){
			 pageDriver.findElement(By.name(pageProps.getProperty("COUNTRY"))).click();
			 	if(country.equals("Canada"))
			 		pageDriver.findElement(By.xpath(pageProps.getProperty("COUNTRY_CAN"))).click();
			 	else
			 		pageDriver.findElement(By.xpath(pageProps.getProperty("COUNTRY_USA"))).click();
		 }
		 else{
			 pageDriver.findElement(By.xpath(pageProps.getProperty("COUNTRY"))).click();
			 pageDriver.findElement(By.xpath(pageProps.getProperty("COUNTRY_CAN"))).sendKeys(country);
		 }
		 pageDriver.findElement(By.name(pageProps.getProperty("ZIPCODE"))).sendKeys(zipcode);
		 pageDriver.findElement(By.name(pageProps.getProperty("PASSWORD"))).sendKeys(password);
		 pageDriver.findElement(By.name(pageProps.getProperty("VERIFY"))).sendKeys(verifyPassword);
		 pageDriver.findElement(By.name(pageProps.getProperty("SIGNUP_BUTTON"))).click();
		Thread.sleep(10000);
		
	}

	public void clearEmailField() {
		pageDriver.findElement(By.name(pageProps.getProperty("EMAIL")))
				.sendKeys(Keys.CONTROL + "a");
		pageDriver.findElement(By.name(pageProps.getProperty("EMAIL")))
				.sendKeys(Keys.DELETE);
	}
	
	public void addFIFromPostSignUpPage() throws Exception{
		  WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		if(env.equals(TestProperties.ANDROID)){
			QuickenLogger.log(Level.INFO, "Adding FI");
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(pageProps.getProperty("GET_STARTED"))));
		    pageDriver.findElement(By.name(pageProps.getProperty("GET_STARTED"))).click();
		}
		else
		pageDriver.findElement(By.xpath(pageProps.getProperty("FIND_BANK"))).click();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(pageProps.getProperty("SEARCH_BANK"))));
		pageDriver.findElement(By.name(pageProps.getProperty("SEARCH_BANK"))).sendKeys("Customer Central Bank");
	//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(pageProps.getProperty("CC_BANK_SEARCH_RESULTS"))));
		Thread.sleep(10000);
		//   wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(pageProps.getProperty("CC_BANK_SEARCH_RESULTS"))));
		pageDriver.findElement(By.xpath(pageProps.getProperty("CC_BANK_SEARCH_RESULTS"))).click();
		QuickenLogger.log(Level.INFO, "Exit: Found Search Results");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(pageProps.getProperty("BANK_PASSWORD"))));
		pageDriver.findElement(By.name(pageProps.getProperty("BANK_PASSWORD"))).sendKeys("test");
		Thread.sleep(5000);
		pageDriver.findElement(By.name(pageProps.getProperty("BANK_USERNAME"))).sendKeys("test");
		Thread.sleep(5000);
		if(env.equals(TestProperties.ANDROID)){
			pageDriver.findElement(By.name(pageProps.getProperty("ADD_IT"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(pageProps.getProperty("LATER"))));
			pageDriver.findElement(By.id(pageProps.getProperty("LATER"))).click();
		}
		else{
			pageDriver.findElement(By.xpath(pageProps.getProperty("ADD_IT"))).click();
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageProps.getProperty("LATER"))));
			pageDriver.findElement(By.xpath(pageProps.getProperty("LATER"))).click();
		}
		Thread.sleep(10000);		
	}
	
	public void addFIForiosFromPostSignUpPage() throws Exception {
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		pageDriver.findElement(By.name(pageProps.getProperty("FIND_BANK")))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(pageProps.getProperty("SEARCH_BANK"))));
		pageDriver.findElement(By.xpath(pageProps.getProperty("SEARCH_BANK")))
				.sendKeys("Customer Central Bank");
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(pageProps.getProperty("CC_BANK_SEARCH_RESULTS"))));
		Thread.sleep(10000);
		pageDriver.findElement(
				By.name(pageProps.getProperty("CC_BANK_SEARCH_RESULTS")))
				.click();
		QuickenLogger.log(Level.INFO, "Exit: Found Search Results");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(pageProps.getProperty("BANK_PASSWORD"))));
		pageDriver
				.findElement(By.xpath(pageProps.getProperty("BANK_PASSWORD")))
				.sendKeys("test");
		Thread.sleep(5000);
		pageDriver
				.findElement(By.xpath(pageProps.getProperty("BANK_USERNAME")))
				.sendKeys("test");
		Thread.sleep(5000);
		pageDriver.findElement(By.name(pageProps.getProperty("ADD_IT")))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.name(pageProps.getProperty("LATER"))));
		pageDriver.findElement(By.name(pageProps.getProperty("LATER")))
				.click();
		Thread.sleep(10000);
	}
	
	public boolean validateOverviewPageForIos() throws Exception{
		QuickenLogger.log(Level.INFO, "validateOverviewPageForIos");
		boolean overviewElements = false;
		Thread.sleep(5000);
		if(pageDriver.findElement(By.name(pageProps.getProperty("ACCOUNTS"))) == null || pageDriver.findElement(By.name(pageProps.getProperty("BUDGETS"))) == null || pageDriver.findElement(By.name(pageProps.getProperty("ALERTS"))) == null || pageDriver.findElement(By.name(pageProps.getProperty("CASHFLOW"))) == null)
		{
			QuickenLogger.log(Level.INFO,"Overview page elements not found so returning false");
			overviewElements = false;
		}
		else
		overviewElements = true;
		return overviewElements;
	}
	
	public boolean validateOverviewPageForAndroid() throws Exception{
		QuickenLogger.log(Level.INFO, "validateOverviewPageForAndroid");
		boolean overviewElements = false;
		if(pageDriver.findElement(By.name(pageProps.getProperty("OVERVIEW_ACCOUNTS"))) == null || pageDriver.findElement(By.name(pageProps.getProperty("OVERVIEW_BUDGETS"))) == null || pageDriver.findElement(By.name(pageProps.getProperty("OVERVIEW_CASHFLOW"))) == null)
		{
			QuickenLogger.log(Level.SEVERE,"Overview page elements not found so returning false for android");
			overviewElements = false;
		}
		else
		overviewElements = true;
		return overviewElements;
	}
	
	public void goToLoginPage() throws Exception {
		if (env.equals(TestProperties.ANDROID))
			pageDriver.navigate().back();
		else
			pageDriver.findElement(By.name("Close")).click();

	}
	
	public void navigateToLogOutForiOS() throws Exception{
		pageDriver.findElement(By.name("menuButton")).click();
		Thread.sleep(2000);
		pageDriver.findElement(By.name("Settings")).click();
		Thread.sleep(2000);
		pageDriver.findElement(By.xpath("//UIATableView[2]/UIATableCell[4]")).click();
		Thread.sleep(2000);
		pageDriver.findElement(By.xpath("//UIAAlert[1]/UIATableView[2]")).click();
		Thread.sleep(2000);
		
	}
	
	public void navigateToLogOutForAndroid() throws Exception{
		QuickenLogger.log(Level.INFO,"navigateToLogOutForAndroid");
		pageDriver.findElement(By.name("More options")).click();
		Thread.sleep(5000);
		pageDriver.findElement(By.xpath("//android.widget.ListView[1]/android.widget.LinearLayout[4]")).click();
		Thread.sleep(2000);
		// Logout cliclking will not work because scrolling is not supported. Because Logout does not have name we cannot make this work.
		JavascriptExecutor js = (JavascriptExecutor) pageDriver;
		js.executeScript("mobile: scrollTo", "element: name('Background Image:').ref");
		
	// This Logout will not work because scrolling witll not work.Layout of the elemnts gets changed.
		pageDriver.findElement(By.xpath("//android.view.View[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[6]")).click();
		Thread.sleep(2000);
		pageDriver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(2000);
		
	}
	
	public boolean validateErrorTextForExistingUser() throws Exception{
		QuickenLogger.log(Level.INFO,"validateErrorTextForExistingUser");
		String err = pageDriver.findElement(By.xpath(pageProps.getProperty("SIGNUP_FAILED_ERROR"))).getText();
		return pageDriver.getPageSource().contains("err");
	}
	
	public boolean validateTextInPage(String text){
		QuickenLogger.log(Level.INFO,"validateTextInPage");
		return pageDriver.getPageSource().contains(text);
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
	
}
