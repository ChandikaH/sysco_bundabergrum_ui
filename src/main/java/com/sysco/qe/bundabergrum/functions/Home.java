package com.sysco.qe.bundabergrum.functions;

import com.sysco.qe.bundabergrum.common.Constants;
import com.sysco.qe.bundabergrum.pages.HomePage.HomePage;
import com.sysco.qe.bundabergrum.utils.DriverSetUpUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Home.java - class to verify Home Page functions
 *
 * @author chandikab
 * @since 08/05/2018.
 */
public class Home {

    private static final Logger LOGGER = Logger.getLogger(Home.class);
    public static HomePage homePage = new HomePage();


    public static void loadHomePage() {

        if (Constants.RUN_LOCALLY) {
            DriverSetUpUtil.setToRunLocally();
            DesiredCapabilities capabilities = null;
            homePage.loadPage(capabilities, Constants.APP_URL);
        } else {
            homePage.loadPage(DriverSetUpUtil.setToRunRemotely(Constants.APP_OS), Constants.APP_URL);
        }
        LOGGER.info("Home page loaded successfully");
    }

    public static void isHomePageLoaded() {
        homePage.waitTillHomePageLoaded();
    }

    public static boolean isHomePageDisplayed() {
        return homePage.isHomePageLoaded();
    }

    public static boolean isMyAccountLinkLoaded() {
        return homePage.isMyAccountLinkLoaded();
    }

    public static void navigateToLoginPage() {
        homePage.waitFor(3);
        homePage.navigateToLoginPage();
        LOGGER.info("Navigated to Login Page");
    }

    public static void mouseHoverProductsLink() {
        homePage.mouseHoverProductsLink();
    }

    public static void selectCategoryFromList() {
        homePage.selectCategory();
        LOGGER.info("Category selected");
    }

}
