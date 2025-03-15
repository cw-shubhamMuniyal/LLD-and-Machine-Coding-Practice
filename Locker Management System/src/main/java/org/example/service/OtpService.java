package org.example.service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.example.model.Slot;
import org.example.repository.SlotOtpRepository;
import org.example.strategies.OtpGeneratorStrategy;

import java.util.Objects;

@AllArgsConstructor
public class OtpService {

    private final OtpGeneratorStrategy otpGeneratorStrategy;
    private final SlotOtpRepository slotOtpRepository;

    public String saveSlotOtpMapping(@NonNull final Slot slot) {

        String otpCode = otpGeneratorStrategy.generateOtp(4);
        slotOtpRepository.addOtpInSlot(slot, otpCode);
        return otpCode;
    }

    public boolean validateOtp(@NonNull final Slot slot,
                               @NonNull final String otpCode) {

        String otp = slotOtpRepository.getOtp(slot);
        return Objects.nonNull(otp) && otpCode.equals(otp);
    }


}
