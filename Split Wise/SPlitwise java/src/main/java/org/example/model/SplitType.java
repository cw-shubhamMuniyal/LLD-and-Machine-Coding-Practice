package org.example.model;

import lombok.NonNull;
import org.example.exceptions.InvalidSplitTypeException;

public enum SplitType {

    EQUAL,
    EXACT,
    PERCENT,
    SHARE;

    public static SplitType fromName(@NonNull final String name) {

        for (SplitType splitType : SplitType.values()) {
            if (splitType.name().equals(name)) {
                return splitType;
            }
        }

        throw new InvalidSplitTypeException();
    }
}
