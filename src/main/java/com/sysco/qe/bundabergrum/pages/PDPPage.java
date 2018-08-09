package com.sysco.qe.bundabergrum.pages;

import com.sysco.qe.bundabergrum.utils.PageBase;
import org.openqa.selenium.By;

/**
 * PDPPage.java - class to verify PDP functions
 *
 * @author chandikab
 * @since 08/05/2018.
 */

public class PDPPage extends PageBase {
    private By lblExclusiveRange = By.xpath("//h1[contains(text(),'Exclusive Range')]");
    private By liProductItem1 = By.xpath("//div[@class='category-products list']/ul/li[1]");
    private By spnProductPrice = By.xpath("//span[@id='product-price-1414']//span[@class='price']");
    private By divProductName = By.xpath("//div[@class='product-name']/h1");
    private By btnAddToCart = By.xpath("//button[@title='Add to Cart']");


    public boolean isExclusiveRangeHeaderDisplayed() {
        return syscoLabUI.isDisplayed(lblExclusiveRange);
    }

    public void clickProductItem() {
        syscoLabUI.click(liProductItem1);
    }

    public String getProductName() {
        return syscoLabUI.getText(divProductName);
    }

    public String getProductPrice() {
        return syscoLabUI.getText(spnProductPrice);
    }

    public void clickAddToCart() {
        syscoLabUI.click(btnAddToCart);
    }

}
