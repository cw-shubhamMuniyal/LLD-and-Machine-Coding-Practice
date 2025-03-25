package org.example.stratergies;

import lombok.NonNull;
import org.example.model.Split;

import java.util.List;

public class EqualSplitValidationStrategy implements SplitValidationStrategy {

    @Override
    public Boolean validate(@NonNull final Double amount, @NonNull List<Split> splits) {

        Double dividedAmount = amount / splits.size();

        for (Split split : splits) {
            if (!split.getAmount().equals(dividedAmount)) {
                return false;
            }
        }
        return true;
    }
}
