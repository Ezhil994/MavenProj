package org.steps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.helper.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.pojo.AddToCartPojo;
import org.pojo.FlipkartHomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition1 extends Utility {
	FlipkartHomePage home;
	AddToCartPojo add;
	@Given("User have to be in flipkart homepage")
	public void user_have_to_be_in_flipkart_homepage() {
		
	}
	@When("User have to enter product name and press enter button")
	public void user_have_to_enter_product_name_and_press_enter_button() {
	    home= new FlipkartHomePage();
	    WebElement searchBox = home.getSearchBox();
	    fillTextBox(searchBox, "Soundbars");
	    searchBox.submit();
	}
	@When("User have to select the product")
	public void user_have_to_select_the_product() {
	    home= new FlipkartHomePage();
	    List<WebElement> sonySoundbar = home.getSonySoundbar();
	    WebElement sony = sonySoundbar.get(0);
	    sony.click();
	}
	@When("User have to enter pincode to check the availability")
	public void user_have_to_enter_pincode_to_check_the_availability() {
		String parent = driver.getWindowHandle();
	    Set<String> allWind = driver.getWindowHandles();
		for (String eachWind : allWind) {
			if (!eachWind.equals(parent)) {
				driver.switchTo().window(eachWind);
			}
		}
		home = new FlipkartHomePage();
		List<WebElement> pincode = home.getPincode();
	    pincode.get(0).sendKeys("600100");
	    home.getCheckButton().click();
	}
	@When("User have to click add to cart button")
	public void user_have_to_click_add_to_cart_button() {
	   add = new AddToCartPojo();
	   WebElement addCart = add.getAddCart();
	   addCart.click();
	}
	@Then("The product should get added to a cart")
	public void the_product_should_get_added_to_a_cart() {
		add= new AddToCartPojo();
		String cart = driver.getCurrentUrl();
	    if (cart.contains("viewcart")) {
			System.out.println("Product added to cart");
			WebElement saveLater = add.getSaveLater();
			saveLater.click();
		} else {
			System.out.println("Product not added to cart");
		}
	}
	@When("User have to enter product name {string} and press enter button")
	public void user_have_to_enter_product_name_and_press_enter_button(String product) {
	   home = new FlipkartHomePage();
	   WebElement searchBox = home.getSearchBox();
	   fillTextBox(searchBox, product);
	   searchBox.submit();
	}
	@Then("User have to check the products list")
	public void user_have_to_check_the_products_list() {
	    home = new FlipkartHomePage();
	    List<WebElement> iphoneList = home.getIphone();
	    for (int i = 0; i < iphoneList.size(); i++) {
			WebElement iphone = iphoneList.get(i);
			String text = iphone.getText();
			if (!text.contains("Apple")) {
				System.out.println("other products are present in products list");
			}
		}
	}
	@Given("User have to scrolldown the page to bottom")
	public void user_have_to_scrolldown_the_page_to_bottom() {
//	    JavascriptExecutor js =(JavascriptExecutor)driver;
//	    home = new FlipkartHomePage();
//	    WebElement helpCenter = home.getHelpCenter();
//	    js.executeScript("arguments[0].scrollIntoView(true)", helpCenter);
	}
	@When("User have to click the links in the bottom of home page")
	public void user_have_to_click_the_links_in_the_bottom_of_home_page() {
		home = new FlipkartHomePage();
		home.getContact().click();
	}
	@Then("User should get the related screen of the particular link")
	public void user_should_get_the_related_screen_of_the_particular_link() {
	    String currentUrl = driver.getCurrentUrl();
	    if (currentUrl.contains("helpcentre")) {
			System.out.println("Contact us link works properly");
		} else {
			System.out.println("Contact us link not works");
		}
	}



	
}
