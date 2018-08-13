package com.sysco.qe.bundabergrum.panels;

import com.sysco.qe.bundabergrum.pages.PDPPage;
import com.sysco.qe.bundabergrum.utils.PageBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * CartPanel.java - class to verify Cart page methods
 *
 * @author chandikab
 * @since 08/05/2018.
 */
public class CartPanel extends PageBase {
    public static PDPPage productPage = new PDPPage();
    private static final Logger LOGGER = Logger.getLogger(CartPanel.class);

    private By spnCartHeader = By.id("cartHeader");
    private By lnkRemoveItem = By.xpath("//a[@class='btn-remove']");
    private By lblItemCount = By.xpath("(//span[@class='orange'])[2]");
    private By divCartDropDown = By.id("topCartContent");
    private By lnkCartItemName = By.xpath("//p[@class='product-name']/a");
    private By lnkCartItemNPrice = By.xpath("//p[@class='subtotal']/span[@class='price']");
    private By btnCheckoutFromCart = By.xpath("//div[@class='mini-cart-btm']//button");
    private By btnProceedToCheckout = By.xpath("//button[@title='Proceed to Checkout']");


    public boolean isCartIconDisplayed() {
        return syscoLabUI.isDisplayed(spnCartHeader);
    }

    public boolean isCartDropDownDisplayed() {
        return syscoLabUI.isDisplayed(spnCartHeader);
    }

    public int getCartItemCount() {
        return Integer.parseInt(syscoLabUI.getText(lblItemCount));
    }

    public void clickCart() {
        syscoLabUI.click(spnCartHeader);
        PageBase.waitFor(2);
    }

    public void removeCartItems() {
        if (getCartItemCount() != 0) {
            while (getCartItemCount() != 0) {
                clickCart();
                PageBase.waitFor(1);
                syscoLabUI.click(lnkRemoveItem);
                if (syscoLabUI.isAlertDisplayed()) {
                    syscoLabUI.clickOkInWindowsAlert();
                }
                PageBase.waitFor(3);
            }
            LOGGER.info("Cart Items removed");
        } else {
            LOGGER.info("Cart is already empty");
        }
    }

    public boolean verifyCartItemName() {
        return syscoLabUI.getText(lnkCartItemName).contains(productPage.getProductName());
    }

    public boolean verifyCartItemPrice() {
        return syscoLabUI.getText(lnkCartItemNPrice).equals(productPage.getProductPrice());
    }

    public void clickButtonCartCheckout() {
        if (!syscoLabUI.isDisplayed(btnCheckoutFromCart)) {
            clickCart();
            PageBase.waitFor(2);
        }
        syscoLabUI.click(btnCheckoutFromCart);
    }

    public void clickButtonProceedToCheckout() {
        syscoLabUI.click(btnProceedToCheckout);
    }


}
