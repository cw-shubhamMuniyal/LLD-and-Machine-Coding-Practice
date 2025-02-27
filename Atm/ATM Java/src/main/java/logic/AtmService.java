package logic;

import logic.states.AtmState;
import logic.states.IdleState;
import lombok.Getter;
import models.Atm;
import models.Card;
import models.NoteDenomination;
import models.TransactionType;

import java.util.List;

public class AtmService {

    private AtmState atmState;
    @Getter
    private Atm atm;

    public AtmService(Atm atm) {
        this.atm = atm;
        atmState = new IdleState(this);
    }

    public void updateState(AtmState atmState) {
        this.atmState = atmState;
    }

    public void setCard(Card card) {
        this.atmState.setCard(card);
    }

    public void setPin(Integer pin) throws Exception {
        this.atmState.setPin(pin);
    }

    public void setTransactionType(TransactionType transactionType) throws Exception {
        this.atmState.setTransactionType(transactionType);
    }

    public void withdrawAmount(Double amount) throws Exception {
        this.atmState.withdrawAmount(amount);
    }

    public void depositCash(List<NoteDenomination> notes) {
        this.atmState.depositCash(notes);
    }

    public void checkBalance() {
        this.atmState.checkBalance();
    }

    public boolean validatePin(Integer pin) {
        return this.atm.validatePin(pin);
    }

}
