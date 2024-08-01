package com.Mohs10.TestScripts;
 
 
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.testng.annotations.Test;

import com.Mohs10.autoit_runner.ExtentReportManager;
import com.aventstack.extentreports.ExtentTest;
 
public class Insta_Safe
{
	@Test(priority=0)
    public  void Instasafe_Demo() {
    	
    	
        // Initialize the ExtentReports with the path to the 'reports' directory
        ExtentReportManager.init("InstasafeReports/extendreport.html");
        ExtentReportManager.createTest("AutoIt Script Execution Test", "Test to execute AutoIt script and log the output");
 
        ExtentTest test = ExtentReportManager.getTest();
 
        try {
            // Path to the AutoIt executable and script
            String autoItExecutable = "C:\\Users\\Dell\\Downloads\\Insta_Safe_Open.exe";
            String autoItScript = "C:\\Users\\Dell\\Downloads\\Instasafe.bat";  // Update this path to your script location
 
            // Build the process
            ProcessBuilder processBuilder = new ProcessBuilder(autoItExecutable, autoItScript);
            processBuilder.redirectErrorStream(true); // Merge stdout and stderr
 
            // Start the process
            Process process = processBuilder.start();
 
            // Read the output from the AutoIt script
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                test.info(line); // Log each line to the report
            }
 
            // Wait for the process to complete
            int exitCode = process.waitFor();
            String exitMessage = "AutoIt script exited with code: " + exitCode;
            System.out.println(exitMessage);
            test.info(exitMessage);
 
            if (exitCode != 0) {
                String errorMessage = "AutoIt script encountered an error.";
                System.err.println(errorMessage);
                test.fail(errorMessage);
            } else {
                test.pass("AutoIt script executed successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            test.fail(e.getMessage());
        } finally {
            ExtentReportManager.flush(); // Write the report to the file
        }
    }
}