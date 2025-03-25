package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Command {

    private final CommandType commandType;
    private final List<String> params;
}
