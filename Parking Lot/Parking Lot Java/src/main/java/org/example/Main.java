package org.example;

import org.example.command.CommandExecutorFactory;
import org.example.mode.Mode;
import org.example.mode.ModeFactory;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Parking Lot LLD!");

        ParkingLotService parkingLotService = new ParkingLotService();
        CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(parkingLotService);
        ModeFactory modeFactory = new ModeFactory(commandExecutorFactory);
        Mode mode = modeFactory.getFactory(args);
        mode.process();
    }
}