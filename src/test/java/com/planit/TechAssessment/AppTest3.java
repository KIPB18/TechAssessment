package com.planit.TechAssessment;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class AppTest3 {
	static AppMethods met = new AppMethods();
	AppVars vars = new AppVars();

	@BeforeClass
	public static void testSetup() {
		met.testSetup();
	}

	@Test
	public void testCase3() {
		met.driver.get(vars.appUrl);
		met.navigateToShop();
		met.buyStuffToys("Stuffed Frog", 2);
		met.buyStuffToys("Fluffy Bunny", 5);
		met.buyStuffToys("Valentine Bear", 3);
		met.navigateToCart();
		met.verifyPriceIsCorrectInCartVsShop("Stuffed Frog");
		met.verifyPriceIsCorrectInCartVsShop("Fluffy Bunny");
		met.verifyPriceIsCorrectInCartVsShop("Valentine Bear");
		met.verifySubtotalOfAddedProduct("Stuffed Frog", 2);
		met.verifySubtotalOfAddedProduct("Fluffy Bunny", 5);
		met.verifySubtotalOfAddedProduct("Valentine Bear", 3);
		met.verifySumOfAllItemsVsSubtotal(true);

	}

	@AfterClass
	public static void closeBrowser() throws InterruptedException {
		met.testEnd();
	}
}
