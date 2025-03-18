package org.example.factory;

import lombok.NonNull;
import org.example.service.LeastConnectionLoadBalancer;
import org.example.service.LoadBalancer;
import org.example.service.RoundRobinLoadBalancer;

public class LoadBalancerFactory {

    public static LoadBalancer getLoadBalancer(@NonNull final String loadBalancerAlgorithm) {

        return switch (loadBalancerAlgorithm) {
            case "least-connection" -> new LeastConnectionLoadBalancer();
            default -> new RoundRobinLoadBalancer();
        };

    }
}
