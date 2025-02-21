package logic;

import State.*;
import models.Coin;
import models.CoinType;
import models.Inventory;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class VendingMachine {

    private State state = new IdleState(this);
    Map<CoinType, Integer> coinTypeCount = new HashMap<>();

    private Integer priceEntered;

    public Integer getPriceEntered() {
        return priceEntered;
    }

    private Integer codeEntered;

    public Integer getcodeEntered() {
        return codeEntered;
    }

    private Inventory inventory;

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public VendingMachine() {
        inventory = new Inventory();
    }

    public void pressInsertCashButton() {
        state.pressInsertCashButton();
    }

    public void setPrice(List<Coin> coins) throws Exception {
        state.setPrice(coins);
    }

    public void pressSelectProductButton() {
        state.pressSelectProductButton();
    }

    public void setCode(Integer code) throws Exception {
        state.setCode(code);
    }

    public void validatePrice() throws Exception {
        state.validatePrice();
    }

    public void dispenseProduct() {
        state.dispenseProduct();
    }

    public void cancelPayment() {

        System.out.println("Please collect your refund of " + this.priceEntered
                + " from change tray!");
        System.out.println();
    }

    public void returnChange() {
        state.returnChange();
    }

    public void updateState(State state) {

        this.state = state;
    }

    public void addCoins(Coin coin) {

        Integer coinCount = coinTypeCount.getOrDefault(coin.getCoinType(), 0);
        coinTypeCount.put(coin.getCoinType(), coinCount + 1);
    }

    public void setPriceEntered(Integer priceEntered) {
        this.priceEntered = priceEntered;
    }

    public void setCodeEntered(Integer codeEntered) {

        this.codeEntered = codeEntered;
    }

    public void displayInventory() {

        this.inventory.displayInventory();
    }
}
