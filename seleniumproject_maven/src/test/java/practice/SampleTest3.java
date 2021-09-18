package practice;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SampleTest3 {
public static void main(String[]args) throws IOException {
System.out.println("Exicute Text");
FileInputStream fis=new FileInputStream("./data/commonData.properties");
Properties p=new Properties();
p.load(fis);

String URL =p.getProperty("url");
String USERNAME = p.getProperty("username");
String PASSWORD = p.getProperty("password");
	
System.out.println(URL);    
System.out.println(USERNAME);
System.out.println(PASSWORD);

WebDriver driver=new ChromeDriver();
driver.get(URL);

driver.close();
}
}
