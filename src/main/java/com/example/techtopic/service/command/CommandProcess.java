package com.example.techtopic.service.command;

import java.io.IOException;

public interface CommandProcess {
    String process(String input) throws IOException;
}
