package com.example.techtopic.service.command;

import com.example.techtopic.service.impl.CommandServiceImpl;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
@Component
public class FindWordCountCommand implements Command {
    private final CommandServiceImpl findWordCountService;

    public FindWordCountCommand(CommandServiceImpl findWordCountService) {
        this.findWordCountService = findWordCountService;
    }


    @Override
    public String execute(List<String> inputData) throws IOException {
        return this.findWordCountService.findWordCount(inputData.get(0));
    }
}
