package com.sysco.qe.bundabergrum.functions;

import com.sysco.qe.bundabergrum.pages.HomePage.AgeGatePage;
import com.sysco.qe.bundabergrum.pages.PDPPage;
import com.sysco.qe.bundabergrum.utils.PageBase;
import org.apache.log4j.Logger;

/**
 * Product.java - class to verify Product functions
 *
 * @author chandikab
 * @since 08/05/2018.
 */
public class Product {
    private static final Logger LOGGER = Logger.getLogger(Product.class);
    public static PDPPage productPage = new PDPPage();

    public static boolean isProductExclusiveDisplayed() {
        return productPage.isExclusiveRangeHeaderDisplayed();
    }

    public static void clickProductItemAndNavigateToCart() {
        productPage.clickProductItem();
        productPage.getProductName();
        productPage.getProductPrice();
        productPage.clickAddToCart();
        LOGGER.info("product added to cart");
        PageBase.waitFor(2);
    }

    public static void clickAddToCartButton() {
        productPage.clickAddToCart();
    }

    public static String getProductNameText() {
        LOGGER.info("product name is " + productPage.getProductName());
        return productPage.getProductName();
    }

    public static String getAgeErrorMessage() {
        LOGGER.info("product price is " + productPage.getProductPrice());
        return productPage.getProductPrice();
    }

}
