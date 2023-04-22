package com.example.techtopic.service.command;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class BonusClient {
    private final CommandInvoker commandInvoker;
    private final ReverseCommand reverseCommand;
    private final FindWordCountCommand findWordCountCommand;


    public BonusClient(CommandInvoker commandInvoker, ReverseCommand reverseCommand, FindWordCountCommand findWordCountCommand) {
        this.commandInvoker = commandInvoker;
        this.reverseCommand = reverseCommand;
        this.findWordCountCommand = findWordCountCommand;
    }

    public String executeReverse(List<String> inputData) throws IOException {
        commandInvoker.setCommand(reverseCommand);
        return commandInvoker.executeCommand(inputData);
    }

    public String executeFindWordCount(List<String> inputData) throws IOException {
        commandInvoker.setCommand(findWordCountCommand);
        return commandInvoker.executeCommand(inputData);
    }
}
