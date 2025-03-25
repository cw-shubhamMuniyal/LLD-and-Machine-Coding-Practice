package org.example.model;

import lombok.Getter;
import lombok.NonNull;
import org.example.exceptions.InvalidCommandException;

@Getter
public enum CommandType {

    EXPENSE,
    SHOW;

    public String getName(@NonNull final CommandType commandType) {
        return commandType.name();
    }

    public static CommandType fromName(@NonNull final String name) {

        for (CommandType commandType : CommandType.values()) {
            if (commandType.name().equals(name)) {
                return commandType;
            }
        }
        throw new InvalidCommandException();
    }
}
