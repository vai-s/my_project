package com.qkn.automation.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.applitools.eyes.Eyes;

public class MenuPage extends Page{
	private String env;
	private WebDriver pageDriver;
	private java.util.Properties pageprops;
	//private Eyes eyes;
	
	public MenuPage(String env,WebDriver driver,java.util.Properties props){
		this.env = env;
		this.pageDriver = driver;
		this.pageprops = props;
		//this.eyes=eyes;
	}
	
	
	public void navigateToOverview() {
		pageDriver.findElement(By.name(pageprops.getProperty("OVERVIEW"))).click();
	}

	public void navigateToAccounts() {
		pageDriver.findElement(By.name(pageprops.getProperty("ACCOUNTS"))).click();
	}

	public void navigateToBudgets() {
		pageDriver.findElement(By.name(pageprops.getProperty("BUDGETS"))).click();
	}

	public void navigateToCashFlow() {
		pageDriver.findElement(By.name(pageprops.getProperty("CASHFLOW"))).click();
	}

	public void navigateToAlerts() {
		pageDriver.findElement(By.name(pageprops.getProperty("ALERTS"))).click();
	}
//Commented by ashwini-feature not in quicken 
	/*public void navigateToAdvice() {
		pageDriver.findElement(By.name(pageprops.getProperty("ADVICE"))).click();
	}*/

	public void navigateToTrends() {
		pageDriver.findElement(By.name(pageprops.getProperty("TRENDS"))).click();
	}
/*commented by ashwini-feature not in quicken 
	public void navigateToInvestments() {
		pageDriver.findElement(By.name(pageprops.getProperty("INVESTMENTS"))).click();
	}
*/
	public void navigateToSettings() {
		pageDriver.findElement(By.name(pageprops.getProperty("SETTINGS"))).click();

	}

	
}
