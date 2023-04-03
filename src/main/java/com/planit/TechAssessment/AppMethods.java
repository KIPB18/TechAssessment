package com.planit.TechAssessment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chromium.HasNetworkConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppMethods {

	ChromeDriver driver;
	WebElement element;

	AppVars vars = new AppVars();
	
	public String FROG_PRICE_IN_SHOP = "";
	public String BUNNY_PRICE_IN_SHOP = "";
	public String VAL_BEAR_PRICE_IN_SHOP = "";

	@SuppressWarnings("deprecation")
	public void testSetup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	}

	public void testEnd() {
		((HasNetworkConditions) driver).deleteNetworkConditions();
		driver.quit();
	}
	
	public void clickSubmitInContactForm() {
		driver.findElement(By.xpath(vars.SUBMIT_BTN_XPATH)).click();
	}

	public void verifyContactFormRequiredFieldsErrorMessages() {
		driver.findElement(By.id(vars.FORNAME_ERROR_REQUIRED_ID)).isDisplayed();
		driver.findElement(By.id(vars.EMAIL_ERROR_REQUIRED_ID)).isDisplayed();
		driver.findElement(By.id(vars.MESSAGE_ERROR_REQUIRED_ID)).isDisplayed();
	}

	public void populateContactFormRequiredFields() {
		driver.findElement(By.xpath(vars.FORENAME_INPUT_XPATH)).sendKeys(vars.SAMPLE_NAME);
		driver.findElement(By.xpath(vars.EMAIL_INPUT_XPATH)).sendKeys(vars.SAMPLE_EMAIL);
		driver.findElement(By.xpath(vars.MESSAGE_INPUT_XPATH)).sendKeys(vars.SAMPLE_MESSAGE);
	}

	public boolean verifyContactFormRequiredFieldsDontHaveErrorMessages(Boolean dontHaveerrorMessages) {

		try {
			Boolean fornameError = driver.findElement(By.id(vars.FORNAME_ERROR_REQUIRED_ID)).isDisplayed();
			Boolean emailError = driver.findElement(By.id(vars.EMAIL_ERROR_REQUIRED_ID)).isDisplayed();
			Boolean messageError = driver.findElement(By.id(vars.MESSAGE_ERROR_REQUIRED_ID)).isDisplayed();
			if (fornameError.equals(true) && emailError.equals(true) && messageError.equals(true)) {
				dontHaveerrorMessages = false;
			}

		} catch (org.openqa.selenium.NoSuchElementException e) {
			return true;
		}
		return dontHaveerrorMessages;
	}

	public boolean verifyContactFeedbackSuccessfull(boolean isSuccessful) {
		return isSuccessful = driver.findElement(By.xpath(vars.VALID_CONTACT_SUBMIT_XPATH)).isDisplayed();

	}

	public void navigateToShop() {
		driver.findElement(By.cssSelector(vars.SHOP_MODULE_CSS)).click();

		FROG_PRICE_IN_SHOP = driver.findElement(By.xpath(vars.SHOP_STUFFED_FROG_PRICE_XPATH)).getText();
		BUNNY_PRICE_IN_SHOP = driver.findElement(By.xpath(vars.SHOP_FLUFFY_BUNNY_PRICE_XPATH)).getText();
		VAL_BEAR_PRICE_IN_SHOP = driver.findElement(By.xpath(vars.SHOP_VALENTINE_BEAR_PRICE_XPATH)).getText();

	}

	public void navigateToCart() {
		driver.findElement(By.cssSelector(vars.CART_MODULE_CSS)).click();
	}
	
	public void navigateToContacts() {
		driver.findElement(By.cssSelector(vars.CONTACT_MODULE_CSS)).click();
	}
	
	public void navigateToHome() {
		driver.findElement(By.cssSelector(vars.HOME_MODULE_CSS)).click();
	}

	public void buyStuffToys(String Type, int Num) {
		if (Type == "Stuffed Frog") {
			for (int i = 0; i < Num; i++) {
				driver.findElement(By.xpath(vars.BUY_BTN_FROG_XPATH)).click();
			}

		} else if (Type == "Fluffy Bunny") {
			for (int i = 0; i < Num; i++) {
				driver.findElement(By.xpath(vars.BUY_BTN_BUNNY_XPATH)).click();
			}

		} else if (Type == "Valentine Bear") {
			for (int i = 0; i < Num; i++) {
				driver.findElement(By.xpath(vars.BUY_BTN_VAL_BEAR_XPATH)).click();
			}
		} /* Can add more condition for the rest of options */

	}

	public void verifyPriceIsCorrectInCartVsShop(String itemName) {
		if (itemName == "Stuffed Frog") {
			driver.findElement(By.xpath(vars.CART_STUFFED_FROG_PRICE_XPATH)).getText().equals(FROG_PRICE_IN_SHOP);

		} else if (itemName == "Fluffy Bunny") {
			driver.findElement(By.xpath(vars.CART_FLUFFY_BUNNY_PRICE_XPATH)).getText().equals(BUNNY_PRICE_IN_SHOP);

		} else if (itemName == "Valentine Bear") {
			driver.findElement(By.xpath(vars.CART_VALENTINE_BEAR_PRICE_XPATH)).getText().equals(VAL_BEAR_PRICE_IN_SHOP);
		} /* Can add more condition for the rest of options */
	}

	public void verifySubtotalOfAddedProduct(String itemName, int quantity) {

		String quantityToString = Integer.toString(quantity);

		if (itemName == "Stuffed Frog") {

			String frogPrice = driver.findElement(By.xpath(vars.CART_STUFFED_FROG_PRICE_XPATH)).getText();

			driver.findElement(By.xpath(vars.STUFFED_FROG_QUANTITY_XPATH)).getAttribute("value")
					.equals(quantityToString);

			String newFormatPrice = frogPrice.replace("$", "");

			double PriceToString = Double.parseDouble(newFormatPrice);
			double Subtotal = quantity * PriceToString;

			String StrSubtotal = Double.toString(Subtotal);

			String displayedItemSubtotal = driver.findElement(By.xpath(vars.STUFFED_FROG_SUBTOTAL_XPATH)).getText();
			
			displayedItemSubtotal.equals(StrSubtotal);
			
			System.out.println("ITEM SUBTOTAL :" + newFormatPrice);
			System.out.println("DISPLAYED ITEM SUBTOTAL :" + displayedItemSubtotal);
			

		} else if (itemName == "Fluffy Bunny") {
			String bunnyPrice = driver.findElement(By.xpath(vars.CART_FLUFFY_BUNNY_PRICE_XPATH)).getText();

			driver.findElement(By.xpath(vars.FLUFFY_BUNNY_QUANTITY_XPATH)).getAttribute("value")
					.equals(quantityToString);

			String newFormatPrice = bunnyPrice.replace("$", "");

			double PriceToString = Double.parseDouble(newFormatPrice);
			double Subtotal = quantity * PriceToString;

			String StrSubtotal = Double.toString(Subtotal);

			String displayedItemSubtotal = driver.findElement(By.xpath(vars.FLUFFY_BUNNY_SUBTOTAL_XPATH)).getText();
			
			displayedItemSubtotal.equals(StrSubtotal);
			
			System.out.println("ITEM SUBTOTAL :" + newFormatPrice);
			System.out.println("DISPLAYED ITEM SUBTOTAL :" + displayedItemSubtotal);

		} else if (itemName == "Valentine Bear") {
			String valBearPrice = driver.findElement(By.xpath(vars.CART_VALENTINE_BEAR_PRICE_XPATH)).getText();

			driver.findElement(By.xpath(vars.VALENTINE_BEAR_QUANTITY_XPATH)).getAttribute("value")
					.equals(quantityToString);

			String newFormatPrice = valBearPrice.replace("$", "");

			double PriceToString = Double.parseDouble(newFormatPrice);
			double Subtotal = quantity * PriceToString;
			
			String StrSubtotal = Double.toString(Subtotal);

			String displayedItemSubtotal = driver.findElement(By.xpath(vars.VALENTINE_BEAR_SUBTOTAL_XPATH)).getText();
			
			displayedItemSubtotal.equals(StrSubtotal);
			
			System.out.println("ITEM SUBTOTAL :" + newFormatPrice);
			System.out.println("DISPLAYED ITEM SUBTOTAL :" + displayedItemSubtotal);

		} /* Can add more condition for the rest of options */
	}

	public boolean verifySumOfAllItemsVsSubtotal(boolean isSumAndTotalEqual) {

		List<WebElement> rws = driver.findElements(By.xpath(vars.CART_SUBTOTAL_SIZE_XPATH));

		int rws_cnt = rws.size();
		Double sum = 0.0;

		List<Double> itemSubTotals = new ArrayList<>();

		for (int i = 0; i < rws_cnt; i++) {
			List<WebElement> values = rws.get(i).findElements(By.xpath(vars.CART_SUBTOTAL_SIZE_XPATH));

			String itemsSubTotalValue = values.get(i).getText().replace("$", "");
			Double d = Double.parseDouble(itemsSubTotalValue);
			itemSubTotals.add(d);
		}
		System.out.println("LIST OF ITEMS SUBTOTAL :" + itemSubTotals);

		for (int i = 0; i < itemSubTotals.size(); i++) {
			sum += itemSubTotals.get(i);
		}

		String totalCartValue = driver.findElement(By.cssSelector(vars.TOTAL_CART_VALUE_CSS)).getText()
				.replace("Total: ", "");
		Double totality = Double.parseDouble(totalCartValue);

		int finalTotality = totality.intValue();
		int finalSum = sum.intValue();
		
		System.out.println("TOTAL :" + totality);
		System.out.println("SUM OF THE ITEMS :" + sum);

		if (finalTotality == finalSum) {
			return true;
		} else {
			return false;
		}
	}
}
