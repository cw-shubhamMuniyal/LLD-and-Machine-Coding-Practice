package org.example;

import org.example.cache.CacheProvider;
import org.example.cache.HashMapBasedStorage;
import org.example.cache.Storage;
import org.example.policies.EvictionPolicy;
import org.example.policies.LruEvictionPolicy;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Multi Level Cache LLD!");


        Storage<String, String> storage = new HashMapBasedStorage<>(
                new HashMap<>(), 3
        );
        EvictionPolicy<String> evictionPolicy = new LruEvictionPolicy<>();

        CacheProvider<String, String> cacheProvider = new CacheProvider<>(evictionPolicy, storage);

        cacheProvider.put("1", "shubham");
        cacheProvider.put("2", "rahul");
        cacheProvider.put("3", "raj");

        System.out.println(cacheProvider.get("2"));

        cacheProvider.put("2", "anjali");
        System.out.println(cacheProvider.get("2"));

        System.out.println(cacheProvider.get("1"));

        cacheProvider.put("4", "aman");

        System.out.println(cacheProvider.get("4"));
        System.out.println(cacheProvider.get("1"));

    }
}