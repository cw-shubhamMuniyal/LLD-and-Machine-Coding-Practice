package logic.states;

import logic.AtmService;
import models.Atm;
import models.Card;
import models.TransactionType;

public class CheckBalanceState extends AtmState {

    private final AtmService atmService;

    public CheckBalanceState(AtmService atmService) {
        this.atmService = atmService;
    }

    public void checkBalance() {
        Atm atm = atmService.getAtm();
        Card card = atm.getCard();
        System.out.println("Current balance in your account is " + card.getBalance());
        this.atmService.updateState(new SelectTransactionState(atmService));
    }


}
