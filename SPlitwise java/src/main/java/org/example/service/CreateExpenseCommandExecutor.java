package org.example.service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.example.exceptions.AmountValidationFailedException;
import org.example.model.Split;
import org.example.model.SplitType;
import org.example.model.User;
import org.example.stratergies.SplitValidationStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class CreateExpenseCommandExecutor implements CommandExecutor {

    private final ExpenseService expenseService;
    private final UserService userService;
    private final SplitValidationStrategy splitValidationStrategy;

    @Override
    public void execute(@NonNull final List<String> params) {

        int index = 0;
        String paidByUserId = params.get(index++);
        Double totalAmount = Double.valueOf(params.get(index++));
        int numOfUsers = Integer.parseInt(params.get(index++));
        List<String> userIds = new ArrayList<>();
        List<Double> amountToPay = new ArrayList<>();

        for (int i = 0; i < numOfUsers; i++) {
            userIds.add(params.get(index++));
        }

        String splitType = params.get(index++);
        SplitType splitTypeEnum = SplitType.fromName(splitType);

        if (Objects.nonNull(params.get(index))) {
            for (int i = 0; i < numOfUsers; i++) {
                amountToPay.add(Double.valueOf(params.get(index++)));
            }
        }

        List<Split> splits = getSplits(userIds, totalAmount, amountToPay, splitTypeEnum);
        Boolean isValidationSuccess = splitValidationStrategy.validate(totalAmount, splits);

        if (!isValidationSuccess) {
            throw new AmountValidationFailedException();
        }

        expenseService.createExpense(
                paidByUserId,
                totalAmount,
                splitTypeEnum,
                splits);
    }

    private List<Split> getSplits(@NonNull final List<String> userIds,
                                  @NonNull final Double totalAmount,
                                  @NonNull final List<Double> amountToPay,
                                  @NonNull final SplitType splitType) {

        List<Split> splits = new ArrayList<>();

        switch (splitType) {
            case EQUAL -> {
                Double splitAmount = totalAmount / userIds.size();
                for (String userId : userIds) {
                    User user = userService.getUser(userId);
                    Split split = new Split(user, splitAmount);
                    splits.add(split);
                }
            }
            case PERCENT -> {
                for (int index = 0; index < userIds.size(); index++) {
                    User user = userService.getUser(userIds.get(index));
                    Double splitAmount = totalAmount * amountToPay.get(index) / 100.0;
                    Split split = new Split(user, splitAmount);
                    splits.add(split);
                }
            }
            case EXACT -> {
                for (int index = 0; index < userIds.size(); index++) {
                    User user = userService.getUser(userIds.get(index));
                    Double splitAmount = amountToPay.get(index);
                    Split split = new Split(user, splitAmount);
                    splits.add(split);
                }
            }
        }

        return splits;
    }
}
