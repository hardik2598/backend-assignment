package com.postman.slotbookingsystem.service;

import com.postman.slotbookingsystem.model.User;

import java.util.HashMap;
import java.util.Map;

public class InterControllerMap {
    private static User activeUser;

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

    public static User getActiveUser() {
        return activeUser;
    }

    public static void setActiveUser(User activeUser) {
        InterControllerMap.activeUser = activeUser;
    }
}
