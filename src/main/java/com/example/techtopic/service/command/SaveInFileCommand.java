package com.example.techtopic.service.command;

import com.example.techtopic.service.impl.CommandServiceImpl;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
@Component
public class SaveInFileCommand implements Command{
    private final CommandServiceImpl saveInFileService;

    public SaveInFileCommand(CommandServiceImpl saveInFileService) {
        this.saveInFileService = saveInFileService;
    }

    @Override
    public String execute(List<String> inputData) throws IOException {
        return this.saveInFileService.saveInFile(inputData);
    }
}
