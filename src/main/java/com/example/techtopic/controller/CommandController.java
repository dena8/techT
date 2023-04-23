package com.example.techtopic.controller;
import com.example.techtopic.service.command.CommandProcessImpl;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class CommandController {
    private final CommandProcessImpl commandProcess;

    public CommandController(CommandProcessImpl commandProcess) {
        this.commandProcess = commandProcess;
    }

    public void executeCommand(String input) throws IOException {
        String result = this.commandProcess.process(input);
        System.out.println(result);
    }
}
