package org.example.cache;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.example.policies.EvictionPolicy;

import java.util.Objects;

@AllArgsConstructor
public class CacheProvider<Key, Value> {

    private final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key, Value> storage;

    public Value get(@NonNull Key key)  {

//        if (Objects.isNull(storage.get(key))) {
//            throw new Exception("this key does not exists!");
//        }
        this.evictionPolicy.keyAccessed(key);
        return this.storage.get(key);
    }

    public void put(@NonNull Key key, @NonNull Value value) {

        Value value1 = this.storage.get(key);

        if (Objects.isNull(value1) && this.storage.isStorageFull()) {
            Key key1 = this.evictionPolicy.evictKey();
            this.storage.remove(key1);
        }

        this.storage.add(key, value);
        this.evictionPolicy.keyAccessed(key);
    }

    public Double getUsage() {
        return this.storage.getUsage();
    }

}
