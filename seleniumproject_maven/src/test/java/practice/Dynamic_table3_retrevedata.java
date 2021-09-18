package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.genericUtils.JSONFileUtil;

public class Dynamic_table3_retrevedata 
{
	WebDriver driver;
@Test
public void deselect_lastone() throws Throwable {
	JSONFileUtil j=new JSONFileUtil();
	String BROWSER = j.readDataFromJSON("browser");
	String URL = j.readDataFromJSON("url");
	String USERNAME = j.readDataFromJSON("username");
	String PASSWORD = j.readDataFromJSON("password");
	if(BROWSER.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	}else if(BROWSER.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
	}else {
		System.out.println("invalid browser");
	}
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Organizations")).click();
	List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
	for(WebElement l:list)
	{
		l.click();	
	}
	list.get(list.size()-1).click();
	}
}
