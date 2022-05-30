package com.example.techtopic.service.impl;

import com.example.techtopic.service.FileManageService;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.*;

import static com.example.techtopic.constants.Constants.FILE_ERROR_MASSAGE;

@Service
public class FileManageServiceImpl  implements FileManageService {
    @Override
    public BufferedReader getBufferReader(String fileName) throws FileNotFoundException {
        File file = ResourceUtils.getFile(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(FILE_ERROR_MASSAGE);
        }
        return new BufferedReader(new FileReader(file.getAbsoluteFile()));
    }

    @Override
    public BufferedWriter getBufferWriter(String fileName) throws IOException {
        File file = ResourceUtils.getFile(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        return new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
    }

}
