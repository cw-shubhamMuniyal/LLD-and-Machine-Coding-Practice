package models;

import java.time.LocalDate;


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
}
