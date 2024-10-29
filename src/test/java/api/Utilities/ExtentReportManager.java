package api.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManager implements ITestListener {
    
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    String reportName;

    @Override
    public void onStart(ITestContext context) {
        // Initialize the ExtentReports instance
        String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
        reportName = "Test-Report-" + timeStamp + ".html";
        sparkReporter = new ExtentSparkReporter("./Reports/" + reportName);
        sparkReporter.config().setDocumentTitle("TravelPortalCRM Rest Assured Automation");
        sparkReporter.config().setReportName("Agency Test API");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Tester", "Sagar Raipurkar"); // Update with your name
        extent.setSystemInfo("Environment", "Test Environment"); // Specify environment
    }

//    @Override
//    public void onTestStart(ITestResult result) {
//        // Create a new test entry in the report
//        test = extent.createTest(result.getName());
//        test.assignCategory(result.getMethod().getGroups());
//        test.createNode(result.getName());
//        test.log(Status.PASS, "Test Passed");
//        
//    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Log test success
    	  test = extent.createTest(result.getName());
          test.assignCategory(result.getMethod().getGroups());
          test.createNode(result.getName());
          test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	  test = extent.createTest(result.getName());
          test.assignCategory(result.getMethod().getGroups());
          test.createNode(result.getName());
          test.log(Status.FAIL, "Test Fail");
          test.log(Status.FAIL, result.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    	  test = extent.createTest(result.getName());
          test.assignCategory(result.getMethod().getGroups());
          test.createNode(result.getName());
          test.log(Status.SKIP, "Test Skipped");
          test.log(Status.FAIL, result.getThrowable().getMessage());
    }

    @Override
    public void onFinish(ITestContext context) {
        // Flush the reports at the end of the test suite
        if (extent != null) {
            extent.flush();
        }
    }
}
