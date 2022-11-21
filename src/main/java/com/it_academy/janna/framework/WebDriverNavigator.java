package com.it_academy.janna.framework;

import com.it_academy.janna.rest_api.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.Arrays;
import java.util.stream.Stream;


public enum WebDriverNavigator {
    CHROME("Chrome", new ChromeDriverCreator()),
    EDGE("MicrosoftEdge", new EdgeDriverCreator()),
    OPERA("Opera", new OperaDriverCreator());

    private static final Logger LOG = LoggerFactory.getLogger(WebDriverNavigator.class);
    private final String driverType;
    private final WebDriverCreator webDriver;

    WebDriverNavigator(String driverType, WebDriverCreator webDriver) {
        this.driverType = driverType;
        this.webDriver = webDriver;
    }

    public static void getWebDriverByType(String driverType, boolean remote) {
        WebDriverNavigator driverNavigator = null;
        driverNavigator = Arrays.stream(WebDriverNavigator.values())
                .flatMap(s -> Stream.ofNullable(s))
                .filter(type -> type.getDriverType().equals(driverType))
                .findAny()
                .orElseGet(() -> WebDriverNavigator.EDGE);
        if (!remote) {
            LOG.info("LocalWebDriver was created");
            AbstractBasePage.driver.set((WebDriver) driverNavigator.getWebDriver().createDriver());
            AbstractBasePage.driver.get().manage().window().maximize();
        } else {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(driverNavigator.getDriverType());
            capabilities.setCapability("os", PropertiesReader.getConfigProperty("os.type"));
            capabilities.setCapability("os_version", PropertiesReader.getConfigProperty("os.version"));
            URL gridURL = PropertiesReader.getConfigURL("grid.url");
            LOG.info("RemoteWebDriver was created");
            AbstractBasePage.driver.set(new RemoteWebDriver(gridURL, capabilities));
        }
    }

    public String getDriverType() {
        return driverType;
    }

    public WebDriverCreator getWebDriver() {
        return webDriver;
    }
}
/**
 * public static void getWebDriverByType() {
 * String driverType = System.getProperty("driverType");
 * if (System.getProperty("isRemote").equals("false")) {
 * WebDriverNavigator driverNavigator = null;
 * driverNavigator = Arrays.stream(WebDriverNavigator.values())
 * .flatMap(s -> Stream.ofNullable(s))
 * .filter(type -> type.getDriverType().equals(driverType))
 * .findAny()
 * .orElseThrow(() -> new RuntimeException("Driver not found."));
 * LOG.info("LocalWebDriver was created");
 * AbstractBasePage.driver.set((WebDriver) driverNavigator.getWebDriver().createDriver());
 * } else {
 * DesiredCapabilities capabilities = new DesiredCapabilities();
 * capabilities.setBrowserName(PropertiesReader.getConfigProperty("driverType"));
 * capabilities.setCapability("os", PropertiesReader.getConfigProperty("os.type"));
 * capabilities.setCapability("os_version", PropertiesReader.getConfigProperty("os.version"));
 * URL gridURL = PropertiesReader.getConfigURL("grid.url");
 * LOG.info("RemoteWebDriver was created");
 * AbstractBasePage.driver.set(new RemoteWebDriver(gridURL, capabilities));
 * }
 * }
 * }
 */