package org.example.strategies;

import lombok.NonNull;

public interface OtpGeneratorStrategy {
    String generateOtp(@NonNull final Integer length);
}
