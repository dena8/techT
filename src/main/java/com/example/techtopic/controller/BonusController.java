package com.example.techtopic.controller;

import com.example.techtopic.service.ReverseService;
import org.springframework.stereotype.Controller;

import static com.example.techtopic.constants.Constants.COUNT_WORDS_COMMAND;
import static com.example.techtopic.constants.Constants.REVERSE_COMMAND;

@Controller
public class BonusController {
    private final ReverseService reverseService;

    public BonusController(ReverseService reverseService) {
        this.reverseService = reverseService;
    }

    public void getData(String input) {
        String inputData = input.substring(input.indexOf(" ")).trim();

        if (input.startsWith(REVERSE_COMMAND)) {
            String result = this.reverseService.reverse(inputData);
            System.out.println(result);
        } else if (input.startsWith(COUNT_WORDS_COMMAND)) {

        }

    }
}
