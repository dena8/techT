package com.example.techtopic.service.command;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
@Component
public class CommandInvoker {
    private  Command command;


    public CommandInvoker setCommand(Command command) {
        this.command = command;
        return this;
    }

    public String executeCommand(List<String> inputData) throws IOException {
        return this.command.execute(inputData);
    }
}
