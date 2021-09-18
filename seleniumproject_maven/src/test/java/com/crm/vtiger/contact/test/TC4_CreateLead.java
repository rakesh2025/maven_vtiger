package com.crm.vtiger.contact.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtiger.genericUtils.ExcelFileUtility;
import com.vtiger.genericUtils.JSONFIleUtils;
import com.vtiger.genericUtils.JavaUtility;
import com.vtiger.genericUtils.WebDiverutilities;

public class TC4_CreateLead  {
	 WebDriver driver;
	@Test
	public void createLead() throws Throwable {
		
	JavaUtility j=new JavaUtility();
	WebDiverutilities w = new WebDiverutilities();
	ExcelFileUtility e = new ExcelFileUtility();
	JSONFIleUtils js =new JSONFIleUtils();
	
	String BROWSER = js.readDataFromJSON("browser");
	String URL = js.readDataFromJSON("url");
	String USERNAME = js.readDataFromJSON("username");
	String PASSWORD = js.readDataFromJSON("password");
	
	//String product = e.getDataFromExcel("Sheet1", 3, 4);
	
	 //int part1 = e.getintExcel("Sheet1", 3, 5);
	
	if(BROWSER.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	}
	else if (BROWSER.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
	}
	else {
		System.err.println("invalid browser");
	}
	w.waitUntilPageLoad(driver);
	driver.manage().window().maximize();
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Leads")).click();
	driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
	WebElement ele1 = driver.findElement(By.name("salutationtype"));
    	w.select(ele1, 1);
    	driver.findElement(By.name("firstname")).sendKeys("hgkesh");
    	driver.findElement(By.name("lastname")).sendKeys("Pradhan");
    	driver.findElement(By.name("company")).sendKeys("Testyantra");
    	WebElement ele2 = driver.findElement(By.name("leadsource"));
    	w.select(ele2, 4);
    	WebElement ele3 = driver.findElement(By.name("industry"));
    	w.select(ele3, 6);
    	driver.findElement(By.name("website")).sendKeys("rak");
    	
    	driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.name("button")).click();
}
}
