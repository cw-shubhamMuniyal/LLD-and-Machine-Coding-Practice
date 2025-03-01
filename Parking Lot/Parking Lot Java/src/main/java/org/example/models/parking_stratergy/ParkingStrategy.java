package org.example.models.parking_stratergy;

public interface ParkingStrategy {

    void addSlot(Integer id);
    void removeSlot(Integer id);
    Integer getNextFreeSlot() throws Exception;
}
