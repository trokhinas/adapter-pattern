package com.patterns.adapter.utils;

import java.util.HashMap;
import java.util.Map;

public final class CountryUtils {
    private static Map<String, String> countries = new HashMap<String, String>();
    private static final String UNKNOWN_COUNTRY = "Unknown country code";

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    private CountryUtils() { }

    public static String getCountryByCode(String countryCode) {
        return countries.getOrDefault(countryCode, UNKNOWN_COUNTRY);
    }
}
