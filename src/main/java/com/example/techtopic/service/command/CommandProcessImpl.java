package com.example.techtopic.service.command;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.example.techtopic.constants.Constants.*;
@Component
public class CommandProcessImpl implements CommandProcess {
    private final CommandClient commandClient;
    private final BonusClient bonusClient;

    public CommandProcessImpl(CommandClient commandClient, BonusClient bonusClient) {
        this.commandClient = commandClient;
        this.bonusClient = bonusClient;
    }

    @Override
    public String process(String input) throws IOException {
        List<String> inputData = Arrays.stream(input.split("\\s+")).skip(1).toList();
        if (input.startsWith(GET_COMMAND)) {
            return this.commandClient.executeGet(inputData);
        } else if (input.startsWith(SET_COMMAND)) {
            return this.commandClient.executeSet(inputData);
        } else if (input.startsWith(LOAD_COMMAND)) {
            return this.commandClient.executeLoadFile(inputData);
        } else if (input.startsWith(SAVE_COMMAND)) {
            return this.commandClient.saveInFile(inputData);
        } else if (input.startsWith(REVERSE_COMMAND)) {
            return this.bonusClient.executeReverse(inputData);
        } else if (input.startsWith(COUNT_WORDS_COMMAND)) {
            return this.bonusClient.executeFindWordCount(inputData);
        } else {
            return OUTPUT_WRONG_COMMAND_MASSAGE;
        }
    }

}
