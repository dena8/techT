package com.example.techtopic.service.impl;

import com.example.techtopic.service.ReverseService;
import org.springframework.stereotype.Service;

@Service
public class ReverseServiceImpl implements ReverseService {
    private final StringBuilder stringBuilder;

    public ReverseServiceImpl(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    @Override
    public String reverse(String inputData) {
        stringBuilder.setLength(0);
        return this.stringBuilder.append(inputData).reverse().toString();
    }
}
