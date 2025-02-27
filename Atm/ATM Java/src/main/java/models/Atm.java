package models;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Atm {

    private final Map<NoteDenomination, Integer> noteDenomiationCountMap = new HashMap<>();
    private Double currentAmount;
    private Card card;

    public void addNotes(List<NoteDenomination> noteDenominationList) {

        Double amount = 0.0;
        for (NoteDenomination noteDenomination : noteDenominationList) {

            noteDenomiationCountMap.compute(noteDenomination, (k, count) -> count + 1);
            amount += noteDenomination.getValue();
        }

        this.currentAmount += amount;
        this.card.addBalance(amount);
    }

    public void deductAmount(Double amount) {
        this.currentAmount -= amount;
    }

    public void deductAccountAmount(Double amount) {
        this.card.deductBalance(amount);
    }
}
