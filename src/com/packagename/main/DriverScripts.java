package com.packagename.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;


import com.packagename.xls.read.Xls_Reader;

public class DriverScripts {

	public static Logger APP_LOGS;
	public Xls_Reader Suitexls;
    public String rnmd,rmtc,tsrun,tsdescr;
    public String tsiddm,tciddm;
    public Xls_Reader modulexls;
    public static Properties CONFIG;
	public static Properties OR;
    
    
    
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("F:\\Automation-Test\\NewWorkspace_2\\HybridFramework_1\\src\\com\\packagename\\config\\config.properties");
		//FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\config\\config.properties");
		CONFIG=new Properties();
		CONFIG.load(fis);
		
		fis=new FileInputStream("F:\\Automation-Test\\NewWorkspace_2\\HybridFramework_1\\src\\com\\packagename\\config\\OR.properties");
		OR=new Properties();
		OR.load(fis);
		// TODO Auto-generated method stub
		DriverScripts ds = new DriverScripts();
        ds.startFunction();
        
		
	}
	
	public void startFunction(){
		APP_LOGS=Logger.getLogger("devpinoyLogger");
		APP_LOGS.debug(" - Testing is Started!!");
    //Create the object for Suite File and get module names
		Suitexls= new Xls_Reader("F:\\Automation-Test\\NewWorkspace_2\\HybridFramework_1\\src\\com\\packagename\\xlsmain\\Suite.xlsx");
		
		int rowCount = Suitexls.getRowCount("TestSuite");
		
            //Reading TestSuite and get TSID Row//
	         for(int row=2;row<=rowCount ;row++)
	         { 
	        	 rnmd  = Suitexls.getCellData("TestSuite", "Runmode", row);
	                   if ((rnmd).equals("Y")){
	                	tsiddm = Suitexls.getCellData("TestSuite", "TSID", row);
	                	APP_LOGS.debug("Module to be executed as " +tsiddm );
	                
	                     modulexls = new Xls_Reader("F:\\Automation-Test\\NewWorkspace_2\\HybridFramework_1\\src\\com\\packagename\\xlsmain\\"+tsiddm+".xlsx");
	                       /// To Read Module file or test Case files// 
	                     int rowexecuteCount = modulexls.getRowCount("TestCase");
	                      // APP_LOGS.debug(rowexecuteCount);
	                        for(int rm =2;rm<=rowexecuteCount ;rm++)
	                          { 
	        	                 rmtc  = modulexls.getCellData("TestCase", "Runmode", rm);
	                                   if ((rmtc).equals("Y")){
	                	                    tciddm = modulexls.getCellData("TestCase", "TCID", rm);
	                	                       // APP_LOGS.debug("TestCase to be executed as " +tciddm );
	                	                        
	                	  // To Compare test step with test case to be executed.   
	                	                        for(int ts =2;ts<=rowexecuteCount ;ts++)
	              	                          { 
	              	        	                 tsrun  = modulexls.getCellData("TestSteps", "TCID", ts);
	              	                                   if ((tsrun).equals("tciddm"))
	              	                                	  {
	              	                                	 tsdescr = modulexls.getCellData("TestSteps", "Description", ts);
	              	                	                      APP_LOGS.debug("Test Case Description is " +tsdescr );                     
	                	  
	                }
                }
	         }
           }
        } 
	   }
	 }
	}
