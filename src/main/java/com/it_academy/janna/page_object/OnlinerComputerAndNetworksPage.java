package com.it_academy.janna.page_object;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.it_academy.janna.framework.AbstractBasePage;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class OnlinerComputerAndNetworksPage extends AbstractBasePage {

    private static final String COMPUTERS_AND_NETWORKS_TAB_LINK_XPATH_PATTERN =
            "//*[@class='catalog-navigation-list__aside-title' and contains(text(), '%s') " +
                    "and not (contains(text(), 'Комплектующие для'))]";
    private static final String NOTEBOOKS_COMPUTERS_MONITORS_LINK =
            "//*[contains(@class, 'catalog-navigation-list__aside-title')" +
                    " and contains(text(), ' Ноутбуки, компьютеры, мониторы')]";
    private final ElementsCollection computersAndNetworksLinks =
            $$x("//*[@class = 'catalog-navigation-list__aside catalog-navigation-list__aside_active']" +
                    "/div[@class = 'catalog-navigation-list__aside-list']" +
                    "/div[contains(@class, 'catalog-navigation-list__aside-item')]" +
                    "/div[contains(@class, 'catalog-navigation-list__aside-title')]");

    public List<String> getComputersAndNetworksLinks() {
        return computersAndNetworksLinks.shouldHave(CollectionCondition.sizeGreaterThan(0)).texts();
    }

    public OnlinerComponentPage clickOnComputersAndNetworksLink(String linkContains) {
        $x(format(COMPUTERS_AND_NETWORKS_TAB_LINK_XPATH_PATTERN, linkContains))
                .shouldBe(Condition.visible, ofSeconds(20)).click();
        return new OnlinerComponentPage();
    }

    public OnlinerComputerAndNetworksPage clickOnCatalogClassifierLink() {
        $x(NOTEBOOKS_COMPUTERS_MONITORS_LINK).shouldBe(Condition.visible, ofSeconds(20)).click();
        return this;
    }
}
