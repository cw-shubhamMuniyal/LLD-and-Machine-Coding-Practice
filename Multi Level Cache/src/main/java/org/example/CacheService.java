package org.example;

import lombok.NonNull;
import org.example.cache.LevelCache;
import org.example.model.ReadResponse;
import org.example.model.StatsResponse;
import org.example.model.WriteResponse;

import java.util.ArrayList;
import java.util.List;

public class CacheService<Key, Value> {

    private final LevelCache<Key, Value> levelCache;
    private final Integer operationsCount;
    private final List<Double> readOperationTimes;
    private final List<Double> writeOperationTimes;

    public CacheService(LevelCache<Key, Value> levelCache, Integer operationsCount) {
        this.levelCache = levelCache;
        this.operationsCount = operationsCount;
        readOperationTimes = new ArrayList<>();
        writeOperationTimes = new ArrayList<>();
    }


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

    public StatsResponse fetchStats() {
        return StatsResponse.builder()
                .averageWriteTime(getAverageWriteTimeTime())
                .averageReadTime(getAverageReadTime())
                .usages(getUsages())
                .build();
    }

    private List<Double> getUsages() {
        return levelCache.getUsages();
    }

    private Double getAverageReadTime() {
        return getSum(readOperationTimes) / Math.min(operationsCount, readOperationTimes.size());
    }

    private Double getAverageWriteTimeTime() {
        return getSum(writeOperationTimes) / Math.min(operationsCount, writeOperationTimes.size());
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
