package org.pojo;

import java.util.List;

import org.helper.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class FlipkartHomePage extends Utility {
	public FlipkartHomePage() {
		PageFactory.initElements(driver, this);
	}
    @FindBy(xpath = "//input[@type='text']")
	private WebElement searchBox;
	@FindBys({@FindBy(xpath="//a[@class='wjcEIp']"),@FindBy(xpath="//a[contains(text(),'SONY HT-S20R 5.1ch Home Theatre')]")})
	private List<WebElement> sonySoundbar;
	@FindAll({@FindBy(xpath="//input[@class='AFOXgu']"),@FindBy(id="pincodeInputId")})
	private List<WebElement> pincode;
	@FindBy(xpath="//span[@class='i40dM4']")
	private WebElement checkButton;
	@FindBy(xpath="(//div[@class='hVvnXm'])[position()=1]")
	private WebElement deliveryMsg;
	@FindBy(xpath="//div[@class='KzDlHZ']")
	private List<WebElement> iphone;
	@FindBy(xpath="//span[text()='Help Center']")
	private WebElement helpCenter;
	@FindBy(xpath="//a[text()='Contact Us']")
	private WebElement contact;
	
	public WebElement getSearchBox() {
		return searchBox;
	}
	public List<WebElement> getSonySoundbar() {
		return sonySoundbar;
	}
	public List<WebElement> getPincode() {
		return pincode;
	}
	public WebElement getCheckButton() {
		return checkButton;
	}
	public WebElement getDeliveryMsg() {
		return deliveryMsg;
	}
	public List<WebElement> getIphone() {
		return iphone;
	}
	public WebElement getHelpCenter() {
		return helpCenter;
	}
	public WebElement getContact() {
		return contact;
	}
	
	
	
}
