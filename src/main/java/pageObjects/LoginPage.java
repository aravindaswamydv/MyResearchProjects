package pageObjects;

import java.net.URL;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import functionLibrary.GenericFunctions;
import managers.FileReaderManager;

public class LoginPage extends GenericFunctions{
WebDriver driver;
protected WebDriverWait driverWait;
int pageWeight=10;
public LoginPage(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver, this);
	driverWait = new WebDriverWait(driver, pageWeight * 2, pageWeight);
	
}

@FindBy(how = How.XPATH, using = "//input[@name='username']") 
private WebElement inputField_Username;

@FindBy(how = How.XPATH, using = "//input[@name='password']") 
private WebElement inputField_Password;

@FindBy(how = How.XPATH, using = "//button[@value='Login']") 
private WebElement btn_Login;

public void navigateTo_LoginPage(){
	driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
}

public void enter_Username(){

	enterTextField(driver, driverWait, inputField_Username, "IN\\ashish.kumar3");
}

public void enter_Password(){
	
	enterTextField(driver, driverWait, inputField_Password, "asfe$asdg5");
}

public void login() throws Exception{
	
	//accessHomePage("https://supportpulseasia.cbre.com.hk/#/login");
	driver.get("https://supportpulseasia.cbre.com.hk/#/login?logoutclick=true");
	enter_Username();
	enter_Password();
	click_Login();
	//driver.switchTo().alert();
	//Selenium-WebDriver Java Code for entering Username & Password as below:
	//inputField_Username.sendKeys("IN\\Chandra.nanjappan");
	//inputField_Username.sendKeys("Cbre@2018");
	//driver.switchTo().alert().accept();
	//driver.switchTo().defaultContent();
}

public void click_Login(){
	
	click(driver,driverWait,btn_Login);
}


public void accessHomePage(String URL) throws Exception {
	
	String browserName;
	String custURL;
	browserName =getBrowserType(driver); 
		
	try{
	if(browserName.equalsIgnoreCase("IE"))
	{
		driver.get(URL);
		UserAndPassword UP = new UserAndPassword("IN\\ashish.kumar3","asfe$asdg5");
		driver.switchTo().alert().authenticateUsing(UP);
	}
	if(browserName.equalsIgnoreCase("GC"))
	{
		custURL=customURLForChrome(URL);
		driver.get(custURL);		
		driver.get(URL);
		
	}
	}catch(UnhandledAlertException uae){
	//	logger.error("unhandeled alert execption occurred");
		driver.switchTo().alert().accept();
		driver.get(URL);
		
		
	}catch(NoAlertPresentException nape){
	//	logger.error("No Alert Present execption,Continuing the execution...  ");
	}
	driver.manage().window().maximize();
	
}

/**
 * This method customize the application url for chrome browser so that browser bypass the authentication window
 * @param url - application URL which is used to customize according to Chrome browser needs to bypass the authentication window
 * @throws Exception 
 * @author Aravind.Venkatadri2
 */
public String customURLForChrome(String url) throws Exception{
	
	URL appURL = new URL(url);
	String usrName="IN\\ashish.kumar3";
	String usrNme= usrName.replaceAll(".*\\\\", ""); // extract all chars after slash (\) in usrName and copy to a variable: usrNme
	String customURL=appURL.getProtocol()+"://"+ usrNme + ":"+ "asfe$asdg5" + "@" + appURL.getHost();
	return customURL;
	
	
}

/**
 * This method finds the instance of browser which is being used by the webdriver and returns it to calling method
 * @param driver - Webdirver object used to find the browser instance of it
 * @return broserType - type of browser
 * @author Aravind.Venkatadri2
 * 
 */
public String getBrowserType(WebDriver driver){
	
	String browserType="Unknown Browser";
	
	if(driver instanceof ChromeDriver) {
		browserType = "GC";
	}else if(driver instanceof InternetExplorerDriver) {
		browserType = "IE";
	}else if (driver instanceof FirefoxDriver){
		browserType = "FF";
	}
	return browserType;
}

/**
 * This method finds the alert/dialog windows returns the boolean values: true or false
 * @param driver - a Webdirver object used to get the title of dialog window which is opened
 * @return boolean values - true or false
 * @author Aravind.Venkatadri2
 * 
 */
public boolean isDialogPresent(WebDriver driver) {
    try {
        driver.getTitle();
        return false;
    } catch (UnhandledAlertException e) {
        // Modal dialog showed
        return true;
    }
}

}
