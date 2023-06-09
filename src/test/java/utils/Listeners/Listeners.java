package utils.Listeners;

import base.BaseTests;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentReports.ExtentReportClass;

import java.io.File;
import java.io.IOException;

public class Listeners extends BaseTests implements ITestListener {

    ExtentReports extentReports = ExtentReportClass.getReporterObject();
    ExtentTest test;
    WebDriver driver;

    @Override
    public void onTestStart(ITestResult result) {
        test = extentReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS,"Test case " + result.getName() + " has passed.");
    }


    @Override
    public void onTestFailure(ITestResult result) {
        try {
            driver = (ChromeDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e){
            e.printStackTrace();
        }
        try {
            test.addScreenCaptureFromPath(getScreenshotPath(result.getName(), driver),
                    result.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.log(Status.FAIL,"Test case "+result.getName() +" has Failed !!");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }

    public static String getScreenshotPath(String testcaseName, WebDriver driver) throws IOException {
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "\\src\\main\\resources\\reports\\screenshots\\" + testcaseName + ".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }
}
