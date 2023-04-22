package com.example.techtopic.service.command;

import com.example.techtopic.service.impl.CommandServiceImpl;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
@Component
public class LoadFileCommand implements Command{
    private final CommandServiceImpl commandService;

    public LoadFileCommand(CommandServiceImpl commandService) {
        this.commandService = commandService;
    }


    @Override
    public String execute(List<String> inputData) throws IOException {
        return this.commandService.loadFile(inputData);
    }
}
