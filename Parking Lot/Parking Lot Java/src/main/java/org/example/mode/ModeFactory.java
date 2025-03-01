package org.example.mode;

import lombok.AllArgsConstructor;
import org.example.command.CommandExecutorFactory;

@AllArgsConstructor
public class ModeFactory {

    private final CommandExecutorFactory commandExecutorFactory;

    public Mode getFactory(String[] args) {

        if (args.length > 0) {
            return new FileMode(this.commandExecutorFactory, args[0]);
        } else {
            return new InteractiveMode(this.commandExecutorFactory);
        }

    }
}
