package com.example.techtopic.service.command;

import com.example.techtopic.service.CommandService;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ReverseCommand implements Command{
    private final CommandService reverseCommand;

    public ReverseCommand(CommandService reverseCommand) {
        this.reverseCommand = reverseCommand;
    }

    @Override
    public String execute(List<String> inputData) {
        return this.reverseCommand.reverse(inputData.get(0));
    }
}
