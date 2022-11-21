package com.it_academy.janna.framework;

import org.openqa.selenium.WebDriver;

public abstract class AbstractBasePage {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
}