package com.sysco.qe.bundabergrum.pages;

import com.sysco.qe.bundabergrum.utils.PageBase;
import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;

/**
 * MyAccountPage.java - class to verify MyAccount methods
 *
 * @author chandikab
 * @since 08/05/2018.
 */
public class MyAccountPage extends PageBase {
    private By lblUserName = By.xpath("//div[@class='welcome-msg']/h2");
    private By lblDashboard = By.xpath("//strong[contains(text(),'Dashboard')]");

    public boolean isUsernameDisplayed() {
        return syscoLabUI.isDisplayed(lblUserName);
    }

    public boolean isMyAccountDisplayed() {
        return syscoLabUI.isDisplayed(lblDashboard);
    }

    public String getUserName() {
        String txtUserName = syscoLabUI.getText(lblUserName);
        String[] arrOfStr = txtUserName.split(", ", 2);
        String userName = arrOfStr[1].replace("!", "");
        return userName;
    }
}
