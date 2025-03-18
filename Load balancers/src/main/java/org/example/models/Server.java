package org.example.models;

import lombok.Getter;
import lombok.NonNull;
import org.example.exceptions.ServerNotAvailableException;

@Getter
public class Server {

    private final Integer id;

    private Integer currentNumberOfRequests;

    private Integer capacity;

    public Server(Integer id, Integer capacity) {
        this.id = id;
        this.capacity = capacity;
        this.currentNumberOfRequests = 0;
    }

    public void handleRequest() {
        if (currentNumberOfRequests >= capacity) {
            throw new ServerNotAvailableException();
        }
        System.out.println("Request accepted by serer " + this.id);
        currentNumberOfRequests++;
    }

    public void completeRequest() {
        currentNumberOfRequests--;
    }

    public void updateCapacity(@NonNull final Integer capacity) {
        this.capacity = capacity;
    }

}
