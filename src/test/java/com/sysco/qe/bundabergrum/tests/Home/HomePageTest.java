package com.sysco.qe.bundabergrum.tests.Home;


import com.sysco.qe.bundabergrum.common.PageConstants;
import com.sysco.qe.bundabergrum.functions.*;
import com.sysco.qe.bundabergrum.messages.Messages;
import com.sysco.qe.bundabergrum.utils.DateUtils;
import com.sysco.qe.bundabergrum.utils.PageBase;
import com.sysco.qe.bundabergrum.utils.TestBase;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import org.testng.ITestContext;
import org.testng.annotations.*;

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
        softAssert.assertTrue(AgeGate.isAgeGateOverlayDisplayed(), "Should display age Gate Logo in the AgeGate Overlay");
        AgeGate.enterBirthdayDetailsAndConfirm(DateUtils.getPastDate(16));
        softAssert.assertTrue(AgeGate.isAgeErrorMessageDisplayed(), "Should display Age Error");
        softAssert.assertEquals(AgeGate.getAgeErrorMessage(), Messages.INCORRECT_AGE_MESSAGE);
        softAssert.assertAll();
    }

    @Test(description = "TC_002", alwaysRun = true, dependsOnMethods = "testVerifyAgeGateErrorMessage")
    public void testVerifyAgeGateConfirmation() {
        AgeGate.waitForAgeGatePageLoaded();
        softAssert.assertTrue(AgeGate.isAgeGateOverlayDisplayed(), "Should display age Gate Logo in the AgeGate Overlay");
        AgeGate.enterBirthdayDetailsAndConfirm(DateUtils.getPastDate(21));
        softAssert.assertFalse(AgeGate.isAgeErrorMessageDisplayed(), "Age Error should not be displayed");
        softAssert.assertTrue(Home.isHomePageDisplayed(), "Should display Home page logo");
        softAssert.assertAll();
    }

    @Test(description = "TC_003", alwaysRun = true, dependsOnMethods = "testVerifyAgeGateConfirmation")
    public void testNavigateToMyAccountPage() {
        softAssert.assertTrue(Home.isMyAccountLinkLoaded(), "Should display MyAccount link");
        Home.navigateToLoginPage();
        softAssert.assertTrue(Login.isLoginButtonDisplayed(), "Should display Login button");
        softAssert.assertAll();
    }

    @Test(description = "TC_004", alwaysRun = true, dependsOnMethods = "testNavigateToMyAccountPage")
    public void testVerifyLoginErrorValidation() {
        Login.enterLoginDetailsAndSubmit(PageConstants.INVALID_EMAIL, PageConstants.INVALID_PW);
        softAssert.assertTrue(Login.isLoginErrorMessageDisplayed(), "Login Error should be displayed");
        softAssert.assertEquals(Login.getLoginErrorMessage(), Messages.LOGIN_ERROR_MESSAGE);
        softAssert.assertAll();
    }

    @Test(description = "TC_005", alwaysRun = true, dependsOnMethods = "testVerifyLoginErrorValidation")
    public void testVerifyCredentialValidation() {
        Login.enterLoginDetailsAndSubmit(PageConstants.INVALID_FORMAT_EMAIL, PageConstants.INVALID_FORMAT_PW);
        softAssert.assertTrue(Login.isIncorrectEmailMessageDisplayed(), "Incorrect Email Error should be displayed");
        softAssert.assertEquals(Login.getIncorrectEmailMessageText(), Messages.INCORRECT_EMAIL_MESSAGE);
        softAssert.assertTrue(Login.isIncorrectPasswordMessageDisplayed(), "Incorrect Password Error should be displayed");
        softAssert.assertEquals(Login.getIncorrectPasswordMessageText(), Messages.INCORRECT_PW_MESSAGE);
        softAssert.assertAll();
    }

    @Test(description = "TC_006", alwaysRun = true, dependsOnMethods = "testVerifyCredentialValidation")
    public void testVerifySuccessfulLogin() {
        PageBase.waitFor(3);
        Login.enterLoginDetailsAndSubmit(PageConstants.VALID_EMAIL, PageConstants.VALID_PW);
        PageBase.waitFor(3);
        softAssert.assertTrue(Account.isMyAccountDisplayed(), "Dashboard label should be displayed");
        softAssert.assertTrue(Account.isUsernameDisplayed(), "Username label should be displayed");
        softAssert.assertEquals(Account.getUserNameText(), Messages.USER_NAME);
        softAssert.assertAll();
    }

    @Test(description = "TC_007", alwaysRun = true, dependsOnMethods = "testVerifySuccessfulLogin")
    public void testVerifyMyAccountUser() {
        softAssert.assertTrue(Account.isUsernameDisplayed(), "Username label should be displayed");
        softAssert.assertEquals(Account.getUserNameText(), Messages.USER_NAME);
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
        softAssert.assertEquals(Cart.verifyCartItemCount(), 0);
        softAssert.assertAll();
    }

}