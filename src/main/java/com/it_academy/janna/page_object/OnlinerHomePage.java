package com.it_academy.janna.page_object;

import com.codeborne.selenide.Condition;
import com.it_academy.janna.framework.AbstractBasePage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class OnlinerHomePage extends AbstractBasePage {

    public static final String ONLINER_LINK = "https://www.onliner.by/";
    private static final String ONLINER_CATALOG_PATTERN =
            "//*[@class='b-top-menu']//a[contains(@href,'catalog')]";

    public static OnlinerHomePage navigateToOnlinerHomePage() {
        OnlinerHomePage homePage = new OnlinerHomePage();
        try {
            open(ONLINER_LINK);
        } catch (NullPointerException e) {
            throw new RuntimeException("No URL found in properties file");
        }
        return homePage;
    }

    public OnlinerCatalogPage clickOnCatalogLink(String linkContains) {
        $x(format(ONLINER_CATALOG_PATTERN, linkContains))
                .shouldBe(Condition.visible, ofSeconds(20)).click();
        return new OnlinerCatalogPage();
    }
}
