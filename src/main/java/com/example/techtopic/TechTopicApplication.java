package com.example.techtopic;

import com.example.techtopic.controller.BonusController;
import com.example.techtopic.controller.CommandController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Scanner;

import static com.example.techtopic.constants.Constants.*;

@SpringBootApplication
@EnableAsync
public class TechTopicApplication implements CommandLineRunner {
    private final CommandController commandController;
    private final BonusController bonusController;
    private final ConfigurableApplicationContext context;

    public TechTopicApplication(CommandController commandController, BonusController bonusController, ConfigurableApplicationContext context) {
        this.commandController = commandController;
        this.bonusController = bonusController;
        this.context = context;
    }

    public static void main(String[] args) {
        SpringApplication.run(TechTopicApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println(INITIAL_MASSAGE);
        String input = scanner.nextLine();

        while (!input.equals(EXIT_COMMAND)) {
            if (input.startsWith(REVERSE_COMMAND)||input.startsWith(COUNT_WORDS_COMMAND)) {
                this.bonusController.getData(input);
            } else  {
                this.commandController.getData(input);
            }

            input = scanner.nextLine();
        }

        this.context.close();

    }
}
