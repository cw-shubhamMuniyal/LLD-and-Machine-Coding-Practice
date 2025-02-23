package org.example.cache;

import lombok.AllArgsConstructor;
import org.example.model.LevelCacheData;
import org.example.model.ReadResponse;
import org.example.model.WriteResponse;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class DefaultLevelCache<Key, Value> implements LevelCache<Key, Value> {

    private final CacheProvider<Key, Value> cacheProvider;
    private final LevelCache<Key, Value> next;
    private final LevelCacheData levelCacheData;

    @Override
    public ReadResponse<Value> get(Key key) {

        Value value = cacheProvider.get(key);
        Double timeTaken = levelCacheData.getReadTime();

        if (Objects.isNull(value)) {
            ReadResponse<Value> readResponse = next.get(key);
            value = readResponse.getValue();
            timeTaken += levelCacheData.getReadTime();
            cacheProvider.put(key, readResponse.getValue());
            timeTaken += levelCacheData.getWriteTime();
        }

        return new ReadResponse<>(value, timeTaken);
    }

    @Override
    public WriteResponse put(Key key, Value value) {

        Value value1 = cacheProvider.get(key);
        Double timeTaken = levelCacheData.getReadTime();

        if (!value.equals(value1)) {
            cacheProvider.put(key, value);
            timeTaken += levelCacheData.getWriteTime();
        }

        timeTaken += next.put(key, value).getTimeTaken();
        return new WriteResponse(timeTaken);
    }

    @Override
    public List<Double> getUsages() {

        List<Double> usages = next.getUsages();
        usages.addFirst(this.cacheProvider.getUsage());
        return usages;
    }
}
