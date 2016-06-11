package com.qkn.automation.pages;

import java.util.NoSuchElementException;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.applitools.eyes.Eyes;


public class AllAccountsPage extends Page{
	private String env;
	private WebDriver pageDriver;
	private java.util.Properties pageprops;
//	private Eyes eyes;
	

	
	public AllAccountsPage(String env,WebDriver driver,java.util.Properties props){
		this.env = env;
		this.pageDriver = driver;
		this.pageprops = props;
	//	this.eyes=eyes;
	}

	
	public void navigateToFirstTXN() throws Exception{
		Thread.sleep(3000);
		 // CheckToggleText();
		if (pageDriver.getPageSource().contains("Tap to toggle balance"))
			
		{
			 pageDriver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
			 pageDriver.findElement(By.xpath(pageprops.getProperty("CD_FIRST_TXN"))).click();
		}
		else
			{
		  Thread.sleep(3000);
	     // FindElementByTagNameAndClick(pageDriver, pageprops.getProperty("CD_FIRST_TXN"));
		  pageDriver.findElement(By.xpath(pageprops.getProperty("CD_FIRST_TXN"))).click();
		}
	}
	
	
	public void CheckToggleText() throws Exception{
		Thread.sleep(3000);
		QuickenLogger.log(Level.INFO,"CheckToggleText transactions page");
		FindElementByTagNameAndClick(pageDriver,pageprops.getProperty("TOGGLE_TEXT_CLICK"));
	}
	
	private boolean existsElement(String name) {
	    try {
	        pageDriver.findElement(By.name(name));
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	    return true;
	}
	
	public void navigateBackToAccountsPage(){
		FindElementByTagNameAndClick(pageDriver, pageprops.getProperty("ACCOUNTS_BACK_BUTTON"));
	}
	
}
