package com.example.techtopic.service.impl;

import com.example.techtopic.service.SetService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentMap;

import static com.example.techtopic.constants.Constants.OUTPUT_DELIMITER;
import static com.example.techtopic.constants.Constants.OUTPUT_SET_MASSAGE;

@Service
public class SetServiceImpl implements SetService {
    private final ConcurrentMap<String,String> dataStorage;
    private final StringBuilder stringBuilder;

    public SetServiceImpl(ConcurrentMap<String, String> dataStorage, StringBuilder stringBuilder) {
        this.dataStorage = dataStorage;
        this.stringBuilder = stringBuilder;
    }

    @Override
    public CompletableFuture<String> setData(List<String> data) {
        stringBuilder.setLength(0);
        this.dataStorage.put(data.get(0),data.get(1));
        String result=  stringBuilder.append(OUTPUT_SET_MASSAGE).append(data.get(0)).append(OUTPUT_DELIMITER).append(data.get(1)).toString();
        return CompletableFuture.completedFuture(result);
    }
}
