package org.example.cache;

public interface Storage<Key, Value> {

    void add(Key key, Value value);

    Value get(Key key);

    void remove(Key key);

    boolean isStorageFull();

    Double getUsage();
}
