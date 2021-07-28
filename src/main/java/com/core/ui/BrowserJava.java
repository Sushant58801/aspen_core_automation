package com.core.ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.core.Utilities.Constant;
import com.core.context.AutomationContextManager;

public class BrowserJava {

	private final static Logger logger = LoggerFactory.getLogger(Browser.class);

	public static void launch(String url) {
		AutomationContextManager.driver().get(url);
	}

	public static WebElement findElement(By locator) {
		return AutomationContextManager.driver().findElement(locator);
	}

	public static List<WebElement> findElements(By locator) {
		return AutomationContextManager.driver().findElements(locator);
	}

	public static String getElementText(By locator) {
		return findElement(locator).getText();
	}

	public static String getAttributeValue(By locator, String attribute) {
		return findElement(locator).getAttribute(attribute);
	}

	public static void switchToFream(int index) {
		AutomationContextManager.driver().switchTo().frame(index);
	}

	public static void switchToFream(String framename) {
		AutomationContextManager.driver().switchTo().frame(framename);
	}

	public static void switchToParent() {
		AutomationContextManager.driver().switchTo().defaultContent();
	}

	public static void click(By locator) {
		WebElement element = null;
		Boolean flag = false;
		WebDriverWait wait = new WebDriverWait(AutomationContextManager.driver(), Constant.dealy);

		for (int i = 0; i < 2; i++) {
			try {
				element = AutomationContextManager.driver().findElement(locator);
				wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				wait.until(ExpectedConditions.elementToBeClickable(locator));
				element.click();
				logger.info("element is clickable" + locator);

				System.out.println("Clicked Passed********" + AutomationContextManager.driver() + "********" + locator);
				long threadid = Thread.currentThread().getId();
				System.out.println("Thread id is" + threadid);

				flag = true;
				break;

			} catch (Exception e) {
				logger.error("Error on clicking element for occurence-->>" + i + "locator" + locator, e);

			}

			if (flag = false) {
				logger.error("Element is not clickable>>>" + locator);

				System.out.println("Clicked Failed********" + AutomationContextManager.driver() + "********" + locator);
				long threadid = Thread.currentThread().getId();
				System.out.println("Thread id is" + threadid);

			}
		}
	}

	public static void sendkeys(By locator, String text) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(AutomationContextManager.driver(), Constant.dealy);

		try {
			element = AutomationContextManager.driver().findElement(locator);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			element.clear();
			element.sendKeys(text);
			logger.info("Entered text in to element" + locator);

			System.out.println("Sendkeys Passed********" + AutomationContextManager.driver() + "********" + locator);
			long threadid = Thread.currentThread().getId();
			System.out.println("Thread id is" + threadid);

		} catch (Exception e) {
			logger.error("Error on entering text into  element for occurence-->>" + locator, e);

			System.out.println("Sendkeys Failed********" + AutomationContextManager.driver() + "********" + locator);
			long threadid = Thread.currentThread().getId();
			System.out.println("Thread id is" + threadid);

		}
	}

	public static void doubleClick(By locator) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(AutomationContextManager.driver(), Constant.dealy);

		try {
			Actions action = new Actions(AutomationContextManager.driver());
			element = AutomationContextManager.driver().findElement(locator);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			action.doubleClick(element).perform();

			logger.info("Element is double clicked" + locator);

			System.out.println("Click Passed********" + AutomationContextManager.driver() + "********" + locator);
			long threadid = Thread.currentThread().getId();
			System.out.println("Thread id is" + threadid);

		} catch (Exception e) {
			logger.error("Error on double clicking element for occurence-->>" + locator, e);

			System.out.println("Click Failed********" + AutomationContextManager.driver() + "********" + locator);
			long threadid = Thread.currentThread().getId();
			System.out.println("Thread id is" + threadid);

		}
	}

	public static void rightClick(By locator) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(AutomationContextManager.driver(), Constant.dealy);

		try {
			Actions action = new Actions(AutomationContextManager.driver());
			element = AutomationContextManager.driver().findElement(locator);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			action.contextClick(element).perform();

			logger.info("Element is right clicked" + locator);

			System.out.println("right Click Passed********" + AutomationContextManager.driver() + "********" + locator);
			long threadid = Thread.currentThread().getId();
			System.out.println("Thread id is" + threadid);

		} catch (Exception e) {
			logger.error("Error on right clicking element for occurence-->>" + locator, e);

			System.out.println("right Click Failed********" + AutomationContextManager.driver() + "********" + locator);
			long threadid = Thread.currentThread().getId();
			System.out.println("Thread id is" + threadid);

		}
	}

	public static boolean elementVisible(By locator) {
		WebElement element = null;
		Boolean flag = false;
		try {
			element = AutomationContextManager.driver().findElement(locator);
			flag = element.isDisplayed();
			logger.info("Element is  visible" + locator);

			System.out.println(
					"element visibility Passed********" + AutomationContextManager.driver() + "********" + locator);
			long threadid = Thread.currentThread().getId();
			System.out.println("Thread id is" + threadid);

		} catch (Exception e) {
			logger.error("Element is not visible-->>" + locator, e);
			System.out.println(
					"element visibility Failed********" + AutomationContextManager.driver() + "********" + locator);
			long threadid = Thread.currentThread().getId();
			System.out.println("Thread id is" + threadid);

		}
		return flag;
	}

	public static boolean elementEnable(By locator) {
		WebElement element = null;
		Boolean flag = false;
		try {
			element = AutomationContextManager.driver().findElement(locator);
			flag = element.isEnabled();
			logger.info("Element is  enabled" + locator);

			System.out.println(
					"element enabled Passed********" + AutomationContextManager.driver() + "********" + locator);
			long threadid = Thread.currentThread().getId();
			System.out.println("Thread id is" + threadid);

		} catch (Exception e) {
			logger.error("Element is not enabled-->>" + locator, e);
			System.out.println(
					"element enable Failed********" + AutomationContextManager.driver() + "********" + locator);
			long threadid = Thread.currentThread().getId();
			System.out.println("Thread id is" + threadid);

		}
		return flag;
	}

	public static boolean elementSelected(By locator) {
		WebElement element = null;
		Boolean flag = false;
		try {
			element = AutomationContextManager.driver().findElement(locator);
			flag = element.isSelected();
			logger.info("Element is  selected" + locator);

			System.out.println(
					"element select Passed********" + AutomationContextManager.driver() + "********" + locator);
			long threadid = Thread.currentThread().getId();
			System.out.println("Thread id is" + threadid);

		} catch (Exception e) {
			logger.error("Element is not selected-->>" + locator, e);
			System.out.println(
					"element select Failed********" + AutomationContextManager.driver() + "********" + locator);
			long threadid = Thread.currentThread().getId();
			System.out.println("Thread id is" + threadid);

		}
		return flag;
	}

	public static void scrollTo(By locator) {
		WebElement element = null;
		try {
			element = AutomationContextManager.driver().findElement(locator);
			Actions action = new Actions(AutomationContextManager.driver());
			action.moveToElement(element);
			action.perform();
			logger.info("scroll to operation perform on element" + locator);

			System.out.println(
					"element scroll Passed********" + AutomationContextManager.driver() + "********" + locator);
			long threadid = Thread.currentThread().getId();
			System.out.println("Thread id is" + threadid);

		} catch (Exception e) {
			logger.error("scroll to operation not perform on element-->>" + locator, e);
			System.out.println(
					"element scroll Failed********" + AutomationContextManager.driver() + "********" + locator);
			long threadid = Thread.currentThread().getId();
			System.out.println("Thread id is" + threadid);

		}

	}

	public static void sendkeys(By locator, Keys key) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(AutomationContextManager.driver(), Constant.dealy);

		try {
			element = AutomationContextManager.driver().findElement(locator);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			element.clear();
			element.sendKeys(key);
			logger.info("Entered text in to element" + locator);

			System.out.println("Sendkeys Passed********" + AutomationContextManager.driver() + "********" + locator);
			long threadid = Thread.currentThread().getId();
			System.out.println("Thread id is" + threadid);

		} catch (Exception e) {
			logger.error("Error on entering text into  element for occurence-->>" + locator, e);

			System.out.println("Sendkeys Failed********" + AutomationContextManager.driver() + "********" + locator);
			long threadid = Thread.currentThread().getId();
			System.out.println("Thread id is" + threadid);

		}
	}

	public static void expliciteWait(By locator) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(AutomationContextManager.driver(), Constant.dealy);

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

			logger.info("Element is visbile using explicite wait-->>" + locator);

			System.out.println(
					"Explicite Wait Passed********" + AutomationContextManager.driver() + "********" + locator);
			long threadid = Thread.currentThread().getId();
			System.out.println("Thread id is" + threadid);

		} catch (Exception e) {
			logger.error("Element is not visbile using explicite wait-->>" + locator, e);

			System.out.println(
					"Explicite Wait  Failed********" + AutomationContextManager.driver() + "********" + locator);
			long threadid = Thread.currentThread().getId();
			System.out.println("Thread id is" + threadid);

		}
	}

	public static void clearText(By locator) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(AutomationContextManager.driver(), Constant.dealy);

		try {
			element = AutomationContextManager.driver().findElement(locator);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			element.clear();

			logger.info("Entered text is cleared-->>" + locator);

			System.out.println("Clear text Passed********" + AutomationContextManager.driver() + "********" + locator);
			long threadid = Thread.currentThread().getId();
			System.out.println("Thread id is" + threadid);

		} catch (Exception e) {
			logger.error("Entered text is not cleared-->>" + locator, e);

			System.out.println("Clear text  Failed********" + AutomationContextManager.driver() + "********" + locator);
			long threadid = Thread.currentThread().getId();
			System.out.println("Thread id is" + threadid);

		}
	}

}