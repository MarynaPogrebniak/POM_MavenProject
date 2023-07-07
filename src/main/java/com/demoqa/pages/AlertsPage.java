package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AlertsPage extends BasePage{

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "promtButton")
    WebElement promtButton;

    public AlertsPage sendMessageToAlert(String message) {

        clickWithJSExecutor(promtButton, 0, 300);
        if (message != null) {
            driver.switchTo().alert().sendKeys(message);
            driver.switchTo().alert().accept();
        }
        return this;

    }

    @FindBy(id = "alertButton")
    WebElement alertButton;

    public AlertsPage clickButtonToSeeAlert() {
        click(alertButton);
        driver.switchTo().alert().accept();
        return this;
    }

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;

    public AlertsPage clickButtonToSeeAlertAfterFiveSeconds() {
        click(timerAlertButton);
        pause(5000);
        driver.switchTo().alert().accept();
        return this;
    }

    @FindBy(id = "confirmButton")
    WebElement confirmButton;

    public AlertsPage clickButtonConfirmBoxWillAppear() {
        clickWithJSExecutor(confirmButton, 0, 300);
        driver.switchTo().alert().accept();
        return this;
    }

    @FindBy(id = "promptResult")
    WebElement promptResult;

    public AlertsPage assertMessage(String message) {
        Assert.assertTrue(promptResult.getText().contains(message));
        return this;
    }

    @FindBy(id = "confirmResult")
    WebElement confirmResult;

    public AlertsPage assertMessageConfirmResult(String message) {
        Assert.assertTrue(confirmResult.getText().contains(message));
        return this;
    }

    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement submitMessage;

    public AlertsPage submitMessageConfirmResult(String message) {
        Assert.assertTrue(submitMessage.getText().contains(message));
        return this;
    }
}
