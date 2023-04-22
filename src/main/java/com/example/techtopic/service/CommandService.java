package com.example.techtopic.service;

import java.util.List;

public interface CommandService {
    String getResultData(List<String> inputData);

    String setData(List<String> data);

    String reverse(String inputData);
}
