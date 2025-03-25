package org.example.model;

import lombok.NonNull;

import java.util.List;

public class Expense {

    private final String id;
    private final String paidByUserID;
    private final List<Split> splits;
    private ExpenseMetadata expenseMetadata;
    private final Double amount;
    private final SplitType splitType;

    public Expense(@NonNull final String id,
                   @NonNull final String paidByUserID,
                   @NonNull final List<Split> splits,
                   @NonNull  final Double amount,
                   @NonNull final SplitType splitType) {

        this.id = id;
        this.paidByUserID = paidByUserID;
        this.splits = splits;
        this.amount = amount;
        this.splitType = splitType;
    }
}
