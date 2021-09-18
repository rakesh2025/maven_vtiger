package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SampleTest {
@Test
public void sampleTest() {
System.out.println("Exicute Text");
String URL = System.getProperty("url");
String USERNAME = System.getProperty("username");
String PASSWORD = System.getProperty("password");
String BROWSER=System.getProperty("browser");
WebDriver driver=null;
//System.out.println(URL);    
//System.out.println(USERNAME);
//System.out.println(PASSWORD);
if(BROWSER.equals("chrome")) {
	driver=new ChromeDriver();
}
else if(BROWSER.equals("firefox")) {
	driver=new FirefoxDriver();
}
else {
	System.out.println("Invalid Browser");
}

driver.manage().window().maximize();

driver.get(URL);
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.findElement(By.name("user_name")).sendKeys(USERNAME);
driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
driver.findElement(By.id("submitButton")).click();
driver.findElement(By.xpath("//a[text()='Contacts']")).click();
driver.findElement(By.xpath("//img [@title='Create Contact...']")).click();

driver.close();
}
}
