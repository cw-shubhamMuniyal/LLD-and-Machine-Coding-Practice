package logic;

import logic.states.AtmState;
import lombok.Getter;
import models.Atm;

public class AtmService {

    private AtmState atmState;
    @Getter
    private Atm atm;

    public AtmService(AtmState atmState) {
        this.atmState = atmState;
    }

    public void updateState(AtmState atmState) {
        this.atmState = atmState;
    }

}
