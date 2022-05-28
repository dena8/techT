package com.example.techtopic;

import com.example.techtopic.controller.CommandController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TechTopicApplication implements CommandLineRunner {
    private final CommandController commandController;

    public TechTopicApplication(CommandController commandController) {
        this.commandController = commandController;
    }

    public static void main(String[] args) {
        SpringApplication.run(TechTopicApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter data, please:");
        String input = scanner.nextLine();

        while (!input.equals("exit")){
            this.commandController.getData(input);
            input= scanner.nextLine();
        }

    }
}
