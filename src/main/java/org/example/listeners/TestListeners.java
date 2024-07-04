package org.example.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {
    private static final Logger LOGGER = LogManager.getLogger(TestListeners.class);
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("*******************************************************");
        System.out.println("Test " + result.getMethod().getMethodName() + " started");
        System.out.println("*******************************************************");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("*******************************************************");
        System.out.println("Test " + result.getMethod().getMethodName() + " success");
        System.out.println("*******************************************************");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("*******************************************************");
        System.out.println("Test " + result.getMethod().getMethodName() + " failed");
        System.out.println("*******************************************************");
    }
}
