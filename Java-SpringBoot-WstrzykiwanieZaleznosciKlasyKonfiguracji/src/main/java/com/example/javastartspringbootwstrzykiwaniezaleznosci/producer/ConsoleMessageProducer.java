package com.example.javastartspringbootwstrzykiwaniezaleznosci.producer;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Scanner;
@Profile("console")
@Service
 class ConsoleMessageProducer implements MessageProducer{

    private final Scanner scanner;

    ConsoleMessageProducer(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getMessage() {
        System.out.println("Enter text to print:");;
        return scanner.nextLine();
    }
}
