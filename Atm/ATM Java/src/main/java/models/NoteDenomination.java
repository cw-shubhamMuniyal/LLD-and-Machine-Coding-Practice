package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum NoteDenomination {

    HUNDRED(100.0),
    FIVE_HUNDRED(500.0),
    THOUSAND(1000.0);

    private final Double value;
}
