package com.crm.vtiger.contact.test;



import org.testng.Assert;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;
import com.crm.vtiger.elementRepository.CreatingNewOpportunitiesPage;
import com.crm.vtiger.elementRepository.HomePage;
import com.crm.vtiger.elementRepository.OpportunitiesInfrmationPage;
import com.crm.vtiger.elementRepository.OpportunitiesPage;
import com.crm.vtiger.elementRepository.OrganizationnameListPage;
import com.vtiger.genericUtils.BaseClass;


public class TC0000_CreateOrganization extends BaseClass {
	@DataProvider
	public Object[][] getData()throws Throwable{
		return e.getDataFromExcel("Sheet2");
	}

	@Test(dataProvider ="getData" )
	public void CreateOpportunitiesWithSalesStage(String SalesStage) throws Throwable {
		System.out.println("running tc0000");
		String OPPNAME=e.getDataFromExcel("Sheet1", 4, 7)+j.getRanDomNumber();
		//String SALESSTAGE=e.getDataFromExcel("Sheet1", 4, 6);
		String parameter=e.getDataFromExcel("Sheet1", 4, 8);
		
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
		create.salesStageChoose(SalesStage);
		
		OpportunitiesInfrmationPage oppinfo=new OpportunitiesInfrmationPage(driver);
		String actual = oppinfo.Salesstagetext();
		Assert.assertTrue(actual.contains(SalesStage));
		System.out.println(actual);
		oppinfo.clickonhomelink();
}
}
