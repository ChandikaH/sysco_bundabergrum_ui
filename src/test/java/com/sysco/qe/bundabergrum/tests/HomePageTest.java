package com.sysco.qe.bundabergrum.tests;

import com.sysco.qe.bundabergrum.common.PageConstants;
import com.sysco.qe.bundabergrum.functions.*;
import com.sysco.qe.bundabergrum.messages.Messages;
import com.sysco.qe.bundabergrum.utils.DateUtils;
import com.sysco.qe.bundabergrum.utils.PageBase;
import com.sysco.qe.bundabergrum.utils.TestBase;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import org.testng.ITestContext;
import org.testng.annotations.*;

/**
 * HomePageTest.java - class to include test cases to verify Bundabergrum - Checkout flow
 *
 * @author chandikab
 * @since 08/05/2018.
 */

@Listeners(SyscoLabListener.class)
public class HomePageTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Bundabergrum - Checkout");
        Home.loadHomePage();
    }

    @Test(description = "TC_001", alwaysRun = true)
    public void testVerifyAgeGateErrorMessage() {
        AgeGate.waitForAgeGatePageLoaded();
        softAssert.assertTrue(AgeGate.isAgeGateOverlayDisplayed(), "age Gate Logo in the AgeGate Overlay is not displayed");
        AgeGate.enterBirthdayDetailsAndConfirm(DateUtils.getPastDate(16));
        softAssert.assertTrue(AgeGate.isAgeErrorMessageDisplayed(), "Age Error is not displayed");
        softAssert.assertEquals(AgeGate.getAgeErrorMessage(), Messages.INCORRECT_AGE_MESSAGE);
        softAssert.assertAll();
    }

    @Test(description = "TC_002", alwaysRun = true, dependsOnMethods = "testVerifyAgeGateErrorMessage")
    public void testVerifyAgeGateConfirmation() {
        AgeGate.waitForAgeGatePageLoaded();
        softAssert.assertTrue(AgeGate.isAgeGateOverlayDisplayed(), "age Gate Logo in the AgeGate Overlay is not displayed");
        AgeGate.enterBirthdayDetailsAndConfirm(DateUtils.getPastDate(21));
        softAssert.assertFalse(AgeGate.isAgeErrorMessageDisplayed(), "Age Error is displayed");
        softAssert.assertTrue(Home.isHomePageDisplayed(), "Home page logo");
        softAssert.assertAll();
    }

    @Test(description = "TC_003", alwaysRun = true, dependsOnMethods = "testVerifyAgeGateConfirmation")
    public void testNavigateToMyAccountPage() {
        softAssert.assertTrue(Home.isMyAccountLinkLoaded(), "MyAccount link is not displayed");
        Home.navigateToLoginPage();
        softAssert.assertTrue(Login.isLoginButtonDisplayed(), "Login button is not displayed");
        softAssert.assertAll();
    }

    @Test(description = "TC_004", alwaysRun = true, dependsOnMethods = "testNavigateToMyAccountPage")
    public void testVerifyLoginErrorValidation() {
        Login.enterLoginDetailsAndSubmit(PageConstants.INVALID_EMAIL, PageConstants.INVALID_PW);
        softAssert.assertTrue(Login.isLoginErrorMessageDisplayed(), "Login Error is not displayed");
        softAssert.assertEquals(Login.getLoginErrorMessage(), Messages.LOGIN_ERROR_MESSAGE);
        softAssert.assertAll();
    }

    @Test(description = "TC_005", alwaysRun = true, dependsOnMethods = "testVerifyLoginErrorValidation")
    public void testVerifyCredentialValidation() {
        Login.enterLoginDetailsAndSubmit(PageConstants.INVALID_FORMAT_EMAIL, PageConstants.INVALID_FORMAT_PW);
        softAssert.assertTrue(Login.isIncorrectEmailMessageDisplayed(), "Incorrect Email Error is not displayed");
        softAssert.assertEquals(Login.getIncorrectEmailMessageText(), Messages.INCORRECT_EMAIL_MESSAGE);
        softAssert.assertTrue(Login.isIncorrectPasswordMessageDisplayed(), "Incorrect Password Error is not displayed");
        softAssert.assertEquals(Login.getIncorrectPasswordMessageText(), Messages.INCORRECT_PW_MESSAGE);
        softAssert.assertAll();
    }

    @Test(description = "TC_006", alwaysRun = true, dependsOnMethods = "testVerifyCredentialValidation")
    public void testVerifySuccessfulLogin() {
        PageBase.waitFor(3);
        Login.enterLoginDetailsAndSubmit(PageConstants.VALID_EMAIL, PageConstants.VALID_PW);
        PageBase.waitFor(3);
        softAssert.assertTrue(Account.isMyAccountDisplayed(), "Dashboard label is not displayed");
        softAssert.assertTrue(Account.isUsernameDisplayed(), "Username label is not displayed");
        softAssert.assertEquals(Account.getUserNameText(), PageConstants.USER_NAME, "Username not equal");
        softAssert.assertAll();
    }

    @Test(description = "TC_007", alwaysRun = true, dependsOnMethods = "testVerifySuccessfulLogin")
    public void testVerifyMyAccountUser() {
        softAssert.assertTrue(Account.isUsernameDisplayed(), "Username label is not displayed");
        softAssert.assertEquals(Account.getUserNameText(), PageConstants.USER_NAME);
        softAssert.assertAll();
    }

    @Test(description = "TC_008", alwaysRun = true, dependsOnMethods = "testVerifyMyAccountUser")
    public void testRemoveCartItems() {
        Cart.emptyCartItems();
        softAssert.assertEquals(Cart.verifyCartItemCount(), 0);
        softAssert.assertAll();
    }

    @Test(description = "TC_009", alwaysRun = true, dependsOnMethods = "testRemoveCartItems")
    public void testAddItemToCart() {
        Home.mouseHoverProductsLink();
        Home.selectCategoryFromList();
        softAssert.assertTrue(Product.isProductExclusiveDisplayed(), "Product exclusive range header is not displayed");
        Product.clickProductItemAndNavigateToCart();
        softAssert.assertEquals(Cart.verifyCartItemCount(), 1);
        softAssert.assertAll();
    }

    @Test(description = "TC_010", alwaysRun = true, dependsOnMethods = "testAddItemToCart")
    public void testVerifyItemFromCart() {
        Cart.clickCartIcon();
        softAssert.assertTrue(Cart.isCartDropDownDisplayed(), "Cart drop down is not displayed");
        softAssert.assertTrue(Cart.verifyCartItemName(), "Item Name mismatch");
        softAssert.assertTrue(Cart.verifyCartItemPrice(), "Item Price mismatch");
        Cart.proceedToCart();
        softAssert.assertAll();
    }

    @Test(description = "TC_011", alwaysRun = true, dependsOnMethods = "testVerifyItemFromCart")
    public void testVerifyUserDetailsInCheckout() {
        Cart.proceedToCheckoutFromCart();
        softAssert.assertTrue(Checkout.verifyName(PageConstants.STRING_FIRST_NAME), "First name is not displayed in textbox");
        softAssert.assertTrue(Checkout.verifyName(PageConstants.STRING_LAST_NAME), "Last name is not displayed in textbox");
        softAssert.assertAll();
    }

    @Test(description = "TC_012", alwaysRun = true, dependsOnMethods = "testVerifyUserDetailsInCheckout")
    public void testVerifyShippingMandatoryFields() {
        Checkout.clearMandatoryFields();
        Checkout.clickButtonContinue();
        softAssert.assertEquals(Checkout.getFirstNameErrorMessage(), Messages.REQUIRED_ERROR_MESSAGE, "Required error message is not displayed");
        softAssert.assertEquals(Checkout.getLastNameErrorMessage(), Messages.REQUIRED_ERROR_MESSAGE, "Required error message is not displayed");
        softAssert.assertEquals(Checkout.getAddressErrorMessage(), Messages.REQUIRED_ERROR_MESSAGE, "Required error message is not displayed");
        softAssert.assertEquals(Checkout.getContactNumberErrorMessage(), Messages.REQUIRED_ERROR_MESSAGE, "Required error message is not displayed");
        softAssert.assertEquals(Checkout.getPostcodeErrorMessage(), Messages.REQUIRED_ERROR_MESSAGE, "Required error message is not displayed");
        softAssert.assertAll();
    }
}