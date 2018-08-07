package com.sysco.qe.bundabergrum.functions;

import com.sysco.qe.bundabergrum.common.PageConstants;
import com.sysco.qe.bundabergrum.pages.HomePage.AgeGatePage;

import java.text.DateFormatSymbols;

/**
 * AgeGate.java - class to verify AgeGate Page functions
 *
 * @author chandikab
 * @since 08/05/2018.
 */
public class AgeGate {

    public static AgeGatePage ageGatePage = new AgeGatePage();

    public static void waitForAgeGatePageLoaded() {
        ageGatePage.waitTillAgeGateOverlayLoaded();
    }

    public static boolean isAgeGateOverlayDisplayed() {
        return ageGatePage.isAgeGateOverlayLoaded();
    }

    public static void enterBirthdayDetailsAndConfirm(String pastDate) {

        String date = pastDate;
        String[] dateParts = date.split("/");
        String day = dateParts[0].replaceAll("^[0]+", "");
        int month = Integer.parseInt(dateParts[1]);
        String monthName = getMonth(month);
        String year = dateParts[2];

        ageGatePage.selectCountry(PageConstants.SELECT_COUNTRY_US);
        ageGatePage.selectDay(day);
        ageGatePage.selectMonth(monthName);
        ageGatePage.selectYear(year);
        ageGatePage.clickAgeConfirmButton();
    }

    public static String getAgeErrorMessage() {
        return ageGatePage.getAgeErrorMessage();
    }

    public static boolean isAgeErrorMessageDisplayed() {
        return ageGatePage.isAgeErrorMessageLoaded();
    }

    private static String getMonth(int month) {
        return new DateFormatSymbols().getMonths()[month - 1];
    }
}
