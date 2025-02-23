package org.example.cache;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value> {

    private final Map<Key, Value> map;
    private final Integer capacity;

    @Override
    public void add(Key key, Value value) {
        map.put(key, value);
    }

    @Override
    public Value get(Key key) {
        return map.get(key);
    }

    @Override
    public void remove(Key key) {
        map.remove(key);
    }

    @Override
    public boolean isStorageFull() {
        return map.size() == capacity;
    }

    @Override
    public Double getUsage() {
        return map.size() / (double) capacity;
    }
}
