package org.example.service;

import lombok.NonNull;
import org.example.model.Expense;
import org.example.model.Split;
import org.example.model.SplitType;

import java.util.*;

public class ExpenseService {

    private final List<Expense> expenses;

    //    Improvement: There should be a separate service to handle balance sheet of users.
    private final Map<String, Map<String, Double>> balanceSheets;

    public ExpenseService() {
        expenses = new ArrayList<>();
        balanceSheets = new HashMap<>();
    }

    public void createExpense(@NonNull final String paidByUserId,
                              @NonNull final Double amount,
                              @NonNull final SplitType splitType,
                              @NonNull final List<Split> splits) {

        String id = UUID.randomUUID().toString();
        Expense expense = new Expense(
                id,
                paidByUserId,
                splits,
                amount,
                splitType
        );
        expenses.add(expense);

        for (Split split : splits) {

            String payerUserId = split.getUser().getId();

//            Balance sheet updation for payee

            if (!balanceSheets.containsKey(paidByUserId)) {
                balanceSheets.put(paidByUserId, new HashMap<>());
            }
            Double amountToPay = balanceSheets.get(paidByUserId).getOrDefault(payerUserId, 0.0);
            balanceSheets.get(paidByUserId).put(payerUserId, amountToPay + split.getAmount());

//            Balance sheet updation for payer

            if (!balanceSheets.containsKey(payerUserId)) {
                balanceSheets.put(payerUserId, new HashMap<>());
            }
            amountToPay = balanceSheets.get(payerUserId).getOrDefault(paidByUserId, 0.0);
            balanceSheets.get(payerUserId).put(paidByUserId, amountToPay - split.getAmount());

        }
    }

    public void showBalanceForUser(@NonNull final String userId) {

        Map<String, Double> balanceSheet = balanceSheets.get(userId);
        if (Objects.isNull(balanceSheet)) {
            System.out.println("No Active balances for given user with id " + userId);
        }

        for (Map.Entry<String, Double> entry : balanceSheet.entrySet()) {
            if (entry.getValue() < 0.0) {
                System.out.println(userId + " needs to pay " + entry.getKey() + " amount " + entry.getValue());
            } else {
                System.out.println(entry.getKey() + " needs to pay " + userId + " amount " + entry.getValue());
            }
        }

    }

    public void showBalanceForAllUsers() {

        for (String userId : balanceSheets.keySet()) {

            showBalanceForUser(userId);
        }
    }
}
