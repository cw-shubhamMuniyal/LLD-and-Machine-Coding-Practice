package org.example.service;

import lombok.NonNull;
import org.example.exceptions.BadRequestException;
import org.example.models.Request;
import org.example.models.RequestType;
import org.example.models.Server;
import org.example.models.Service;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RoundRobinLoadBalancer extends LoadBalancer {

    Lock lock;
    HashMap<RequestType, Queue<Server>> requestTypeQueueHashMap;

    public RoundRobinLoadBalancer() {
        super();
        lock = new ReentrantLock();
        requestTypeQueueHashMap = new HashMap<>();
    }

    @Override
    public void handleRequest(@NonNull final Request request) {

        RequestType requestType = request.getRequestType();

        Service service = super.requestTypeServiceMap.get(requestType);

        Server server;
        try {
            lock.lock();
            if (!requestTypeQueueHashMap.containsKey(requestType)) {
                requestTypeQueueHashMap.put(requestType, new LinkedList<>(service.getServers()));
            }
            server = requestTypeQueueHashMap.get(requestType).poll();
        } finally {
            lock.unlock();
        }

        if (Objects.isNull(server)) {
            throw new BadRequestException();
        }

        requestTypeQueueHashMap.get(requestType).offer(server);

        server.handleRequest();
    }
}
