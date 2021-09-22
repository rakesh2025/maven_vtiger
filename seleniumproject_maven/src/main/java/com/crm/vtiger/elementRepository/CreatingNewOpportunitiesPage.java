package com.crm.vtiger.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genericUtils.ExcelFileUtility;
import com.vtiger.genericUtils.WebDiverutilities;

public class CreatingNewOpportunitiesPage extends WebDiverutilities {
	
public CreatingNewOpportunitiesPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
@FindBy(name="potentialname")
private WebElement OpportunityNameedt;
@FindBy(xpath = "(//img[@align='absmiddle'])[3]")
private WebElement addOrganizationNameimg;
@FindBy(name="sales_stage")
private WebElement SalesStagedrpdn;
@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement savebtn;
public WebElement getSavebtn() {
	return savebtn;
}
public WebElement getOpportunityNameedt() {
	return OpportunityNameedt;
}
public WebElement getAddOrganizationNameimg() {
	return addOrganizationNameimg;
}
public WebElement getSalesStagedrpdn() {
	return SalesStagedrpdn;
}
public void opportunityName(String OPPNAME) {
	OpportunityNameedt.sendKeys(OPPNAME);
}

public void addOrgNameimg(WebDriver driver,String Accounts) {
	addOrganizationNameimg.click();
	switchToWindow(driver, Accounts);
}
public void salesStageID() {
	select(SalesStagedrpdn, 4);
	savebtn.click();
}
public void salesStagePerception() {
	select(SalesStagedrpdn, 5);
	savebtn.click();
}
public void salesStageProposal() {
	select(SalesStagedrpdn, 6);
	savebtn.click();
}
public void salesStageNegotiation() {
	select(SalesStagedrpdn, 7);
	savebtn.click();
}
public void salesStageClosed() {
	select(SalesStagedrpdn, 8);
	savebtn.click();
}
public void salesStageChoose(String text) {
	dropdown(SalesStagedrpdn, text);
	savebtn.click();
}
}
