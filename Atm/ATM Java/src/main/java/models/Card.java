package models;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
public class Card {

    private String id;
    private Account account;
    private String cvv;
    private LocalDate expiryDate;
    private Integer pin;
    private CardType cardType;

    public Double getBalance() {
        return this.account.getBalance();
    }

    public void addBalance(Double amount) {
        this.account.addAmount(amount);
    }

    public void deductBalance(Double amount) {
        this.account.deductAmount(amount);
    }

    public boolean validatePin(Integer pin) {
        return this.pin == pin;
    }
}
