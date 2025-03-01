package org.example;

import org.example.exceptions.NoSlotFoundException;
import org.example.exceptions.ParkingLotExistsException;
import org.example.models.Car;
import org.example.models.ParkingLot;
import org.example.models.Slot;
import org.example.models.parking_stratergy.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ParkingLotService {

    ParkingLot parkingLot;
    ParkingStrategy parkingStrategy;

    public void createParkingLot(Integer capacity, ParkingStrategy parkingStrategy) {

        if (Objects.nonNull(parkingLot)) {
            throw new ParkingLotExistsException("Parking lot already exists!");
        }
        this.parkingLot = new ParkingLot(capacity);
        this.parkingStrategy = parkingStrategy;
        for (int index = 0; index < capacity; index++) {
            parkingStrategy.addSlot(index);
        }
    }

    public Integer park(String registrationNumber, String color) throws Exception {

        Integer nextFreeSLot = this.parkingStrategy.getNextFreeSlot();
        this.parkingLot.addCar(new Car(registrationNumber, color), nextFreeSLot);
        this.parkingStrategy.removeSlot(nextFreeSLot);
        return nextFreeSLot;
    }

    public Integer leave(Integer slotId) throws Exception {

        this.parkingLot.removeCar(slotId);
        this.parkingStrategy.addSlot(slotId);
        return slotId;
    }

    public List<String> fetchCarsByColor(String color) {

        List<String> cars = new ArrayList<>();
        Map<Integer, Slot> slots = this.parkingLot.getSlots();
        for (Map.Entry<Integer, Slot> entry : slots.entrySet()) {
            Slot slot = entry.getValue();
            Car car = slot.getCar();
            if (car.getColor().equals(color)) {
                cars.add(car.getRegistrationNumber());
            }
        }

        return cars;
    }

    public List<Integer> fetchSlotNumbersByColor(String color) {

        List<Integer> slotNumbers = new ArrayList<>();
        Map<Integer, Slot> slots = this.parkingLot.getSlots();
        for (Map.Entry<Integer, Slot> entry : slots.entrySet()) {
            Slot slot = entry.getValue();
            Car car = slot.getCar();
            if (car.getColor().equals(color)) {
                slotNumbers.add(slot.getId());
            }
        }

        return slotNumbers;
    }

    public Integer fetchSlotNumberByRegistrationNumber(String registrationNumber) {

        Map<Integer, Slot> slots = this.parkingLot.getSlots();
        for (Map.Entry<Integer, Slot> entry : slots.entrySet()) {
            Slot slot = entry.getValue();
            Car car = slot.getCar();
            if (car.getRegistrationNumber().equals(registrationNumber)) {
                return slot.getId();
            }
        }

        throw new NoSlotFoundException("No slot found for given registration number!");
    }


}
