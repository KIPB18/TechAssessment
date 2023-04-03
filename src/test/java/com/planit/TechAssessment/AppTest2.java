package com.planit.TechAssessment;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class AppTest2 {

	static AppMethods met = new AppMethods();
	AppVars vars = new AppVars();

	@BeforeClass
	public static void testSetup() {
		met.testSetup();
	}
	@Test
	public void testCase2() {
		met.driver.get(vars.appUrl);
		met.navigateToHome();
		met.navigateToContacts();
		met.populateContactFormRequiredFields();
		met.clickSubmitInContactForm();
		met.verifyContactFormRequiredFieldsDontHaveErrorMessages(true);
		met.verifyContactFeedbackSuccessfull(true);
	}

	@AfterClass
	public static void closeBrowser() throws InterruptedException {
		met.testEnd();
	}
}
