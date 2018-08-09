package com.sysco.qe.bundabergrum.functions;

import com.sysco.qe.bundabergrum.panels.CartPanel;
import com.sysco.qe.bundabergrum.utils.PageBase;

/**
 * Cart.java - class to verify Cart functions
 *
 * @author chandikab
 * @since 08/05/2018.
 */
public class Cart {

    public static CartPanel myCartPanel = new CartPanel();

    public static int verifyCartItemCount() {
        return myCartPanel.getCartItemCount();
    }

    public static void emptyCartItems() {
        myCartPanel.removeCartItems();
    }

    public static void clickCartIcon() {
        myCartPanel.clickCart();
    }

    public static boolean isCartDropDownDisplayed() {
        return myCartPanel.isCartDropDownDisplayed();
    }

    public static boolean verifyCartItemName() {
        return myCartPanel.verifyCartItemName();
    }

    public static boolean verifyCartItemPrice() {
        return myCartPanel.verifyCartItemPrice();
    }

    public static void proceedToCheckoutFromCart() {
        myCartPanel.clickButtonProceedToCheckout();
        PageBase.waitFor(2);
    }

    public static void proceedToCart() {
        PageBase.waitFor(5);
        myCartPanel.clickButtonCartCheckout();
    }


}
