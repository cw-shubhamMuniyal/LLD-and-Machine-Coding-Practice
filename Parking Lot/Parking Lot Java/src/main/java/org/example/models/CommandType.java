package org.example.models;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CommandType {

    CREATE_PARKING_LOT("create_parking_lot"),
    PARK("park"),
    LEAVE("leave"),
    EXIT("exit"),
    REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOR("registration_numbers_for_cars_with_colour"),
    SLOT_NUMBERS_FOR_CARS_WITH_COLOR("slot_numbers_for_cars_with_colour"),
    SLOT_NUMBER_FOR_REGISTRATION_NUMBER("slot_number_for_registration_number");

    final String description;

    public static CommandType getEnumNameForValue(String value) throws Exception {
        CommandType[] values = CommandType.values();

        for(CommandType eachValue : values) {

            if (eachValue.description.equalsIgnoreCase(value)) {
                return eachValue;
            }
        }
        throw new Exception("invalid command provided!");
    }
}
