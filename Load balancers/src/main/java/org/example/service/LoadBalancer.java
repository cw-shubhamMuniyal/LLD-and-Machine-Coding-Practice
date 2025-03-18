package org.example.service;

import lombok.NonNull;
import org.example.models.Request;
import org.example.models.RequestType;
import org.example.models.Server;
import org.example.models.Service;

import java.util.HashMap;
import java.util.Map;

public abstract class LoadBalancer {

    Map<RequestType, Service> requestTypeServiceMap;

    public LoadBalancer() {
        requestTypeServiceMap = new HashMap<>();
    }

    public void registerService(@NonNull final RequestType requestType,
                         @NonNull final Service service) {

        requestTypeServiceMap.put(requestType, service);
    }

    public abstract void handleRequest(@NonNull final Request request);
}
