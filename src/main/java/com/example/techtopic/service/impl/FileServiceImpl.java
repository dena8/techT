package com.example.techtopic.service.impl;

import com.example.techtopic.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

import static com.example.techtopic.constants.Constants.*;

@Service
public class FileServiceImpl implements FileService {
    private final ConcurrentMap<String, String> dataStorage;
    private final StringBuilder stringBuilder;

    public FileServiceImpl(ConcurrentMap<String, String> dataStorage, StringBuilder stringBuilder) {
        this.dataStorage = dataStorage;
        this.stringBuilder = stringBuilder;
    }

    @Override
    public String loadFile(List<String> inputData) throws IOException {
        stringBuilder.setLength(0);
        File file = ResourceUtils.getFile(CLASSPATH + inputData.get(0));
        String path = file.getAbsolutePath();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while ((line = br.readLine()) != null) {
            String[] splitLine = line.split(OUTPUT_DELIMITER);
            this.dataStorage.put(splitLine[0], splitLine[1]);
        }
        return stringBuilder.append(OUTPUT_LOAD_MASSAGE).insert(10, inputData.get(0)).toString();
    }
}
