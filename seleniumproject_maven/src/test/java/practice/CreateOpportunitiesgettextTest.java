package practice;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.elementRepository.CreatingNewOpportunitiesPage;
import com.crm.vtiger.elementRepository.HomePage;

import com.crm.vtiger.elementRepository.OpportunitiesInfrmationPage;
import com.crm.vtiger.elementRepository.OpportunitiesPage;
import com.crm.vtiger.elementRepository.OrganizationnameListPage;
import com.vtiger.genericUtils.BaseClass;


public class CreateOpportunitiesgettextTest extends BaseClass{
	
@Test(groups = "SmokeSuite")
public void CreateOpportunitiesWithSalesStageIDTest() throws Throwable {
	
	String OPPNAME=e.getDataFromExcel("Sheet1", 5, 7)+j.getRanDomNumber();
	String SALESSTAGE=e.getDataFromExcel("Sheet1", 5, 6);
	String parameter=e.getDataFromExcel("Sheet1", 5, 8);
	
	
	
	HomePage home=new HomePage(driver);
	home.clickOnOpportunities();
	
	OpportunitiesPage opp=new OpportunitiesPage(driver);
	
	opp.gettextofaddOpertunity(driver);
	
	
	
}
}
