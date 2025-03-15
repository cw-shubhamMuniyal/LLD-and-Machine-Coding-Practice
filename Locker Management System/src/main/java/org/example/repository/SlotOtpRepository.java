package org.example.repository;

import lombok.NonNull;
import org.example.model.Slot;

public interface SlotOtpRepository {

    void addOtpInSlot(@NonNull final Slot slot, @NonNull final String otpCode);
    String getOtp(@NonNull final Slot slot);
}
