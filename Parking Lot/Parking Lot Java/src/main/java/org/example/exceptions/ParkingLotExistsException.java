package org.example.exceptions;

public class ParkingLotExistsException extends RuntimeException{
    public ParkingLotExistsException(String message) {
        super(message);
    }
}
