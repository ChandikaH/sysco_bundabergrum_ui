package com.sysco.qe.bundabergrum.functions;

import com.sysco.qe.bundabergrum.panels.CartPanel;
import com.sysco.qe.bundabergrum.utils.PageBase;
import org.apache.log4j.Logger;

/**
 * Cart.java - class to verify Cart functions
 *
 * @author chandikab
 * @since 08/05/2018.
 */
public class Cart {

    private static final Logger LOGGER = Logger.getLogger(Cart.class);
    public static CartPanel myCartPanel = new CartPanel();

    public static int verifyCartItemCount() {
        return myCartPanel.getCartItemCount();
    }

    public static void emptyCartItems() {
        myCartPanel.removeCartItems();
    }

    public static void clickCartIcon() {
        myCartPanel.clickCart();
        LOGGER.info("Cart icon clicked");
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
        LOGGER.info("Clicked Button Proceed To Checkout");
        PageBase.waitFor(2);
    }

    public static void proceedToCart() {
        PageBase.waitFor(5);
        myCartPanel.clickButtonCartCheckout();
        LOGGER.info("Clicked Button Cart Checkout");
    }


}
