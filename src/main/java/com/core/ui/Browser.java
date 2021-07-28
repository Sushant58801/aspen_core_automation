package com.core.ui;

import java.io.File;
import java.io.IOException;

import javax.swing.text.Keymap;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aventstack.extentreports.utils.FileUtil;
import com.core.Utilities.Constant;

public interface Browser {

	final static Logger logger = LoggerFactory.getLogger(Browser.class);

	static void KillBrowserDriver() {
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromdriver.exe /T");
			Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe /T");
		} catch (IOException e) {
			logger.error("Error in killing browser driver", e);
		}
	}

	static String capture(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(Constant.screenshotreportpath + System.currentTimeMillis() + ".png");
		String errflpath = dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, dest);
		return errflpath;
	}

	static void Sleep(long wait) {
		try {
			Thread.sleep(wait);
		} catch (InterruptedException e) {
			logger.error("Error in wait command" + e);
		}

	}

	public void launch(String url);

	public void click(By locator);

	public void sendkeys(By locator, String string);

	public void sendkeys(By locator, Keys key);

	public void doubleClick(By locator);

	public String getElementText(By locator);

	public String getAttributeValue(By locator, String attributname);

	public boolean elementEnabled(By locator);

	public boolean elementSelected(By locator);

	public boolean elementVisible(By locator);

	public WebElement findElement(By locator);

	public void scrollTo(By locator);

	public void clearText(By locator);

	public void switchToFrame(int index);

	public void switchToFrame(String framename);

	public void switchToParent();

	public void rightClick(By locator);

	public void expliciteWait(By locator);

	public void mouseHover(By locator);

}
