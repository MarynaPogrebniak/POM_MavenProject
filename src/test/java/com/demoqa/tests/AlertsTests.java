package com.demoqa.tests;

import com.demoqa.pages.AlertsPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getAlertsFrameWindows();
        new SidePanel(driver).selectAlerts();
    }

    @Test
    public void sentMessageToAlertTest() {
        new AlertsPage(driver).sendMessageToAlert("Hello world!")
                .assertMessage("Hello world!");
    }

    @Test
    public void clickButtonToSeeAlertTest() {
        new AlertsPage(driver).clickButtonToSeeAlert();
    }

    @Test
    public void clickButtonToSeeAlertAfterFiveSeconds() {
        new AlertsPage(driver).clickButtonToSeeAlertAfterFiveSeconds();
    }

    @Test
    public void clickButtonConfirmBoxWillAppear() {
        new AlertsPage(driver).clickButtonConfirmBoxWillAppear()
                .assertMessageConfirmResult("Ok");
    }


}
