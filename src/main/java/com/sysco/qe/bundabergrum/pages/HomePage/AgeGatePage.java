package com.sysco.qe.bundabergrum.pages.HomePage;

import com.sysco.qe.bundabergrum.utils.PageBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * AgeGatePage.java - class to verify Age Gate Page methods
 *
 * @author chandikab
 * @since 08/05/2018.
 */


public class AgeGatePage extends PageBase {
    private static final Logger LOGGER = Logger.getLogger(AgeGatePage.class);

    private By imgAgeLogo = By.id("age_logo_img");
    private By spnCheckId = By.xpath("//span[contains(text(),'Can we see some ID please?')]");
    private By spnEnterBirthDate = By.xpath("//span[contains(text(),'Enter your birthdate:')]");
    private By drpAgeSelectDay = By.id("age_select_day");
    private By drpAgeSelectMonth = By.id("age_select_month");
    private By drpAgeSelectYear = By.id("age_select_year");
    private By chkRememberMe = By.className("langable age_remember_me_basic");
    private By btnAgeConfirm = By.id("age_confirm_btn");
    private By drpAgeSelectCountry = By.id("age_select_country");
    private By spnAgeErrorMessage = By.xpath("//div[@id='age_missing_message']/span");

    public void waitTillAgeGateOverlayLoaded() {
        syscoLabUI.waitTillElementLoaded(imgAgeLogo);
        LOGGER.info("Age Gate Page loaded successfully");
    }

    public boolean isAgeGateOverlayLoaded() {
        return syscoLabUI.isDisplayed(imgAgeLogo);
    }

    public void selectDay(String day) {
        syscoLabUI.selectFromDropDown(drpAgeSelectDay, day);
    }

    public void selectMonth(String month) {
        syscoLabUI.selectFromDropDown(drpAgeSelectMonth, month);
    }

    public void selectYear(String year) {
        syscoLabUI.selectFromDropDown(drpAgeSelectYear, year);
    }

    public void selectCountry(String country) {
        syscoLabUI.selectFromDropDown(drpAgeSelectCountry, country);
    }

    public void clickAgeConfirmButton() {
        syscoLabUI.click(btnAgeConfirm);
    }

    public boolean isAgeErrorMessageLoaded() {
        return syscoLabUI.isDisplayed(spnAgeErrorMessage);
    }

    public String getAgeErrorMessage() {
        return syscoLabUI.getText(spnAgeErrorMessage);
    }


}
