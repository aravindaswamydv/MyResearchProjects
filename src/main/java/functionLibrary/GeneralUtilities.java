package functionLibrary;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GeneralUtilities {

	//static Logger logger;

	/**
	 * this method checks whether a file exist in a given file path
	 * 
	 * @author Aravind.Venkatadri2
	 * @param filePath
	 * @return returns boolean value true if file existing otherwise false
	 */
	public boolean isFileExist(String filePath) {
		File path = new File(filePath);
		return path.exists();
	}

	/**
	 * This method returns the user home directory
	 * 
	 * @author Aravind.Venkatadri2
	 * @return
	 */
	public String getUserHomedirectory() {
		return System.getProperty("user.home");
	}

	/**
	 * This method returns the file names in a given zip folder path
	 * 
	 * @author Aravind.Venkatadri2
	 * @param folderPath
	 *            - A string value represent location of the Zip folder
	 * @return array of string representing the filenames in a Zip folder
	 * @throws IOException
	 */
	public String[] getFilenames(String folderPath) throws IOException {
		String[] fileName = null;
		int totalFiles = 0;
		int i = 0;
		ZipFile zipFile = new ZipFile(folderPath);
		Enumeration zipEntries = zipFile.entries();
		totalFiles = zipFile.size();
		fileName = new String[totalFiles];
		while (zipEntries.hasMoreElements()) {
			fileName[i] = ((ZipEntry) zipEntries.nextElement()).getName();
			i++;

		}
		return fileName;
	}

	/**
	 * This method checks whether given string is a number or not
	 * 
	 * @author Aravind.Venkatadri2
	 * @param str
	 *            - A string variable having a number
	 * @return Return boolean true if given string is a number otherwise returns
	 *         false
	 */
	public boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	/**
	 * This method returns the latest updated file in a given directory path
	 * 
	 * @param dirPath
	 * @return lastModifiedFile
	 */
	public File getLatestFilefromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		// return lastModifiedFile.getAbsolutePath();
		return lastModifiedFile;
	}

	/**
	 * This Method appends the time stamp (with format: ddMMyyyyHHmmss) to the
	 * text which is passed to it and returns the same text with time stamp
	 * 
	 * @author Aravind.Venkatadri2
	 * @param text
	 *            - A String value which is used to append time stamp to it
	 * @return textWithTimestamp - A String value appended with time stamp
	 */
	public String appendTimeStamp(String text) {
		String textWithTimestamp = "";
		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		textWithTimestamp = text + simpleDateFormat.format(timestamp);
		return textWithTimestamp;
	}

	/**
	 * This Method returns the current date with format dd/MM/yyyy
	 * 
	 * @author Aravind.Venkatadri2
	 * @return todaysDate - A String value contains today's date in dd/MM/yyyy
	 *         format
	 */
	public String getTodayDate() {
		String todaysDate = "";
		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		todaysDate = simpleDateFormat.format(date);
		return todaysDate;
	}

	/**
	 * This method capture the screenshot and save to provided location and return the path of the screenshot
	 * 
	 * @author Aravind.Venkatadri2
	 * @param screenshotFolderPath
	 *            - location of screenshot to be saved
	 * @param fileName
	 *            - name to be given to screenshot
	 * @return screenImg  - location of screen Image that is Saved  
	 */

	public String getScreenshot(WebDriver webDriver, String screenshotFolderPath, String fileName) {
		String screenImg = null;

		screenImg = screenshotFolderPath + fileName + ".png";
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the screenshot to desired location using copyFile
			FileUtils.copyFile(src, new File(screenImg));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		return screenImg;
	}
	
	   public String getBrowserName(WebDriver driver){
		   String browserName="";
		   Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		   browserName = cap.getBrowserName();
		 //  logger.info("Broser Name : " + browserName);
		   return browserName;
	   }
	   
	  /* public String getdownloadpath(WebDriver driver){
		   String browserName="";
		   Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		   Profiles prof = ((RemoteWebDriver) driver).pro`
		   browserName = cap.ge;
		 //  logger.info("Broser Name : " + browserName);
		   return browserName;
	   }*/
}
