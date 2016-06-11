package com.qkn.automation.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.applitools.eyes.Eyes;
import com.qkn.automation.utilities.TestConstants;
import com.thoughtworks.selenium.SeleniumException;

public class TransactionPage extends Page{
	private String env;
	private WebDriver pageDriver;
	private java.util.Properties pageprops;
	//	private Eyes eyes;

	public TransactionPage(String env,WebDriver driver,java.util.Properties props){
		this.env = env;
		this.pageDriver = driver;
		this.pageprops = props;
		//	this.eyes=eyes;
	}

	public void addTransaction_IOS() throws Exception{
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		//added by ashwini
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.name(pageprops.getProperty("CHOOSE_MERCHANT"))));
		pageDriver.findElement(
				By.name(pageprops.getProperty("CHOOSE_MERCHANT"))).click();
		Thread.sleep(15000);
		//added by ashwini
		/*	wait.until(ExpectedConditions.visibilityOfElementLocated(By
			.name(pageprops.getProperty("CHOOSE_MERCHANT"))));
			pageDriver.findElement(
					By.name(pageprops.getProperty("CHOOSE_MERCHANT"))).click();
			Thread.sleep(5000);*/
		createMerchantIOS();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.name(pageprops.getProperty("NUMBER_FIVE"))));
		pageDriver.findElement(
				By.name(pageprops.getProperty("NUMBER_FIVE"))).click();
		pageDriver.findElement(
				By.name(pageprops.getProperty("NUMBER_ZERO"))).click();
		pageDriver.findElement(
				By.name(pageprops.getProperty("NUMBER_ZERO"))).click();
		pageDriver.findElement(
				By.name(pageprops.getProperty("NEXT_BUTTON"))).click();
		Thread.sleep(3000);
		pageDriver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[4]")).click();
		Thread.sleep(3000);
		pageDriver.findElement(By.name("State")).click();
		Thread.sleep(3000);
		//The below has no names ask the developer
		pageDriver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[5]")).click();
		pageDriver.findElement(By.name("Tax Related")).click();
		pageDriver.findElement(By.name("Save")).click();
		pageDriver.findElement(By.name("Camera")).click();
	
		//	pageDriver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[4]/UIAActionSheet[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]")).click();
		//name Take Photo
		pageDriver.findElement(By.xpath(pageprops.getProperty("TAKE_PHOTO"))).click();
		//	Choose From Photo Library
		Thread.sleep(3000);
		pageDriver.findElement(By.name("OK")).click();
		//	Moments
		pageDriver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).click();
		//Select the first photo from the moments 
		pageDriver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.name(pageprops.getProperty("SAVE"))));
		pageDriver.findElement(By.name(pageprops.getProperty("SAVE"))).click();
		Thread.sleep(26000);
	}


	public void addTransactionWithoutAttachment_IOS() throws Exception{
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		//added by ashwini
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.name(pageprops.getProperty("CHOOSE_MERCHANT"))));
		pageDriver.findElement(
				By.name(pageprops.getProperty("CHOOSE_MERCHANT"))).click();
		Thread.sleep(15000);	
		createMerchantIOS();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.name(pageprops.getProperty("NUMBER_FIVE"))));
		pageDriver.findElement(
				By.name(pageprops.getProperty("NUMBER_FIVE"))).click();
		pageDriver.findElement(
				By.name(pageprops.getProperty("NUMBER_ZERO"))).click();
		pageDriver.findElement(
				By.name(pageprops.getProperty("NUMBER_ZERO"))).click();
		pageDriver.findElement(
				By.name(pageprops.getProperty("NEXT_BUTTON"))).click();
		Thread.sleep(3000);
		pageDriver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[4]")).click();
		Thread.sleep(3000);
		pageDriver.findElement(By.name("State")).click();
		Thread.sleep(3000);

		//The below has no names ask the developer
		pageDriver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[5]")).click();
		pageDriver.findElement(By.name("Tax Related")).click();
		pageDriver.findElement(By.name("Save")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.name(pageprops.getProperty("SAVE"))));
		pageDriver.findElement(By.name(pageprops.getProperty("SAVE"))).click();
		Thread.sleep(46000);
	}



	private void createMerchant() throws InterruptedException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String currentDate=dateFormat.format(date);
		String payeeName=("QucikenTest"+ currentDate);
		
		pageDriver.findElement(By.id("com.quicken.qm2014:id/merchant_name")).sendKeys(payeeName);
		findElementByXpathAndClick(pageDriver, pageprops.getProperty("CHOOSE_ENTEREDPAYEE"));
		
		
//		Thread.sleep(10000);
		//	pageDriver.findElement(By.id("com.quicken.qm2014:id/text")).click();
		
//		pageDriver.findElement(By.xpath(pageprops.getProperty("CHOOSE_ENTEREDPAYEE"))).click();

//		Thread.sleep(6000);


	}

	private void createMerchantIOS() throws InterruptedException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String currentDate=dateFormat.format(date);
		String payeeName=("QucikenTest"+ currentDate);
		// pageDriver.findElement(By.name("Clear text")).click();
		pageDriver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIASearchBar[1]")).click();
		Thread.sleep(3000);
		pageDriver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIASearchBar[1]/UIASearchBar[1]")).sendKeys(payeeName);
		Thread.sleep(10000);
		pageDriver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]")).click();
		Thread.sleep(6000);



	}



	public void addTransaction_Android() throws Exception{
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(pageprops.getProperty("CHOOSE_MERCHANT"))));
		findElementByXpathAndClick(pageDriver,pageprops.getProperty("CHOOSE_MERCHANT"));
		Thread.sleep(TestConstants.NOMINALSLEEPTIME);
		
		createMerchant();
		
//		pageDriver.findElement(By.name("1")).click();
//		pageDriver.findElement(By.name("2")).click();
//		pageDriver.findElement(By.name("3")).click();
//		pageDriver.findElement(By.name(pageprops.getProperty("NEXT_BUTTON"))).click();
		
		clickOnNumbersInNumberPad("1");
		clickOnNumbersInNumberPad("2");
		clickOnNumbersInNumberPad("3");
		clickOnNumbersInNumberPad("Next");
		
		Thread.sleep(TestConstants.MINSLEEPTIME);
		findElementByXpathAndClick(pageDriver, pageprops.getProperty("CATEGORY"));
		findElementByXpathAndSendKeys(pageDriver, pageprops.getProperty("CATEGORYNAME_TXTFLD"),"State");
		findElementByXpathAndClick(pageDriver, "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]");
		findElementByXpathAndClick(pageDriver, pageprops.getProperty("TAGS"));
		findElementByXpathAndClick(pageDriver, pageprops.getProperty("REIMBURSABLE"));
		findElementByXpathAndClick(pageDriver, pageprops.getProperty("TAGSDONE_BTN"));
		findElementByXpathAndClick(pageDriver, pageprops.getProperty("MEMO"));
		findElementByXpathAndSendKeys(pageDriver, pageprops.getProperty("MEMONOTES_TXT"), "test");
		findElementByXpathAndClick(pageDriver, pageprops.getProperty("MEMONOTESDONE_BTN"));
		findElementByXpathAndClick(pageDriver, pageprops.getProperty("TRANSACTIONSAVE_BTN"));
		
//		pageDriver.findElement(By.xpath(pageprops.getProperty("CATEGORY"))).click();
		//	pageDriver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[7]/android.widget.TextView[1]")).click();
//		pageDriver.findElement(By.xpath(pageprops.getProperty("CATEGORYNAME_TXTFLD"))).sendKeys("State");
		//Click on state 
//		pageDriver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).click();
//		Thread.sleep(15000);
//	    pageDriver.findElement(By.xpath(pageprops.getProperty("TAGS"))).click();
		//Select first tag
//		pageDriver.findElement(By.xpath(pageprops.getProperty("REIMBURSABLE"))).click();
		////pageDriver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[4]")).click();
		//pageDriver.findElement(By.id("com.quicken.qm2014:id/category_row"));
//		Thread.sleep(3000);
//		findElementByXpathAndClick(pageDriver, pageprops.getProperty("TAGSDONE_BTN"));
//		pageDriver.findElement(By.name("Done")).click();
//		Thread.sleep(5000);
		
		
		////pageDriver.findElement(By.id("com.quicken.qm2014:id/hint_for_tags"));
		////pageDriver.findElement(By.name("Tax Related")).click();
		//com.quicken.qm2014:id/tag_check
//		Thread.sleep(26000);
	}

	public void clickOnNumbersInNumberPad(String keytopress)
	{
		try{
			findElementByXpathAndClick(pageDriver, pageprops.getProperty("NUMBERPADBUTTONS")+"[@text='"+keytopress+"']");
			QuickenLogger.log(Level.INFO, "clicking on the button "+keytopress+" on numberpad was successfull");
			
		}catch(SeleniumException ex)
		{
			QuickenLogger.log(Level.SEVERE, "clicking on the button "+keytopress+" on numberpad was not successfull, following exception was thrown "+ex.getLocalizedMessage());
		}
		
	}
	

	public void addattachement_Android() throws Exception{
		
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.name(pageprops.getProperty("CHOOSE_MERCHANT"))));
		pageDriver.findElement(
				By.name(pageprops.getProperty("CHOOSE_MERCHANT"))).click();
		Thread.sleep(15000);
		createMerchant();
		pageDriver.findElement(By.name("1")).click();
		pageDriver.findElement(By.name("2")).click();
		pageDriver.findElement(By.name("3")).click();
		pageDriver.findElement(By.name(pageprops.getProperty("NEXT_BUTTON"))).click();
		Thread.sleep(3000);
		pageDriver.findElement(By.xpath(pageprops.getProperty("CATEGORY"))).click();
		//	pageDriver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[7]/android.widget.TextView[1]")).click();
		pageDriver.findElement(By.name("Category name")).sendKeys("State");
		//Click on state 
		pageDriver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).click();
		Thread.sleep(15000);
		//	pageDriver.findElement(By.xpath(pageprops.getProperty("TAGS"))).click();
		//Select first tag
		pageDriver.findElement(By.xpath(pageprops.getProperty("TAG_1"))).click();
		////pageDriver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[4]")).click();
		//pageDriver.findElement(By.id("com.quicken.qm2014:id/category_row"));
		Thread.sleep(3000);
		pageDriver.findElement(By.name("Done")).click();
		Thread.sleep(3000);
		pageDriver.findElement(By.xpath("MEMO")).click();
		pageDriver.findElement(By.name("Notes")).sendKeys("test");
		pageDriver.findElement(By.name("Done")).click();
		
		//attachement icon -com.quicken.qm2014:id/txn_detail_no_attachment
		//name =Take A New Photo    
		//Choose Existing Photo
		
		
		
		pageDriver.findElement(By.name("Save")).click();
	}
	


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
}
