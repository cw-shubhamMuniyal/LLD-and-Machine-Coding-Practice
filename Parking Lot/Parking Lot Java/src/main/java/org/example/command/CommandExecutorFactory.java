package org.example.command;

import lombok.AllArgsConstructor;
import org.example.ParkingLotService;
import org.example.models.Command;

@AllArgsConstructor
public class CommandExecutorFactory {

    final ParkingLotService parkingLotService;

    public CommandExecutor getCommandExecutor(Command command) throws Exception {

        CommandExecutor commandExecutor = null;
        switch (command.getCommand()) {
            case CREATE_PARKING_LOT -> commandExecutor = new CreateParkingLotCommandExecutor(
                    parkingLotService
            );
            case PARK -> commandExecutor = new ParkCommandExecutor(
                    parkingLotService
            );
            case LEAVE -> commandExecutor = new LeaveCommandExecutor(
                    parkingLotService
            );
            case REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOR -> commandExecutor = new FetchCarsByColorCommandExecutor(
                    parkingLotService
            );
            case SLOT_NUMBERS_FOR_CARS_WITH_COLOR -> commandExecutor = new FetchSlotsByColorCommandExecutor(
                    parkingLotService
            );
            case SLOT_NUMBER_FOR_REGISTRATION_NUMBER -> commandExecutor = new FetchSlotByCarCommandExecutor(
                    parkingLotService
            );
            default -> throw new Exception("Incorrect command provided!");
        }

        return commandExecutor;
    }


}
