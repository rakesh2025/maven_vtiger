package com.crm.vtiger.contact.test;
/**
 * author Rakesh
 */
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.genericUtils.ExcelFileUtility;
import com.vtiger.genericUtils.JSONFIleUtils;
import com.vtiger.genericUtils.JavaUtility;
import com.vtiger.genericUtils.WebDiverutilities;

public class TC3_createProductAndVerify {
	/**
	 * This Class is used to create a product and check whether the product is created or not .
	 * @param args
	 * @throws Throwable
	 */
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
		
		String product = e.getDataFromExcel("Sheet1", 3, 4);
		
		 int part1 = e.getintExcel("Sheet1", 3, 5);
		
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
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(product+j.getRanDomNumber());
		driver.findElement(By.id("productcode")).sendKeys(part1+"");
		driver.findElement(By.name("button")).click();
		WebElement text = driver.findElement(By.xpath("//table[@class='small']/tbody/tr[*]/td[4][@class='dvtCellInfo']"));
		String expected = text.getText();
		System.out.println(expected);
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.name("search_text")).sendKeys(part1+"");
		WebElement ele2 = driver.findElement(By.id("bas_searchfield"));
		w.dropdown(ele2, "productcode");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[2]"));
        for(WebElement l:list) {
        	String actual = l.getText();
    		System.out.println(actual);
        	if(expected.contains(actual)) {
        		
        		System.out.println("match found");
        	}
        }
        WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
    	w.mousehover(driver, ele);
    	driver.findElement(By.linkText("Sign Out")).click();
    Thread.sleep(2000);
	driver.close();	
	}
}
