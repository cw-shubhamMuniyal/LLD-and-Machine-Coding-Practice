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

    }

    @Override
    public void setPrice(List<Coin> coins) throws Exception {

    }

    @Override
    public void pressSelectProductButton() {

    }

    @Override
    public void setCode(Integer code) throws Exception {

    }

    @Override
    public void validatePrice() throws Exception {

    }

    @Override
    public void dispenseProduct() {

        System.out.println("Your Item is dispensed." +
                "Please collect your item from tray!");

        Integer codeEntered = this.vendingMachine.getcodeEntered();
        this.vendingMachine.getInventory().getItems().remove(codeEntered);
        this.vendingMachine.updateState(new CashChangeState(vendingMachine));
    }

    @Override
    public void returnChange() {

    }

}
