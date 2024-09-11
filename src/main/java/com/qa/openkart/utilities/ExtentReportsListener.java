package com.qa.openkart.utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportsListener implements ITestListener {
    private static ExtentReports extentReports;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    static {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent-report.html");
        
        ///below lines is for design in Extent Report
        htmlReporter.config().setReportName("Playwright POM_HTML");
        htmlReporter.config().setDocumentTitle("Playwright Project");
        htmlReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.STANDARD);
        
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }

    @Override
    public void onStart(ITestContext context) {
        // You can initialize anything before the tests start if needed 
    }
 
    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReports.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().skip("Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}
