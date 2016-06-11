package com.qkn.automation.pages;



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


public class BudgetsPage extends Page{
	private String env;
	private WebDriver pageDriver;
	private java.util.Properties pageprops;
	//private Eyes eyes;
	
	
	public BudgetsPage(String env,WebDriver driver,java.util.Properties props){
		this.env = env;
		this.pageDriver = driver;
		this.pageprops = props;
		//this.eyes=eyes;
	}
	
	
	public void addBudget(String category, int amount) throws Exception {
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		if(env.equals(TestProperties.ANDROID)){
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.name(pageprops.getProperty("MORE_OPTIONS"))));
			pageDriver.findElement(
					By.name(pageprops.getProperty("MORE_OPTIONS"))).click();
			findElementByNameAndClick("android.widget.TextView", "text", "Add budget");
			findElementByNameAndClick("android.widget.TextView", "text", "Parking");
			findElementByNameAndClick("android.widget.TextView", "text", "Done");
			
		}
		else{
		Thread.sleep(5000);
		pageDriver.findElement(By.name("Parking")).click();
		Thread.sleep(5000);
		pageDriver.findElement(By.name("Save")).click();
		}

	}
	
	public void editBudget() throws Exception{
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		if(env.equals(TestProperties.ANDROID)){
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.name(pageprops.getProperty("EDIT_BUDGET"))));
			pageDriver.findElement(By.name(pageprops.getProperty("EDIT_BUDGET"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(pageprops.getProperty("EDIT_BUDGET_VALUE"))));
		pageDriver.findElement(By.name(pageprops.getProperty("EDIT_BUDGET_VALUE"))).click();
		pageDriver.findElement(By.name(pageprops.getProperty("SET_BUDGET_VALUE"))).sendKeys("50");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.name("Done")));
		pageDriver.findElement(By.name(pageprops.getProperty("BUDGET_DONE"))).click();
		pageDriver.findElement(By.name(pageprops.getProperty("BUDGET_DONE"))).click();
		}
		else{
			QuickenLogger.log(Level.INFO, " Editing Budget for Ios");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.name(pageprops.getProperty("EDIT_BUDGET"))));
		pageDriver.findElement(By.name(pageprops.getProperty("EDIT_BUDGET"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.name(pageprops.getProperty("EDIT_BUDGET_VALUE"))));
		pageDriver.findElement(By.name(pageprops.getProperty("EDIT_BUDGET_VALUE"))).click();
	//	pageDriver.findElement(By.name(pageprops.getProperty("EDIT_BUDGET_VALUE"))).click();
		Thread.sleep(5000);
		/*wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(pageprops.getProperty("SET_BUDGET_VALUE3"))));
		pageDriver.findElement(By.xpath(pageprops.getProperty("SET_BUDGET_VALUE"))).sendKeys("50");*/
		findElementByXpathAndSendKeys("UIATextField", "xpath", "SET_BUDGET_VALUE","66");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.name("OK")));
		pageDriver.findElement(By.name(pageprops.getProperty("BUDGET_DONE"))).click();
		pageDriver.findElement(By.name(pageprops.getProperty("BUDGET_DONE"))).click();
		}
	
		
	}
	
	public void deleteBudget(String budgetName) throws Exception {
		QuickenLogger.log(Level.INFO,"Delete Budget");
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		if (env.equals(TestProperties.ANDROID)) {
			QuickenLogger.log(Level.INFO,"Deleting Budget in android");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.name(pageprops.getProperty("EDIT_BUDGET"))));
			pageDriver.findElement(By.name(pageprops.getProperty("EDIT_BUDGET"))).click();
			Thread.sleep(5000);
			pageDriver.findElement(
					By.name(pageprops.getProperty("DELETE_BUDGET_ICON")))
					.click();
			Thread.sleep(7000);
			pageDriver.findElement(By.id(pageprops.getProperty("DELETE_POPUP"))).click();
			Thread.sleep(5000);
		} else {
			pageDriver.findElement(By.name("Edit Budget")).click();
			Thread.sleep(5000);
			pageDriver.findElement(
					By.name("Delete"))
					.click();
			findElementByNameAndClick("UIATableCell","label", "Delete");
		}

	}
	//Added by Ashwini
	public void zeroStateBudget() throws Exception  {
		String BudgetMessage;
		WebDriverWait wait = new WebDriverWait(pageDriver, 120);
		if (env.equals(TestProperties.ANDROID)) {
		FindElementByTagNameAndClick(pageDriver, "android.widget.TextView",
				"text", "No Zero state budget message on the screens");		
		Thread.sleep(50000);
		
		}
		
	}
	
	//Added by Ashwini
	public boolean validateZeroStateTextinBudgetPage() throws Exception{	
		Thread.sleep(3000);
		if (env.equals(TestProperties.ANDROID)) {
		return (pageDriver.getPageSource().contains("You haven't budgeted any categories."));
		}
		else
			return (pageDriver.findElement(By.name("zeroStateLabel")).isDisplayed());
			}	
	
	
	
	//Added by Ashwini
	public int validateBudgetMonth() throws Exception{	
		Thread.sleep(3000);
		String month,actualmonth;
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MMMMMMMMM");
		month= formatter.format(date);          
        System.out.println("####################"+month+"&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		//return (pageDriver.getPageSource().contains("October"));
        actualmonth=pageDriver.findElement(By.id("com.quicken.qm2014:id/month")).getText();
    	Thread.sleep(3000);
        System.out.println("$$$$$$$$$$$$$$$"+actualmonth+"****************");
		return(month.compareToIgnoreCase(actualmonth));
		
				
	}
	
	public void findElementByXpathAndSendKeys(String classType, String searchType,
			String xpath,String amount) {
		List<WebElement> listOfInputs = pageDriver.findElements(By
				.className(classType));
		for (int i = 0; i < listOfInputs.size(); i++) {
			if (listOfInputs.get(i).getAttribute(searchType).equals(xpath))
				listOfInputs.get(i).sendKeys(amount);;
						}

	}
	
	
	public void navigateBacktoOverviewFromBudget() throws Exception{
		pageDriver.findElement(By.xpath(pageprops.getProperty("BACK_OVERVIEW"))).click();
	}
	
	public void navigateBacktoOverview() throws Exception{
		pageDriver.findElement(By.name(pageprops.getProperty("OVERVIEW"))).click();
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
