package com.it_academy.janna;

import com.it_academy.janna.page_object.OnlinerCatalogPage;
import com.it_academy.janna.page_object.OnlinerHomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OnlinerCatalogPageTest {
    private static final List<String> EXPECTED_SECTION = Arrays.asList
            ("Электроника", "Компьютеры и сети", "Бытовая техника",
                    "Стройка и ремонт", "Дом и сад", "Авто и мото",
                    "Красота и спорт", "Детям и мамам", "Работа и офис", "Еда");

    @BeforeClass
    public void navigateToOnlinerClickOnCatalogLink() {
        OnlinerHomePage.navigateToOnlinerHomePage()
                .clickOnCatalogLink("Каталог");
    }

    @Test
    public void testCheckInCatalogSections() {
        assertThat(new OnlinerCatalogPage().getCatalogLinks())
                .as("Page sections don't contain section list")
                .containsAll(EXPECTED_SECTION);
    }
}