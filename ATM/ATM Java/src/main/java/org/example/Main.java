package org.example;

import logic.AtmService;
import models.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("ATM LLD!");
        System.out.println("_________");

        Account account = new Account("1234567890", "Rahul Pathak", "HSFD1290", 1000.0);
        Atm atm = new Atm(2000.0);

        List<NoteDenomination> noteDenominations = new ArrayList<>();
        noteDenominations.add(NoteDenomination.THOUSAND);
        noteDenominations.add(NoteDenomination.FIVE_HUNDRED);
        noteDenominations.add(NoteDenomination.HUNDRED);
        noteDenominations.add(NoteDenomination.HUNDRED);
        noteDenominations.add(NoteDenomination.HUNDRED);
        noteDenominations.add(NoteDenomination.HUNDRED);
        noteDenominations.add(NoteDenomination.HUNDRED);

        atm.addNotes(noteDenominations);

        AtmService atmService = new AtmService(atm);

        System.out.println("Please enter your card to start transaction!");

        Card card = new Card("1", account, "1234", LocalDate.now(), 9089, CardType.DEBIT_CARD);

        System.out.println("User entered his card.");

        atmService.setCard(card);

        System.out.println("please enter your pin to proceed.");

        atmService.setPin(9089);

        System.out.println("please select your transaction type! You can withdraw, deposit or check balance");

        atmService.setTransactionType(TransactionType.DEPOSIT);

        atmService.depositCash(List.of(NoteDenomination.FIVE_HUNDRED, NoteDenomination.FIVE_HUNDRED, NoteDenomination.HUNDRED));


        System.out.println("please select your transaction type! You can withdraw, deposit or check balance");

        atmService.setTransactionType(TransactionType.CHECK_BALANCE);

        atmService.checkBalance();

        System.out.println("please select your transaction type! You can withdraw, deposit or check balance");

        atmService.setTransactionType(TransactionType.WITHDRAW);

        atmService.withdrawAmount(1901.0);

        System.out.println("please select your transaction type! You can withdraw, deposit or check balance");

        atmService.setTransactionType(TransactionType.CHECK_BALANCE);

        atmService.checkBalance();
    }
}