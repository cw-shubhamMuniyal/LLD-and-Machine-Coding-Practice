package org.example.service;

import java.util.List;

public interface CommandExecutor {
    void execute(List<String> params);
}
