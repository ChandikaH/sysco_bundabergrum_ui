package com.sysco.qe.bundabergrum.functions;

import com.sysco.qe.bundabergrum.common.Constants;
import com.sysco.qe.bundabergrum.common.PageConstants;
import com.sysco.qe.bundabergrum.pages.CheckoutPage;
import com.sysco.qe.bundabergrum.pages.MyAccountPage;
import com.sysco.qe.bundabergrum.panels.CartPanel;
import com.sysco.qe.bundabergrum.utils.PageBase;

/**
 * Checkout.java - class to verify Checkout functions
 *
 * @author chandikab
 * @since 08/05/2018.
 */
public class Checkout {

    public static CheckoutPage checkout = new CheckoutPage();

    public static boolean verifyName(String name) {
        if (name == PageConstants.STRING_FIRST_NAME) {
            return getName(name).equals(checkout.getFirstName());
        } else
            return getName(name).equals(checkout.getLastName());
    }

    public static void clickButtonContinue() {
        checkout.clickContinueButton();
    }

    private static String getName(String name) {
        String username = (PageConstants.USER_NAME).toLowerCase();
        String[] arrOfStr = username.split(" ", 2);
        if (name == PageConstants.STRING_FIRST_NAME)
            return arrOfStr[0];
        else
            return arrOfStr[1];
    }

    public static void clearMandatoryFields() {
        checkout.clearFirstName();
        checkout.clearLastName();
        checkout.clearAddress1();
        checkout.clearContactNumber();
        checkout.clearPostcode();
        PageBase.waitFor(2);
    }

    public static String getFirstNameErrorMessage() {
        return checkout.getFirstNameErrorMessage();
    }

    public static String getLastNameErrorMessage() {
        return checkout.getLastNameErrorMessage();
    }

    public static String getAddressErrorMessage() {
        return checkout.getAddressErrorMessage();
    }

    public static String getPostcodeErrorMessage() {
        return checkout.getPostcodeErrorMessage();
    }

    public static String getContactNumberErrorMessage() {
        return checkout.getContactNumberErrorMessage();
    }
}
