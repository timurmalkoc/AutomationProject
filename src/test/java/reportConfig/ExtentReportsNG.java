package reportConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {
    static ExtentReports extentReports;

    public static ExtentReports getExtentReports(){
        String path = System.getProperty("user.dir")+"/reports/index.html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
        sparkReporter.config().setReportName("Web Automation Report Results");
        sparkReporter.config().setDocumentTitle("Test Results");

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Tester","Timur");
        return extentReports;
    }
}
