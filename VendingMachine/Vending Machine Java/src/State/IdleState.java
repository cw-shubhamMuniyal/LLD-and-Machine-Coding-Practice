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
        System.out.println();
        vendingMachine.updateState(new PriceInputState(vendingMachine));
    }

    @Override
    public void setPrice(List<Coin> coins) {

        System.out.println("You cannot enter price in IDLE state!");
    }

    @Override
    public void pressSelectProductButton() {

        System.out.println("You cannot click select product button in IDLE state!");
    }

    @Override
    public void setCode(Integer code) {

        System.out.println("You cannot enter code in IDLE state!");
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
