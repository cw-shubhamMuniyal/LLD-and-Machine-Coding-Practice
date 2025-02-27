package models;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Data
public class Atm {

    private final Map<NoteDenomination, Integer> noteDenomiationCountMap = new HashMap<>();
    private Double currentAmount;
    private Card card;

    public Atm(Double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public void addNotes(List<NoteDenomination> noteDenominationList) {

        Double amount = 0.0;
        for (NoteDenomination noteDenomination : noteDenominationList) {

            Integer numberOfNotes = noteDenomiationCountMap.get(noteDenomination);
            if (Objects.nonNull(numberOfNotes)) {
                noteDenomiationCountMap.put(noteDenomination, numberOfNotes+1);
            }
            else {
                noteDenomiationCountMap.put(noteDenomination, 1);
            }
            amount += noteDenomination.getValue();
        }

        this.currentAmount += amount;
        if (Objects.nonNull(card)) {
            this.card.addBalance(amount);
        }
    }

    public void deductAmount(Double amount) {
        this.currentAmount -= amount;
    }

    public void deductAccountAmount(Double amount) {
        this.card.deductBalance(amount);
    }

    public boolean validatePin(Integer pin) {
        return this.card.validatePin(pin);
    }
}
