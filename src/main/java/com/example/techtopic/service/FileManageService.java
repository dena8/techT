package com.example.techtopic.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileManageService {
    BufferedReader getBufferReader(String fileName) throws FileNotFoundException;

    BufferedWriter getBufferWriter(String fileName) throws IOException;
}
