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
    private By txtFirstName = By.id("billing:firstname");
    private By txtLastName = By.id("billing:lastname");
    private By txtAddress1 = By.id("billing:street1");
    private By txtPostcode = By.id("billing:postcodesuburb");
    private By txtContactNumber = By.id("billing:telephone");
    private By divFirstNameError = By.id("advice-required-entry-billing:firstname");
    private By divLastNameError = By.id("advice-required-entry-billing:lastname");
    private By divAddress1Error = By.id("advice-required-entry-billing:street1");
    private By divPostcodeError = By.id("advice-required-entry-billing:postcodesuburb");
    private By divContactNumberError = By.id("advice-required-entry-billing:telephone");
    private By btnClearPostcode = By.id("billing:postcodesuburbremove");
    private By btnContinue = By.id("delivery-address-button");


    public String getFirstName() {
        return syscoLabUI.getValue(txtFirstName);
    }

    public String getLastName() {
        return syscoLabUI.getValue(txtLastName);
    }

    public void clickContinueButton() {
        syscoLabUI.click(btnContinue);
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
}
