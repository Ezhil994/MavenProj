package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.reports.Report;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Flipkart1.feature",glue="org.steps",
  dryRun=false,tags=("@smoke or @sanity or @Regression"),plugin= {"json:target\\Reports\\JVM Report\\Flipkart.json",
  "html:target\\Reports\\HTML Report\\Flipkart","junit:target\\Reports\\Junit Report\\Flipkart.xml"})

public class TestRunner {
	@AfterClass
	public static void generateReport() {
		Report.createReport("target\\Reports\\JVM Report\\Flipkart.json");
		
	}

}


