package com.example.techtopic.service.impl;

import com.example.techtopic.service.GetService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;

import static com.example.techtopic.constants.Constants.OUTPUT_DELIMITER;

@Service
public class GetServiceImpl implements GetService {
    private final ConcurrentMap<String, String> dataStorage;
    private final StringBuilder stringBuilder;

    public GetServiceImpl(ConcurrentMap<String, String> dataStorage, StringBuilder stringBuilder) {
        this.dataStorage = dataStorage;
        this.stringBuilder = stringBuilder;
    }


    @Override
    public String getResultData(List<String> inputData) {
        String key = inputData.get(0);
        stringBuilder.setLength(0);
        Optional<String> value = Optional.ofNullable(this.dataStorage.get(key));
        return value.isEmpty() ? this.stringBuilder.append("Err: no value for ").append(key).toString() : this.stringBuilder.append(key).append(OUTPUT_DELIMITER).append(value.get()).toString();
    }
}
