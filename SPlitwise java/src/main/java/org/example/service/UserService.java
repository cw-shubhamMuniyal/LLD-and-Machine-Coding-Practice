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
        User user = new User(name, name);
        users.put(user.getId(), user);
        return user;
    }

    public User getUser(@NonNull final String userId) {
        return users.get(userId);
    }
}
