package com.example.techtopic.controller;

import com.example.techtopic.service.FileService;
import com.example.techtopic.service.ReverseService;
import org.springframework.stereotype.Controller;
import java.io.IOException;
import static com.example.techtopic.constants.Constants.COUNT_WORDS_COMMAND;
import static com.example.techtopic.constants.Constants.REVERSE_COMMAND;

@Controller
public class BonusController {
    private final ReverseService reverseService;
    private final FileService fileService;

    public BonusController(ReverseService reverseService, FileService fileService) {
        this.reverseService = reverseService;
        this.fileService = fileService;
    }

    public void getData(String input) throws IOException {

        if (input.startsWith(REVERSE_COMMAND)) {
            String inputData = input.substring(input.indexOf(" ")).trim();
            System.out.println(this.reverseService.reverse(inputData));
        } else if (input.startsWith(COUNT_WORDS_COMMAND)) {
            String result = this.fileService.findWordCount(input);
            System.out.println(result);
        }

    }
}
