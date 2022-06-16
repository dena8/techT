package com.example.techtopic.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface SetService {

    CompletableFuture<String> setData(List<String> data);

}
