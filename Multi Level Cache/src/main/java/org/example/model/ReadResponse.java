package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@AllArgsConstructor
@Data
public class ReadResponse<Value> {

    private final Value value;

    private final Double timeTaken;
}
