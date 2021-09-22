package com.crm.vtiger.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationnameListPage {
public OrganizationnameListPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//table[@class='small']/tbody/tr[*]/td[1]/a[.='Testyantra']")
private WebElement testyantraorg;
public WebElement gettestyantraorg() {
	return testyantraorg;
}
public void selectTestyantraOrg() {
	testyantraorg.click();
}
}
