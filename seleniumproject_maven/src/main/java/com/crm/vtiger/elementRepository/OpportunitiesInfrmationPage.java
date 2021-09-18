package com.crm.vtiger.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesInfrmationPage {
public OpportunitiesInfrmationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}


@FindBy(xpath="//font[.='Id. Decision Makers']")
public WebElement iddecision;
@FindBy(xpath="//font[.='Perception Analysis']")
public WebElement perception;
@FindBy(xpath="//font[.='Proposal/Price Quote']")
public WebElement proposal;
@FindBy(xpath="//font[.='Negotiation/Review']")
public WebElement negotiation;
@FindBy(xpath="//font[.='Closed Won']")
public WebElement closedwon;
@FindBy(xpath = "//img[@style='width:16px;height:16px;']")
private WebElement homepagelnk;
@FindBy(xpath="(//table[@class='small']/tbody/tr[*]/td[4])[7]")
private WebElement salesStagetxt;
public WebElement getSalesStagetxt() {
	return salesStagetxt;
}
public WebElement getHomepagelnk() {
	return homepagelnk;
}
public WebElement getIddecision() {
	return iddecision;
}
public WebElement getPerception() {
	return perception;
}
public WebElement getProposal() {
	return proposal;
}
public WebElement getNegotiation() {
	return negotiation;
}
public WebElement getClosedwon() {
	return closedwon;
}
public String salesId() {
	return iddecision.getText();
}
public String salesPerception() {
	return perception.getText();
}
public String salesProposal() {
	return proposal.getText();
}
public String salesNegotiation() {
	return negotiation.getText();
}
public String salesClosedwon() {
	return closedwon.getText();
}
public void clickonhomelink() {
	homepagelnk.click();
}
public String Salesstagetext() {
	 return salesStagetxt.getText();
}
}