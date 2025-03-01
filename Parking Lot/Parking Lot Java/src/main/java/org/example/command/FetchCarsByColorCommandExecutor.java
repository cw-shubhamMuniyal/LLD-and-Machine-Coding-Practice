package org.example.command;

import lombok.AllArgsConstructor;
import org.example.ParkingLotService;
import org.example.models.parking_stratergy.NaturalOrderParkingStrategy;

import java.util.List;

@AllArgsConstructor
public class FetchCarsByColorCommandExecutor implements CommandExecutor{

    final ParkingLotService parkingLotService;

    @Override
    public void execute(List<String> params) {
        List<String> cars = this.parkingLotService.fetchCarsByColor(params.getFirst());

        if (cars.isEmpty()) {
            System.out.println("No cars found for given color!");
            return;
        }

        System.out.println("for given color:" + params.getFirst() +" , cars are ");
        for (String car : cars) {
            System.out.println(car);
        }
    }

    @Override
    public boolean validate(List<String> params) {
        return params.size() == 1;
    }
}
