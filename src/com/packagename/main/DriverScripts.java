package com.packagename.main;

import org.apache.log4j.Logger;

import com.packagename.xls.read.Xls_Reader;

public class DriverScripts {

	public Logger APP_LOGS;
	public Xls_Reader Suitexls;
    public String rnmd,rmtc;
    public String tsiddm,tciddm;
    public Xls_Reader modulexls;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DriverScripts ds = new DriverScripts();
        ds.startFunction();
        
		
	}
	
	public void startFunction(){
		APP_LOGS=Logger.getLogger("devpinoyLogger");
		APP_LOGS.debug(" - Testing is Started!!");
    //Create the object for Suite File and get module names
		Suitexls= new Xls_Reader("F:\\Automation-Test\\NewWorkspace_2\\HybridFramework_1\\src\\com\\packagename\\xls\\Suite.xlsx");
		
		int rowCount = Suitexls.getRowCount("TestSuite");
		
            //Reading TestSuite and get TSID Row//
	         for(int row=2;row<=rowCount ;row++)
	         { 
	        	 rnmd  = Suitexls.getCellData("TestSuite", "Runmode", row);
	                   if ((rnmd).equals("Y")){
	                	tsiddm = Suitexls.getCellData("TestSuite", "TSID", row);
	                	APP_LOGS.debug("Module to be executed as " +tsiddm );
	                
	                     modulexls = new Xls_Reader("F:\\Automation-Test\\NewWorkspace_2\\HybridFramework_1\\src\\com\\packagename\\xls\\"+tsiddm+".xlsx");
	         
	                      int rowexecuteCount = modulexls.getRowCount("TestCase");
	                      // APP_LOGS.debug(rowexecuteCount);
	                        for(int rm =2;rm<=rowexecuteCount ;rm++)
	                          { 
	        	                 rmtc  = modulexls.getCellData("TestCase", "Runmode", rm);
	                                   if ((rmtc).equals("Y")){
	                	                    tciddm = modulexls.getCellData("TestCase", "TCID", rm);
	                	                        APP_LOGS.debug("TestCase to be executed as " +tciddm );
	                }
                }
	         }
           }
        }
}
