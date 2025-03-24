package org.example.stratergies;

import lombok.NonNull;
import org.example.model.Split;

import java.util.List;

public interface SplitValidationStrategy {
    Boolean validate(@NonNull final Double amount, @NonNull final List<Split> splits);
}
