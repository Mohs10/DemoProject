package com.Mohs10.Reports;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Mohs10.Base.StartBrowser;
//import com.Mohs10.Functions.CommonFuns;
import com.Mohs10.Functions.MO_Fun;
import com.Mohs10.utility.ListenerClass;

@Listeners(ListenerClass.class)
public class CustomizedEmailableReport extends StartBrowser 
{	
//	@Test
  /*  public void PassReportTest() throws Throwable{
		MO_Fun cnf = new MO_Fun();		
		cnf.DemoLoginforReports();
    } 

   //Fail scenario
    @Test
    public void FailReportTest() throws Throwable {
    	CommonFuns cnf = new CommonFuns();		
		cnf.DemoLoginforReports(); 
    } */
}
