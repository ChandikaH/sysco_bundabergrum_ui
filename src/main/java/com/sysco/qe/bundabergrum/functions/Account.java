package com.sysco.qe.bundabergrum.functions;

import com.sysco.qe.bundabergrum.pages.MyAccountPage;

/**
 * Account.java - class to verify Account functions
 *
 * @author chandikab
 * @since 08/05/2018.
 */
public class Account {

    public static MyAccountPage myAccountPage = new MyAccountPage();

    public static String getUserNameText() {
        return myAccountPage.getUserName();
    }

    public static boolean isUsernameDisplayed() {
        return myAccountPage.isUsernameDisplayed();
    }

    public static boolean isMyAccountDisplayed() {
        return myAccountPage.isMyAccountDisplayed();
    }


}
