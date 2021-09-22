package com.vtiger.genericUtils;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.collections4.map.StaticBucketMap;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.vtiger.elementRepository.HomePage;
import com.crm.vtiger.elementRepository.LoginPage;

public class BaseClass {
	
	public JavaUtility j=new JavaUtility();
	public WebDiverutilities w = new WebDiverutilities();
	public ExcelFileUtility e = new ExcelFileUtility();
	public JSONFIleUtils js =new JSONFIleUtils();
	public WebDriver driver;
	public static WebDriver staticdriver;
	
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void connectDB() {
		System.out.println("Making DataBase Cnnection");
	}
	//@Parameters("Browser")
	@BeforeClass(groups = {"SmokeSuite","RegressionSuite"})
	public void launchBrowser(/*String BROWSER*/) throws Throwable {
		System.out.println("Launch The Browser");
		String BROWSER = js.readDataFromJSON("browser");
		String URL = js.readDataFromJSON("url");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		
		else {
			System.err.println("invalid browser");
		}
		w.maximizeWindows(driver);
		w.waitUntilPageLoad(driver);
		driver.get(URL);
		staticdriver=driver;
	}
	@BeforeMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void loginToAPP() throws Throwable {
		System.out.println("login To Application");
		String USERNAME = js.readDataFromJSON("username");
		String PASSWORD = js.readDataFromJSON("password");
		LoginPage log=new LoginPage(driver);
		log.login(USERNAME, PASSWORD);
		
	}
	@AfterMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void logOutApp() {
		HomePage home=new HomePage(driver);
		System.out.println("log out from App");
		home.clickonSignout(driver);
		
	}
	@AfterClass(groups = {"SmokeSuite","RegressionSuite"})
	public void closeBrowser() {
		driver.close();
		System.out.println("close the broswer");
	}
	
	@AfterSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void closeDB() {
		System.out.println("close DB connection");
	}
	public String getScreenShot(String name) throws IOException {
		File srcFile=((TakesScreenshot)staticdriver).getScreenshotAs(OutputType.FILE);
		 String destfile = System.getProperty("user.dir")+"/Screenshot/"+name+".png";
		File finaldest = new File(destfile);
		FileUtils.copyFile(srcFile, finaldest);
		return destfile;
	} 
}
