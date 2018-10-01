package pageObjects;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import functionLibrary.GenericFunctions;

public class DashboardPage extends GenericFunctions{
	WebDriver driver;
	protected WebDriverWait driverWait;
	int pageWeight=10;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		driverWait = new WebDriverWait(driver, pageWeight * 2, pageWeight);

	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"building\"]")
	private WebElement btn_AllProperties;

	@FindAll(@FindBy(how = How.XPATH, using = "//ul[@class='building-lists']/li"))
	private List<WebElement> list_Building;

	@FindBy(how = How.XPATH, using = "//*[@id=\"_tour_Occupancy\"]/div[3]/div/div[1]/div[2]/span")
	private WebElement field_OcupancyValue;
	
	@FindBy(how = How.XPATH, using = "//*[@id='pulseAsiaBody']/screenshot/pulse-asia/header/div[1]/div[3]/div[2]/button[4]")
	private WebElement menuIcon;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tour_Document']")
	private WebElement menuItemDocumentLibrary;
	
	@FindBy(how = How.XPATH, using = "//*[@id='pulseAsiaBody']/screenshot/pulse-asia/div[2]/document-library/div/div/div/div/div/div[1]/div/div[2]/button[2]")
	private WebElement btnAddNewDocument;
	
	@FindBy(how = How.XPATH, using = "//*[@type='button' and @id='ufile']")
	private WebElement btnBrowse;
	
/*	@FindBy(how = How.XPATH, using = "//button[@ng-model='ct.fileUpload']")
	private WebElement btnBrowse;*/
	
	
	
	
	
	

	public void click_AllProperties() {
		
		click(driver,driverWait,btn_AllProperties);
	}
	
	public boolean isBuildingListPresent() {
		boolean result=false;
		waitForTime(20000);
		result=isWebElementExists(driver, driverWait, btn_AllProperties);
		return result;
	}

	public void select_Building(String buildingName) {
		String s;
		try{
		for(WebElement building: list_Building){
			s=building.getText();
			if(s.contains(buildingName))
				
				click(driver,driverWait,building);

		}
		}catch(Exception e){
			Assert.assertTrue("Exception occurred  : " + e.getMessage(), false);
		}
		
	}

	public void verify_OccupancyValue(String occupancyValue) {
		
		String occupVal;

		waitForTime(20000);
		
		occupVal = getText(driver,driverWait,field_OcupancyValue);
				
			//	field_OcupancyValue.getText();
		if (!occupVal.equalsIgnoreCase(occupancyValue)) {
			Assert.assertTrue("Occupancy Values do not match", false);
		}
	}
	
	
	
	public void navigateToDocumentLibrary(){
		
		click(driver,driverWait,menuIcon);
		click(driver,driverWait, menuItemDocumentLibrary);
	}
	
	public void click_AddNewDocumentButton(){
		click(driver,driverWait, btnAddNewDocument);
	}
	
	public void click_BrowseButton(){
		click(driver,driverWait, btnBrowse);
		waitForTime(2000);
	}
	
	public void uploadDoc() throws IOException, InterruptedException{
				
		//Runtime.getRuntime().exec("AutoIT_FileUpload.exe"+" GC"+" C:\\Users\\aravinda_dv\\Desktop\\tst.png");
		
		
	//	String[] cmd = new String[1];
		//cmd[0] = "AutoIT_FileUpload.exe"+" GC"+" C:\\Users\\aravinda_dv\\Desktop\\tst.png";
		        
		Process result = Runtime.getRuntime().exec("AutoIT_FileUpload.exe"+" GC"+" C:\\Users\\aravinda_dv\\Desktop\\tst.png");
		result.waitFor();   
		    
		if (result.exitValue()==1)
		    System.out.println("YAY!");
		else
		    System.out.println("boo");
		
		waitForTime(10000);
	}
	
	public void clickbutton(){
		
		
	
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		
		 System.out.println("Clicked? 0  " + executor.executeScript("arguments[0].click();", btnBrowse));
//		 System.out.println("clicked ? by id " + executor.executeScript("document.getElementById('ufile').click();"));
	//	 System.out.println("clicked ? by id " + executor.executeScript("document.getElementById('ufile').click();", btnBrowse));
		 //System.out.println("Clicked? 2 " + executor.executeScript("arguments[2].click();", btnBrowse));
		 
		 waitForTime(10000);
	}

}
