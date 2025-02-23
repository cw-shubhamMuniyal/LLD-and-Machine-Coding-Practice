package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class ReadResponse<Value> {

    private final Value value;

    private final Double timeTaken;
}
