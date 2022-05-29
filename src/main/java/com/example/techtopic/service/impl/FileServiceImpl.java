package com.example.techtopic.service.impl;

import com.example.techtopic.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.Arrays;
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
        String path = getPath(inputData);
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while ((line = br.readLine()) != null) {
            String[] splitLine = line.split(OUTPUT_DELIMITER);
            this.dataStorage.put(splitLine[0], splitLine[1]);
        }
        br.close();
        return stringBuilder.append(OUTPUT_LOAD_MASSAGE).insert(10, inputData.get(0)).toString();
    }
    @Override
    public String saveInFile(List<String> inputData) throws IOException {
        stringBuilder.setLength(0);
        String path = getPath(inputData);
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));

        this.dataStorage.forEach((key, value) -> {
            try {
                bw.write(System.lineSeparator()+key + OUTPUT_DELIMITER + value);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bw.close();
        return stringBuilder.append(OUTPUT_SAVE_MASSAGE).insert(OUTPUT_SAVE_MASSAGE.length(),inputData.get(0)).toString();
    }

    @Override
    public String findWordCount(String inputData) throws IOException {
        List<String> inputSplit = Arrays.stream(inputData.split("\\s+")).skip(1).toList();
        String path = getPath(inputSplit);
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        int count=0;
        while ((line = br.readLine()) != null) {
            count+= Arrays.stream(line.split("\\s+")).count();
        }
        br.close();
        return String.format("%s %s: %s",OUTPUT_WORD_COUNT_MASSAGE,inputSplit.get(0),count);
    }

    private String getPath(List<String> inputData) throws FileNotFoundException {
        File file = ResourceUtils.getFile(inputData.get(0));
        return file.getAbsolutePath();
    }
}
