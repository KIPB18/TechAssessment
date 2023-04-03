package com.planit.TechAssessment;

public class AppVars {
	
	/* GENERIC MAPPINGS */
	
	public String appUrl = "http://jupiter.cloud.planittesting.com";
	
	public String CONTACT_MODULE_CSS = "a[href*='contact']";
	
	public String HOME_MODULE_CSS = "a[href*='home']";
	
	public String SHOP_MODULE_CSS = "a[href*='shop']";
	
	public String CART_MODULE_CSS = "a[href*='cart']";
	
	/* ELEMENTS IN CONTACT */
	
	public String SUBMIT_BTN_XPATH = "//a[text()='Submit']";
	
	public String FORNAME_ERROR_REQUIRED_ID = "forename-err";
	
	public String EMAIL_ERROR_REQUIRED_ID = "email-err";
	
	public String MESSAGE_ERROR_REQUIRED_ID = "message-err";
	
	public String FORENAME_INPUT_XPATH = "//input[@id='forename']";
	
	public String EMAIL_INPUT_XPATH = "//input[@id='email']";
	
	public String MESSAGE_INPUT_XPATH = "//textarea[@id='message']";
	
	public String VALID_CONTACT_SUBMIT_XPATH = "//div[@class='alert alert-success']";
	
	/* ELEMENTS IN SHOP */
	
	public String BUY_BTN_FROG_XPATH = "//h4[contains(text(),'Frog')]/following-sibling::p/a";
	
	public String BUY_BTN_BUNNY_XPATH = "//h4[contains(text(),'Bunny')]/following-sibling::p/a";
	
	public String BUY_BTN_VAL_BEAR_XPATH = "//h4[contains(text(),'Valentine')]/following-sibling::p/a";
	
	public String SHOP_STUFFED_FROG_PRICE_XPATH = "//h4[contains(text(),'Frog')]/following-sibling::p/span";
	
	public String SHOP_FLUFFY_BUNNY_PRICE_XPATH = "//h4[contains(text(),'Bunny')]/following-sibling::p/span";
	
	public String SHOP_VALENTINE_BEAR_PRICE_XPATH = "//h4[contains(text(),'Valentine')]/following-sibling::p/span";
	
	/* ELEMENTS IN CART */
	
	public String CART_STUFFED_FROG_PRICE_XPATH = "//td[contains(text(),'Frog')]//following-sibling::td[1]";
	
	public String CART_FLUFFY_BUNNY_PRICE_XPATH = "//td[contains(text(),'Bunny')]//following-sibling::td[1]";
	
	public String CART_VALENTINE_BEAR_PRICE_XPATH = "//td[contains(text(),'Valentine')]//following-sibling::td[1]";
	
	public String STUFFED_FROG_QUANTITY_XPATH = "//td[contains(text(),'Frog')]//following-sibling::td[2]/input";
	
	public String FLUFFY_BUNNY_QUANTITY_XPATH = "//td[contains(text(),'Bunny')]//following-sibling::td[2]/input";
	
	public String VALENTINE_BEAR_QUANTITY_XPATH = "//td[contains(text(),'Valentine')]//following-sibling::td[2]/input";
	
	public String STUFFED_FROG_SUBTOTAL_XPATH = "//td[contains(text(),'Frog')]//following-sibling::td[3]";
	
	public String FLUFFY_BUNNY_SUBTOTAL_XPATH = "//td[contains(text(),'Bunny')]//following-sibling::td[3]";
	
	public String VALENTINE_BEAR_SUBTOTAL_XPATH = "//td[contains(text(),'Valentine')]//following-sibling::td[3]";
	
	public String CART_SUBTOTAL_SIZE_XPATH = "//table[contains(@class,'cart-items')]//tbody/tr/td[4]";
	
	public String TOTAL_CART_VALUE_CSS = "td [class*='total']";
	
	
	/* GENERIC VARIABLES */
	
	public String SAMPLE_NAME = "John Wick";
	
	public String SAMPLE_EMAIL = "babayaga@continentalhotel.com";
	
	public String SAMPLE_MESSAGE = "Fortis Fortuna Adiuvat";
	
	
	

}
