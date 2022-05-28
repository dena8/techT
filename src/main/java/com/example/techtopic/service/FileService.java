package com.example.techtopic.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FileService {
    String loadFile(List<String> inputData) throws IOException;

}
