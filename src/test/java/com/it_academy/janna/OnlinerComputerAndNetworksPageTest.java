package com.it_academy.janna;

import com.it_academy.janna.page_object.OnlinerComputerAndNetworksPage;
import com.it_academy.janna.page_object.OnlinerHomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OnlinerComputerAndNetworksPageTest {
    private static final List<String> EXPECTED_SECTIONS_IN_COMPUTER_AND_NETWORKS = Arrays.asList
            ("Ноутбуки, компьютеры, мониторы",
            "Комплектующие", "Хранение данных", "Сетевое оборудование");
    private static OnlinerComputerAndNetworksPage computersAndNetworksPage;

    @BeforeClass
    public static void navigateToOnlinerFindComputersAndNetworksTabAndClick() {
        OnlinerHomePage.navigateToOnlinerHomePage()
                .clickOnCatalogLink("Каталог")
                .clickOnCatalogSectionLink("Компьютеры");
        computersAndNetworksPage = new OnlinerComputerAndNetworksPage()
                .clickOnCatalogClassifierLink();
    }

    @Test
    public void testSectionComputerAndNetworkList() {
        assertThat(computersAndNetworksPage.getComputersAndNetworksLinks())
                .as("Page sections don't contain section list")
                .containsAll(EXPECTED_SECTIONS_IN_COMPUTER_AND_NETWORKS);
    }
}
