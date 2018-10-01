package stepDefinitions;

import java.io.File;
import java.lang.reflect.Method;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import functionLibrary.GenericFunctions;

public class Hooks {

	TestContext testContext;
/*	public static ExtentReports extReports;
	public static ExtentTest extTestReporter;
	public GenericFunctions genfun;
	//boolean isTestReportSet=false;
	public String testReportFilePath="./src/main/resources/TestReport/TestReport.html";
	public String testReportConfigFielPath="extent-config.xml";
	public Method method;*/
	

	public Hooks(TestContext context) {
		testContext = context;

		
	}
	
	/*public ExtentTest getExtTestReporter(){
		return extTestReporter;
	}
	
	public ExtentReports getExtTestReports(){
		return extReports;
	}
*/
	@Before
	public void BeforeSteps() {
		
/*		if (!isTestReportSet) {
			extReports = new ExtentReports(testReportFilePath, true, DisplayOrder.OLDEST_FIRST);
			extReports.loadConfig(new File(testReportConfigFielPath));
			isTestReportSet = true;
		}
		*/
//		extTestReporter = extReports.startTest(this.getClass().getName(), "test desc");
		
		/*What all you can perform here
			Starting a webdriver
			Setting up DB connections
			Setting up test data
			Setting up browser cookies
			Navigating to certain page
			or anything before the test
		*/
	}

	@After
	public void AfterSteps() {
		testContext.getWebDriverManager().closeDriver();
		/*extReports.endTest(extTestReporter);
		extReports.flush();
		extReports.close();
		genfun.setTestReportSet(false);*/
		//isTestReportSet = false;
	}

}