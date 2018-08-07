package com.sysco.qe.bundabergrum.tests;


import com.sysco.qe.bundabergrum.functions.Login;
import com.sysco.qe.bundabergrum.utils.TestBase;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Login - ValidLogin");
    }

    @Test
    public void testLogin() throws Exception {

        // Sample way to retrive data from excel
        //LoginData loginData = ExcelUtil.getLoginData("$as238l");

        softAssert.assertTrue(Login.isLoginButtonDisplayed(), "The Login Button is displayed");


    }
}