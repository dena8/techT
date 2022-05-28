package com.example.techtopic.controller;

import com.example.techtopic.service.FileService;
import com.example.techtopic.service.GetService;
import com.example.techtopic.service.SetService;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.example.techtopic.constants.Constants.*;

@Controller
public class CommandController {
    private final SetService setService;
    private final GetService getService;
    private final FileService fileService;
    public CommandController(SetService setService, GetService getService, FileService fileService) {
        this.setService = setService;
        this.getService = getService;
        this.fileService = fileService;
    }


    public void getData(String input) throws IOException {
        List<String> inputData = Arrays.stream(input.split("\\s+")).skip(1).toList();

        if (input.startsWith(GET_COMMAND)) {
            String result = this.getService.getResultData(inputData);
            System.out.println(result);
        } else if (input.startsWith(SET_COMMAND)) {
            String result = this.setService.setData(inputData);
            System.out.println(result);
        } else if (input.startsWith(LOAD_COMMAND)) {
            String result = this.fileService.loadFile(inputData);
            System.out.println(result);
        } else if(input.startsWith(LOAD_COMMAND)){

        }
    }
}
