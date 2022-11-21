package com.it_academy.janna;

import com.it_academy.janna.page_object.OnlinerComponentPage;
import com.it_academy.janna.page_object.OnlinerComputerAndNetworksPage;
import com.it_academy.janna.page_object.OnlinerHomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OnlinerComponentPageTest {
    private static OnlinerComponentPage componentsPage;

    @BeforeClass
    public static void navigateToOnlinerFindAccessoriesTabAndClick() {
        OnlinerHomePage.navigateToOnlinerHomePage()
                .clickOnCatalogLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры");
        componentsPage = new OnlinerComputerAndNetworksPage()
                .clickOnComputersAndNetworksLink("Комплектующие");
    }

    @Test
    public void testAllElementsContainName() {
        assertThat(componentsPage.getProductsNames())
                .as("Not all products contain name")
                .allMatch(e -> !e.isEmpty());
    }

    @Test
    public void testAllElementsContainQuantity() {
        assertThat(componentsPage.getProductsDescription())
                .as("Not all products contain quantity")
                .allMatch(e -> e.contains("товар"));
    }

    @Test
    public void testAllElementsContainPrice() {
        assertThat(componentsPage.getProductsDescription())
                .as("Not all products contain price")
                .allMatch(e -> e.contains("р."));
    }
}
