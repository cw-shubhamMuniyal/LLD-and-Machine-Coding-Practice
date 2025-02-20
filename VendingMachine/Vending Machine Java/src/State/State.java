package State;

import models.Coin;

import java.util.List;

public interface State {

    void pressInsertCashButton();

    void setPrice(List<Coin> coins) throws Exception;

    void pressSelectProductButton();

    void setCode(Integer code) throws Exception;

    void validatePrice() throws Exception;

    void dispenseProduct();

    void returnChange();

}
