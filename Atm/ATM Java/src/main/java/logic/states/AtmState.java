package logic.states;

import models.Card;
import models.NoteDenomination;
import models.TransactionType;

import java.util.List;

public abstract class AtmState {

    public void setCard(Card card) {}

    public void setPin(Integer pin) throws Exception {}

    public void setTransactionType(TransactionType transactionType) throws Exception {}

    public void withdrawAmount(Double amount) throws Exception {}

    public void depositCash(List<NoteDenomination> notes) {}

    public void checkBalance() {}
}
