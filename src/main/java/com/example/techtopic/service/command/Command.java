package com.example.techtopic.service.command;

import java.io.IOException;
import java.util.List;

public interface Command {
    String execute(List<String> inputData) throws IOException;

}
