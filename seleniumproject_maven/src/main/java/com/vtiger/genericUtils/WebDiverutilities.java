package com.vtiger.genericUtils;

import java.util.Iterator;  

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contain WebDriver specific generic method
 * @author Rakesh
 *
 */
public class WebDiverutilities {
	/**
	 * This method wait 20 second for page loading
	 * @param 
	 */
public void waitUntilPageLoad(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}
/**
 * This method maximize the window
 * @param 
 */
public void maximizeWindows(WebDriver driver) {
driver.manage().window().maximize();
}
/**
 * This method wait for the element to be visible
 * @param ele
 * @param text
 */
public void waitForElementVisibility(WebDriver driver,WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOf(element));
}
/**
 * This method wait for the element to be clicked , its custom wait created to avoid elemenInterAceptable Exception
 * @param element
 * @throws throwable
 * 
 */
public void waitAndClick(WebElement element) throws InterruptedException
{
	int count = 0;
    while(count<20) {
		   try {
		element.click();
		       break;
		}catch(Throwable e){
			Thread.sleep(1000);
			   count++;
		   }
    }

}
/**
 * this methods enables user to handle dropdown using select by value
 * @param element
 * @param option
 */

public void dropdown(WebElement ele,String text) {
	Select s=new Select(ele);
	s.selectByValue(text);
}

/**
 * this methods enables user to handle dropdown using index
 * @param element
 * @param index
 */
public void select(WebElement element, int index)
{
	   Select select=new Select(element);
	select.selectByIndex(index);   
}


/**
 * This method will perform mouse over action
 * @param driver
 * @param element
 */

public void mousehover(WebDriver driver,WebElement ele) {
	Actions a=new Actions(driver);
	a.moveToElement(ele).perform();
}
/**
 * This method performs right click operation 
 * @param driver
 * @param element
 */
public void rightClick(WebDriver driver,WebElement element)
{
	   Actions act = new Actions(driver);
	act.contextClick(element).perform();
}
/**
 * This method performs double click operation 
 * @param driver
 * @param element
 */
public void doubleClick(WebDriver driver,WebElement ele) {
	Actions a=new Actions(driver);
	a.doubleClick(ele).perform();
}
/**
 * This method perform drag and drop action 
 * @param driver
 * @param ele
 * @param sourse
 * @param target
 */
 
public void dragDrop(WebDriver driver,WebElement ele,WebElement sourse,WebElement target ) {
	Actions a=new Actions(driver);
	a.dragAndDrop(sourse, target);
}
/**
 * This method used for scrolling action in a webpage
 * @param driver
 * @param element
 */

public void scrollBar(WebDriver driver,int x,int y) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy("+x+","+y+")");
}
/**
 * Accept alert 
 * @param driver
 */

public void alertpopup(WebDriver driver) {
	driver.switchTo().alert().accept();
}
/**
 * Cancel Alert
 * @param driver
 */
public void cancelAlert(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}

public void switchTabs(WebDriver driver) {
	Set<String> child = driver.getWindowHandles();
	for(String b:child) {
		driver.switchTo().window(b);
	}
}
/**
 * This methods used for Switching Frame
 * @param driver
 */
public void switchFrame(WebDriver driver) {
	driver.switchTo().frame(0);
}
/**
 * This methods used for Switching Back to Frame
 * @param driver
 */
public void switchBackFrame(WebDriver driver) {
	driver.switchTo().defaultContent();
}
/**
* This method helps to switch from one window to another
* @param driver
* @parampartialWinTitle
*/
public void switchToWindow(WebDriver driver, String partialWinTitle)
	   {
		   Set<String> window = driver.getWindowHandles();
		   Iterator<String> it = window.iterator();
		   while(it.hasNext())
		   {
			   String winId=it.next();
			   String title=driver.switchTo().window(winId).getTitle();
	           if(title.contains(partialWinTitle))
	           {
		   break;
	           }
			
		   }
		
	   }
   }

