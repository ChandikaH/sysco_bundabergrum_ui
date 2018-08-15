package com.sysco.qe.bundabergrum.functions;

import com.sysco.qe.bundabergrum.pages.LoginPage;
import com.sysco.qe.bundabergrum.utils.PageBase;
import org.apache.log4j.Logger;

/**
 * Login.java - class to verify Login Page functions
 *
 * @author chandikab
 * @since 08/05/2018.
 */
public class Login {

    private static final Logger LOGGER = Logger.getLogger(Login.class);
    public static LoginPage loginPage = new LoginPage();

    public static boolean isLoginButtonDisplayed() {
        return loginPage.isLoginButtonDisplayed();
    }

    public static void enterLoginDetailsAndSubmit(String email, String password) {
        loginPage.enterEmailText(email);
        loginPage.enterPasswordText(password);
        LOGGER.info("Login details entered");
        PageBase.waitFor(2);
        loginPage.clickSubmit();
        LOGGER.info("Clicked on Login button");
    }

    public static String getLoginErrorMessage() {
        return loginPage.getLoginErrorMessage();
    }

    public static boolean isLoginErrorMessageDisplayed() {
        return loginPage.isLoginErrorMessageDisplayed();
    }

    public static String getIncorrectEmailMessageText() {
        return loginPage.getIncorrectEmailMessage();
    }

    public static boolean isIncorrectEmailMessageDisplayed() {
        return loginPage.isIncorrectEmailMessageDisplayed();
    }

    public static String getIncorrectPasswordMessageText() {
        return loginPage.getIncorrectPasswordMessage();
    }

    public static boolean isIncorrectPasswordMessageDisplayed() {
        return loginPage.isIncorrectPasswordMessageDisplayed();
    }


}
