package State;

import logic.VendingMachine;
import models.Coin;
import models.Product;

import java.util.List;
import java.util.Map;

public class HasCashState implements State {

    VendingMachine vendingMachine;

    public HasCashState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void pressInsertCashButton() {

        System.out.println("You cannot click insert coin button in has cash state!");
    }

    @Override
    public void setPrice(List<Coin> coins) {

        System.out.println("You cannot enter price in Price input state!");
    }

    @Override
    public void pressSelectProductButton() {

        System.out.println("select product button pressed!");
        System.out.println();
        this.vendingMachine.updateState(new ProductInputState(vendingMachine));
    }

    @Override
    public void setCode(Integer code) {

        System.out.println("You cannot enter code in has cash state!");
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
