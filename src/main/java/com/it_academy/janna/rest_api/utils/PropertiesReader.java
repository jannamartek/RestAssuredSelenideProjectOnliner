package com.it_academy.janna.rest_api.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class PropertiesReader {
    private static final Logger LOG = LoggerFactory.getLogger(PropertiesReader.class);
    private static final String CONFIGURATION_PROPERTIES = "src/main/resources/config.properties";
    private static final String ENDPOINTS_PROPERTIES = "src/main/resources/endpoints.properties";

    public static URL getConfigURL(String url) {
        try {
            return new URL(getConfigProperty(url));
        } catch (MalformedURLException ex) {
            LOG.info("Wrong URL");
            return null;
        }
    }

    public static String getConfigProperty(String property) {
        return getStringFromPropertiesFile(CONFIGURATION_PROPERTIES, property);
    }

    public static String getEndpoint(String property) {
        return getStringFromPropertiesFile(ENDPOINTS_PROPERTIES, property);
    }

    private static String getStringFromPropertiesFile(String path, String property) {
        try (InputStream input = new FileInputStream(path)) {
            Properties appProps = new Properties();
            appProps.load(input);
            return appProps.getProperty(property);
        } catch (IOException ex) {
            LOG.info("File properties not found");
            return null;
        }
    }
}

