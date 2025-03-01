package org.example.command;

import lombok.AllArgsConstructor;
import org.example.ParkingLotService;
import org.example.exceptions.ParkingLotExistsException;
import org.example.models.parking_stratergy.NaturalOrderParkingStrategy;

import java.util.List;

@AllArgsConstructor
public class CreateParkingLotCommandExecutor implements CommandExecutor {

    final ParkingLotService parkingLotService;

    @Override
    public void execute(List<String> params) {

        try {
            this.parkingLotService.createParkingLot(Integer.valueOf(params.getFirst()),
                    new NaturalOrderParkingStrategy());
            System.out.println("Created Parking Lot with capacity: " + params.getFirst());
        }
        catch (ParkingLotExistsException exception) {
            System.out.println("Parking lot already Exists!");
        }
    }

    @Override
    public boolean validate(List<String> params) {
        return params.size() == 1;
    }
}
