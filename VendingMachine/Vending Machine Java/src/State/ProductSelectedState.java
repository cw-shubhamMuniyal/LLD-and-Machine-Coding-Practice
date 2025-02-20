package State;

import logic.VendingMachine;
import models.Coin;
import models.Product;

import java.util.List;
import java.util.Map;

public class ProductSelectedState implements State {

    VendingMachine vendingMachine;

    public ProductSelectedState(VendingMachine vendingMachine) {
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
    public void setCode(Integer code) {

    }

    @Override
    public void validatePrice() throws Exception {

        Map<Integer, Product> items = vendingMachine.getInventory().getItems();

        Product product = items.get(vendingMachine.getcodeEntered());

        if (vendingMachine.getPriceEntered() >= product.getPrice()) {
            this.vendingMachine.updateState(new CashChangeState(vendingMachine));
        } else {
            throw new Exception("Entered Coins are of less value than cost of selected item." +
                    "Please Collect your coins and try again!");

        }
    }

    @Override
    public void dispenseProduct() {

    }

    @Override
    public void returnChange() {

    }
}
