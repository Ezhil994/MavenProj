package org.steps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.helper.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.pojo.AddToCartPojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition extends Utility {
	
	@Given("User have to be in Facebook login page")
	public void user_have_to_be_in_facebook_login_page() {
	    
	}
	@Given("User can maximize the window")
	public void user_can_maximize_the_window() {
	    
	}
	@When("User enters the invalid email and invalid password")
	public void user_enters_the_invalid_email_and_invalid_password(io.cucumber.datatable.DataTable dataTable) {
	    
	}
	@When("User clicks login button")
	public void user_clicks_login_button() {
	    
	}
	@Then("User should be in the invalid credentials page")
	public void user_should_be_in_the_invalid_credentials_page() {
	    
	}
	@When("User enters the valid email and invalid password")
	public void user_enters_the_valid_email_and_invalid_password(io.cucumber.datatable.DataTable dataTable) {
	    
	}

	
	
	
	@When("User mouse hovering to electronics section")
	public void user_mouse_hovering_to_electronics_section() {
	   a = new Actions(driver);
	   WebElement elec = driver.findElement(By.xpath("//span[text()='Electronics']"));
	   a.moveToElement(elec).perform();
	}
	@When("User mouse hovering to Laptop Accessories and click the Router")
	public void user_mouse_hovering_to_laptop_accessories_and_click_the_router() {
	    a = new Actions(driver);
	    WebElement lap = driver.findElement(By.xpath("//a[text()='Laptop Accessories']"));
	    a.moveToElement(lap).perform();
	    driver.findElement(By.xpath("//a[text()='Router']")).click();
	}
	@When("User have to choose a particular product")
	public void user_have_to_choose_a_particular_product() {
	   driver.findElement(By.xpath("//div[contains(text(),'HI-FOCUS LTE 4G ROUTER/Support 5G')]")).click();
	}
	@When("User redirects to a new window")
	public void user_redirects_to_a_new_window() {
	    Set<String> allWind = driver.getWindowHandles();
	    List<String> li = new ArrayList<String>();
	    li.addAll(allWind);
	    String wind = li.get(1);
	    driver.switchTo().window(wind);
	    driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
	}
	@When("User click the add to cart button")
	public void user_click_the_add_to_cart_button() {
	    
	}
	@Then("the product should get added to a cart")
	public void the_product_should_get_added_to_a_cart() {
	    String cart = driver.getCurrentUrl();
	    if (cart.contains("viewcart")) {
			System.out.println("Product added to cart");
			driver.findElement(By.xpath("//div[text()='Save for later']")).click();
		} else {
			System.out.println("Product not added to cart");
		}
    }
	
	
	
	@Given("User have to be in Login page")
	public void user_have_to_be_in_login_page() {
		WebDriverManager.edgedriver().setup();
		 driver = new EdgeDriver();
		 driver.get("https://adactinhotelapp.com/");
	}
	@Given("User maximize the window")
	public void user_maximize_the_window() {
	   driver.manage().window().maximize();
	}
	@When("User have to enter valid username and invalid password")
	public void user_have_to_enter_valid_username_and_invalid_password(io.cucumber.datatable.DataTable dataTable) {
	   List<List<String>> allData = dataTable.asLists();
	   String userName = allData.get(3).get(0);
	   driver.findElement(By.id("username")).sendKeys(userName);
	   String password = allData.get(3).get(1);
	   driver.findElement(By.id("password")).sendKeys(password);
	}
	@When("User have to click login button")
	public void user_have_to_click_login_button() {
	   driver.findElement(By.id("login")).click();
	}
	@Then("User have to receives a invalid credentials message")
	public void user_have_to_receives_a_invalid_credentials_message() {
	    WebElement invalid = driver.findElement(By.xpath("//b[contains(text(),'Invalid Login details')]"));
	    String message = invalid.getText();
	    if (message.contains("Invalid Login")) {
			System.out.println("User received a invalid credentials message");
		} else {
			System.out.println("User not receive a invalid credentials message");
		}
	}
	
	@When("User have to enter valid username and valid password")
	public void user_have_to_enter_valid_username_and_valid_password(io.cucumber.datatable.DataTable dataTable) {
	    List<String> asList = dataTable.asList();
	    String userName = asList.get(0);
	    driver.findElement(By.id("username")).sendKeys(userName);
	    String password = asList.get(1);
	    driver.findElement(By.id("password")).sendKeys(password);
	}
	@Then("User have to lands on the Adactin home page")
	public void user_have_to_lands_on_the_adactin_home_page() {
	    WebElement title = driver.findElement(By.xpath("//td[@class='login_title']"));
	    String text = title.getText();
	    if (text.contains("Search")) {
			System.out.println("User lands on the home page");
		} else {
			System.out.println("User not login properly");
		}
	}


	
	

}
