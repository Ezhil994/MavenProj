package org.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Report {
	
	public static void createReport(String json) {
		File file = new File("target\\Reports");
		Configuration config = new Configuration(file, "Flipkart Homepage");
		config.addClassifications("QA", "Ezhil");
		config.addClassifications("Environment", "Testing-1");
		config.addClassifications("Sprint", "24");
		config.addClassifications("os", "Windows 11");
		config.addClassifications("Browser", "Chrome");
		config.addClassifications("Browser version", "129.0.6668.90");
		
		List<String> list = new ArrayList<String>();
		list.add(json);
		ReportBuilder report = new ReportBuilder(list, config);
		report.generateReports();
	}

}
