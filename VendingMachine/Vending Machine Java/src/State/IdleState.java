package State;

import logic.VendingMachine;
import models.Coin;

import java.util.List;

public class IdleState implements State {

    VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void pressInsertCashButton() {

        System.out.println("Insert cash button pressed!");
        vendingMachine.updateState(new PriceInputState(vendingMachine));
    }

    @Override
    public void setPrice(List<Coin> coins) {


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
