package org.example.service;

import lombok.NonNull;
import org.example.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserService {

    Map<String, User> users;

    public UserService() {
        users = new HashMap<>();
    }

    public User addUser(@NonNull final String name) {
        return new User(UUID.randomUUID().toString(), name);
    }

    public User getUser(@NonNull final String userId) {
        return users.get(userId);
    }
}
