package com.example.techtopic.controller;

import com.example.techtopic.service.command.FindWordCountCommand;
import com.example.techtopic.service.command.ReverseCommand;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.example.techtopic.constants.Constants.COUNT_WORDS_COMMAND;
import static com.example.techtopic.constants.Constants.REVERSE_COMMAND;

@Controller
public class BonusController {
    private final ReverseCommand reverseCommand;
    private final FindWordCountCommand findWordCountCommand;

    public BonusController(ReverseCommand reverseCommand, FindWordCountCommand findWordCountCommand) {
        this.reverseCommand = reverseCommand;
        this.findWordCountCommand = findWordCountCommand;
    }

    public void getData(String input) throws IOException {
        List<String> inputData = Arrays.stream(input.split("\\s+")).skip(1).toList();

        if (input.startsWith(REVERSE_COMMAND)) {
            System.out.println(this.reverseCommand.execute(inputData));
        } else if (input.startsWith(COUNT_WORDS_COMMAND)) {
            String result = this.findWordCountCommand.execute(inputData);
            System.out.println(result);
        }

    }
}
