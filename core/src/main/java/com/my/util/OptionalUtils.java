package com.my.util;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class OptionalUtils {

    public static <T> T throwIfNull(T value, String name) {
        return Optional.ofNullable(value)
                .orElseThrow(() -> new IllegalArgumentException(name + " must not be null."));
    }

    public static <T extends Collection> T throwIfEmpty(T list, String name) {
        return Optional.ofNullable(list)
                .filter(Predicate.not(Collection::isEmpty))
                .orElseThrow(() -> new IllegalArgumentException(name + " must not be empty."));
    }
}
