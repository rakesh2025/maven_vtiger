package com.crm.vtiger.contact.test;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.elementRepository.CreatingNewOpportunitiesPage;
import com.crm.vtiger.elementRepository.HomePage;

import com.crm.vtiger.elementRepository.OpportunitiesInfrmationPage;
import com.crm.vtiger.elementRepository.OpportunitiesPage;
import com.crm.vtiger.elementRepository.OrganizationnameListPage;
import com.vtiger.genericUtils.BaseClass;


public class TC19_CreateOpportunitiesWithSalesStageNegotionTest extends BaseClass{
@Test(groups = "RegressionSuite")
public void CreateOpportunitiesWithSalesStageIDTest() throws Throwable {
	
	String OPPNAME=e.getDataFromExcel("Sheet1", 7, 7)+j.getRanDomNumber();
	String SALESSTAGE=e.getDataFromExcel("Sheet1", 7, 6);
	String parameter=e.getDataFromExcel("Sheet1", 7, 8);
	
	
	HomePage home=new HomePage(driver);
	home.clickOnOpportunities();
	
	OpportunitiesPage opp=new OpportunitiesPage(driver);
	opp.addOpportunityimg();
	
	CreatingNewOpportunitiesPage create=new CreatingNewOpportunitiesPage(driver);
	create.opportunityName(OPPNAME);
	create.addOrgNameimg(driver, parameter);
	
	
	OrganizationnameListPage orgname=new OrganizationnameListPage(driver);
	orgname.selectTestyantraOrg();
	w.switchTabs(driver);
	create.salesStageNegotiation();
	
	OpportunitiesInfrmationPage oppinfo=new OpportunitiesInfrmationPage(driver);
	String actual = oppinfo.salesNegotiation();
	Assert.assertTrue(actual.contains(SALESSTAGE));
	System.out.println(actual);
	oppinfo.clickonhomelink();
	
}
}
