package com.sysco.qe.bundabergrum.utils;

import com.sysco.qe.bundabergrum.common.Constants;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import com.syscolab.qe.core.reporting.SyscoLabQCenter;
import com.syscolab.qe.core.reporting.SyscoLabReporting;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;

public class TestBase extends SyscoLabListener {
    private static final Logger LOGGER = Logger.getLogger(TestBase.class);


    private SyscoLabListener testListeners;
    private SyscoLabQCenter syscoLabQCenter;
    protected SyscoLabReporting syscoLabReporting;
    protected SoftAssert softAssert;


    @BeforeClass
    public void init() {
        syscoLabQCenter = new SyscoLabQCenter();
        syscoLabReporting = new SyscoLabReporting();
        testListeners = new SyscoLabListener(syscoLabUI);
    }

    @BeforeMethod
    public void beforeMethod() {
        softAssert = new SoftAssert();
    }

    @BeforeMethod
    public void nameBefore(Method method) {
        LOGGER.info("Test name: " + method.getName());
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Test Running " + this.getClass().toString());
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        LOGGER.info("Executed test case name:" + result.getMethod().getMethodName());
    }

    @AfterClass(alwaysRun = true)
    public void cleanUp(ITestContext iTestContext) {
        try {
            syscoLabQCenter.setProjectName(Constants.TEST_PROJECT);
            syscoLabQCenter.setEnvironment(Constants.TEST_ENV);

            syscoLabQCenter.setRelease(Constants.TEST_RELEASE);
            syscoLabQCenter.setModule(iTestContext.getAttribute("feature").toString());
            syscoLabQCenter.setFeature(iTestContext.getAttribute("feature").toString());
            syscoLabQCenter.setClassName(iTestContext.getClass().getName());

            if (Constants.UPDATE_DASHBOARD)
                SyscoLabReporting.generateJsonFile(SyscoLabListener.getResults(), syscoLabQCenter);
            PageBase.quitDriver();

        } catch (Exception e) {
            e.printStackTrace();
            PageBase.quitDriver();
        }
    }
}
