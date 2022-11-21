package com.it_academy.janna.rest_api.utils;

import io.restassured.response.ResponseBody;

import java.util.List;

public class ResponseBodyUtils {
    private ResponseBodyUtils() {
    }

    public static <T> List<T> getObjectsByJsonPath(ResponseBody responseBody, String jsonPath, Class<T> genericType) {
        return responseBody
                .jsonPath()
                .getList(jsonPath, genericType);
    }

    public static List<String> getListStringByJsonPath(ResponseBody responseBody, String jsonPath) {
        return responseBody
                .jsonPath()
                .getList(jsonPath);
    }

}


