package org.example.command;

import java.util.List;

public interface CommandExecutor {

    void execute(List<String> params) throws Exception;
    boolean validate(List<String> params);
}
