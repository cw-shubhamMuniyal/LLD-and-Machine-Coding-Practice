package org.example;

import org.example.factories.CommandExecutorFactory;
import org.example.model.User;
import org.example.service.ExpenseService;
import org.example.service.InputReader;
import org.example.service.UserService;
import org.example.stratergies.DefaultSplitValidationStrategy;
import org.example.stratergies.EqualSplitValidationStrategy;
import org.example.stratergies.SplitValidationStrategy;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Learning Splitwise LLD and machine coding!");

        UserService userService = new UserService();
        User user1 = userService.addUser("Chandler");
        System.out.println("created new user: " + user1);

        User user2 = userService.addUser("Joey");
        System.out.println("created new user: " + user2);


        User user3 = userService.addUser("Ross");
        System.out.println("created new user: " + user3);


        User user4 = userService.addUser("Rachel");
        System.out.println("created new user: " + user4);

        User user5 = userService.addUser("Phoebe");
        System.out.println("created new user: " + user5);

        User user6 = userService.addUser("Monica");
        System.out.println("created new user: " + user5);

        ExpenseService expenseService = new ExpenseService();
        SplitValidationStrategy defaultSplitValidationStrategy = new DefaultSplitValidationStrategy();
        SplitValidationStrategy equalSplitValidationStrategy = new EqualSplitValidationStrategy();


        CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(
                expenseService,
                userService,
                defaultSplitValidationStrategy
        );

        InputReader inputReader = new InputReader(commandExecutorFactory);

        inputReader.read();
    }
}