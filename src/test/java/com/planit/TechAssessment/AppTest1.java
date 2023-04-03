package com.planit.TechAssessment;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class AppTest1 {
	static AppMethods met = new AppMethods();
	AppVars vars = new AppVars();
	
	@BeforeClass
	public static void testSetup() {
		met.testSetup();
	}

	@Test
	public void testCase1() {
		met.driver.get(vars.appUrl);
		met.navigateToHome();
		met.navigateToContacts();
		met.clickSubmitInContactForm();
		met.verifyContactFormRequiredFieldsErrorMessages();
		met.populateContactFormRequiredFields();
		met.verifyContactFormRequiredFieldsDontHaveErrorMessages(true);
	}

	@AfterClass
	public static void closeBrowser() throws InterruptedException {
		met.testEnd();
	}
}
