package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleTest2 {
@Test
public void sampleTest() {
System.out.println("Exicute Text");
String URL = System.getProperty("url");
String USERNAME = System.getProperty("username");
String PASSWORD = System.getProperty("password");
	
System.out.println(URL);    
System.out.println(USERNAME);
System.out.println(PASSWORD);

WebDriver driver=new ChromeDriver();
driver.get(URL);

driver.close();
}
}
