package org.example;

import org.example.cache.*;
import org.example.model.LevelCacheData;
import org.example.model.ReadResponse;
import org.example.model.StatsResponse;
import org.example.model.WriteResponse;
import org.example.policies.EvictionPolicy;
import org.example.policies.LruEvictionPolicy;

import java.util.ArrayList;
import java.util.HashMap;

public class Main<Key, Value> {
    public static void main(String[] args) throws Exception {
        System.out.println("Multi Level Cache LLD!");


        Storage<String, String> storageLevel1 = new HashMapBasedStorage<>(
                new HashMap<>(), 1
        );
        EvictionPolicy<String> evictionPolicyLevel1 = new LruEvictionPolicy<>();

        CacheProvider<String, String> cacheProviderLevel1 = new CacheProvider<>(evictionPolicyLevel1, storageLevel1);

        Storage<String, String> storageLevel2 = new HashMapBasedStorage<>(
                new HashMap<>(), 3
        );
        EvictionPolicy<String> evictionPolicyLevel2 = new LruEvictionPolicy<>();

        CacheProvider<String, String> cacheProviderLevel2 = new CacheProvider<>(evictionPolicyLevel2, storageLevel2);


//        Added this to just debug Single level cache with just using CacheProvider and not using CacheService
//        cacheProvider.put("1", "shubham");
//        cacheProvider.put("2", "rahul");
//        cacheProvider.put("3", "raj");
//
//        System.out.println(cacheProvider.get("2"));
//
//        cacheProvider.put("2", "anjali");
//        System.out.println(cacheProvider.get("2"));
//
//        System.out.println(cacheProvider.get("1"));
//
//        cacheProvider.put("4", "aman");
//
//        System.out.println(cacheProvider.get("4"));
//        System.out.println(cacheProvider.get("1"));

        LevelCacheData levelCacheDataLevel1 = new LevelCacheData(1.0,3.0);
        LevelCacheData levelCacheDataLevel2 = new LevelCacheData(2.0,4.0);

        LevelCache<String, String> l2Cache = new DefaultLevelCache<>(cacheProviderLevel2,
               new NullLevelCache<>() , levelCacheDataLevel2);


        LevelCache<String, String> l1Cache = new DefaultLevelCache<>(cacheProviderLevel1,
                l2Cache , levelCacheDataLevel1);

        CacheService<String, String> cacheService = new CacheService<>(l1Cache, 5);

        WriteResponse writeResponse = cacheService.put("1", "Rahul");
        System.out.println(writeResponse);

        writeResponse = cacheService.put("2", "Aman");
        System.out.println(writeResponse);

        ReadResponse<String> readResponse = cacheService.get("2");
        System.out.println(readResponse);

        writeResponse = cacheService.put("1", "Rahul");
        System.out.println(writeResponse);

        StatsResponse statsResponse = cacheService.fetchStats();
        System.out.println(statsResponse);

    }
}