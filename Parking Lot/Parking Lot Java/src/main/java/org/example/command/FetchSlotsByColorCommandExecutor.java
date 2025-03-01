package org.example.command;

import lombok.AllArgsConstructor;
import org.example.ParkingLotService;

import java.util.List;

@AllArgsConstructor
public class FetchSlotsByColorCommandExecutor implements CommandExecutor{

    final ParkingLotService parkingLotService;

    @Override
    public void execute(List<String> params) {
        List<Integer> slots = this.parkingLotService.fetchSlotNumbersByColor(params.getFirst());

        if (slots.isEmpty()) {
            System.out.println("NO slots found for given color!");
            return;
        }

        System.out.println("for given color:" + params.getFirst() +" , slots are ");

        for (Integer slot : slots) {
            System.out.println(slot);
        }
    }

    @Override
    public boolean validate(List<String> params) {
        return params.size() == 1;
    }
}
