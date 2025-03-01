package org.example.command;

import lombok.AllArgsConstructor;
import org.example.ParkingLotService;

import java.util.List;

@AllArgsConstructor
public class LeaveCommandExecutor implements CommandExecutor{

    final ParkingLotService parkingLotService;

    @Override
    public void execute(List<String> params) throws Exception {
        Integer slotId = this.parkingLotService.leave(Integer.valueOf(params.getFirst()));

        System.out.println(slotId + " is free now!");
    }

    @Override
    public boolean validate(List<String> params) {
        return params.size() == 1;
    }
}
