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

        if (!coins.isEmpty()) {
            this.vendingMachine.setPriceEntered(totalPriceEntered);
            this.vendingMachine.updateState(new HasCashState(vendingMachine));
        } else {
            throw new Exception("Please Enter coins to place a purchase order!");
        }

    }

    @Override
    public void pressSelectProductButton() {

    }

    @Override
    public void setCode(Integer code) {

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
