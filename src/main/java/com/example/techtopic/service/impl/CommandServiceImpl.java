package com.example.techtopic.service.impl;

import com.example.techtopic.service.CommandService;
import com.example.techtopic.service.FileManageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;

import static com.example.techtopic.constants.Constants.*;

@Service
public class CommandServiceImpl extends FileServiceImpl implements CommandService {
    public CommandServiceImpl(ConcurrentMap<String, String> dataStorage, StringBuilder stringBuilder, FileManageService fileManageService) {
        super(dataStorage, stringBuilder, fileManageService);
    }

    @Override
    public String getResultData(List<String> inputData) {
        String key = inputData.get(0);
        super.stringBuilder.setLength(0);
        Optional<String> value = Optional.ofNullable(super.dataStorage.get(key));
        // return value.isEmpty() ? this.stringBuilder.append(OUTPUT_ERROR_MASSAGE).append(key).toString() : this.stringBuilder.append(key).append(OUTPUT_DELIMITER).append(value.get()).toString();
        return value.map(s -> this.stringBuilder.append(key).append(OUTPUT_DELIMITER).append(s).toString()).orElseGet(() -> this.stringBuilder.append(OUTPUT_ERROR_MASSAGE).append(key).toString());
    }

    @Override
    public String setData(List<String> data) {
        stringBuilder.setLength(0);
        this.dataStorage.put(data.get(0), data.get(1));
        return stringBuilder.append(OUTPUT_SET_MASSAGE).append(data.get(0)).append(OUTPUT_DELIMITER).append(data.get(1)).toString();
    }

    @Override
    public String reverse(String inputData) {
        stringBuilder.setLength(0);
        return this.stringBuilder.append(inputData).reverse().toString();
    }
}
