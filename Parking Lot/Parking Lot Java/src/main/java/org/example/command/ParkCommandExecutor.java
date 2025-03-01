package org.example.command;

import lombok.AllArgsConstructor;
import org.example.ParkingLotService;
import org.example.exceptions.NoSlotAvailableException;
import org.example.models.parking_stratergy.NaturalOrderParkingStrategy;

import java.util.List;

@AllArgsConstructor
public class ParkCommandExecutor implements CommandExecutor{

    final ParkingLotService parkingLotService;

    @Override
    public void execute(List<String> params) {
        try {


            Integer slotId = this.parkingLotService.park(params.getFirst(), params.get(1));
            System.out.println("Allocated slot " + slotId);
        }
        catch (NoSlotAvailableException exception) {
            System.out.println(exception.getMessage());
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public boolean validate(List<String> params) {
        return params.size() == 2;
    }
}
