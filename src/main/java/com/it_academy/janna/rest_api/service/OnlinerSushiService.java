package com.it_academy.janna.rest_api.service;

import com.it_academy.janna.rest_api.model.OnlinerSushiProduct;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.it_academy.janna.rest_api.utils.GetRequestUtils.makeRequestAndGetResponseBody;
import static com.it_academy.janna.rest_api.utils.PropertiesReader.getEndpoint;
import static com.it_academy.janna.rest_api.utils.ResponseBodyUtils.getListStringByJsonPath;
import static com.it_academy.janna.rest_api.utils.ResponseBodyUtils.getObjectsByJsonPath;

public class OnlinerSushiService {
    public List<OnlinerSushiProduct> getProducts() {
        return getObjectsByJsonPath(makeRequestAndGetResponseBody
                        (getEndpoint("catalog.sushi"), null, null),
                "products", OnlinerSushiProduct.class);
    }

    public List<String> getNamePrefixes() {
        Map<String, Object> params = new HashMap<>();
        params.put("sushi_typ[0]", "roll");
        params.put("sushi_typ[operation]", "union");
        return getListStringByJsonPath(makeRequestAndGetResponseBody
                        (getEndpoint("catalog.sushi"), null, params),
                "products.name_prefix");
    }
}

