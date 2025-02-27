package logic;

import models.NoteDenomination;

import java.util.Map;

public class FiveHundredWithdrawProcessor extends WithdrawProcessor {

    public FiveHundredWithdrawProcessor(WithdrawProcessor next) {
        super(next);
    }

    public void withdraw(Map<NoteDenomination, Integer> noteDenomiationCountMap, Double amount) throws Exception {

        int requiredNotes = (int) (amount / 500);
        Double pendingAmount = amount % 500;

        Integer availableNotes = noteDenomiationCountMap.get(NoteDenomination.FIVE_HUNDRED);

        if (requiredNotes <= availableNotes) {
            noteDenomiationCountMap.put(NoteDenomination.FIVE_HUNDRED, availableNotes-requiredNotes);
        }
        else {
            noteDenomiationCountMap.put(NoteDenomination.FIVE_HUNDRED, 0);
            pendingAmount += (requiredNotes - availableNotes) * 500;
        }

        if (pendingAmount > 0.0) {
            super.withdraw(noteDenomiationCountMap, pendingAmount);
        }
    }
}
