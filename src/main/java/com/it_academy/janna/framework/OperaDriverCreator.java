package com.it_academy.janna.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OperaDriverCreator implements WebDriverCreator {
    private static final Logger LOG = LoggerFactory.getLogger(OperaDriverCreator.class);

    @Override
    public WebDriver createDriver() {
        ThreadLocal<WebDriver> driver = new ThreadLocal<>();
        WebDriverManager.operadriver().setup();
        driver.set(new OperaDriver());
        LOG.info("ChromeDriver was started");
        return driver.get();
    }
}