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

        System.out.println("You cannot click insert coin button in product selected state!");
    }

    @Override
    public void setPrice(List<Coin> coins) {

        System.out.println("You cannot enter price in product selected state!");
    }

    @Override
    public void pressSelectProductButton() {

        System.out.println("You cannot click insert product button in product selected state!");
    }

    @Override
    public void setCode(Integer code) {

        System.out.println("You cannot enter code in product selected state!");
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
