package org.example.stratergies;

import lombok.NonNull;
import org.example.model.Split;

import java.util.List;
import java.util.Optional;

public class DefaultSplitValidationStrategy implements SplitValidationStrategy {

    @Override
    public Boolean validate(@NonNull Double amount, @NonNull List<Split> splits) {

        Optional<Double> sum = splits.stream()
                .map(Split::getAmount)
                .reduce(Double::sum);

        return sum.map(aDouble -> aDouble.equals(amount)).orElse(false);

    }
}
