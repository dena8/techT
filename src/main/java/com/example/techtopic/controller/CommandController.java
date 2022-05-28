package com.example.techtopic.controller;

import com.example.techtopic.service.SetService;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;

import static com.example.techtopic.constants.Constants.*;

@Controller
public class CommandController {
    private final SetService setService;


    public CommandController(SetService setService) {
        this.setService = setService;
    }


    public void getData(String input) {
        List<String> data = Arrays.stream(input.split("\\s+")).skip(1).toList();

        if (input.startsWith(GET_COMMAND)) {

        } else if (input.startsWith(SET_COMMAND)) {
            String result = this.setService.setData(data);
            System.out.println(result);
        } else if (input.startsWith(LOAD_COMMAND)) {

        }
    }
}
