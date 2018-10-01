package functionLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

//import org.testng.Assert;
import org.junit.Assert;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GenericFunctions{
	
	private static WebElement element;
	static GeneralUtilities genUtils;
	static String screenshotImgPath;
	static String screenshotFolderPath="D:\\D_Drive\\screeshots";
	public static ExtentReports extReports;
	public static ExtentTest extTestReporter;
	boolean isTestReportSet=false;
	public String testReportFilePath="./src/main/resources/TestReport/TestReport.html";
	public String testReportConfigFielPath="extent-config.xml";
	
	/*public GenericFunctions(){
		if (!isTestReportSet) {
			extReports = new ExtentReports(testReportFilePath, true, DisplayOrder.OLDEST_FIRST);
			extReports.loadConfig(new File(testReportConfigFielPath));
			isTestReportSet = true;
		}
		
	}
	
	public ExtentTest getExtTestReporter() {
		return extTestReporter;
	}

	public ExtentReports getExtTestReports() {
		return extReports;
	}

	public void setTestReportSet(boolean boo) {
		isTestReportSet=boo;
	}*/
	/**
	 * Method Name : click 
	 * Purpose: Method for click
	 * @param: gDriver,identifyBy,identifyBy,locator,valuetoType
	 * @return None
	 * @Author: EVRY
	 */
	public static void click(WebDriver gDriver, WebDriverWait driverWait, By locator) {
		try {

			element = getWebElement(gDriver, driverWait, locator);
			element.click();
		} catch (Exception e) {
/*			extTestReporter.log(LogStatus.FAIL, "MethodName: click : Exception occured for locator = " + locator
					+ "  exception = " + e.getMessage());
			screenshotImgPath = genUtils.getScreenshot(gDriver, screenshotFolderPath, genUtils.appendTimeStamp(""));
			extTestReporter.log(LogStatus.FAIL, "", extTestReporter.addScreenCapture(screenshotImgPath));*/
	/*		Assert.assertTrue(false, "MethodName: click : Exception occured for locator = " + locator + "  exception = "
					+ e.getMessage());*/
			Assert.assertTrue("MethodName: click : Exception occured for locator = " + locator + "  exception = "
					+ e.getMessage(), false);
		}
	}
	
	
	public static void click(WebDriver gDriver, WebDriverWait driverWait, WebElement element) {
		try {

			if(isWebElementExists(gDriver,driverWait,element))
			element.click();
		} catch (Exception e) {
/*			extTestReporter.log(LogStatus.FAIL, "MethodName: click : Exception occured for element = " + element
					+ "  exception = " + e.getMessage());
			screenshotImgPath = genUtils.getScreenshot(gDriver, screenshotFolderPath, genUtils.appendTimeStamp(""));
			extTestReporter.log(LogStatus.FAIL, "", extTestReporter.addScreenCapture(screenshotImgPath));*/
	/*		Assert.assertTrue(false, "MethodName: click : Exception occured for locator = " + locator + "  exception = "
					+ e.getMessage());*/
			Assert.assertTrue("MethodName: click : Exception occured for element = " + element + "  exception = "
					+ e.getMessage(), false);
		}
	}
	

	/**
	 * Method Name : webElement 
	 * Purpose: Return true if web control present in
	 * the page,and assign that web control to perform further operation
	 * 
	 * @param: gDriver,locator
	 * @return: WebElement
	 * @Author: EVRY
	 */
	public static WebElement getWebElement(WebDriver driver, WebDriverWait driverWait, By locator) {
		try {

			if (isWebElementExists(driver, driverWait, locator)) {
				element = driver.findElement(locator);
			} else {
			}
		} catch (Exception e) {
			/*extTestReporter.log(LogStatus.FAIL,
					"Test is Failed due to exception occured in the method getWebElement for the locator " + locator
							+ "  due to  " + e.getMessage());
			screenshotImgPath = genUtils.getScreenshot(driver, screenshotFolderPath, genUtils.appendTimeStamp(""));
			extTestReporter.log(LogStatus.FAIL, "", extTestReporter.addScreenCapture(screenshotImgPath));*/

			/*Assert.assertTrue(false,
					"Test is Failed due to exception occured in the method getWebElement for the locator " + locator
							+ "  due to  " + e.getMessage());*/
			
			Assert.assertTrue("Test is Failed due to exception occured in the method getWebElement for the locator " + locator
					+ "  due to  " + e.getMessage(),false);
		}
		return element;
	}

	/**
	 * Method Name : isWebElementExists 
	 * Purpose: return true if web control present in the page	 * 
	 * @param: gDriver,locator
	 * @return: boolean value true/false
	 * @Author: EVRY
	 */

	public static boolean isWebElementExists(WebDriver driver, WebDriverWait driverWait, By locator) {

		try {
			driverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
			return driver.findElement(locator).isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}
	
	public static boolean isWebElementExists(WebDriver driver, WebDriverWait driverWait, WebElement ele) {

		try {
			driverWait.until(ExpectedConditions.visibilityOf(ele));
			return ele.isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}
	

	/**
	 * Method Name : getText 
	 * Purpose: Method to get the Text value of the web element
	 * @param: gDriver,identifyBy,locator
	 * @return text of the element
	 * @Author: EVRY
	 */

	public static String getText(WebDriver gDriver, WebDriverWait driverWait, By locator) {
		String strText = "";
		try {
			element = getWebElement(gDriver, driverWait, locator);
			strText = element.getText().toString();
		} catch (Exception e) {
			/*extTestReporter.log(LogStatus.FAIL,
					"Exception in the method getText for the element " + locator + " due to  " + e.getMessage());*/
			/*Asserts.assertTrue(false,
					"Exception in the method getText for the element " + locator + " due to  " + e.getMessage());*/
			Assert.assertTrue("Exception in the method getText for the element " + locator + " due to  " + e.getMessage(), false);
		}
		return strText;
	}
	
	
	public static String getText(WebDriver gDriver, WebDriverWait driverWait, WebElement element) {
		String strText = "";
		try {
			if (isWebElementExists(gDriver, driverWait, element)) {
			strText = element.getText().toString();
			}
		} catch (Exception e) {
			/*extTestReporter.log(LogStatus.FAIL,
					"Exception in the method getText for the element " + element + " due to  " + e.getMessage());*/
			/*Asserts.assertTrue(false,
					"Exception in the method getText for the element " + locator + " due to  " + e.getMessage());*/
			Assert.assertTrue("Exception in the method getText for the element " + element + " due to  " + e.getMessage(), false);
		}
		return strText;
	}
	

/**
 * Method Name: enterTextField
 * Purpose: This method keys the value in to the text field specified by the element locator
 * @param webDriver,webDriverWait,elementLocator,inputData
 * @return: None
 * @author: EVRY
 */
	public void enterTextField(WebDriver webDriver, WebDriverWait webDriverWait, By elementLocator, String inputData) {
		try {
			element = getWebElement(webDriver, webDriverWait, elementLocator);
			element.clear();
			element.sendKeys(inputData);
			//extTestReporter.log(LogStatus.INFO, " Entered the value : " + inputData);
		} catch (Exception e) {
			/*extTestReporter.log(LogStatus.FAIL,"The Test Failed to enter " + " due to " + e.getMessage());
			screenshotImgPath = genUtils.getScreenshot(webDriver, screenshotFolderPath,
					genUtils.appendTimeStamp(this.getClass().getSimpleName()));
			extTestReporter.log(LogStatus.FAIL, "",extTestReporter.addScreenCapture(screenshotImgPath));*/
		/*	Asserts.assertTrue(false,
					"The Test Failed to enter " + " due to " + e.getMessage());*/
			Assert.assertTrue("The Test Failed to enter " + " due to " + e.getMessage(), false);
		}
		
	}
	
	public void enterTextField(WebDriver webDriver, WebDriverWait webDriverWait, WebElement element, String inputData) {
		try {
			if (isWebElementExists(webDriver, webDriverWait, element)) {
			element.clear();
			element.sendKeys(inputData);
			}
			//extTestReporter.log(LogStatus.INFO, " Entered the value : " + inputData);
		} catch (Exception e) {
			/*extTestReporter.log(LogStatus.FAIL,"The Test Failed to enter " + " due to " + e.getMessage());
			screenshotImgPath = genUtils.getScreenshot(webDriver, screenshotFolderPath,
					genUtils.appendTimeStamp(this.getClass().getSimpleName()));
			extTestReporter.log(LogStatus.FAIL, "",extTestReporter.addScreenCapture(screenshotImgPath));*/
		/*	Asserts.assertTrue(false,
					"The Test Failed to enter " + " due to " + e.getMessage());*/
			Assert.assertTrue("The Test Failed to enter " + " due to " + e.getMessage(), false);
		}
		
	}
	
	/**
	 * Method Name : waitForTime 
	 * Purpose: Method to wait For Time in milliseconds
	 * @param: longtime
	 * @return None
	 * @Author: EVRY
	 */
	public static void waitForTime(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			extTestReporter.log(LogStatus.FAIL,"Exception in the method waitForTime due to   "			+ e.getMessage());
			Assert.assertTrue("Exception in the method waitForTime due to   "			+ e.getMessage(),false);
		}
	}
}
