package com.sysco.qe.bundabergrum.panels;

import com.sysco.qe.bundabergrum.utils.PageBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;


public class CartPanel extends PageBase {
    private static final Logger LOGGER = Logger.getLogger(CartPanel.class);


    private By spnCartHeader = By.id("cartHeader");
    private By lnkRemoveItem = By.xpath("//a[@class='btn-remove']");
    private By lblItemCount = By.xpath("(//span[@class='orange'])[2]");

    public boolean isCartIconDisplayed() {
        return syscoLabUI.isDisplayed(spnCartHeader);
    }

    public int getCartItemCount() {
        return Integer.parseInt(syscoLabUI.getText(lblItemCount));
    }

    public void clickCart() {
        syscoLabUI.click(spnCartHeader);
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


}
