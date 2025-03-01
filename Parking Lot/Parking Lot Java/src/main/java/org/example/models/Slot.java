package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
public class Slot {

    private Integer id;
    private Car car;

    public Slot(Integer id) {
        this.id = id;
    }

    public void assignCar(Car car) {
        this.car = car;
    }

    public void unassignCar() {
        this.car = null;
    }

    public boolean isSlotFree() {
        return Objects.isNull(this.car);
    }
}
