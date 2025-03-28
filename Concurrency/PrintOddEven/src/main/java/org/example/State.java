package org.example;

import lombok.Data;
import lombok.NonNull;

@Data
public class State {

    private PrinterType nextTypeToPrint;

    public State(@NonNull final PrinterType nextTypeToPrint) {
        this.nextTypeToPrint = nextTypeToPrint;
    }
}
