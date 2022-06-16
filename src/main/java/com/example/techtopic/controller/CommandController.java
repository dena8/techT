package com.example.techtopic.controller;

import com.example.techtopic.service.FileService;
import com.example.techtopic.service.GetService;
import com.example.techtopic.service.SetService;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.example.techtopic.constants.Constants.*;

@Controller
public class CommandController{
    private final SetService setService;
    private final GetService getService;
    private final FileService fileService;
    public CommandController(SetService setService, GetService getService, FileService fileService) {
        this.setService = setService;
        this.getService = getService;
        this.fileService = fileService;
    }


    public void getData(String input) throws IOException, ExecutionException, InterruptedException {
        List<String> inputData = Arrays.stream(input.split("\\s+")).skip(1).toList();

        if (input.startsWith(GET_COMMAND)) {
            CompletableFuture<String> result = this.getService.getResultData(inputData);
            System.out.println(result.get());
        } else if (input.startsWith(SET_COMMAND)) {
            CompletableFuture<String> result = this.setService.setData(inputData);
            System.out.println(result.get());
        } else if (input.startsWith(LOAD_COMMAND)) {
            CompletableFuture<String> result = this.fileService.loadFile(inputData);
            System.out.println(result.get());
        } else if(input.startsWith(SAVE_COMMAND)){
            CompletableFuture<String> result = this.fileService.saveInFile(inputData);
            System.out.println(result.get());
        }else{
            System.out.println(OUTPUT_WRONG_COMMAND_MASSAGE);
        }
    }

}
