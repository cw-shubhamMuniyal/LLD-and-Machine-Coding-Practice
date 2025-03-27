package org.example.service;

import lombok.NonNull;
import org.example.exceptions.NoUserExistsException;
import org.example.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserService {

    Map<String, User> users;

    public UserService() {
        users = new HashMap<>();
    }

    public User addUser(@NonNull final String contactNumber) {
        String userId = UUID.randomUUID().toString();
        User user = new User(userId, contactNumber);
        users.put(userId, user);
        return user;
    }

    public User getUser(@NonNull final String userId) {
        if (!users.containsKey(userId)) {
            throw new NoUserExistsException();
        }
        return users.get(userId);
    }
}
