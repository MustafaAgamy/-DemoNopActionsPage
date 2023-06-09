package utils.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;

public class ExtentReportClass {
    static ExtentReports extentReports;
    static String path = System.getProperty("user.dir") +"\\src\\main\\resources\\reports\\extent-results\\index.html";
    static String ReportName = "Selenium Test Results";
    static String DocumentTitle = "Automation Test Results";
    static String Title = "Tester";
    static String PersonName = "Mostafa Agamy";

    public static ExtentReports getReporterObject(){

        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName(ReportName);
        reporter.config().setDocumentTitle(DocumentTitle);

        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo(Title,PersonName);

        return extentReports;
       
    }
}
