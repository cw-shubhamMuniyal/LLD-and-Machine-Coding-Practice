package org.example.service;

import lombok.NonNull;
import org.example.exceptions.BadRequestException;
import org.example.exceptions.ServerNotAvailableException;
import org.example.models.Request;
import org.example.models.Server;
import org.example.models.Service;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LeastConnectionLoadBalancer extends LoadBalancer {

    Lock lock;

    public LeastConnectionLoadBalancer() {
        super();
        lock = new ReentrantLock();
    }

    @Override
    public void handleRequest(@NonNull final Request request) {

        Service service = super.requestTypeServiceMap.get(request.getRequestType());

        if (Objects.isNull(service)) {
            throw new BadRequestException();
        }

        Optional<Server> server;

        try {

            lock.lock();
            server = service.getServers().stream()
                    .filter(server1 -> server1.getCurrentNumberOfRequests() < server1.getCapacity())
                    .min(Comparator.comparingInt(Server::getCurrentNumberOfRequests));

        } finally {
            lock.unlock();
        }

        if (server.isEmpty()) {
            throw new ServerNotAvailableException();
        }

        server.get().handleRequest();
    }
}
