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

public class TC1_CreateOrganization 
{
public static void main(String[] args) throws Throwable {
	JavaUtility j=new JavaUtility();
	WebDiverutilities w = new WebDiverutilities();
	ExcelFileUtility e = new ExcelFileUtility();
	JSONFIleUtils js =new JSONFIleUtils();
	
	String BROWSER = js.readDataFromJSON("browser");
	String URL = js.readDataFromJSON("url");
	String USERNAME = js.readDataFromJSON("username");
	String PASSWORD = js.readDataFromJSON("password");
	String orgn=e.getDataFromExcel("Sheet1", 1, 3);
	WebDriver driver=null;
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
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
	driver.findElement(By.name("accountname")).sendKeys(orgn+j.getRanDomNumber());
	WebElement ele = driver.findElement(By.name("industry"));
	w.dropdown(ele, "Education");
	driver.findElement(By.name("button")).click();
	WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	w.mousehover(driver, ele2);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
Thread.sleep(2000);
driver.close();
	


}
}
