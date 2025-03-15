package org.example.repository;

import lombok.NonNull;
import org.example.model.Slot;

import java.util.HashMap;
import java.util.Map;

public class SlotOtpRepositoryInMemory implements SlotOtpRepository {

    Map<Slot, String> slotOtpMapping;

    public SlotOtpRepositoryInMemory() {
        slotOtpMapping = new HashMap<>();
    }

    @Override
    public void addOtpInSlot(@NonNull Slot slot, @NonNull String otpCode) {
        this.slotOtpMapping.put(slot, otpCode);
    }

    @Override
    public String getOtp(@NonNull Slot slot) {
        return slotOtpMapping.get(slot);
    }
}
