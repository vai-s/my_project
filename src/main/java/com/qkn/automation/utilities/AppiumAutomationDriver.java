package com.qkn.automation.utilities;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppiumAutomationDriver {
	private WebDriver pageDriver;
	
	private boolean existsElementByName(String name) {
		try {
			pageDriver.findElement(By.name(name));
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}

	private boolean existsElementByID(String ID) {
		System.out.println("Exist element called");
		try {
			pageDriver.findElement(By.id(ID));
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;
	}
   
	
}
