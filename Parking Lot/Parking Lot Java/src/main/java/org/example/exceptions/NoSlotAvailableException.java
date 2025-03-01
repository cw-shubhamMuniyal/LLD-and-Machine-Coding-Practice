package org.example.exceptions;

public class NoSlotAvailableException extends RuntimeException{

    public NoSlotAvailableException(String message) {
        super(message);
    }
}
