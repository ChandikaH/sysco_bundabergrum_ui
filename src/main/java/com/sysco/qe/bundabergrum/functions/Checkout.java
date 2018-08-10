package com.sysco.qe.bundabergrum.functions;

import com.sysco.qe.bundabergrum.common.PageConstants;
import com.sysco.qe.bundabergrum.pages.CheckoutPage;
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

    public static void clickButtonContinueToDelivery() {
        checkout.clickContinueToDeliveryButton();
        PageBase.waitFor(5);
    }

    public static void clickContinueToPaymentSection() {
        checkout.clickContinueToPayment();
        PageBase.waitFor(3);
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

    public static void enterUserInformation() {
        checkout.enterFirstNameText(getName(PageConstants.STRING_FIRST_NAME));
        checkout.enterLastNameText(getName(PageConstants.STRING_LAST_NAME));
        checkout.enterAddress1Text(PageConstants.STRING_ADDRESS1);
        checkout.enterContactNumber(PageConstants.STRING_CONTACT_NUMBER);
    }

    public static void enterPostalCode() {
        checkout.enterPostalCode(PageConstants.STRING_POSTAL_CODE);
    }

    public static boolean isPostalCodeDisplayed() {
        return checkout.isPostalCodeAdded();
    }

    public static boolean isFirstNameDisplayed() {
        return checkout.isFirstNameDisplayed();
    }

    public static boolean isLastNameDisplayed() {
        return checkout.isLastNameDisplayed();
    }

    public static boolean isDeliveryWarningDisplayed() {
        return checkout.isDeliveryWarningDisplayed();
    }

    public static boolean isInstructionsTextAreaDisplayed() {
        return checkout.isInstructionsTextAreaDisplayed();
    }

    public static void checkAuthorizeShippingCheckbox() {
        checkout.checkAuthorizeShipping();
    }

    public static String getDeliveryWarningErrorMessage() {
        return checkout.getDeliveryWarningErrorMessage();
    }

    public static void clickPurchaseOrderButton() {
        checkout.clickPurchaseOrderButton();
    }

    public static boolean isLabelSelectPaymentMethodDisplayed() {
        return checkout.isLabelSelectPaymentMethodDisplayed();
    }

    public static void selectCreditCardOption() {
        checkout.clickCreditCardRadio();
        PageBase.waitFor(1);
    }

    public static boolean isCreditCardTextboxDisplayed() {
        return checkout.isCreditCardTextboxDisplayed();
    }

    public static String getCreditCardTextboxErrorMessage() {
        return checkout.getCreditCardTextboxErrorMessage();
    }

    public static String getInvalidCreditCardErrorMessage() {
        return checkout.getInvalidCreditCardError();
    }
    public static String getCreditCardCVVTextboxErrorMessage() {
        return checkout.getCreditCardCVVErrorMessage();
    }

    public static void enterCreditCardDetails(String creditCardNumber, String cvvCode) {
        checkout.enterCreditCardNumber(creditCardNumber);
        checkout.enterCVVCodeText(cvvCode);
        PageBase.waitFor(1);
    }
}
