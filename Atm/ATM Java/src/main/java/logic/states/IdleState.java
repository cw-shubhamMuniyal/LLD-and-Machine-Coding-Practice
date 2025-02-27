package logic.states;

import logic.AtmService;
import lombok.AllArgsConstructor;
import models.Card;

import java.util.Objects;

@AllArgsConstructor
public class IdleState extends AtmState {

    private final AtmService atmService;

    void setCard(Card card) {

        if (Objects.isNull(card)) {
            throw new RuntimeException("Incorrect card entered!" +
                    "please check and try again!");
        }

        atmService.getAtm().setCard(card);
        atmService.updateState(new HasCardState(atmService));

    }
}
