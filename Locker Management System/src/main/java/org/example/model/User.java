package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public abstract class User {

    private final String id;
    @Getter
    private final Contact contact;
}
