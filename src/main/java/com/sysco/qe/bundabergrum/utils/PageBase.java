package com.sysco.qe.bundabergrum.utils;

import com.sysco.qe.bundabergrum.pages.HomePage.AgeGatePage;
import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;

/**
 * PageBase.java - class to add common page methods
 *
 * @author chandikab
 * @since 08/05/2018.
 */
public class PageBase {
    protected static SyscoLabUI syscoLabUI;
    private static final Logger LOGGER = Logger.getLogger(PageBase.class);

    public PageBase() {

    }

    public static void loadPage(Capabilities capabilities, String url) {
        syscoLabUI = new SyscoLabWUI(capabilities);
        syscoLabUI.navigateTo(url);
        syscoLabUI.driver.manage().window().maximize();
    }

    public void refreshBrowser() {
        syscoLabUI.refreshBrowser();
    }

    public static void quitDriver() {
        if (syscoLabUI != null) {
            syscoLabUI.quit();
        }
    }

    public static void waitFor(int timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            LOGGER.info("Failed to Wait...!");
            e.printStackTrace();
        }
    }
}
