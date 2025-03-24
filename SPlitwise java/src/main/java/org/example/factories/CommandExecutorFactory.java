package org.example.factories;

import lombok.NonNull;
import org.example.exceptions.InvalidInputException;
import org.example.model.Command;
import org.example.model.CommandType;
import org.example.service.*;
import org.example.stratergies.SplitValidationStrategy;

public class CommandExecutorFactory {

    private final ExpenseService expenseService;
    private UserService userService;
    private SplitValidationStrategy splitValidationStrategy;

    public CommandExecutorFactory(@NonNull final ExpenseService expenseService,
                                  @NonNull final UserService userService,
                                  @NonNull final SplitValidationStrategy splitValidationStrategy) {

        this.expenseService = expenseService;
        this.userService = userService;
        this.splitValidationStrategy = splitValidationStrategy;
    }

    public CommandExecutorFactory(@NonNull final ExpenseService expenseService) {

        this.expenseService = expenseService;
    }

    public CommandExecutor getCommandExecutor(@NonNull final Command command) {

        return switch (command.getCommandType()) {
            case CommandType.EXPENSE -> new CreateExpenseCommandExecutor(
                    expenseService,
                    userService,
                    splitValidationStrategy
            );
            case CommandType.SHOW -> new ShowExpenseCommandExecutor(
                    expenseService
            );
            default -> throw new InvalidInputException();
        };
    }
}
