package org.example.mode;

import org.example.command.CommandExecutorFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InteractiveMode extends Mode {

    public InteractiveMode(CommandExecutorFactory commandExecutorFactory) {
        super(commandExecutorFactory);
    }

    @Override
    public void process() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String command = bufferedReader.readLine();

            if (command.equals("EXIT")) {
                return;
            }
            processCommand(command);
        }
    }
}
