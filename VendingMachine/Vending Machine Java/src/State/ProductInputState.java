package State;

import logic.VendingMachine;
import models.Coin;
import models.Product;

import java.util.List;
import java.util.Objects;

public class ProductInputState implements State {

    VendingMachine vendingMachine;

    public ProductInputState(VendingMachine vendingMachine) {

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

    }

    @Override
    public void setCode(Integer code) throws Exception {

        this.vendingMachine.setCodeEntered(code);

        Product product = vendingMachine.getInventory().getItems().get(code);

        if (Objects.nonNull(product)) {

            System.out.println("You have selected " + vendingMachine.getInventory().getItems().get(code).getName());
            this.vendingMachine.setCodeEntered(code);
            this.vendingMachine.updateState(new ProductSelectedState(vendingMachine));
        }
        else {
            throw new Exception("Entered item code does not contain any item in vending machine" +
                    "please try again!");
        }
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
