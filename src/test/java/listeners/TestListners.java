package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BasePage;
import utils.ExtentReporter;

public class TestListners implements ITestListener{
	
	ExtentTest test;
	ExtentReports extent = ExtentReporter.getExtentObject();
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass("Test PASSED!");
		 try {
		        WebDriver driver = (WebDriver) result.getTestClass()
		                .getRealClass()
		                .getField("driver")
		                .get(result.getInstance());

		        String path = new BasePage().captureScreenshot(
		                result.getMethod().getMethodName(),
		                driver);

		        test.addScreenCaptureFromPath(path);

		    } catch (Exception e) {
		        e.printStackTrace();
		    }
	}
	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		 try {
		        WebDriver driver = (WebDriver) result.getTestClass()
		                .getRealClass()
		                .getField("driver")
		                .get(result.getInstance());

		        String path = new BasePage().captureScreenshot(
		                result.getMethod().getMethodName(),
		                driver);

		        test.addScreenCaptureFromPath(path);

		    } catch (Exception e) {
		        e.printStackTrace();
		    }
	}
	@Override
    public void onTestSkipped(ITestResult result) {

        test.skip("Test Skipped");

    }
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
	
}
