package com.example.techtopic.service.impl;

import com.example.techtopic.service.SetService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

@Service
public class SetServiceImpl implements SetService {
    private final ConcurrentMap<String,String> dataStorage;
    private final StringBuilder stringBuilder;

    public SetServiceImpl(ConcurrentMap<String, String> dataStorage, StringBuilder stringBuilder) {
        this.dataStorage = dataStorage;
        this.stringBuilder = stringBuilder;
    }


    @Override
    public String setData(List<String> data) {
        stringBuilder.setLength(0);
        this.dataStorage.put(data.get(0),data.get(1));
        return  stringBuilder.append("Saved ").append(data.get(0)).append("=").append(data.get(1)).toString();
    }
}
