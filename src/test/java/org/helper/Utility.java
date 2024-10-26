package org.helper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.Scenario;

public class Utility {
	public static WebDriver driver;
	public static Actions a;
	public static Robot r;
	public static Select text;
	public static JavascriptExecutor js;
	public static TakesScreenshot take;
	public static Scenario scen;
	public static void browserLaunch(String browser,String url ) {
		switch (browser) {
		case "Chrome":
			driver = new ChromeDriver();
			driver.get(url);
			break;
		case "Edge":
			driver = new EdgeDriver();
			driver.get(url);
			break;	
			
		}
	}
	public static void selectDropdownOptions(String selectMethod,WebElement element,String input) {
		switch (selectMethod) {
		case "text":
			Select text = new Select(element);
			text.selectByVisibleText(input);
			break;
		case "value":
			Select value = new Select(element);
			value.selectByValue(input);
			break;
		case "index":
			Select index = new Select(element);
			int numInput = Integer.parseInt(input);
			index.selectByIndex(numInput);
			break;

		 }
    }
	public static void mouseOperations(String selectMethod,WebElement element) {
		if (selectMethod.equalsIgnoreCase("movetoelement")) {
			a= new Actions(driver);
			a.moveToElement(element).perform();
		}
		else if (selectMethod.equalsIgnoreCase("doubleclick")) {
			a=new Actions(driver);
			a.doubleClick(element).perform();
		}
		else if (selectMethod.equalsIgnoreCase("rightclick")) {
			a=new Actions(driver);
			a.contextClick(element).perform();
		}
	}
	public static void dragAndDrop(WebElement src,WebElement dest) {
		a=new Actions(driver);
	    a.dragAndDrop(src, dest).perform();
	}
	public static void toFrameById(String input) {
		driver.switchTo().frame(input);
	}
	public static void toFrameByEle(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public static String readExcel(String fileName,String sheetName,int rowNo,int cellNo) {
		String data=null;
		try {
			File file = new File("C:\\Users\\ezhil\\eclipse-workspace\\MavenProject\\ExcelSheets\\"+fileName+".xlsx");
			FileInputStream fin = new FileInputStream(file);
			Workbook excel = new XSSFWorkbook(fin);
			Sheet sheet = excel.getSheet(sheetName);
			Row row = sheet.getRow(rowNo);
			Cell cell = row.getCell(cellNo);
			int cellType = cell.getCellType();
			
			if (cellType==1) {
				data = cell.getStringCellValue();
			}else if (DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat sim = new SimpleDateFormat("dd MM YYYY");
				data = sim.format(date);
			} 
			else {
				double num = cell.getNumericCellValue();
				long l =(long)num;
				data = String.valueOf(l);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
		
	}
	public static void toRefresh() {
		driver.navigate().refresh();
	}
	public static void toNavigate(String url) {
		driver.navigate().to(url);
	}
	public static void nextScreen() {
		driver.navigate().forward();
	}
	public static void previousScreen() {
		driver.navigate().back();
	}
	public static void takeScreenshot(String filename) {
		try {
			take=(TakesScreenshot)driver;
			File srcFile = take.getScreenshotAs(OutputType.FILE);
			File destFile = new File("C:\\Users\\ezhil\\eclipse-workspace\\MavenProject\\Screenshots\\"+filename+".png");
			FileUtils.copyFile(srcFile, destFile);
		} catch (Exception e) {
			
		}
	}
	public static void attachScreenshot(String name) {
		take=(TakesScreenshot)driver;
		byte[] screenshot = take.getScreenshotAs(OutputType.BYTES);
		scen.attach(screenshot, "img/png", name);
	}
	public static void switchWindow(int windowIndex) {
		Set<String> allWindow = driver.getWindowHandles();
		List<String> windowsList= new ArrayList<String>(allWindow);
		driver.switchTo().window(windowsList.get(windowIndex));
	}
	public static void scrollDown(WebElement element) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	public static void scrollUp(WebElement element) {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}
	public static void waitProg(int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	public static void pressEnter() {
		try {
			r= new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
     	}
	}
	public static void copy() {
		try {
			r=new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_C);
			r.keyRelease(KeyEvent.VK_CONTROL);
		} catch (AWTException e) {
			
		}
		
	}
	public static void nextField() {
		try {
			r=new Robot();
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
		} catch (AWTException e) {
			
		}
		
	}
	public static void paste() {
		try {
			r=new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
		} catch (AWTException e) {
			
		}
		
	}
	
	public static void fillTextBox(WebElement element,String value) {
		element.sendKeys(value);
	}
	public static void maxWindow() {
		driver.manage().window().maximize();
	}
	public static void minWindow() {
		driver.manage().window().minimize();
	}

}
