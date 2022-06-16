package com.example.techtopic.service;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface FileService {
    CompletableFuture<String> loadFile(List<String> inputData) throws IOException;

    CompletableFuture<String>  saveInFile(List<String> inputData) throws IOException;

    String findWordCount(String inputData) throws IOException;
}
