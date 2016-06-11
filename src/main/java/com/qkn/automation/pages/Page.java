package com.qkn.automation.pages;

import java.lang.reflect.Method;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.applitools.eyes.Eyes;
import com.thoughtworks.selenium.SeleniumException;



public  class Page  {
	Logger QuickenLogger = Logger.getLogger("MyLogger");
	//Added by ashwini for applitools
  	
	
	//
	public void FindElementByTagNameAndClick(WebDriver pageDriver,String classType, String searchType,
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
	
	public void FindElementByTagNameAndClick(WebDriver pageDriver,String val) {
		StringTokenizer st = new StringTokenizer(val,",");
		   String[] splitArray = val.split(",");
		List<WebElement> listOfInputs = pageDriver.findElements(By
				.className(splitArray[0]));
		for (int i = 0; i < listOfInputs.size(); i++) {
			if (listOfInputs.get(i).getAttribute(splitArray[1]).equals(splitArray[2])){
				listOfInputs.get(i).click();
				return;
			}

		}
		

	}
	
	public void FindElementByTagNameAndSendKeys(WebDriver pageDriver,String propertyName,String value) {
		StringTokenizer st = new StringTokenizer(propertyName,",");
		   String[] splitArray = propertyName.split(",");
		List<WebElement> listOfInputs = pageDriver.findElements(By
				.className(splitArray[0]));
		for (int i = 0; i < listOfInputs.size(); i++) {
			if (listOfInputs.get(i).getAttribute(splitArray[1]).equals(splitArray[2])){
				listOfInputs.get(i).sendKeys(value);
				return;
			}

		}
		

	}
	
	public void findElelemntByIndexAndClick(WebDriver driver,String classType, int index) {
		/*
		Looping thru elements is not working because there are more than1 image and
		 images dont have names to them.So forced to use index
		*/
		QuickenLogger.log(Level.INFO,"findElelemntByIndexAndClick");
		List<WebElement> listOfInputs = driver.findElements(By
				.className(classType));
				listOfInputs.get(index).click();
	}
	
	public void findElelemntByIndexAndClick(WebDriver driver,String propertyName) {
		/*
		Looping thru elements is not working because there are more than1 image and
		 images dont have names to them.So forced to use index
		*/
		StringTokenizer st = new StringTokenizer(propertyName,",");
		   String[] splitArray = propertyName.split(",");
		   int index = Integer.parseInt(splitArray[1]);
		QuickenLogger.log(Level.INFO,"findElelemntByIndexAndClick");
		List<WebElement> listOfInputs = driver.findElements(By
				.className(splitArray[0]));
				listOfInputs.get(index).click();
	}
	
	public void findElementByXpathAndClick(WebDriver driver,String XPATH)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try{
			driver.findElement(By.xpath(XPATH)).click();	
			QuickenLogger.log(Level.INFO,"Element with xpath "+XPATH+" was clicked");
		}
		catch(SeleniumException ex)
		{
			QuickenLogger.log(Level.SEVERE, "Exception while clicking on element with xpath "+XPATH);
			ex.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
	}
	
	public void findElementByXpathAndSendKeys(WebDriver driver,String XPATH,String textToSet)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try{
			driver.findElement(By.xpath(XPATH)).sendKeys(textToSet);	
			QuickenLogger.log(Level.INFO,"The text "+textToSet+" was set in the Element with xpath "+XPATH);
		}
		catch(SeleniumException ex)
		{
			QuickenLogger.log(Level.SEVERE, "Exception while findElementByXpathAndSendKeys on element with xpath "+XPATH);
			ex.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
	}
	
	public boolean existsElementByName(WebDriver pageDriver,String name) {
		try {
			pageDriver.findElement(By.name(name));
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

	public boolean existsElementByID(WebDriver pageDriver,String ID) {
		System.out.println("Exist element called");
		try {
			pageDriver.findElement(By.id(ID));
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}
	
	public boolean existsElementByXPATH(WebDriver pageDriver,String XPATH) {
		System.out.println("Inside existsElementByXPATH");
		try {
			pageDriver.findElement(By.xpath(XPATH));
			System.out.println("Element with xpath "+XPATH+" exist");
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}
	
	

}