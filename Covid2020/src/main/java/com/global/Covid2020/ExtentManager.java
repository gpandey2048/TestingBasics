package com.global.Covid2020;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentManager  extends BaseTest{
	public static  ExtentReports extent;
	
	
	
	public static ExtentReports getInstance()
	{
		if (extent==null) {
			
			Date dt= new Date();
			String filePath = dt.toString().replace(':', '_').replace(' ', '_')+(".html");
			
			
			extent=new ExtentReports(projectpath+ "//Htmlreports//"+filePath);
			extent.loadConfig(new File(projectpath+"//extentconfigreport.xml"));
			
			//extent.addSystemInfo("Selenium Language","Version 2.10").addSystemInfo("Environment","Production");
			extent.addSystemInfo("Selenium Language", "3.11.0").addSystemInfo("Environment",mainprop.getProperty("env"));

			
			
		}
		
		
		
		
		
		
		
		return extent;
		
		
		
		
		
	}
	
	
	

}
