package com.example.techtopic.controller;
import com.example.techtopic.service.command.CommandClient;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.example.techtopic.constants.Constants.*;

@Controller
public class CommandController {
    private final CommandClient commandClient;
    public CommandController(CommandClient commandClient) {
        this.commandClient = commandClient;
    }


    public void getData(String input) throws IOException {
        List<String> inputData = Arrays.stream(input.split("\\s+")).skip(1).toList();

        if (input.startsWith(GET_COMMAND)) {
            String result = this.commandClient.executeGet(inputData);
            System.out.println(result);
        } else if (input.startsWith(SET_COMMAND)) {
            String result = this.commandClient.executeSet(inputData);
            System.out.println(result);
        } else if (input.startsWith(LOAD_COMMAND)) {
            String result = this.commandClient.executeLoadFile(inputData);
            System.out.println(result);
        } else if(input.startsWith(SAVE_COMMAND)){
            String result = this.commandClient.saveInFile(inputData);
            System.out.println(result);
        }else{
            System.out.println(OUTPUT_WRONG_COMMAND_MASSAGE);
        }
    }
}
