package com.patterns.adapter.utils;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

public final class PhoneNumberUtils {
    private static final String PHONE_NUMBER_FORMAT = "({0}){1}-{2}-{3}";

    private PhoneNumberUtils() { }

    public static String completeNumber(String numberPart, int requiredPhoneNumberLength) {
        if (numberPart == null)
            throw new IllegalStateException();

        int length = numberPart.length();
        int countOfZeros = requiredPhoneNumberLength - length;
        if (length == 0) {
            return numberPart;
        }
        return generateZeros(countOfZeros) + numberPart;
    }

    public static String formatNumber(String numberPart) {
        return MessageFormat.format(PHONE_NUMBER_FORMAT, separateIntoParts(numberPart).toArray());
    }

    private static List<String> separateIntoParts(String numberPart) {
        if (numberPart == null) {
            throw new IllegalStateException("argument is null");
        }
        if (numberPart.length() != 10) {
            numberPart = completeNumber(numberPart, 10);
        }

        String countryPart = numberPart.substring(0, 3);
        String threeNumberPart = numberPart.substring(3, 6);
        String twoNumberFirstPart = numberPart.substring(6, 8);
        String twoNumberSecondPart = numberPart.substring(8, 10);

        return Arrays.asList(countryPart, threeNumberPart, twoNumberFirstPart, twoNumberSecondPart);
    }

    private static String generateZeros(int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append("0");
        }

        return builder.toString();
    }
}
