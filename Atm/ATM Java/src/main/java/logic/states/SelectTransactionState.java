package logic.states;

import logic.AtmService;
import models.TransactionType;

public class SelectTransactionState extends AtmState {

    private final AtmService atmService;

    public SelectTransactionState(AtmService atmService) {
        this.atmService = atmService;
    }

    void setTransactionType(TransactionType transactionType) throws Exception {

        switch (transactionType) {

            case DEPOSIT -> atmService.updateState(new DepositMoneyState(atmService));
            case WITHDRAW -> atmService.updateState(new WithdrawMoneyState(atmService));
            case CHECK_BALANCE -> atmService.updateState(new CheckBalanceState(atmService));
            default -> throw new Exception("Incorrect transaction type Entered! " +
                    "Please try with valid transaction type!");
        }
    }

}
