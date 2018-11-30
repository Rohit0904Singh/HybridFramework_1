package com.packagename.main;

import static com.packagename.main.DriverScripts.APP_LOGS;
import static com.packagename.main.DriverScripts.OR;
import static com.packagename.main.DriverScripts.CONFIG;


import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.packagename.main.Constants;

public class Keywords {
	
	public WebDriver driver;
	static File scrfile;
	static String getvar;
	//string
	
	public String OpenWebSite(String data,String object){
		APP_LOGS.debug(" Data is "+data);
		APP_LOGS.debug(" object is "+object);
		System.setProperty("webdriver.chrome.driver", "F:\\Automation-Test\\Projects\\Jars\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		
		try{
			driver.get(data);
		}catch(Throwable e){
			APP_LOGS.debug("Exception in Open website "+e);
		}
		
		
		return "Pass";
	}
	public String openBrowser(String data,String object){
		System.out.println("Inside Open Browser");
		APP_LOGS.debug("Hello");
		if(data.equals("Mozilla")){
			driver=new FirefoxDriver();
			APP_LOGS.debug("FF");
		}else if (data.equals("IE")){
			driver=new InternetExplorerDriver();
		}else if(data.equals("Chrome")){
			driver=new ChromeDriver();
			
		}
		//long implicitWaitTime=Long.parseLong(CONFIG.getProperty("implicitwait"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return Constants.PASS;
	}
	
	public String navigate(String data,String object){
		//System.out.println("Inside navigate");
		try{
		driver.navigate().to(data);
		}catch(Exception e){
			return "Fail";
		}
		return Constants.PASS;
	}
	
	public String clickLink(String data,String object){
		//System.out.println("Inside clickLink" +OR.getProperty(object));
		try{
			Thread.sleep(2000);
			driver.findElement(By.xpath(OR.getProperty(object))).click();
		}catch(Throwable e){
			//System.out.println("Inside Click link exception is "+e);
			
		}
		return Constants.PASS;
	}
	
	
	public String takescreenshot(String data,String object){
		//System.out.println("Inside clickLink" +OR.getProperty(object));
		try{
			Thread.sleep(2000);
			driver.findElement(By.xpath(OR.getProperty(object))).click();
			
		}catch(Throwable e){
			//System.out.println("Inside Click link exception is "+e);
			
		}
		return Constants.PASS;
	}
	
	public  String writeInInput(String data,String object){
		APP_LOGS.debug("Writing in text box "+data);
		APP_LOGS.debug("Writing Object in text box "+object);
		
		try{
			Thread.sleep(5000);
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
		}catch(Throwable e){
			//return Constants.KEYWORD_FAIL+" Unable to write "+e.getMessage();
			System.out.println("Inside writeInInput exception is "+e);
		}
		return "Pass";
		
	}
	
	public String verifytext(String data,String object) {
		int count=0;
		try {
			getvar=driver.findElement(By.xpath(OR.getProperty(object))).getText();
			if(getvar.equals(data)) {
				count=1;
			}
			else				
				count=0;
				
			
		}catch(Throwable e){
		}		
		
		if(count==1)
			return "Pass";
		else
			return "Fail";
	}

}
