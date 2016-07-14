package com.qkn.automation.pages;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.applitools.eyes.Eyes;
import com.qkn.automation.utilities.TestConstants;

public class TransactionDetailPage extends Page{
	private String env;
	private WebDriver pageDriver;
	private java.util.Properties pageprops;
	//private Eyes eyes;

	public TransactionDetailPage(String env,WebDriver driver,java.util.Properties props){
		this.env = env;
		this.pageDriver = driver;
		this.pageprops = props;
		//	this.eyes=eyes;
	}


	public void updateNotes(String updatedNote){
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(pageprops.getProperty("TXN_DETAIL_NOTES"))));
		pageDriver.findElement(By.id(pageprops.getProperty("TXN_DETAIL_NOTES_old"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(pageprops.getProperty("NOTE_EDIT_BOX"))));
		pageDriver.findElement(
				By.name(pageprops.getProperty("NOTE_EDIT_BOX"))).sendKeys(
						Keys.CONTROL + "a");
		pageDriver.findElement(
				By.name(pageprops.getProperty("NOTE_EDIT_BOX"))).sendKeys(
						Keys.DELETE);
		pageDriver.findElement(By.name(pageprops.getProperty("NOTE_EDIT_BOX"))).sendKeys(updatedNote);
		pageDriver.findElement(By.name(pageprops.getProperty("NOTE_EDIT_DONE"))).click();


	}

	public void updateNotesWithXpath(String updatedNote) throws Exception {
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		Thread.sleep(3000);
		FindElementByTagNameAndClick(pageDriver,
				pageprops.getProperty("TXN_DETAIL_NOTES"));
		pageDriver.findElement(By.name(pageprops.getProperty("NOTE_EDIT_BOX"))).sendKeys(updatedNote);
		pageDriver
		.findElement(By.name(pageprops.getProperty("NOTE_EDIT_DONE")))
		.click();

	}

	public void clearNotes() throws Exception {
		FindElementByTagNameAndClick(pageDriver,
				pageprops.getProperty("TXN_DETAIL_NOTES"));
		pageDriver.findElement(
				By.name(pageprops.getProperty("NOTE_EDIT_BOX"))).sendKeys(
						Keys.CONTROL + "a");
		pageDriver.findElement(
				By.name(pageprops.getProperty("NOTE_EDIT_BOX"))).sendKeys(
						Keys.DELETE);

		pageDriver
		.findElement(By.name(pageprops.getProperty("NOTE_EDIT_DONE")))
		.click();

	}

	public boolean verifyNoteUpdated(String updatedNote){
		return pageDriver.getPageSource().toString().contains(updatedNote);

	}

	public void updateTag() throws Exception{
		Thread.sleep(3000);
		// FindElementByTagNameAndClick(pageDriver, pageprops.getProperty("TAGS"));
		pageDriver.findElement(By.xpath(pageprops.getProperty("EDIT_TAGS"))).click();
		//  findElelemntByIndexAndClick(pageDriver,pageprops.getProperty("TXN_TAG_TYPE"));
		pageDriver.findElement(By.xpath(pageprops.getProperty("REIMBURSABLE"))).click();
		pageDriver.findElement(By.xpath(pageprops.getProperty("TAXRELEATED"))).click();
		pageDriver.findElement(By.xpath(pageprops.getProperty("VACATION"))).click();
		pageDriver.findElement(By.name(pageprops.getProperty("NOTE_EDIT_DONE"))).click();
	}

	public void updateDate(){



	}
	public void updateCategory(){

	}

	public void updateMerchant(String merchantName){
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		//FindElementByTagNameAndClick(pageDriver, pageprops.getProperty("TXN_DETAIL_MERCHANT"));
		pageDriver.findElement(By.xpath(pageprops.getProperty("TXN_DETAIL_MERCHANT"))).click();
		//com.quicken.qm2014:id/merchant_name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(pageprops.getProperty("SEARCH_MERCHANT"))));
		for(int i=0;i<5; i++){
			pageDriver.findElement(
					By.name(pageprops.getProperty("SEARCH_MERCHANT"))).sendKeys(
							Keys.CONTROL + "a");
			pageDriver.findElement(
					By.name(pageprops.getProperty("SEARCH_MERCHANT"))).sendKeys(
							Keys.DELETE);
		}
		pageDriver.findElement(By.name(pageprops.getProperty("SEARCH_MERCHANT"))).sendKeys(merchantName);
		FindElementByTagNameAndClick(pageDriver,"android.widget.TextView","text", merchantName);
	}

	public boolean validateUpdatedContent(String updateContent){
		return (pageDriver.getPageSource().toString().contains("Reimbursable") && pageDriver.getPageSource().toString().contains("Tax Related") && pageDriver.getPageSource().toString().contains("Vacation"));
	}

	public void save(){
		pageDriver.findElement(By.name("Save")).click();
	}

	public void navigateBackToAccountsFromCD(){
		FindElementByTagNameAndClick(pageDriver, pageprops.getProperty("MY_CD_BACK_BUTTON"));
	}

	
	//added by vaishnavi
	public void compareTag() throws IOException {
		// TODO Auto-generated method stub
//		findElementByXpathAndClick(pageDriver, pageprops.getProperty("OVERVIEW_ACCOUNTS"));
//		findElementByXpathAndClick(pageDriver, pageprops.getProperty("ALL_ACCOUNTS1"));
//		findElementByXpathAndClick(pageDriver, pageprops.getProperty("ALL_ACCOUNTS_FIRST_TXN"));
		
		String qd_tag="";
		InputStream reader = new FileInputStream("/Users/vs/Documents/test.properties");
		Properties properties = new Properties();
		properties.load(reader);
		qd_tag = properties.getProperty("Tags");
		
		//String qd_tag= "Tax Related";
		String qm_tag= pageDriver.findElement(By.xpath(pageprops.getProperty("FRST_TXN_TAG"))).getText();
		//Assert.assertTrue(qd_tag.equals(qm_tag), "Tags match");
		Assert.assertEquals(qd_tag, qm_tag);
	}
	
	public void compareCategory() throws IOException {
		// TODO Auto-generated method stub
		String qd_cat="";
		InputStream reader = new FileInputStream("/Users/vs/Documents/test.properties");
		Properties properties = new Properties();
		properties.load(reader);
		qd_cat = properties.getProperty("Category");
		
		
		//String qd_tag= "State";
		String qm_cat= pageDriver.findElement(By.xpath(pageprops.getProperty("FRST_TXN_CAT"))).getText();
		//Assert.assertTrue(qd_cat.equals(qm_cat), "Categories match");
		Assert.assertEquals(qd_cat, qm_cat);

		
	}
	
	public void compareMemo() throws IOException {
		// TODO Auto-generated method stub
		String qd_mem="";
		InputStream reader = new FileInputStream("/Users/vs/Documents/test.properties");
		Properties properties = new Properties();
		properties.load(reader);
		qd_mem = properties.getProperty("Memo");
		
		
		//String qd_mem= "xyz";
		String qm_mem= pageDriver.findElement(By.xpath(pageprops.getProperty("FRST_TXN_MEMO"))).getText();
		//Assert.assertTrue(qd_cat.equals(qm_mem), "Memo matches");
		Assert.assertEquals(qd_mem, qm_mem);
		
	}
	
	public void comparePayee() throws IOException {
	// TODO Auto-generated method stub
	String qd_payee="";
	InputStream reader = new FileInputStream("/Users/vs/Documents/test.properties");
	Properties properties = new Properties();
	properties.load(reader);
	qd_payee = properties.getProperty("Payee");
	
	String qm_payee= pageDriver.findElement(By.xpath(pageprops.getProperty("FRST_TXN_PAYEE"))).getText();
	//Assert.assertTrue(qd_payee.equals(qm_payee), "Payee matches");
	Assert.assertEquals(qd_payee, qm_payee);
	
}
	
	
	public void compareAccount() throws IOException {
	// TODO Auto-generated method stub
	String qd_acc="";
	InputStream reader = new FileInputStream("/Users/vs/Documents/test.properties");
	Properties properties = new Properties();
	properties.load(reader);
	qd_acc = properties.getProperty("Account");
	
	String qm_acc= pageDriver.findElement(By.xpath(pageprops.getProperty("FRST_TXN_ACC"))).getText();
	//Assert.assertTrue(qd_acc.equals(qm_acc), "Account matches");
	Assert.assertEquals(qd_acc, qm_acc);
	
}


	public void compareAmount() throws IOException {
		// TODO Auto-generated method stub
		String qd_amt="";
		InputStream reader = new FileInputStream("/Users/vs/Documents/test.properties");
		Properties properties = new Properties();
		properties.load(reader);
		qd_amt = properties.getProperty("Amount");
		
		String qm_amt= pageDriver.findElement(By.xpath(pageprops.getProperty("FRST_TXN_AMNT"))).getText();
		//Assert.assertTrue(qd_acc.equals(qm_acc), "Account matches");
		Assert.assertEquals(qd_amt, qm_amt);
		
		
	}


	public void logOut() throws InterruptedException {
		// TODO Auto-generated method stub
		pageDriver.findElement(By.xpath(pageprops.getProperty("MORE_OPTIONS"))).click();
		pageDriver.findElement(By.xpath(pageprops.getProperty("OPTION_SETTING"))).click();
		pageDriver.findElement(By.xpath(pageprops.getProperty("SETTING_LOGOUT"))).click();
		
//		if (pageDriver.getPageSource().contains("Log out")) {
//			pageDriver.findElement(By.name("Log out")).click();
//			Thread.sleep(TestConstants.NOMINALSLEEPTIME);
//		}
		pageDriver.findElement(By.xpath(pageprops.getProperty("LOGOUT_NOW"))).click();
		pageDriver.findElement(By.xpath(pageprops.getProperty("LOGOUT_BTN"))).click();
		
		
	}


	
}
