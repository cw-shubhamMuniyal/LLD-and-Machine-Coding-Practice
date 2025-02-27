package logic.states;

import logic.AtmService;
import models.Atm;
import models.NoteDenomination;

import java.util.List;

public class DepositMoneyState extends AtmState {

    private final AtmService atmService;

    public DepositMoneyState(AtmService atmService) {
        this.atmService = atmService;
    }

    void depositCash(List<NoteDenomination> notes) {

        Atm atm = this.atmService.getAtm();
        atm.addNotes(notes);
        System.out.println("please collect your card!");
        this.atmService.updateState(new IdleState(atmService));
    }

}
