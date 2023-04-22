package com.example.techtopic.service.command;

import com.example.techtopic.service.CommandService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SetCommand implements Command {
    private final CommandService setService;

    public SetCommand(CommandService commandService) {
        this.setService = commandService;
    }

    @Override
    public String execute(List<String> inputData) {
        return this.setService.setData(inputData);
    }
}
