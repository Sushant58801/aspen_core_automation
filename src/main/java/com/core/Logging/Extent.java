package com.core.Logging;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ResourceCDN;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sun.media.jfxmedia.track.Track.Encoding;
import com.aventstack.extentreports.*;


public class Extent {
	
	public static ExtentReports returnExtendReprot(String filepath) {
		ExtentReports extent = new ExtentReports();
		
		ExtentHtmlReporter htmlreport = new ExtentHtmlReporter(filepath);
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setDocumentTitle("Report");
		htmlreport.config().setEncoding("UFT-8");
		htmlreport.config().setReportName("Test Report");
		htmlreport.config().setResourceCDN(ResourceCDN.EXTENTREPORTS);
		
		extent.attachReporter(htmlreport);
		
		return extent;
		
	}

}
