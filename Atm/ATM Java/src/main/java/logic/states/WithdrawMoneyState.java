package logic.states;

import logic.*;

public class WithdrawMoneyState extends AtmState {

    private final AtmService atmService;

    public WithdrawMoneyState(AtmService atmService) {
        this.atmService = atmService;
    }

    void withdrawAmount(Double amount) throws Exception {

        if (amount < atmService.getAtm().getCurrentAmount()) {
            throw new Exception("Insufficient amount in ATM");
        }

        if (amount < atmService.getAtm().getCard().getBalance()) {
            throw new Exception("Insufficient amount in Account");
        }

        atmService.getAtm().deductAmount(amount);
        atmService.getAtm().deductAccountAmount(amount);

        WithdrawProcessor withdrawProcessor =
                new ThousandWithdrawProcessor(
                        new FiveHundredWithdrawProcessor(
                                new HundredWithdrawProcessor(
                                        null
                                )
                        )
                );

        withdrawProcessor.withdraw(amount);

        System.out.println("Amount of Rs " + amount + "is successfully withdrawn from your account!");
        System.out.println("please collect your card!");
        this.atmService.updateState(new IdleState(atmService));
    }


}
