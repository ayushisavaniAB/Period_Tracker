package com.videodownloader.period_tracker.utils;


import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.Optional;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public final class OptionalUtil {

    private OptionalUtil() { }

    public static Optional<Integer> parseInteger(String value) {
        return parseInteger(value, 10);
    }

    public static Optional<Integer> parseInteger(String value, int radix) {
        try {
            return Optional.fromNullable(Integer.parseInt(value, radix));
        } catch (NumberFormatException ex) {
            return Optional.absent();
        }
    }

    public static Optional<Date> parseDate(String value, DateFormat format) {
        try {
            return Optional.fromNullable(format.parse(value));
        } catch (ParseException ex) {
            return Optional.absent();
        }
    }
}
