package org.example.mode;

import lombok.AllArgsConstructor;
import org.example.command.CommandExecutor;
import org.example.command.CommandExecutorFactory;
import org.example.models.Command;
import org.example.models.CommandType;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public abstract class Mode {

    private final CommandExecutorFactory commandExecutorFactory;

    void processCommand(String command) throws Exception {

        String SPACE = " ";
        List<String> tokens = Arrays.stream(command.trim().split(SPACE))
                .map(String::trim)
                .filter(token -> !token.isEmpty())
                .collect(Collectors.toList());

        String commandType = tokens.getFirst();
        tokens.removeFirst();

        CommandExecutor commandExecutor = commandExecutorFactory.getCommandExecutor(
                Command.builder()
                        .command(CommandType.getEnumNameForValue(commandType))
                        .params(tokens)
                        .build()
        );

        commandExecutor.validate(tokens);
        commandExecutor.execute(tokens);
    }

    abstract public void process() throws Exception;
}
