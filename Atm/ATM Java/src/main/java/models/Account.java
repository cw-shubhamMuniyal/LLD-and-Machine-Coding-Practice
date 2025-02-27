package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Account {

    private final String id;
    private final String holderName;
    private final String IfscCode;

    @Getter
    private Double balance;

    public void addAmount(Double amount) {
        this.balance += amount;
    }

    public void deductAmount(Double amount) {
        this.balance -= amount;
    }
}
