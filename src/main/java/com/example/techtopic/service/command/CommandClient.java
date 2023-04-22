package com.example.techtopic.service.command;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
@Component
public class CommandClient {
    private final CommandInvoker commandInvoker;
    private final GetCommand getCommand;
    private final SetCommand setCommand;
    private final LoadFileCommand loadFileCommand;
    private final SaveInFileCommand saveInFileCommand;

    public CommandClient(CommandInvoker commandInvoker, GetCommand getCommand, SetCommand setCommand, LoadFileCommand loadFileCommand, SaveInFileCommand saveInFileCommand) {
        this.commandInvoker = commandInvoker;
        this.getCommand = getCommand;
        this.setCommand = setCommand;
        this.loadFileCommand = loadFileCommand;
        this.saveInFileCommand = saveInFileCommand;
    }

    public String executeGet(List<String> inputData) throws IOException {
        commandInvoker.setCommand(getCommand);
        return commandInvoker.executeCommand(inputData);
    }

    public String executeSet(List<String> inputData) throws IOException {
        commandInvoker.setCommand(setCommand);
        return commandInvoker.executeCommand(inputData);
    }

    public String executeLoadFile(List<String> inputData) throws IOException {
        commandInvoker.setCommand(loadFileCommand);
        return commandInvoker.executeCommand(inputData);
    }

    public String saveInFile(List<String> inputData) throws IOException {
        commandInvoker.setCommand(saveInFileCommand);
        return commandInvoker.executeCommand(inputData);
    }
}
