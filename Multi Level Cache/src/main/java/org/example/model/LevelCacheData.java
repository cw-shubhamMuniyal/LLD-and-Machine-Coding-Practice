package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LevelCacheData {

    private final Double readTime;

    private final Double writeTime;
}
