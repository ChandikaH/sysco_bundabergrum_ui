package com.sysco.qe.bundabergrum.pages;

import com.sysco.qe.bundabergrum.utils.PageBase;
import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

/**
 * LoginPage.java - class to verify LoginPage methods
 *
 * @author chandikab
 * @since 08/05/2018.
 */
public class LoginPage extends PageBase {

    /**
     * Initialize Login page elements
     */
    private By lblMyAccount = By.xpath("//h1[contains(text(),'my bundy account')]");
    private By txtEmail = By.id("email");
    private By txtPassword = By.id("pass");
    private By btnSignIn = By.id("send2");
    private By spnLoginErrorMessage = By.xpath("//span[contains(text(),'Invalid login or password.')]");
    private By divInvalidEmail = By.id("advice-validate-email-email");
    private By divInvalidPassword = By.id("advice-validate-password-pass");

    public void waitTillLoginPageLoads() {
        syscoLabUI.isClickable(btnSignIn);
    }

    public boolean isLoginButtonDisplayed() {
        return syscoLabUI.isDisplayed(btnSignIn);
    }

    public void enterEmailText(String email) {
        syscoLabUI.sendKeys(txtEmail, email);
    }

    public void enterPasswordText(String password) {
        syscoLabUI.sendKeys(txtPassword, password);
    }

    public void clickSubmit() {
        syscoLabUI.click(btnSignIn);
    }

    public String getLoginErrorMessage() {
        return syscoLabUI.getText(spnLoginErrorMessage);
    }

    public boolean isLoginErrorMessageDisplayed() {
        return syscoLabUI.isDisplayed(spnLoginErrorMessage);
    }

    public String getIncorrectEmailMessage() {
        return syscoLabUI.getText(divInvalidEmail);
    }

    public boolean isIncorrectEmailMessageDisplayed() {
        return syscoLabUI.isDisplayed(divInvalidEmail);
    }

    public String getIncorrectPasswordMessage() {
        return syscoLabUI.getText(divInvalidPassword);
    }

    public boolean isIncorrectPasswordMessageDisplayed() {
        return syscoLabUI.isDisplayed(divInvalidPassword);
    }

}
