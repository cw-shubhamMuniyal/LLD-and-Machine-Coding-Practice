package logic.states;

import logic.AtmService;

public class HasCardState extends AtmState{

    private final AtmService atmService;
    
    public HasCardState(AtmService atmService) {
        this.atmService = atmService;
    }

    void setPin(Integer pin) throws Exception {

        validatePin(pin);

        atmService.updateState(new SelectTransactionState(atmService));
    }

    private static void validatePin(Integer pin) throws Exception {
        if (pin < 0 || pin > 4999) {
            throw new Exception("Invalid pin Entered!");
        }
    }
}
