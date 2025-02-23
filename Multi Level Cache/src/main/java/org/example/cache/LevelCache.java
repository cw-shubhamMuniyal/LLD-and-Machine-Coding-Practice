package org.example.cache;

import org.example.model.ReadResponse;
import org.example.model.WriteResponse;

import java.util.List;

public interface LevelCache<Key, Value> {

    ReadResponse<Value> get(Key key);

    WriteResponse put(Key key, Value value);

    List<Double> getUsages();
}
