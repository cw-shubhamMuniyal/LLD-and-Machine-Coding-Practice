package logic.states;

import models.Card;
import models.NoteDenomination;
import models.TransactionType;

import java.util.List;

public abstract class AtmState {

    void setCard(Card card) {}

    void setPin(Integer pin) throws Exception {}

    void setTransactionType(TransactionType transactionType) throws Exception {}

    void withdrawAmount(Double amount) throws Exception {}

    void depositCash(List<NoteDenomination> notes) {}

    void checkBalance() {}
}
