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

    }

    @Override
    public void setPrice(List<Coin> coins) {

    }

    @Override
    public void pressSelectProductButton() {

        System.out.println("Select product button pressed!");
        this.vendingMachine.updateState(new ProductInputState(vendingMachine));
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
