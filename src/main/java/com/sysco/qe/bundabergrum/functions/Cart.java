package com.sysco.qe.bundabergrum.functions;

import com.sysco.qe.bundabergrum.pages.MyAccountPage;
import com.sysco.qe.bundabergrum.panels.CartPanel;

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


}
