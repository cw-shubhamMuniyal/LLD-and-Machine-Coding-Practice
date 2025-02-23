package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

import java.util.List;

@Builder
@AllArgsConstructor
@ToString
public class StatsResponse {

    private Double averageReadTime;
    private Double averageWriteTime;
    private List<Double> usages;
}
