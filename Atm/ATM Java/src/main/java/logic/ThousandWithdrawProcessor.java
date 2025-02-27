package logic;

import models.NoteDenomination;

import java.util.Map;

public class ThousandWithdrawProcessor extends WithdrawProcessor {

    public ThousandWithdrawProcessor(WithdrawProcessor next) {
        super(next);
    }

    void withdraw(Map<NoteDenomination, Integer> noteDenomiationCountMap, Double amount) {

        int requiredNotes = (int) (amount / 1000);
        Double pendingAmount = amount % 1000;

        Integer availableNotes = noteDenomiationCountMap.get(NoteDenomination.THOUSAND);

        if (requiredNotes <= availableNotes) {
            noteDenomiationCountMap.put(NoteDenomination.THOUSAND, availableNotes-requiredNotes);
        }
        else {
            noteDenomiationCountMap.put(NoteDenomination.THOUSAND, 0);
            pendingAmount += (requiredNotes - availableNotes) * 1000;
        }

        if (pendingAmount > 0.0) {
            this.withdraw(pendingAmount);
        }
    }
}
