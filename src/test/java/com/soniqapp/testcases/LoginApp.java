package com.soniqapp.testcases;

import com.soniqapp.common.BaseTest;
import com.soniqapp.driver.DriverManager;
import com.soniqapp.utils.Utils;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginApp extends BaseTest {
    private AndroidDriver delegate = null;

    private final String SAUCELABAPP_ACTIVITY = "com.soniq.fs.MainActivity";
    private final String SAUCELABAPP_PACKAGE = "com.soniq.fs.staging";

    @Test
    public void testTC01() throws IOException {
        delegate = (AndroidDriver) DriverManager.getDriver();

        delegate.startActivity(new Activity(SAUCELABAPP_PACKAGE, SAUCELABAPP_ACTIVITY));
        Utils.hardWait(5000);

        AndroidElement usernameBox = (AndroidElement) delegate.findElementByXPath("//android.widget.EditText[@content-desc=\"Telephone input\"]");
        usernameBox.click();
        Utils.hardWait(5000);
        usernameBox.clear();
        Utils.hardWait(5000);
        usernameBox.sendKeys("+84357460419");

        AndroidElement passwordBox = (AndroidElement) delegate.findElementByXPath("//android.widget.EditText[@content-desc=\"passwordField\"]");
        passwordBox.clear();
        passwordBox.sendKeys("Maihuyen69@");

        AndroidElement loginBtn = (AndroidElement) delegate.findElementByXPath("//android.widget.TextView[@text=\"Log in\"]");
        loginBtn.click();
        Utils.hardWait();

    }
}
