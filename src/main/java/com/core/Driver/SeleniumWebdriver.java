package com.core.Driver;

import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.Status;
import com.core.context.AutomationContextManager;

import oracle.jdbc.internal.JMSDequeueOptions.StreamingMode;

public class SeleniumWebdriver {
	
	public void launchDriver() {
		WebDriver driver = null;
		String browser;
		String huburl;
		if (null != System.getProperty("browser") && "" !=System.getProperty("browser")) {
			browser=System.getProperty("browser");
		} else {
			browser = "Chrome";
		}
		
		if (null != System.getProperty("huburl") && "" !=System.getProperty("huburl")) {
			huburl=System.getProperty("huburl");
		} else {
			huburl = "https://localhost:4444/wb/hub";
		}
		
		try {
			if(browser.equalsIgnoreCase("Firefox")) {
				System.out.println("*********************************Executing on FireFox**********");
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				capabilities.setBrowserName("Firefox");
				driver = new RemoteWebDriver(new URL(huburl),capabilities);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			} else if (browser.equalsIgnoreCase("Chrome")) {
				System.out.println("*********************************Executing on Chrome**********");
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				HashMap<String, Object> chromeperfs = new HashMap<String, Object>();
				chromeperfs.put("download.default.directory", System.getProperty("downloadfilepath"));
				ChromeOptions option = new ChromeOptions();
				option.setExperimentalOption("useAutomationExtension", false);
				option.setExperimentalOption("prefs", chromeperfs);
				option.setAcceptInsecureCerts(true);
				capabilities.setBrowserName("Chrome");
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capabilities.setCapability(ChromeOptions.CAPABILITY, option);
				driver = new RemoteWebDriver(new URL(huburl),capabilities);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			}else if (browser.equalsIgnoreCase("IE")) {
				System.out.println("*********************************Executing on IE**********");
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setBrowserName("IE");
				driver = new RemoteWebDriver(new URL(huburl),capabilities);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			}
		}
		catch(Exception e) {
			AutomationContextManager.getExtendtest().log(Status.FAIL, "Selenim driver does not created");
		}
		
	}

}
