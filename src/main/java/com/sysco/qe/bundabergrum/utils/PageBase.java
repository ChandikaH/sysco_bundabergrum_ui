package com.sysco.qe.bundabergrum.utils;

import com.sysco.qe.bundabergrum.pages.HomePage.AgeGatePage;
import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static com.sysco.qe.bundabergrum.common.PageConstants.DEFAULT_TIMEOUT;

/**
 * PageBase.java - class to add common page methods
 *
 * @author chandikab
 * @since 08/05/2018.
 */
public class PageBase {
    protected static SyscoLabUI syscoLabUI;
    protected static RemoteWebDriver webDriver;

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

    protected boolean waitTillElementVisible(By by, Long timeOut) {
        try {
            WebElement element = (new WebDriverWait(webDriver, 10))
                    .until(ExpectedConditions.elementToBeClickable(by));
            return syscoLabUI.isDisplayed(element);
        } catch (Exception e) {
            LOGGER.info("Element : " + by +  " not visible", e);
            webDriver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
            return false;
        }

    }
}
