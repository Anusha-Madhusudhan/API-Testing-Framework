/**
 * 
 */
package com.tekarch.listeners;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * 
 */
public class ListernerClass implements ITestListener{
	
	
	public static ExtentReports extent;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentTest test;
	
	
	@Override
	public void onStart(ITestContext context) {
		
		extent=new ExtentReports();
		
		String timeStamp=new SimpleDateFormat("dd-MM-yyy-hh-mm-ss").format(new Date());
		
		String path=System.getProperty("user.dir")+"/src/test/resources/reports/"+timeStamp+".html";
		
		sparkReporter=new ExtentSparkReporter(new File(path));
		sparkReporter.config().setDocumentTitle("Sales Force Application");
		sparkReporter.config().setReportName("Functional Testing");
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Sales Force Application");
		extent.setSystemInfo("Environment", "QA Environment");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("Tester Name", "Anusha");
		
		
	}
	
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		test=extent.createTest(result.getName());
		test.log(Status.PASS, result.getName()+"is pass");
	}
	
	
	@Override
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, result.getName()+"is skip");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, result.getName()+" is fail");
		
		for(Object o:result.getParameters()) {
			test.info(String.valueOf(o));
		}
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
