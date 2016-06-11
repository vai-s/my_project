package com.qkn.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.applitools.eyes.Eyes;

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

}
