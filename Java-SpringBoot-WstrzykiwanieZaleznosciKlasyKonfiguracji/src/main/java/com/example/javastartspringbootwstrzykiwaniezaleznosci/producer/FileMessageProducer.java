package com.example.javastartspringbootwstrzykiwaniezaleznosci.producer;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
@Profile("file")
@Service
 class FileMessageProducer implements  MessageProducer{
     @Override
     public String getMessage() {
         Path path = getPath();
         try {
             return String.join(" ", Files.readAllLines(path));
         } catch (IOException e) {
             throw new UncheckedIOException(e);
         }
     }


     private Path getPath(){
         System.out.println("Podaj nazwę ppliku z komunikatem do odczytania");
         Scanner scanner = new Scanner(System.in);
         String fileName = scanner.nextLine();
         return Path.of(fileName);
     }
 }
