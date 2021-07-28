package com.core.ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.core.context.AutomationContextManager;

public class BrowserJava {
	
	private final static Logger logger = LoggerFactory.getLogger(Browser.class);
	
	public static void launch(String url) {
		AutomationContextManager.driver().get(url);
	}
	
	public static WebElement findElement(By locator) {
		return AutomationContextManager.driver().findElement(locator);
	}
	
	public static List<WebElement> findElements(By locator){
		return AutomationContextManager.driver().findElements(locator);
	}
	
	public static String getElementText(By locator) {
		return findElement(locator).getText();
	}
	
	public static String getAttributeValue(By locator, String attribute) {
		return findElement(locator).getAttribute(attribute);
	}
	
	
	
}