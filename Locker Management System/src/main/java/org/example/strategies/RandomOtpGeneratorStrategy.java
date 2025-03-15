package org.example.strategies;

import lombok.NonNull;
import org.example.utils.RandomNumberGenerator;

public class RandomOtpGeneratorStrategy implements OtpGeneratorStrategy {

    @Override
    public String generateOtp(@NonNull final Integer length) {

        StringBuilder otpCode = new StringBuilder();
        for (int i=0;i<length;i++) {
            Integer number = RandomNumberGenerator.getRandomNumber(10);
            otpCode.append(number);
        }

        return otpCode.toString();
    }
}
