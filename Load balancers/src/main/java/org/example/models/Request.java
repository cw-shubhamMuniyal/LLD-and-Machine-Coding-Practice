package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class Request {

    private final RequestType requestType;

    private final Map<Object, Object> sessionData;
}
