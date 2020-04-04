package com.postman.slotbookingsystem.model;

import java.util.HashMap;
import java.util.Map;

public class InterControllerMap {
    private static Map<String, String> url2UrlMapping;

    private static Map<String, Object> url2ObjectMapping;

    public static Map<String, String> getUrl2UrlMapping() {
        if (InterControllerMap.url2UrlMapping == null)
            InterControllerMap.url2UrlMapping = new HashMap<>();
        return url2UrlMapping;
    }

    public static Map<String, Object> getUrl2ObjectMapping() {
        if (InterControllerMap.url2ObjectMapping == null)
            InterControllerMap.url2ObjectMapping = new HashMap<>();
        return url2ObjectMapping;
    }
}
