package com.comcast2;

import org.testng.annotations.Test;

public class OrganizationTest {
	@Test(groups = "SmokeSuite")
	public void createOrgTest() {
		System.out.println("createOrgTest");
	}
	@Test(groups = "SmokeSuite")
	public void createOrgWithContactTest() {
		System.out.println("createOrgWithContactTest");
	}
	@Test(groups = "RegressionSuite")
	public void deleteOrgtTest() {
		System.out.println("deleteOrgtTest");
	}

}
