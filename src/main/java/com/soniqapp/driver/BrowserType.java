package com.soniqapp.driver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public enum BrowserType {


    ANDROID("Android") {
        @Override
        public WebDriver createDriver() {

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "android");

            try {

                driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
            } catch (Exception e) {
                System.out.println("Driver error!");
                System.out.println(e.getMessage());
            }

            return driver;
        }

    };

    // private final String deviceName;

    BrowserType(String deviceName) {
        // this.deviceName = deviceName;
    }


    static WebDriver driver;


    public abstract WebDriver createDriver();


}
