package org.example.models;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Service {

    private final Integer id;

    private final String name;

    private final List<Server> servers;

    public Service(@NonNull final Integer id, @NonNull final String name) {
        servers = new ArrayList<>();
        this.id = id;
        this.name = name;
    }

    public void addServer(@NonNull final Server server) {
        this.servers.add(server);
    }

    public void removeServer() {
        if (!servers.isEmpty()) {
            this.servers.removeFirst();
        }
    }
}
