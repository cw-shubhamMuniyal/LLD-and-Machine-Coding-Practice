package logic;

import lombok.AllArgsConstructor;
import models.NoteDenomination;

import java.util.Map;
import java.util.Objects;

@AllArgsConstructor
public class WithdrawProcessor {

    public WithdrawProcessor next;

    public void withdraw(Map<NoteDenomination, Integer> noteDenomiationCountMap, Double amount) throws Exception {
        if (Objects.nonNull(next)) {
            next.withdraw(noteDenomiationCountMap, amount);
        }
        else {
            throw new Exception("Insufficient notes in ATM!");
        }
    }

}
