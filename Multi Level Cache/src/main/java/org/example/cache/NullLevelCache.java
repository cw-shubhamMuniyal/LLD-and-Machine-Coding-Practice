package org.example.cache;

import org.example.model.ReadResponse;
import org.example.model.WriteResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NullLevelCache<Key, Value> implements LevelCache<Key, Value> {

    @Override
    public ReadResponse<Value> get(Key key) {
        return new ReadResponse<Value>(null, 0.0);
    }

    @Override
    public WriteResponse put(Key key, Value value) {
        return new WriteResponse(0.0);
    }

    @Override
    public List<Double> getUsages() {
        return new ArrayList<>();
    }
}
