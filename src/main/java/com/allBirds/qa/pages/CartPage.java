package com.allBirds.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.allBirds.qa.base.TestBase;

public class CartPage extends TestBase {

	
	public static Logger logger=Logger.getLogger(CartPage.class);
	
	
	//@FindBy(xpath = )
	WebElement cancel ;
	
	public CartPage() {
		 
		        PageFactory.initElements(driver, this);
		        logger.info("CartPage elements initialized.");
	}
	public void viewCart() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cancel.click();
	}
	
	
}
