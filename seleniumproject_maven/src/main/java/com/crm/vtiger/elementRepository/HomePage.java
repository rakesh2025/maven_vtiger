package com.crm.vtiger.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericUtils.WebDiverutilities;

public class HomePage extends WebDiverutilities{
public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(linkText = "Opportunities")
private WebElement opportunitieslnk;
@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
private WebElement profileimg;
@FindBy(linkText = "Sign Out")
private WebElement signoutlnk;
public WebElement getopportunitieslnk() {
	return opportunitieslnk;
}
public WebElement getProfileimg() {
	return profileimg;
}
public WebElement getSignoutlnk() {
	return signoutlnk;
}
public void clickOnOpportunities() {
	opportunitieslnk.click();	
}

public void clickonSignout(WebDriver driver) {
	mousehover(driver, profileimg);
	signoutlnk.click();
	
}
}
