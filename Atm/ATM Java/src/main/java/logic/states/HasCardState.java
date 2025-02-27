package logic.states;

import logic.AtmService;

public class HasCardState extends AtmState{

    private final AtmService atmService;
    
    public HasCardState(AtmService atmService) {
        this.atmService = atmService;
    }

    public void setPin(Integer pin) throws Exception {

        validatePin(pin);

        atmService.updateState(new SelectTransactionState(atmService));
    }

    private void validatePin(Integer pin) throws Exception {
        if (this.atmService.validatePin(pin)) {
            throw new Exception("Invalid pin Entered!");
        }
    }
}
