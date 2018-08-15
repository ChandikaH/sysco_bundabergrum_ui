package com.sysco.qe.bundabergrum.pages.HomePage;

import com.sysco.qe.bundabergrum.utils.PageBase;
import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

/**
 * HomePage.java - class to verify Home Page methods
 *
 * @author chandikab
 * @since 08/05/2018.
 */


public class HomePage extends PageBase {
    private static final Logger LOGGER = Logger.getLogger(HomePage.class);

    private By imgHomePageLogo = By.xpath("//div[@class='branding']//a[1]//img[1]");
    private By lnkMyAccount = By.xpath("//a[@title='My Account']");
    private By lnkProducts = By.xpath("//li[@class='link-product']/a");
    private By lnkCategories = By.xpath("//li[@class='link-product']/ul/li/ul/li/a");
    private By lnkCategoryExclusive = By.xpath("//div[@class='nav-column']//a[contains(@class,'level1')][contains(text(),'Exclusive Range')]");



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
        LOGGER.info("Clicked on My Account link");
    }

    public void mouseHoverProductsLink() {
        syscoLabUI.mouseHover(lnkProducts);
    }

    public void selectCategory() {
        syscoLabUI.click(lnkCategoryExclusive);
    }

}
