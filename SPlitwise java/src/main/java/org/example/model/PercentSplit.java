package org.example.model;

import lombok.NonNull;

public class PercentSplit extends Split{

    private final Double percentage;

    public PercentSplit(@NonNull final User user, Double amount, @NonNull final Double percentage) {
        super(user, amount);
        this.percentage = percentage;
    }
}
