package org.example.cache;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.example.model.ReadResponse;
import org.example.model.WriteResponse;

import java.util.List;

@AllArgsConstructor
public class CacheService<Key, Value> {

    private final LevelCache<Key, Value> levelCache;
    private final Integer operationsCount;
    private final List<Double> readOperationTimes;
    private final List<Double> writeOperationTimes;


    public ReadResponse<Value> get(@NonNull Key key) {
        ReadResponse<Value> readResponse = levelCache.get(key);
        addTimes(readOperationTimes, readResponse.getTimeTaken());
        return readResponse;
    }

    public WriteResponse put(@NonNull Key key, @NonNull Value value) {
        WriteResponse writeResponse = levelCache.put(key, value);
        addTimes(writeOperationTimes, writeResponse.getTimeTaken());
        return writeResponse;
    }

    public List<Double> getUsages() {
        return levelCache.getUsages();
    }

    public Double getAverageReadTime() {
        return getSum(readOperationTimes) / operationsCount;
    }

    public Double getAverageWriteTimeTime() {
        return getSum(writeOperationTimes) / operationsCount;
    }

    private void addTimes(List<Double> times, Double timeTaken) {
        if (times.size() == operationsCount) {
            times.removeFirst();
        }
        times.add(timeTaken);
    }

    private Double getSum(List<Double> times) {
        Double sum = 0.0;

        for (Double time:times) {
            sum += time;
        }

        return sum;
    }

}
