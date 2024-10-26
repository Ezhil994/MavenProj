package org.steps;

import org.helper.Utility;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;



public class Hooks extends Utility{
	@Before
	public void initialize() {
		browserLaunch("Chrome", "https://www.flipkart.com/");
		maxWindow();
		waitProg(10);
	}
	
	@After
	public void tearDown(Scenario scen) {
		if (scen.isFailed()) {
			TakesScreenshot take =(TakesScreenshot)driver;
			byte[] screenshot = take.getScreenshotAs(OutputType.BYTES);
			scen.attach(screenshot, "img/png", "Flipkart Home page");
		}
	}
	

}
