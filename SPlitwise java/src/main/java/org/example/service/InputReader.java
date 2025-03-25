package org.example.service;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.example.factories.CommandExecutorFactory;
import org.example.model.Command;
import org.example.model.CommandType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class InputReader {

    private final BufferedReader bufferedReader;
    private final CommandExecutorFactory commandExecutorFactory;

    public InputReader(@NonNull CommandExecutorFactory commandExecutorFactory) {
        this.commandExecutorFactory = commandExecutorFactory;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void read() throws IOException {

        while (true) {
            String input = bufferedReader.readLine().trim();

            if (input.equals("EXIT")) {
                return;
            }
            processInput(input);
        }
    }

    private void processInput(@NonNull final String input) {

        String decimeter = " ";
        String[] tokens = input.split(decimeter);
        String commandType = tokens[0];
        List<String> tokensList = new ArrayList<>(Arrays.asList(tokens));
        tokensList.removeFirst();
        Command command = new Command(
                CommandType.fromName(commandType), tokensList
        );
        CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(command);
        commandExecutor.execute(tokensList);
    }
}
