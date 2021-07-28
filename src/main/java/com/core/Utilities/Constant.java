package com.core.Utilities;

import java.io.File;

public class Constant {
	
	public final static String reportpath =System.getProperty("user.dir")+File.separator+"reports";
	public final static String reportfilepath = System.getProperty("user.dir")+File.separator+"reports"+File.separator+"AutomationrReport.html";
	public final static String archivereportpath = System.getProperty("user.dir")+File.separator+"reports"+File.separator+"Archive"+File.separator;
	public final static String screenshotreportpath = System.getProperty("user.dir")+File.separator+"reports"+File.separator+"ScreenShot"+File.separator;
	public final static String log4jreportpath = System.getProperty("user.dir")+File.separator+"reports"+File.separator+"Log"+File.separator;
	public final static String automationartifactpath =System.getProperty("user.dir")+File.separator+"reports"+File.separator+"AutomationArtifacts"+File.separator;
	public final static int dealy=120;
}
