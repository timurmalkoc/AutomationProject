package reportConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.TestBase;
import utils.Utils;

public class Listener extends TestBase implements ITestListener {
    ExtentTest test;
    ExtentReports extentReports = ExtentReportsNG.getExtentReports();
    //Thread safe for parallel testing
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal();

    @Override
    public void onTestStart(ITestResult result) {
        test = extentReports.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());
        String methodName = result.getMethod().getMethodName();
        String screenshot = Utils.takeScreenshot(methodName);
        Log.error(methodName+ " = " +screenshot);
        extentTest.get().addScreenCaptureFromPath(screenshot, methodName);
        tearDown();
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS,"Test Passed");
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}
