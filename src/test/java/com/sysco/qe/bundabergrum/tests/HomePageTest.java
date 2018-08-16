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
        softAssert.assertAll();
    }

    @Test(description = "TC_007", alwaysRun = true, dependsOnMethods = "testVerifySuccessfulLogin")
    public void testVerifyMyAccountUser() {
        Account.isMyAccountDisplayed();
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
        softAssert.assertTrue(Cart.isCartIconDisplayed(), "Cart icon not displayed");
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
        Checkout.clickButtonContinueToDelivery();
        softAssert.assertEquals(Checkout.getFirstNameErrorMessage(), Messages.REQUIRED_ERROR_MESSAGE, "Required error message is not displayed");
        softAssert.assertEquals(Checkout.getLastNameErrorMessage(), Messages.REQUIRED_ERROR_MESSAGE, "Required error message is not displayed");
        softAssert.assertEquals(Checkout.getAddressErrorMessage(), Messages.REQUIRED_ERROR_MESSAGE, "Required error message is not displayed");
        softAssert.assertEquals(Checkout.getContactNumberErrorMessage(), Messages.REQUIRED_ERROR_MESSAGE, "Required error message is not displayed");
        softAssert.assertEquals(Checkout.getPostcodeErrorMessage(), Messages.REQUIRED_ERROR_MESSAGE, "Required error message is not displayed");
        softAssert.assertAll();
    }

    @Test(description = "TC_013", alwaysRun = true, dependsOnMethods = "testVerifyShippingMandatoryFields")
    public void testEnterUserInformation() {
        Checkout.enterUserInformation();
        softAssert.assertTrue(Checkout.isFirstNameDisplayed(), "First name text is not displayed");
        softAssert.assertTrue(Checkout.isLastNameDisplayed(), "Last name text is not displayed");
        softAssert.assertAll();
    }

    @Test(description = "TC_014", alwaysRun = true, dependsOnMethods = "testEnterUserInformation")
    public void testEnterPostalCode() {
        Checkout.enterPostalCode();
        softAssert.assertTrue(Checkout.isPostalCodeDisplayed(), "Postal code is not displayed");
        softAssert.assertAll();
    }

    @Test(description = "TC_015", alwaysRun = true, dependsOnMethods = "testEnterPostalCode")
    public void testNavigateToDeliveryOptionsPage() {
        Checkout.clickButtonContinueToDelivery();
        softAssert.assertTrue(Checkout.isDeliveryWarningDisplayed(), "Delivery warning not displayed");
        softAssert.assertAll();
    }

    @Test(description = "TC_016", alwaysRun = true, dependsOnMethods = "testNavigateToDeliveryOptionsPage")
    public void testValidateDeliveryOptions() {
        Checkout.checkAuthorizeShippingCheckbox();
        softAssert.assertEquals(Checkout.getDeliveryWarningErrorMessage(), Messages.REQUIRED_ERROR_MESSAGE, "Delivery warning error not displayed");
        softAssert.assertTrue(Checkout.isInstructionsTextAreaDisplayed(), "Special Instructions text area not displayed");
        softAssert.assertAll();
    }

    @Test(description = "TC_017", alwaysRun = true, dependsOnMethods = "testValidateDeliveryOptions")
    public void testNavigateToPaymentOptions() {
        Checkout.checkAuthorizeShippingCheckbox();
        Checkout.clickContinueToPaymentSection();
        softAssert.assertTrue(Checkout.isLabelSelectPaymentMethodDisplayed(), "Payment method label not displayed");
        softAssert.assertAll();
    }

    @Test(description = "TC_018", alwaysRun = true, dependsOnMethods = "testNavigateToPaymentOptions")
    public void testSelectPaymentTypeCreditCard() {
        Checkout.selectCreditCardOption();
        softAssert.assertTrue(Checkout.isCreditCardTextboxDisplayed(), "Credit card number textbox not displayed");
        softAssert.assertAll();
    }

    @Test(description = "TC_019", alwaysRun = true, dependsOnMethods = "testSelectPaymentTypeCreditCard")
    public void testValidatePaymentRequiredFields() {
        Checkout.clickPurchaseOrderButton();
        softAssert.assertEquals(Checkout.getCreditCardTextboxErrorMessage(), Messages.REQUIRED_ERROR_MESSAGE, "Credit card textbox error message not displayed");
        softAssert.assertEquals(Checkout.getCreditCardCVVTextboxErrorMessage(), Messages.REQUIRED_ERROR_MESSAGE, "Credit card textbox error message not displayed");
        softAssert.assertAll();
    }

    @Test(description = "TC_020", alwaysRun = true, dependsOnMethods = "testValidatePaymentRequiredFields")
    public void testValidateIncorrectPaymentDetails() {
        Checkout.enterCreditCardDetails(PageConstants.INVALID_CARD_NO, PageConstants.INVALID_CVV_NO);
        Checkout.clickPurchaseOrderButton();
        PageBase.waitFor(3);
        softAssert.assertEquals(Checkout.getInvalidCreditCardErrorMessage(), Messages.INCORRECT_CC_NUMBER_MESSAGE, "Invalid credit card error message not displayed");
        softAssert.assertAll();
    }

}