package com.example.techtopic.controller;

import com.example.techtopic.service.command.BonusClient;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.example.techtopic.constants.Constants.COUNT_WORDS_COMMAND;
import static com.example.techtopic.constants.Constants.REVERSE_COMMAND;

@Controller
public class BonusController {
    private final BonusClient bonusClient;

    public BonusController(BonusClient bonusClient) {
        this.bonusClient = bonusClient;
    }

    public void getData(String input) throws IOException {
        List<String> inputData = Arrays.stream(input.split("\\s+")).skip(1).toList();

        if (input.startsWith(REVERSE_COMMAND)) {
            System.out.println(this.bonusClient.executeReverse(inputData));
        } else if (input.startsWith(COUNT_WORDS_COMMAND)) {
            String result = this.bonusClient.executeFindWordCount(inputData);
            System.out.println(result);
        }

    }
}
