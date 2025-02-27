package logic;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WithdrawProcessor {

    public WithdrawProcessor next;

    public void withdraw(Double amount) {
        next.withdraw(amount);
    }

}
