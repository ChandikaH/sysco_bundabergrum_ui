package com.sysco.qe.bundabergrum.pages;

import com.sysco.qe.bundabergrum.utils.PageBase;
import org.openqa.selenium.By;


public class PDPPage extends PageBase {
    private By spnItemPrice = By.className("price");
    private By btnAddToCart = By.className("button btn-cart validation-passed");

    public boolean isUsernameDisplayed() {
        return syscoLabUI.isDisplayed(spnItemPrice);
    }

    public boolean isMyAccountDisplayed() {
        return syscoLabUI.isDisplayed(btnAddToCart);
    }
}
