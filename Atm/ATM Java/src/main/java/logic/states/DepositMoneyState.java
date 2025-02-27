package logic.states;

import logic.AtmService;
import models.Atm;
import models.NoteDenomination;
import models.TransactionType;

import java.util.List;

public class DepositMoneyState extends AtmState {

    private final AtmService atmService;

    public DepositMoneyState(AtmService atmService) {
        this.atmService = atmService;
    }

    public void depositCash(List<NoteDenomination> notes) {

        Atm atm = this.atmService.getAtm();
        atm.addNotes(notes);
        System.out.println("Transaction is successful!");
        this.atmService.updateState(new SelectTransactionState(atmService));
    }

}
