package com.it_academy.janna.page_object;

import com.codeborne.selenide.ElementsCollection;
import com.it_academy.janna.framework.AbstractBasePage;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$x;

public class OnlinerComponentPage extends AbstractBasePage {
    private final ElementsCollection productsNamesLink =
            $$x("//*[@class='catalog-navigation-list__aside-title' and contains(text(), 'Комплектующие')" +
                    "and not (contains(text(), 'Комплектующие для'))]//following-sibling::div" +
                    "[@class='catalog-navigation-list__dropdown']//span" +
                    "//*[contains(@class, 'catalog-navigation-list__dropdown-title')]");
    private final ElementsCollection productsDescriptionLink =
            $$x("//*[@class='catalog-navigation-list__aside-title' and contains(text(), 'Комплектующие') " +
                    "and not (contains(text(), 'Комплектующие для'))]//following-sibling::div//span" +
                    "//*[@class='catalog-navigation-list__dropdown-description']");

    public List<String> getProductsNames() {
        return productsNamesLink.shouldHave(sizeGreaterThan(0)).texts();
    }

    public List<String> getProductsDescription() {
        return productsDescriptionLink.shouldHave(sizeGreaterThan(0)).texts();
    }
}