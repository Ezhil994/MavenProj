package org.pojo;

import org.helper.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPojo extends Utility {
	
	public AddToCartPojo() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[text()='Add to cart']")
	private WebElement addCart;
	
	@FindBy(xpath="//div[text()='Save for later']")
	private WebElement saveLater;
	
	public WebElement getSaveLater() {
		return saveLater;
	}
	public WebElement getAddCart() {
		return addCart;
	}
	
	
}
