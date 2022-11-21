package com.it_academy.janna.rest_api;

import com.it_academy.janna.rest_api.service.OnlinerSushiService;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OnlinerSushiServiceTest {
    private final OnlinerSushiService productsService = new OnlinerSushiService();

    @Test
    public void testProductNamesAreNotEmpty() {
        assertThat(productsService.getProducts())
                .as("Object without a name")
                .noneMatch(element -> element.getName().isEmpty());
    }

    @Test
    public void testProductNamesOfTypeRollsContainsPrefixRolls() {
        assertThat(productsService.getNamePrefixes())
                .as("Name_prefix does not contain the text 'Rolls' ")
                .allMatch(element -> element.contains("Роллы"));
    }
}

