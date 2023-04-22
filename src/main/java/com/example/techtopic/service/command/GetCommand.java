package com.example.techtopic.service.command;

import com.example.techtopic.service.CommandService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetCommand implements Command {
    private final CommandService getService;

    public GetCommand(CommandService getService) {
        this.getService = getService;
    }

    @Override
    public String execute(List<String> inputData) {
        return  this.getService.getResultData(inputData);
    }


}
