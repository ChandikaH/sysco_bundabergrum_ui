package com.sysco.qe.bundabergrum.pages.HomePage;

import com.sysco.qe.bundabergrum.utils.PageBase;
import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

/**
 * HomePage.java - class to verify Home Page methods
 *
 * @author chandikab
 * @since 08/05/2018.
 */


public class HomePage extends PageBase {
    private By imgHomePageLogo = By.xpath("//div[@class='branding']//a[1]//img[1]");
    private By lnkMyAccount = By.xpath("//a[@title='My Account']");
    private By lnkProducts = By.xpath("//li[@class='link-product']/a");
    private By lnkCategories = By.xpath("//li[@class='link-product']/ul/li/ul/li/a");


    public void waitTillHomePageLoaded() {
        syscoLabUI.waitTillElementLoaded(imgHomePageLogo);
    }

    public boolean isHomePageLoaded() {
        return syscoLabUI.isDisplayed(imgHomePageLogo);
    }

    public boolean isMyAccountLinkLoaded() {
        return syscoLabUI.isDisplayed(lnkMyAccount);
    }

    public void navigateToLoginPage() {
        syscoLabUI.waitTillElementLoaded(lnkMyAccount);
        syscoLabUI.click(lnkMyAccount);
    }
}
