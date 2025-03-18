package org.example;

import org.example.factory.LoadBalancerFactory;
import org.example.models.Request;
import org.example.models.RequestType;
import org.example.models.Server;
import org.example.models.Service;
import org.example.service.LoadBalancer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Practicing Load balancers LLD!");

        LoadBalancer loadBalancer = LoadBalancerFactory.getLoadBalancer("round-robin");

        Service service = new Service(1, "Authentication service");

        service.addServer(new Server(1, 2));
        service.addServer(new Server(2, 3));

        loadBalancer.registerService(RequestType.AUTHENTICATION, service);

        loadBalancer.handleRequest(new Request(RequestType.AUTHENTICATION, null));
        loadBalancer.handleRequest(new Request(RequestType.AUTHENTICATION, null));
        loadBalancer.handleRequest(new Request(RequestType.AUTHENTICATION, null));
        loadBalancer.handleRequest(new Request(RequestType.AUTHENTICATION, null));
        loadBalancer.handleRequest(new Request(RequestType.AUTHENTICATION, null));

    }
}