package org.example.service;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ShowExpenseCommandExecutor implements CommandExecutor {

    private final ExpenseService expenseService;

    @Override
    public void execute(List<String> params) {

        if (params.size() == 1) {
            expenseService.showBalanceForUser(params.getFirst());
        }
        else {
            expenseService.showBalanceForAllUsers();
        }
    }
}
