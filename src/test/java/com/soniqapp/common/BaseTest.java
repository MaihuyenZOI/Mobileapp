package com.soniqapp.common;

import com.soniqapp.config.Constants;
import com.soniqapp.driver.DriverManager;
import com.soniqapp.driver.LaunchBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class BaseTest {


    @BeforeMethod
    @Parameters(value={"browser"})
    public static void preCondition(@Optional(Constants.BROWSER_TYPE) String browser) {
        WebDriver driver = LaunchBrowser.getDriver(browser);
        DriverManager.setDriver(driver);
    }

    @AfterMethod
    public void postCondition(){
        // Quit the Browser
        DriverManager.quit();
    }
}
