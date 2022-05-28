package com.example.techtopic;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TechTopicApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TechTopicApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter data, please:");
        String input = scanner.nextLine();

        while (!input.equals("exit")){
            System.out.println("work");
            input= scanner.nextLine();
        }

    }
}
