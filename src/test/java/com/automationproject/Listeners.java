package com.automationproject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.myautomationproject.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BaseClass implements ITestListener {
    ExtentReports extent = ExtentReporterNG.getExtentReporter();
    ExtentTest test;
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);

    }

    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test passed.");

    }

    public void onTestFailure(ITestResult result) {
        WebDriver driver = null;
        extentTest.get().fail(result.getThrowable());
        String testName = result.getMethod().getMethodName();
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            extentTest.get().addScreenCaptureFromPath(takeScreenShot(testName, driver), result.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onTestFailedWithTimeout(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
