package org.example.utils;

import lombok.NonNull;

public class RandomNumberGenerator {

    public static Integer getRandomNumber(@NonNull final Integer lessThanThis) {
        return (int) (lessThanThis * Math.random());
    }
}
