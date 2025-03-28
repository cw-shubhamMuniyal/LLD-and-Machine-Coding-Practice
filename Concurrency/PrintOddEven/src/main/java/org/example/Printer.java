package org.example;

import lombok.NonNull;
import lombok.SneakyThrows;

public class Printer implements Runnable {

    private final Integer step;
    private final Integer endValue;
    private final State state;
    private final PrinterType type;
    private final PrinterType nextType;
    private Integer currentValue;

    public Printer(@NonNull final Integer step,
                   @NonNull final Integer endValue,
                   @NonNull final State state,
                   @NonNull final PrinterType type,
                   @NonNull final PrinterType nextType,
                   @NonNull final Integer currentValue) {

        this.step = step;
        this.endValue = endValue;
        this.state = state;
        this.type = type;
        this.nextType = nextType;
        this.currentValue = currentValue;
    }

    @Override
    @SneakyThrows
    public void run() {
        while (currentValue <= endValue) {
            synchronized (state) {
                if (!state.getNextTypeToPrint().equals(type)) {
                    state.wait();
                }
                System.out.println(this.type.toString() + " " + currentValue);
                currentValue += step;
                state.setNextTypeToPrint(nextType);
                state.notifyAll();
            }
        }
    }
}
