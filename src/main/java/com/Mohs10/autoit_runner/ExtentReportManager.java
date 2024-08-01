package com.Mohs10.autoit_runner;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
 
public class ExtentReportManager {
	
    private static ExtentReports extent; // ExtentReports instance
    private static ExtentTest test; // Current ExtentTest instance
    private static ExtentSparkReporter htmlReporter; // ExtentSparkReporter instance for HTML reporting
 
    /**
     * Initialize ExtentReports with the specified report path.
     * @param reportPath The path where the report will be generated.
     */
    public static void init(String reportPath) {
        htmlReporter = new ExtentSparkReporter(reportPath); // Initialize ExtentSparkReporter with reportPath
        extent = new ExtentReports(); // Initialize ExtentReports instance
        extent.attachReporter(htmlReporter); // Attach htmlReporter to extent
    }
 
    /**
     * Create a new test in the report.
     * @param testName Name of the test
     * @param description Description of the test
     */
    public static void createTest(String testName, String description) {
        test = extent.createTest(testName, description); // Create a new ExtentTest with testName and description
    }
 
    /**
     * Retrieve the current test instance.
     * @return Current ExtentTest instance
     */
    public static ExtentTest getTest() {
        return test; // Return the current ExtentTest instance
    }
 
    /**
     * Flush the report (write test information to the report).
     */
    public static void flush() {
        if (extent != null) {
            extent.flush(); // Flush ExtentReports instance to write information to the report
        }
    }
}
