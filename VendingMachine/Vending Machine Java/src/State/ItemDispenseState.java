package State;

import logic.VendingMachine;
import models.Coin;

import java.util.List;

public class ItemDispenseState implements State {

    VendingMachine vendingMachine;

    public ItemDispenseState(VendingMachine vendingMachine) {

        this.vendingMachine = vendingMachine;
    }

    @Override
    public void pressInsertCashButton() {

        System.out.println("You cannot click insert coin button in item dispense state!");
    }

    @Override
    public void setPrice(List<Coin> coins) throws Exception {

        System.out.println("You cannot enter price in item dispense state!");
    }

    @Override
    public void pressSelectProductButton() {

        System.out.println("You cannot click insert product button in item dispense state!");
    }

    @Override
    public void setCode(Integer code) throws Exception {

        System.out.println("You cannot enter code in item dispense state!");
    }

    @Override
    public void validatePrice() throws Exception {

    }

    @Override
    public void dispenseProduct() {

        System.out.println("Your Item is dispensed." +
                "Please collect your item from tray!");
        System.out.println();

        Integer codeEntered = this.vendingMachine.getcodeEntered();
        this.vendingMachine.getInventory().getItems().remove(codeEntered);
    }

    @Override
    public void returnChange() {

    }

}
