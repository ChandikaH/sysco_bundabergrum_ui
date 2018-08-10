package com.sysco.qe.bundabergrum.pages;

import com.sysco.qe.bundabergrum.utils.PageBase;
import org.openqa.selenium.By;

/**
 * CheckoutPage.java - class to verify Checkout Page methods
 *
 * @author chandikab
 * @since 08/05/2018.
 */
public class CheckoutPage extends PageBase {

    private By btnClearPostcode = By.id("billing:postcodesuburbremove");
    private By btnContinueToDelivery = By.id("delivery-address-button");
    private By btnContinueToPayment = By.id("shipping-method-button");
    private By btnPurchaseOrder = By.id("payment-method-button");
    private By chkAuthorizeShipping = By.id("ns-checkout-shipping-authorize_mm");
    private By divFirstNameError = By.id("advice-required-entry-billing:firstname");
    private By divLastNameError = By.id("advice-required-entry-billing:lastname");
    private By divAddress1Error = By.id("advice-required-entry-billing:street1");
    private By divPostcodeError = By.id("advice-required-entry-billing:postcodesuburb");
    private By divPostcode = By.xpath("//div[@id='Autocomplete_billing:postcodesuburb']/div[1]");
    private By divContactNumberError = By.id("advice-required-entry-billing:telephone");
    private By divDeliveryWarningError = By.id("advice-required-entry-ns-checkout-shipping-authorize_mm");
    private By divCreditCardTextboxError = By.id("advice-required-entry-braintree_cc_number");
    private By divInvalidCreditCard = By.id("advice-validate-cc-number-braintree_cc_number");
    private By divCreditCardCVVError = By.id("advice-required-entry-braintree_cc_cid");
    private By lblRadioCreditCard = By.xpath("//label[@for='p_method_braintree']");
    private By lblFlatRate = By.xpath("//label[@for='s_method_matrixrate_matrixrate_58']");
    private By lblSelectPaymentMethod = By.xpath("//dl[@id='checkout-payment-method-load']/label");
    private By spnDeliveryWarning = By.xpath("//span[@for='ns-checkout-shipping-authorize']");
    private By txtFirstName = By.id("billing:firstname");
    private By txtLastName = By.id("billing:lastname");
    private By txtAddress1 = By.id("billing:street1");
    private By txtPostcode = By.id("billing:postcodesuburb");
    private By txtContactNumber = By.id("billing:telephone");
    private By txtDeliveryInstructions = By.id("ns-checkout-shipping-instruction");
    private By txtCreditCardnumber = By.id("braintree_cc_number");
    private By txtCVVCode= By.id("braintree_cc_cid");


    public String getFirstName() {
        return syscoLabUI.getValue(txtFirstName);
    }

    public String getLastName() {
        return syscoLabUI.getValue(txtLastName);
    }

    public void clickContinueToDeliveryButton() {
        syscoLabUI.click(btnContinueToDelivery);
    }

    public void clearFirstName() {
        syscoLabUI.clear(txtFirstName);
    }

    public void clearLastName() {
        syscoLabUI.clear(txtLastName);
    }

    public void clearAddress1() {
        syscoLabUI.clear(txtAddress1);
    }

    public void clearContactNumber() {
        syscoLabUI.clear(txtContactNumber);
    }

    public void clearPostcode() {
        syscoLabUI.click(btnClearPostcode);
    }

    public String getFirstNameErrorMessage() {
        return syscoLabUI.getText(divFirstNameError);
    }

    public String getLastNameErrorMessage() {
        return syscoLabUI.getText(divLastNameError);
    }

    public String getAddressErrorMessage() {
        return syscoLabUI.getText(divAddress1Error);
    }

    public String getPostcodeErrorMessage() {
        return syscoLabUI.getText(divPostcodeError);
    }

    public String getContactNumberErrorMessage() {
        return syscoLabUI.getText(divContactNumberError);
    }

    public void enterFirstNameText(String firstname) {
        syscoLabUI.sendKeys(txtFirstName, firstname);
    }

    public void enterLastNameText(String lastname) {
        syscoLabUI.sendKeys(txtLastName, lastname);
    }

    public void enterAddress1Text(String address) {
        syscoLabUI.sendKeys(txtAddress1, address);
    }

    public void enterContactNumber(String contactNo) {
        syscoLabUI.sendKeys(txtContactNumber, contactNo);
    }

    public boolean isFirstNameDisplayed() {
        return syscoLabUI.getText(txtFirstName) != "";
    }

    public boolean isLastNameDisplayed() {
        return syscoLabUI.getText(txtLastName) != "";
    }

    public void enterPostalCode(String postCode) {
        syscoLabUI.sendKeys(txtPostcode, postCode);
        syscoLabUI.sleep(2);
        syscoLabUI.click(divPostcode);
    }

    public boolean isPostalCodeAdded() {
        return syscoLabUI.getText(txtPostcode) != "";
    }

    public boolean isDeliveryWarningDisplayed() {
        return syscoLabUI.isDisplayed(spnDeliveryWarning);
    }

    public boolean isInstructionsTextAreaDisplayed() {
        return syscoLabUI.isDisplayed(txtDeliveryInstructions);
    }

    public String getDeliveryWarningErrorMessage() {
        return syscoLabUI.getText(divDeliveryWarningError);
    }

    public void checkAuthorizeShipping() {
        syscoLabUI.click(chkAuthorizeShipping);
        PageBase.waitFor(1);
    }

    public void clickContinueToPayment() {
        syscoLabUI.click(btnContinueToPayment);
    }

    public void clickPurchaseOrderButton() {
        syscoLabUI.click(btnPurchaseOrder);
    }

    public boolean isLabelSelectPaymentMethodDisplayed() {
        return syscoLabUI.isDisplayed(lblSelectPaymentMethod);
    }

    public void clickCreditCardRadio() {
        syscoLabUI.click(lblRadioCreditCard);
    }

    public boolean isCreditCardTextboxDisplayed() {
        return syscoLabUI.isDisplayed(txtCreditCardnumber);
    }

    public String getCreditCardTextboxErrorMessage() {
        return syscoLabUI.getText(divCreditCardTextboxError);
    }

    public String getInvalidCreditCardError() {
        return syscoLabUI.getText(divInvalidCreditCard);
    }

    public String getCreditCardCVVErrorMessage() {
        return syscoLabUI.getText(divCreditCardCVVError);
    }

    public void enterCreditCardNumber(String cardNumber) {
        syscoLabUI.sendKeys(txtCreditCardnumber, cardNumber);
    }

    public void enterCVVCodeText(String cvvCode) {
        syscoLabUI.sendKeys(txtCVVCode, cvvCode);
    }
}
