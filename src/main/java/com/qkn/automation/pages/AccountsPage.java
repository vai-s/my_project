package com.qkn.automation.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.applitools.eyes.Eyes;

/*
 * @author bnimmagadda
 */

public class AccountsPage extends Page{
	private String env;
	private WebDriver pageDriver;
	private java.util.Properties pageprops;
	public static String loginUserid;
	public static String loginPassword;
	//private Eyes eyes;

	
	public AccountsPage(String env,WebDriver driver,java.util.Properties props){
		this.env = env;
		this.pageDriver = driver;
		this.pageprops = props;
		//this.eyes = eyes;
	}


	
	
	public void navigateToAllAccounts() throws Exception{
//		WebDriverWait wait = new WebDriverWait(pageDriver, 180);
//		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(pageprops.getProperty("ALL_ACCOUNTS"))));
//		   pageDriver.findElement(By.name(pageprops.getProperty("ALL_ACCOUNTS"))).click();
//	
		//works with quicken with changes to use tagname   accounts page
			Thread.sleep(3000);
			findElementByXpathAndClick(pageDriver,pageprops.getProperty("ALL_ACCOUNTS2"));
	}
	
	
	public void navigateToCD() throws Exception{
		   FindElementByTagNameAndClick(pageDriver, pageprops.getProperty("ALL_ACCOUNTS_CD"));
 
		  
	}
	
	public void navigateToChecking() throws Exception{
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageprops.getProperty("ALL_ACCOUNTS_CHECKING"))));
		   pageDriver.findElement(By.xpath(pageprops.getProperty("ALL_ACCOUNTS_CHECKING"))).click();
	}

	public void navigateToSavings() throws Exception{
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageprops.getProperty("ALL_ACCOUNTS_SAVINGS"))));
		   pageDriver.findElement(By.xpath(pageprops.getProperty("ALL_ACCOUNTS_SAVINGS"))).click();
	}

	public void navigateToVisa() throws Exception{
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageprops.getProperty("ALL_ACCOUNTS_VISA"))));
		   pageDriver.findElement(By.xpath(pageprops.getProperty("ALL_ACCOUNTS_VISA"))).click();
	}
	
	public void navigateToRothIRA() throws Exception{
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageprops.getProperty("ALL_ACCOUNTS_ROTH_IRA"))));
		   pageDriver.findElement(By.xpath(pageprops.getProperty("ALL_ACCOUNTS_ROTH_IRA"))).click();
	}
	
	public boolean validateAllAccountsPageSections() {
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageprops.getProperty("ALL_ACCOUNTS_CD"))));
		return (pageDriver.getPageSource().toString().contains("LOAN") && pageDriver.getPageSource().toString().contains("INVESTMENT") 
				&& pageDriver.getPageSource().toString().contains("CASH") && pageDriver.getPageSource().toString().contains("CREDIT CARDS"));
	}
	
	public void navigateBackToOverviewPage(){
		WebDriverWait wait =  new WebDriverWait(pageDriver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(pageprops.getProperty("NAVIGATE_HOME"))));
		pageDriver.findElement(By.name( pageprops.getProperty("NAVIGATE_HOME"))).click();
	}
	
	
	//Added by ashwini
	
	public void navigateBackToOverviewPageFromAccts(){
		WebDriverWait wait =  new WebDriverWait(pageDriver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(pageprops.getProperty("BACK_ACCOUNTS"))));
			//	(pageprops.getProperty("NAVIGATE_HOME"))));Navigate up
		pageDriver.findElement(By.className(pageprops.getProperty("BACK_ACCOUNTS"))).click();
	}
	
	//added by ashwini
	
	public void navigateBackToHomePageFromAccts(){
		WebDriverWait wait =  new WebDriverWait(pageDriver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(pageprops.getProperty("NAVIGATE_HOME"))));
		pageDriver.findElement(By.name(pageprops.getProperty("NAVIGATE_HOME"))).click();
	}
	
	
	private boolean existsElement(String name) {
	    try {
	        pageDriver.findElement(By.name(name));
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	    return true;
	}

// Added by ashwini 
	public String onlineBalance() throws Exception{
		String onlinevalue=null;
		//id/list_row_amount
		Thread.sleep(5000);
		WebDriverWait wait =  new WebDriverWait(pageDriver, 180);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(pageprops.getProperty("ONLINE_BALANCE2"))));
		onlinevalue =  pageDriver.findElement(By.name( pageprops.getProperty("ONLINE_BALANCE2"))).getAttribute("text");    
	 //   System.out.println(onlinevalue);
		return onlinevalue;
	}

	//Added by vaishnavi
	public void navigateToFirstAccount() {
		//WebDriverWait wait =  new WebDriverWait(pageDriver, 180);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(pageprops.getProperty("FIRST_ACCOUNT"))));
		pageDriver.findElement(By.xpath(pageprops.getProperty("FIRST_ACCOUNT"))).click();
		pageDriver.findElement(By.xpath(pageprops.getProperty("TOGGLE_BALANCE"))).click();
		
	}
	

}
