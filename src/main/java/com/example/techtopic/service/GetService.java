package com.example.techtopic.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface GetService {
    CompletableFuture<String> getResultData(List<String> inputData);
}
