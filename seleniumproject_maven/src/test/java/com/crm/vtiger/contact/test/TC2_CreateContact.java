package com.crm.vtiger.contact.test;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.vtiger.genericUtils.ExcelFileUtility;
import com.vtiger.genericUtils.JSONFIleUtils;
import com.vtiger.genericUtils.JavaUtility;
import com.vtiger.genericUtils.WebDiverutilities;

public class TC2_CreateContact {
public static void main(String[] args) throws Throwable {
	WebDriver driver=null;
	JavaUtility j=new JavaUtility();
	WebDiverutilities w = new WebDiverutilities();
	ExcelFileUtility e = new ExcelFileUtility();
	JSONFIleUtils js =new JSONFIleUtils();
	
	String BROWSER = js.readDataFromJSON("browser");
	String URL = js.readDataFromJSON("url");
	String USERNAME = js.readDataFromJSON("username");
	String PASSWORD = js.readDataFromJSON("password");
	
	String orgname=e.getDataFromExcel("Sheet1", 2, 3);
	String last = e.getDataFromExcel("Sheet1", 2, 2);
	
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
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	driver.findElement(By.xpath("//img[@title='Select']")).click();
	driver.findElement(By.name("lastname")).sendKeys(last);
	w.switchToWindow(driver, "Accounts");
	driver.findElement(By.id("search_txt")).sendKeys(orgname);
	driver.findElement(By.name("search")).click();
	driver.findElement(By.id("1")).click();
	w.switchToWindow(driver, "action");
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	w.mousehover(driver, ele);
	driver.findElement(By.linkText("Sign Out")).click();
Thread.sleep(2000);
	driver.close();
}
}
