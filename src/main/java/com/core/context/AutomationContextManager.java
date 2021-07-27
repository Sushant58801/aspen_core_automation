package com.core.context;

import java.sql.Connection;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class AutomationContextManager {
	private static ThreadLocal<WebDriver> driver = new InheritableThreadLocal<WebDriver>();
	private static ExtentReports extend = null;
	private static ThreadLocal<ExtentTest> extendtest = new InheritableThreadLocal<ExtentTest>();
	private static ThreadLocal<ExtentTest> extenttestnode = new InheritableThreadLocal<ExtentTest>();
	private static Properties prop = null;
	private static Connection connection = null;
	private static String basetab = "";

	public static WebDriver driver() {
		return driver.get();
	}

	public static void setDriver(WebDriver webdriver) {
		driver.set(webdriver);
	}

	public static ExtentReports getExtend() {
		return extend;
	}

	public static void setExtend(ExtentReports extend) {
		AutomationContextManager.extend = extend;
	}

	public static Properties getProp() {
		return prop;
	}

	public static void setProp(Properties prop) {
		AutomationContextManager.prop = prop;
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		AutomationContextManager.connection = connection;
	}

	public static String getBasetab() {
		return basetab;
	}

	public static void setBasetab(String basetab) {
		AutomationContextManager.basetab = basetab;
	}

	public static ExtentTest getExtendtest() {
		return extendtest.get();
	}

	public static void setExtendtest(ITestContext context) {
		ExtentTest extenttest = AutomationContextManager.getExtend().createTest(context.getName());
		AutomationContextManager.extendtest.set(extenttest); 
	}

	public static ExtentTest getExtenttestnode() {
		return extenttestnode.get();
	}

	public static void setExtenttestnode(String featurname) {
		ExtentTest extentestnode = getExtendtest().createNode(featurname);
		AutomationContextManager.extenttestnode.set(extentestnode);
	}
	
	
	
	

}
