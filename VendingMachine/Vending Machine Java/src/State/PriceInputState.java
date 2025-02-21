package State;

import logic.VendingMachine;
import models.Coin;

import java.util.List;

public class PriceInputState implements State {

    VendingMachine vendingMachine;

    public PriceInputState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void pressInsertCashButton() {

        System.out.println("You cannot click insert coin button in Price input state!");
    }

    @Override
    public void setPrice(List<Coin> coins) throws Exception {

        System.out.println("Coins Entered!");

        Integer totalPriceEntered = 0;

        for (Coin coin : coins) {

            totalPriceEntered += coin.getCoinType().getDenonimation();
            this.vendingMachine.addCoins(coin);
            System.out.println(coin.getCoinType().getDenonimation());
        }
        System.out.println();

        if (!coins.isEmpty()) {
            this.vendingMachine.setPriceEntered(totalPriceEntered);
            this.vendingMachine.updateState(new HasCashState(vendingMachine));
        } else {
            throw new Exception("Please Enter coins to place a purchase order!");
        }

    }

    @Override
    public void pressSelectProductButton() {

        System.out.println("You cannot click select product button in Price input state!");
    }

    @Override
    public void setCode(Integer code) {

        System.out.println("You cannot enter code in Price input state!");
    }

    @Override
    public void validatePrice() {

    }

    @Override
    public void dispenseProduct() {

    }

    @Override
    public void returnChange() {

    }

}
