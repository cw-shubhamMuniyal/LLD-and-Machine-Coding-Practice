package logic;

import models.NoteDenomination;

import java.util.Map;

public class HundredWithdrawProcessor extends WithdrawProcessor {

    public HundredWithdrawProcessor(WithdrawProcessor next) {
        super(next);
    }

    public void withdraw(Map<NoteDenomination, Integer> noteDenomiationCountMap, Double amount) throws Exception {

        int requiredNotes = (int) (amount / 100);
        Double pendingAmount = amount % 100;

        Integer availableNotes = noteDenomiationCountMap.get(NoteDenomination.HUNDRED);

        if (requiredNotes <= availableNotes) {
            noteDenomiationCountMap.put(NoteDenomination.HUNDRED, availableNotes-requiredNotes);
        }
        else {
            noteDenomiationCountMap.put(NoteDenomination.HUNDRED, 0);
            pendingAmount += (requiredNotes - availableNotes) * 100;
        }

        if (pendingAmount > 0.0) {
            super.withdraw(noteDenomiationCountMap, pendingAmount);
        }
    }
}
