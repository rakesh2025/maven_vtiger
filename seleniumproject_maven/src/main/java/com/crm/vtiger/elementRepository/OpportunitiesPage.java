package com.crm.vtiger.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericUtils.WebDiverutilities;

public class OpportunitiesPage extends WebDiverutilities {
public OpportunitiesPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//img[@alt='Create Opportunity...']")
private WebElement addimg;
public WebElement getAddimg() {
	return addimg;
}
public void addOpportunityimg() {
	addimg.click();
	
}
public void gettextofaddOpertunity(WebDriver driver) {
//mousehover(driver, addimg);
System.out.println(addimg.getAttribute("title"));
}
}
