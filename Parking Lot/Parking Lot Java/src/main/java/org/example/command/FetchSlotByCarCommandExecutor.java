package org.example.command;

import lombok.AllArgsConstructor;
import org.example.ParkingLotService;
import org.example.exceptions.NoSlotFoundException;

import java.util.List;

@AllArgsConstructor
public class FetchSlotByCarCommandExecutor implements CommandExecutor {

    final ParkingLotService parkingLotService;

    @Override
    public void execute(List<String> params) {

        try {
            Integer slot = this.parkingLotService.fetchSlotNumberByRegistrationNumber(params.getFirst());
            System.out.println("for given registration number of:" + params.getFirst() +
                    "slot is:" + slot);
        }
        catch (NoSlotFoundException exception) {
            System.out.println(exception.getMessage());
        }

    }

    @Override
    public boolean validate(List<String> params) {
        return params.size() == 1;
    }
}
