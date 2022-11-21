package com.it_academy.janna.framework;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EdgeDriverCreator implements WebDriverCreator {
    private static final Logger LOG = LoggerFactory.getLogger(EdgeDriverCreator.class);

    @Override
    public WebDriver createDriver() {
        ThreadLocal<WebDriver> driver = new ThreadLocal<>();
        WebDriverManager.edgedriver().setup();
        driver.set(new EdgeDriver());
        LOG.info("ChromeDriver was started");
        return driver.get();
    }
}